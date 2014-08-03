package org.project.common.module.code.controller;

import java.util.List;

import javax.annotation.Resource;

import org.project.common.module.code.service.CodeService;
import org.project.common.module.code.vo.CodeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("code/")
public class CodeController {
	
	@Resource(name="codeService")
	CodeService codeService;
	
	@RequestMapping(value="/menuList.do", method=RequestMethod.GET)
	@ResponseBody
	public List<CodeVO> menuList() {
		return codeService.menuCodelistAll();
	}

}
