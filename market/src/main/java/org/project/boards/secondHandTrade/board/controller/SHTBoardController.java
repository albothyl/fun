package org.project.boards.secondHandTrade.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SHTBoardController {
/*	
	@Resource(name="jhwService")
	jhwService boardService;
	
	@Resource(name="fileInfoService")
	fileUploadService fileUploadService;
	
	public ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="wrieteForm", method=RequestMethod.GET)
	public ModelAndView writeForm(String subjectCode){
		
		System.out.println("jhwController  :: writeForm");
		
		mav.addObject("subjectCode", subjectCode);
		mav.setViewName("/jhwBoard/jhwWriteForm");
		
		return mav;
	}
	
	@RequestMapping(value="writeAction", method=RequestMethod.POST)
	public ModelAndView writeAction(jhwBoardVO vo){
		
		System.out.println("jhwController   :: writeAction");
		
		int returnCode = boardService.write(vo);
		
		if(returnCode != defineCode.SQLCODE_GOOD)
		{
			mav.addObject("returnCode", returnCode);
			mav.setViewName("/jhwBoard/jhwError");
			return mav;
		}			
		mav.setViewName("/jhwBoard/jhwWriteAction");
		
		return mav;
	}
	
	@RequestMapping(value="readAction", method=RequestMethod.POST)
	public ModelAndView readAction(int bbsNo, String subjectCode){
		
		System.out.println("jhwController   :: readAction");
		
		jhwBoardVO vo = boardService.read(bbsNo);
		
		if(vo.getError_code() != defineCode.SQLCODE_GOOD)
		{
			mav.addObject("subjectCode", subjectCode);
			mav.addObject("returnCode", vo.getError_code());
			mav.setViewName("/jhwBoard/jhwError");
			return mav;
		}
		mav.addObject("jhwBoardVO", vo);
		mav.setViewName("/jhwBoard/jhwRead");
		
		return mav;		
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public ModelAndView updateForm(String subjectCode, Model model){
		
		System.out.println("jhwController   :: updateForm");
		System.out.println(model.toString());

		mav.setViewName("/jhwBoard/jhwUpdateForm");
		
		return mav;	
	}
	
	@RequestMapping(value="updateAction", method=RequestMethod.POST)
	public ModelAndView updateAction(jhwBoardVO vo){
		
		System.out.println("jhwController   :: updateAction");
		
		int returnCode = boardService.update(vo);
		
		if(returnCode != defineCode.SQLCODE_GOOD)
		{
			mav.addObject("returnCode", returnCode);
			mav.setViewName("/jhwBoard/jhwError");
			return mav;
		}
		mav.setViewName("/jhwBoard/jhwUpdateAction");
		
		return mav;	
	}
	
	@RequestMapping(value="deleteAction", method=RequestMethod.POST)
	public ModelAndView deleteAction(int bbsNo, String subjectCode){
		
		System.out.println("jhwController   :: deleteAction");
		
		int returnCode = boardService.delete(bbsNo);
		
		if(returnCode != defineCode.SQLCODE_GOOD)
		{
			mav.addObject("returnCode", returnCode);
			mav.setViewName("/jhwBoard/jhwError");
			return mav;
		}
		
		mav.addObject("subjectCode", subjectCode);
		mav.setViewName("/jhwBoard/jhwDeleteAction");
		
		return mav;
	}
	
	@RequestMapping(value="listAction", method=RequestMethod.GET)
	public ModelAndView listAction(Criteria cri){
		
		System.out.println("jhwController   :: listAction");
		
		cri.chkPageNo(cri.getPageNo());
		
		List<jhwBoardVOList> list = null;
		
		try {
			
			list = boardService.list(cri);
			
		} catch (SQLException e) {
			if(e.getErrorCode() != defineCode.SQLCODE_GOOD)
			{
				System.out.println("SQL ERROR CODE  :: " + e.getErrorCode());
				System.out.println("SQL ERROR MSG   :: " + e.getMessage());
				
				mav.addObject("returnCode", defineCode.SQLCODE_ELSE);
				mav.setViewName("/jhwBoard/jhwError");
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
						
		mav.addObject("jhwBoardVOList", list);
		mav.setViewName("/jhwBoard/jhwList");
		
		return mav;
	}
*/
}
