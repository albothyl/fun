package org.project.member.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.project.common.vo.PageVO;
import org.project.member.certification.dto.Certification;
import org.project.member.dto.Duplication;
import org.project.member.dto.Login;
import org.project.member.dto.Member;
import org.project.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Resource(name="memberService")
	MemberService memberService;
	
	private ModelAndView mav;
	
	//앵귤러 테스트용 폼
	@RequestMapping(value="angularForm", method=RequestMethod.GET)
	public String angularForm() {
		//return "/member/angularForm";
		//return "/angular/angularExpression";
		//return "/angular/angularBinding";
		//return "/angular/angularRepeat";
		//return "/angular/angularSwitch";
		//return "/angular/angularIf";
		//return "/angular/angularShowHide";
		//return "/angular/angularController";
		//return "/angular/angularValidation1";
		//return "/angular/angularValidation2";
		//return "/angular/angularValidation3";
		//return "/angular/angularValidation4";
		//return "/angular/angularEvent1";
		//return "/angular/angularEvent2";
		//return "/angular/angularEvent3";
		//return "/angular/angularScope1";
		//return "/angular/angularScope2";
		return "/angular/angularHttp";
	}
	@RequestMapping(value="angularAjaxAction", method=RequestMethod.POST)
	@ResponseBody
	public Member angularHttpAjaxAction(@RequestBody Member member) {
		System.out.println("angularHttpAjaxAction in");
		System.out.println(member.toString());
		member.setPw("test_password");
		member.setNick("test_nick");
		return member;
	}
		
	//회원 가입
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "/member/join/joinForm";
	}
	@RequestMapping(value="joinCertifyAction", method=RequestMethod.POST)
	public ModelAndView joinCertifyAction(Member member) {
		mav = new ModelAndView();
		mav.addObject("email", memberService.joining(member).getEmail());
		mav.setViewName("/member/join/joinCertify");
		
		return mav;
	}
	@RequestMapping(value="joinCertifiedAction", method=RequestMethod.POST)
	public ModelAndView joinCertifiedAction(Certification certification) {
		mav = new ModelAndView();
		mav.addObject("email", memberService.joined(certification).getEmail());
		mav.setViewName("/member/join/joinCertified");
		
		return mav;				
	}

	/* 회원 조회  */
	@RequestMapping(value="searchAction", method=RequestMethod.POST)
	public ModelAndView searchAction(String email) {
		mav = new ModelAndView();
		mav.addObject("member", memberService.search(email));
		//view를 지정하지 않았을 때 자신을 호출한 jsp로 리턴되던걸로 기억하는데 이를 테스트해야함.
		//mav.setViewName("/member/search");
		return mav;
	}
	
	@RequestMapping(value="duplicationCheckAction", method=RequestMethod.POST)
	@ResponseBody
	public Duplication duplicationCheckAction(String email) {
		if(memberService.existence(email)){
			return new Duplication(true);
		}
		return new Duplication(false);
	}
	
	/* 회원정보 수정 */
	@RequestMapping(value="updateForm", method=RequestMethod.POST)
	public String updateForm() {
		return "/member/updateForm";
	}
	@RequestMapping(value="updateAction", method=RequestMethod.POST)
	public String updateAction(Member member) {
		memberService.update(member);
		return "/member/update";
	}
	
	/* 회원 탈퇴 */
	@RequestMapping(value="secedeAction", method=RequestMethod.POST)
	public String secedeAction(String email) {
		memberService.secede(email);
		return "/member/secede";
	}
	
	/* 회원 리스트 */
	@RequestMapping(value="listAction", method=RequestMethod.POST)
	public String listAction(PageVO pageVO) {
		mav = new ModelAndView();
		mav.addObject("list", memberService.list(pageVO));		
		return "/member/list";
	}
	
	/* 회원 비밀번호 찾기 */
	@RequestMapping(value="recoverForm", method=RequestMethod.GET)
	public String recoverForm() {
		return "/member/recoverForm";
	}
	@RequestMapping(value="recoveryAction", method=RequestMethod.POST)
	public String recoveryAction(Member member) {
		memberService.recover(member.getEmail());
		return "/member/recoveryCheckKey";
	}
	@RequestMapping(value="recoveredAction", method=RequestMethod.POST)
	public String recoveredAction(Certification certification) {
		memberService.recovered(certification);
		return "/member/recoverySuccess";
	}
	
	/* 회원 로그인  */
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "/member/login/loginForm";
	}
	@RequestMapping(value="loginAction", method=RequestMethod.POST)
	public String loginAction(HttpSession session, Member member) {
		System.out.println("loginAction");
		Login login = (Login)session.getAttribute("login");
		String returnView;
		
		returnView = memberService.loginRejectCheck(login);
		
		if(returnView != null){
			if(!memberService.login(member)){
				int nextCnt = login.getLoginCnt()+1;
				if(nextCnt > 3){
					Date rejectionTime = new Date(new Date().getTime() + (long)(1*60*60*1000));
					
					login.setLoginYN(false);
					login.setLoginCnt(nextCnt);
					login.setLoginRejectionYN(false);
					login.setLoginRejectionTime(rejectionTime);
					session.setAttribute("login", login);
					
					returnView = "/member/login/loginReject";
				}else{
					
					login.setLoginCnt(nextCnt);
					login.setLoginYN(false);				
					session.setAttribute("login", login);
					
					returnView = "/member/login/loginFail";
				}
				
				returnView = "/member/login/loginSuccess";
			}
		}
		
		return returnView;
	}

}
