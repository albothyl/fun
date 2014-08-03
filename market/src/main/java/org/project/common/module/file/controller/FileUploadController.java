package org.project.common.module.file.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController{
	
	/* 향후 이미지 다운로드 처리 진행한다면 추가함
	 * 
	@Resource(name="fileInfoService")
	FileUploadService fileUploadService;
	*/
	
	public ModelAndView mav = new ModelAndView();

	//스마트에디터 이미지업로드 컨트롤러
	@RequestMapping(value = "/seImageUploadAction.do", method = RequestMethod.POST)
	public ModelAndView writeBoard(Model model, HttpServletRequest request) throws IOException {				
		String orgFileName   = null;
		String newName       = Long.toString(System.currentTimeMillis()) + "_";
	    String uploadPath    = request.getSession().getServletContext().getRealPath("/") + File.separator + "saveImg"; //업로드된 Image가 저장될 경로(html5이미지저장시 파일스트림을 사용하므로 풀경로사용)
		String uploadUrl     = "http://127.0.0.1:8080/saveImg/"; //에디터에 삽입될 이미지 URL
		String callback_func = null; //스마트에디터에서 받은 콜백함수
		String result        = null; //스마트에디터에 전송할 데이터
		
		//업로드 폴더가 없을경우 생성
		File saveDir = new File(uploadPath);
		if(!saveDir.exists())
			saveDir.mkdir();
		
		//Request의 Contnet-Type이 Multipart형식이 아닌 경우
		if(!(request instanceof MultipartHttpServletRequest)){
			//업로드 Request Header에서 File데이터 수신
			orgFileName = request.getHeader("file-name");
			orgFileName = URLDecoder.decode(orgFileName, "utf-8"); 
								
			//업로드 Request에서 파일스트림을 생성하여 파일 저장
		    InputStream input = null; 
		    FileOutputStream outSource = null; 
		    try {
		    	input = request.getInputStream();
		    	File file = new File(uploadPath + "/" + newName + orgFileName);
		    	outSource = new FileOutputStream(file);
		              
	            byte[] data = new byte[1024];
	            int length = 0; 

	            while( (length = input.read(data)) != -1 ) {
	            	outSource.write(data, 0, length); 
	            }
		     } catch(Exception e){ 
		    	 	System.out.println("파일 작성중 에러 발생 : " + e);	              
		     } finally {
		    	 if(outSource != null){
		    		 outSource.close(); 
	             }		              
	             if(input != null){ 
	            	 input.close(); 
	             }    
		     }
         	          
	         result += "&sFileName=" + newName + orgFileName; 
	         result += "&sFileURL="+uploadUrl + newName + orgFileName;
	         result += "&bNewLine=true";
	         
	         mav.addObject("callback_func", result);
	         
	         mav.setViewName("/../../include/openAPI/editor/SE2/photo_uploader/popup/html5Callback");
		 } //multipart is not END
		 else {
			 FileSystemResource uploadDir = new FileSystemResource(uploadPath);
			 MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
			 MultipartFile file = multipart.getFile("Filedata");
			 callback_func = multipart.getParameter("callback_func");
			 
			 if(!file.isEmpty()) {
				 orgFileName = file.getOriginalFilename();
				   
				 try {
					 if(file.getSize() > 0){
						 File out = new File(uploadDir.getPath() + "/" + newName + orgFileName);
					     FileCopyUtils.copy(file.getBytes(), out);
					 }
			     } catch (IOException e) {
			    	 e.printStackTrace();
			     }
			 }
			 mav.addObject("filename", newName + orgFileName);
			 mav.addObject("callback_func", callback_func);
			 
			 mav.setViewName("/../../include/openAPI/editor/SE2/photo_uploader/popup/commonCallback");
		 } //multipart is ok END
		
	     return mav;
	}

}
