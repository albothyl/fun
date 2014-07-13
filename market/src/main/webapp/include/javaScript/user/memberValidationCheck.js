function recoverFormValidationCheck(){
	if( !nullCheck("email", $("#email").val()) || !nullCheck("randomKey", $("#randomKey").val()) ){
		return false;
	}
	return true;
}
function updateFormValidationCheck(){
	if( !nullCheck("password", $("#pw").val()) || !nullCheck("nick", $("#nick").val()) ){
		return false;
	}
	return true;
}
function loginFormValidationCheck(){
	if(emailCheck()==false || !nullCheck("password", $("#pw").val())){
		return false;
	}
	return true;
}
function joinFormValidationCheck(){	
	if(emailCheck()==false || pwCheck()==false || nickCheck()==false){
		return false;
	}
	return true;
}
//정상적인 이메일주소 형식인지 확인
function emailCheck(){
	var checkMail = $("#email").val();
	
	if(!nullCheck("email", checkMail)){
		return false;
	}
	
	if((checkMail.indexOf("@", 0)) > 0){
		var tail = checkMail.split(".");
		if(tail[1] != "com" && tail[1] != "net"){
			alert("E-MAIL형식이 아닙니다.");
			return false;
		}
	}else{
		alert("E-MAIL형식이 아닙니다.");
		return false;
	}
	
	return true;			
}
//pw와 확인pw가 일치하는지 확인
function pwCheck(){
	var checkPw = $("#pw").val();
	var pwRepeat = $("#pwRepeat").val();
	if(nullCheck("password", checkPw)==false || nullCheck("password", pwRepeat)==false){
		return false;
	}
	
	if(checkPw != pwRepeat){
		alert("입력하신 password가 서로 틀립니다.");
		return false;
	}
	
	return true;	
}
//nickname 작성여부 확인
function nickCheck(){
	var checkNick = $("#nick").val();
	if(nullCheck("nickname", checkNick)==false){
		return false;
	}
	return true;
}
//null 체크
function nullCheck(where, val){
	if(val.length <= 0){
		alert(where + "입력해주세요");
		return false;
	}
	return true;
}