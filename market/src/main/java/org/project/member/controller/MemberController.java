package org.project.member.controller;

import javax.annotation.Resource;

import org.project.common.vo.PageVO;
import org.project.member.dto.Member;
import org.project.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Resource(name="memberService")
	MemberService memberService;
	
	private ModelAndView mav;
/*	
	//회원 가입
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "/view/member/joinForm";
	}
	@RequestMapping(value="joinCertifyAction", method=RequestMethod.POST)
	public ModelAndView joinCertifyAction(Member member) {
		mav = new ModelAndView();
		mav.addObject("certification", memberService.certify(member));
		mav.setViewName("/view/member/joinCertify");
		
		return mav;
	}
	@RequestMapping(value="joinCertifiedAction", method=RequestMethod.POST)
	public ModelAndView joinCertifiedAction(Certification certification) {
		mav = new ModelAndView();
		mav.addObject("member", memberService.certified(certification));
		mav.setViewName("/view/member/joinCertified");
		
		return mav;				
	}
*/
	/* 회원 조회  */
	@RequestMapping(value="searchAction", method=RequestMethod.POST)
	public ModelAndView search(String email) {
		mav = new ModelAndView();
		mav.addObject("member", memberService.search(email));
		//view를 지정하지 않았을 때 자신을 호출한 jsp로 리턴되던걸로 기억하는데 이를 테스트해야함.
		//mav.setViewName("/view/member/search");
		return mav;
	}
	
	/* 회원정보 수정 */
	@RequestMapping(value="updateForm", method=RequestMethod.POST)
	public String updateForm(Member member) {
		return "/view/member/updateForm";
	}
	@RequestMapping(value="updateAction", method=RequestMethod.POST)
	public String update(Member member) {
		memberService.update(member);
		return "/view/member/update";
	}
	
	/* 회원 탈퇴 */
	@RequestMapping(value="secedeAction", method=RequestMethod.POST)
	public String secede(String email) {
		memberService.secede(email);
		return "/view/member/secede";
	}
	
	/* 회원 리스트 */
	@RequestMapping(value="listAction", method=RequestMethod.POST)
	public String list(PageVO pageVO) {
		mav = new ModelAndView();
		mav.addObject("list", memberService.list(pageVO));		
		return "/view/member/list";
	}

}
