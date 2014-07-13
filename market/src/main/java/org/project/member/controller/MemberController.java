package org.project.member.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.project.common.vo.ResultVO;
import org.project.member.certification.domain.Certification;
import org.project.member.certification.service.CertificationService;
import org.project.member.domain.Login;
import org.project.member.domain.Member;
import org.project.member.service.MemberService;
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
	
	@Resource(name="memberService")
	MemberService memberService;
	
	@Resource(name="certificationService")
	CertificationService certificationService;
	
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
	public String springJoinForm(ModelMap model) {
		System.out.println("spring :: joinForm");
		model.addAttribute(new Member());
		return "/member/joinForm";
	}
	
	@RequestMapping(value="joinCertify", method=RequestMethod.POST)
	public String joinCertify(@ModelAttribute @Valid Member member, BindingResult result, Model model) {
		System.out.println("spring :: joinCertify");		
		if(result.hasErrors()) return "/member/joinForm";		
		Certification certification = new Certification();
		certification.setEmail(memberService.joining(member).getEmail());
		model.addAttribute(certification);
		return "/member/joinCertificationForm";
	}
	
	@RequestMapping(value="joinCertified", method=RequestMethod.POST)	
	public String springJoinAction(@ModelAttribute Certification certification, Model model) throws SQLException {
		System.out.println("spring :: joinCertified");
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
		System.out.println("spring duplicationCheckAction : " + email);
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
		System.out.println("spring :: ManagementForm");
		return "/member/managementForm";
	}
	
	@RequestMapping(value="memberUpdateForm", method=RequestMethod.GET)	
	public String memberUpdateForm(HttpSession session, Model model) throws SQLException {
		System.out.println("spring :: memberUpdateForm");		
		Login sessionLogin = (Login)session.getAttribute("login");		
		Member member = memberService.search(sessionLogin.getEmail());
		model.addAttribute(member);
		return "/member/updateForm";
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)	
	public String memberUpdate(@ModelAttribute Member member) {
		System.out.println("spring :: memberUpdate");
		memberService.update(member);
		return "/member/managementForm";
	}	
	
	@RequestMapping(value="memberSecede", method=RequestMethod.GET)	
	public String memberSecede(HttpSession session) {
		System.out.println("spring :: memberSecede");		
		Login sessionLogin = (Login)session.getAttribute("login");		
		memberService.secede(sessionLogin.getEmail());		
		session.removeAttribute("login");		
		return "/../../index";
	}
	
	@RequestMapping(value="recoverPwForm", method=RequestMethod.GET)	
	public String recoverPw(Model model) {
		System.out.println("spring :: ManagementForm");		
		model.addAttribute(new Certification());
		return "/member/recoverCertificationForm";
	}
	
	@RequestMapping(value="sendCertificationKey", method=RequestMethod.GET)
	@ResponseBody
	public ResultVO sendCertificationKey(@RequestParam String email) {
		System.out.println("spring sendCertificationKey");
		certificationService.certify(email);		
		return new ResultVO(true);
	}
	
	@RequestMapping(value="recoverPw", method=RequestMethod.POST)
	public String recoverPw(@ModelAttribute Certification certification, Model model) {
		System.out.println("spring sendCertificationKey");
		
		Certification certifyResult = memberService.recoverPw(certification); 
		
		//email이 없을경우
		if(certifyResult.getResultCode() == 2){
			model.addAttribute(certifyResult);
			return "/member/recoverCertificationForm";
		//인증키가 틀린경우
		}else if(certifyResult.getResultCode() == 3){
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
	public String springLoginForm(ModelMap model) {
		System.out.println("spring :: form");
		model.addAttribute(new Login());
		return "/member/loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)	
	public String springLoginAction(@ModelAttribute @Valid Login login, BindingResult result, HttpSession session, Model model) {
		System.out.println("spring :: login");				
		if(result.hasErrors()) return "/member/loginForm";		
		Login sessionLogin = (Login)session.getAttribute("login");		
		Login resultLogin = memberService.loginProcess(login, sessionLogin);
		session.setAttribute("login", resultLogin);
		model.addAttribute("login", resultLogin);		
		return "/member/loginForm";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)	
	public String springLogoutForm(ModelMap model, HttpSession session) {
		System.out.println("spring :: logout");
		session.removeAttribute("login");
		model.addAttribute(new Login());
		return "/member/loginForm";
	}
}
