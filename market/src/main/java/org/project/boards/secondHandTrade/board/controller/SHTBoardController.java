package org.project.boards.secondHandTrade.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.boards.secondHandTrade.board.service.SHTBoardService;
import org.project.boards.secondHandTrade.reply.service.SHTReplyService;
import org.project.common.module.code.service.CodeService;
import org.project.common.module.code.vo.CodeVO;
import org.project.common.system.customAnnotation.LoginRequired;
import org.project.common.system.customAnnotation.Ownership;
import org.project.common.system.globalCode.defineCode;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;
import org.project.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("board/SHTBoard")
public class SHTBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="shtBoardService")
	SHTBoardService shtBoardService;
	
	@Resource(name="SHTReplyService")
	SHTReplyService shtReplyService;
	
	@Resource(name="codeService")
	CodeService codeService;

	// 메뉴리스트 처리
	@ModelAttribute("menuList")
	public List<CodeVO> menuList() throws Exception {		
		return codeService.menuCodelistAll();
	}

	@LoginRequired
	@RequestMapping(value="writeForm", method=RequestMethod.GET)	
	public String writeForm(@ModelAttribute PageVO<ListVO> pageVO) {
		logger.debug("input : " + pageVO.toString());
		
		return "/boards/secondHandTrade/board/writeForm";
	}
	@LoginRequired
	@RequestMapping(value="write", method=RequestMethod.POST)	
	public String write(@ModelAttribute SHTBoard shtBoard, @ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {
		logger.debug("input : " + shtBoard.toString());
		logger.debug("input : " + pageVO.toString());
		
		shtBoardService.write(shtBoard);
		
		model.addAttribute("codeList", codeService.commonCodelist(defineCode.SHTBOARD_SEARCH_CODE));
		model.addAttribute("pageVO", shtBoardService.list(pageVO));
		return "/boards/secondHandTrade/board/list";
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)	
	public String read(@ModelAttribute SHTBoard shtBoard, @ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {
		logger.debug("input : " + shtBoard.toString());
		logger.debug("input : " + pageVO.toString());
		
		//Board
		model.addAttribute("shtBoard", shtBoardService.read(shtBoard));
		
		//Reply				
		model.addAttribute("replyList", shtReplyService.list(shtBoard.getTradeNo()));
		
		return "/boards/secondHandTrade/board/read";
	}
	
	@LoginRequired
	@Ownership
	@RequestMapping(value="updateForm", method=RequestMethod.POST)	
	public String updateForm(@ModelAttribute SHTBoard shtBoard, @ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {		
		logger.debug("input : " + shtBoard.toString());
		logger.debug("input : " + pageVO.toString());
				
		model.addAttribute("shtBoard", shtBoardService.read(shtBoard));
		return "/boards/secondHandTrade/board/updateForm";
	}
	@LoginRequired
	@Ownership
	@RequestMapping(value="update", method=RequestMethod.POST)	
	public String update(@ModelAttribute SHTBoard shtBoard, @ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {
		logger.debug("input : " + shtBoard.toString());
		logger.debug("input : " + pageVO.toString());
		
		
		shtBoardService.update(shtBoard);
		model.addAttribute("shtBoard", shtBoardService.read(shtBoard));
		return "/boards/secondHandTrade/board/read";
	}
		
	@LoginRequired
	@Ownership
	@RequestMapping(value="delete", method=RequestMethod.POST)	
	public String delete(@ModelAttribute SHTBoard shtBoard, @ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {
		logger.debug("input : " + shtBoard.toString());
		logger.debug("input : " + pageVO.toString());
		
		shtBoardService.delete(shtBoard);
		
		model.addAttribute("codeList", codeService.commonCodelist(defineCode.SHTBOARD_SEARCH_CODE));
		model.addAttribute("pageVO", shtBoardService.list(pageVO));
		return "/boards/secondHandTrade/board/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)	
	public String list(@ModelAttribute PageVO<ListVO> pageVO, ModelMap model) {
		logger.debug("input : " + pageVO.toString());
		
		//model.addAttribute("menuList", codeService.menuCodelistAll());
		model.addAttribute("codeList", codeService.commonCodelist(defineCode.SHTBOARD_SEARCH_CODE));
		model.addAttribute("pageVO", shtBoardService.list(pageVO));
		return "/boards/secondHandTrade/board/list";
	}
	
}
