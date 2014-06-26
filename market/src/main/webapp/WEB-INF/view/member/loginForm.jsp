<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>loginForm</title>

</head>

<body>
	<div id="login">
		<form action="/member/loginAction.do" method="POST">
			<div>
			<table>
				<tr>
					<td width="120"><input type="text" name="userId" id="userid" value="" maxlength="16" /></td>
					<td width="10"></td>
					<td rowspan="3"><input type="submit" value="Login" /></td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td><input type="password" name="userPw" id="userpw" value="" maxlength="16" /></td>
				</tr>					
				<tr>
					<td colspan="2" align="left">
						<a href="/member/joinForm.do">회원가입</a> / <a href="/member/findIdForm.do">ID</a> / <a href="/member/findPwForm.do">PW 찾기</a>
					</td>
				</tr>										
			</table>
			</div>
		</form>
	</div>
</body>

</html>