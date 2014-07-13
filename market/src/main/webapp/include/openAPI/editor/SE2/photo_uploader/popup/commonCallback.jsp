<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String filename = (String)request.getAttribute("filename");
	String callback_func = (String)request.getAttribute("callback_func");
%>

<!doctype html>

<html lang="ko">

<head>
    <meta charset="utf-8">
    
    <script src="/js/jquery-2.0.3.min.js"></script>
    
    <title>SmartEditor Callback</title>
</head>

<body>
    <script type="text/javascript">
    	//alert("callback");
		// document.domain 설정
		try { document.domain = "http://127.0.0.1:8080"; } catch(e) {}
		
        // execute callback script
        var sUrl = document.location.search.substr(1);
		if (sUrl != "blank") {
			var oParameter = {callback_func:"${callback_func}",sFileName : "${filename}",sFileURL : "http://127.0.0.1:8080/saveImg/${filename}",bNewLine : true }; // query array

	        sUrl.replace(/([^=]+)=([^&]*)(&|$)/g, function(){
	            oParameter[arguments[1]] = arguments[2];
	            return "";
	        });
	        
	        if ((oParameter.errstr || '').length) { // on error
	            (parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_error'])(oParameter);
	        } else {
		        (parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_success'])(oParameter);
		   }
		}
    </script>
</body>

</html>