package org.project.member.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.project.common.module.code.service.CodeService;
import org.project.common.system.globalCode.defineCode;
import org.project.common.vo.ResultVO;
import org.project.member.certification.domain.Certification;
import org.project.member.certification.service.CertificationService;
import org.project.member.domain.Login;
import org.project.member.domain.Member;
import org.project.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	MemberService memberService;
	
	@Resource(name="certificationService")
	CertificationService certificationService;
	
	@Resource(name="codeService")
	CodeService codeService;
	
	/*
	 * 추가 작업사항
	 * 향후 관리자 페이지 구현시 :: 회원 리스트, 회원 상세보기, 회원등급 변경 추가.
	 * AOP LOG처리

	 	이슈사항
	 	
	 *  완료 1. 현제 resultVO를 추가하고, 다른 DOMAIN에 상속함
		각 DOMAIN에 있는 resultVO와 성격이 비슷한 변수
		들을 제거하고 resultVO를 활용하도록 수정하고 테스트
		할것. Join 기능에서 인증 실패로직을 추가함 테스트 필요.
		
		완료 2. 파일명이나 변수명을 일관되도록 수정할것. (EX : certify :: certification)
		
		완료 3. PASSWORD 암호화 처리. (PASSWORD -> SHA256, 복호화 불가)
		
		완료 4. INDEX 페이지에서 로그인 BEFORE, AFTER 처리.
		
		완료 5. email, 인증키 요청 페이지의 ajax통신 응답으로 Duplication 객체 사용하는데
		       여러군대에서 사용하므로 이름을 변경해서 적용할것.
	 */
	
	/*
	 * 회원가입 =========================	
	 */
	@RequestMapping(value="joinForm", method=RequestMethod.GET)	
	public String joinForm(ModelMap model) {
		model.addAttribute(new Member());
		return "/member/joinForm";
	}
	
	@RequestMapping(value="joinCertify", method=RequestMethod.POST)
	public String joinCertify(@ModelAttribute @Valid Member member, BindingResult result, Model model) {
		logger.debug("input : " + member.toString());
		
		if(result.hasErrors()) return "/member/joinForm";		
		Certification certification = new Certification();
		certification.setEmail(memberService.joining(member).getEmail());
		model.addAttribute(certification);
		return "/member/joinCertificationForm";
	}
	
	@RequestMapping(value="joinCertified", method=RequestMethod.POST)	
	public String joinAction(@ModelAttribute Certification certification, Model model) throws SQLException {
		logger.debug("input : " + certification.toString());
		
		Member member = memberService.joined(certification); 
		if(member.isResultYN()) {
			model.addAttribute(new Login());
			return "/member/loginForm";
		}else{
			model.addAttribute(member);
			return "/member/joinForm";
		}
	}
	
	@RequestMapping(value="duplicationCheck", method=RequestMethod.GET)
	@ResponseBody
	public ResultVO duplicationCheckAction(@RequestParam String email) {
		logger.debug("input email : " + email);
		
		if(memberService.existence(email)){
			return new ResultVO(true);
		}else{
			memberService.secede(email);
			return new ResultVO(false);
		}		
	}
	
	/*
	 * 회원 정보수정, 회원탈퇴, 비밀번호 찾기 =========================
	 */
	@RequestMapping(value="memberManagementForm", method=RequestMethod.GET)	
	public String memberManagementForm() {
		return "/member/managementForm";
	}
	
	@RequestMapping(value="memberUpdateForm", method=RequestMethod.GET)	
	public String memberUpdateForm(HttpSession session, Model model) throws SQLException {
		logger.debug("input : " + model.toString());
		
		Login sessionLogin = (Login)session.getAttribute("login");		
		Member member = memberService.search(sessionLogin.getEmail());
		model.addAttribute(member);
		return "/member/updateForm";
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)	
	public String memberUpdate(@ModelAttribute Member member) {
		logger.debug("input : " + member.toString());
		
		memberService.update(member);
		return "/member/managementForm";
	}	
	
	@RequestMapping(value="memberSecede", method=RequestMethod.GET)	
	public String memberSecede(HttpSession session) {
		logger.debug("input : " + session.toString());
		
		Login sessionLogin = (Login)session.getAttribute("login");		
		memberService.secede(sessionLogin.getEmail());		
		session.removeAttribute("login");		
		return "/../../index";
	}
	
	@RequestMapping(value="recoverPwForm", method=RequestMethod.GET)	
	public String recoverPwForm(ModelMap model) {
		logger.debug("input : " + model.toString());
		
		model.addAttribute(new Certification());
		return "/member/recoverCertificationForm";
	}
	
	@RequestMapping(value="sendCertificationKey", method=RequestMethod.GET)
	@ResponseBody
	public ResultVO sendCertificationKey(@RequestParam String email) {
		logger.debug("input : " + email);
		
		certificationService.certify(email);		
		return new ResultVO(true);
	}
	
	@RequestMapping(value="recoverPw", method=RequestMethod.POST)
	public String recoverPw(@ModelAttribute Certification certification, Model model) {
		logger.debug("input : " + certification.toString());	
		
		Certification certifyResult = memberService.recoverPw(certification);
		//email이 없을경우
		if(certifyResult.getResultCode() == defineCode.NOT_FOUND_EMAIL){
			model.addAttribute(certifyResult);
			return "/member/recoverCertificationForm";
		//인증키가 틀린경우
		}else if(certifyResult.getResultCode() == defineCode.WRONG_CERIFICATION_KEY){
			model.addAttribute(certifyResult);
			return "/member/recoverCertificationForm";
		//정상처리
		}else{
			Login login = new Login();
			login.updateNewPassword(certifyResult.getRandomKey());
			model.addAttribute(login);
			return "/member/loginForm";	
		}
	}
	
	
	/*
	 * 로그인 =========================	
	 */	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)	
	public String loginForm(ModelMap model) {
		logger.debug("input : " + model.toString());
		
		model.addAttribute(new Login());
		return "/member/loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)	
	public String loginAction(@ModelAttribute @Valid Login login, BindingResult result, HttpSession session, Model model) {
		logger.debug("input : " + login.toString());
		
		if(result.hasErrors()) return "/member/loginForm";
		Login sessionLogin = (Login)session.getAttribute("login");		
		Login resultLogin = memberService.loginProcess(login, sessionLogin);
		session.setAttribute("login", resultLogin);
		model.addAttribute("login", resultLogin);		
		return "/member/loginForm";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)	
	public String logoutForm(ModelMap model, HttpSession session) {
		logger.debug("input : " + model.toString());
		
		session.removeAttribute("login");
		model.addAttribute(new Login());
		return "/member/loginForm";
	}
}
