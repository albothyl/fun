package org.project.swindle.controller;

import javax.annotation.Resource;

import org.project.common.module.code.service.CodeService;
import org.project.common.system.globalCode.defineCode;
import org.project.common.vo.PageVO;
import org.project.swindle.domain.Swindle;
import org.project.swindle.service.SwindleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("swindle")
public class SwindleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwindleController.class);
	
	@Resource(name="swindleService")
	SwindleService swindleService;
	
	@Resource(name="codeService")
	CodeService codeService;

		
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(@ModelAttribute PageVO<Swindle> pageVO) {
		logger.debug("input : " + pageVO.toString());
				
		return "/swindle/writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute Swindle swindle, @ModelAttribute PageVO<Swindle> pageVO, ModelMap model) {
		logger.debug("input : " + swindle.toString());
		
		swindleService.write(swindle);
		
		model.addAttribute("swindleList", swindleService.list(pageVO));
		
		return "/swindle/list";
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(@ModelAttribute Swindle swindle, @ModelAttribute PageVO<Swindle> pageVO, ModelMap model) {
		logger.debug("input : " + swindle.toString());
		
		model.addAttribute("swindleRead", swindleService.read(swindle));
		
		return "/swindle/read";
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public String updateForm(@ModelAttribute Swindle swindle, @ModelAttribute PageVO<Swindle> pageVO) {
		logger.debug("input : " + swindle.toString());
		
		return "/swindle/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute Swindle swindle, @ModelAttribute PageVO<Swindle> pageVO, ModelMap model) {
		logger.debug("input : " + swindle.toString());
		
		swindleService.update(swindle);
		
		model.addAttribute("swindleRead", swindleService.read(swindle));
		
		return "/swindle/read";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute Swindle swindle, @ModelAttribute PageVO<Swindle> pageVO, ModelMap model) {
		logger.debug("input : " + swindle.toString());
		
		swindleService.delete(swindle);
		
		model.addAttribute("swindleList", swindleService.list(pageVO));
		
		return "/swindle/list";
	}
	
	@RequestMapping(value="searchForm", method=RequestMethod.GET)
	public String searchForm(ModelMap model) {
		PageVO<Swindle> pageVO = new PageVO<Swindle>();
		pageVO.setDefault();
		
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("codeList", codeService.commonCodelist(defineCode.SWINDLE_SEARCH_CODE));
		return "/swindle/list";
	}
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	@ResponseBody
	public Swindle list(@ModelAttribute PageVO<Swindle> pageVO, ModelMap model) {
		logger.debug("input : " + pageVO.toString());
		
		model.addAttribute("codeList", codeService.commonCodelist(defineCode.SWINDLE_SEARCH_CODE));
		
		if(pageVO.getSearchKeyword() != null) {
			System.out.println("listing");
			model.addAttribute("swindleList", swindleService.list(pageVO));
		}else{
			System.out.println("form");
			pageVO.setDefault();
		}
		
		return new Swindle();
	}

}
