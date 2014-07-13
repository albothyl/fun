<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String callback_func = (String)request.getAttribute("callback_func");%>

<!doctype html>

<html lang="ko">

<head>
    <meta charset="utf-8">
    
    <script src="/js/jquery-2.0.3.min.js"></script>
    
    <title>SmartEditor HTML5 Callback</title>
</head>

<body>
    ${callback_func}
</body>

</html>