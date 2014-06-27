/**
 * 
 */
//정상적인 이메일주소 형식인지 확인
function emailCheck(){
	var checkMail = $("#email").val();
	if(!nullCheck("email", checkMail)){
		return false;
	}
	if((checkMail.indexOf("@", 0)) > 0){
		var tail = checkMail.split(".");
		if(tail[1] == "com" || tail[1] == "net"){
			return true;
		}
	}
	return false;			
}
//pw와 확인pw가 일치하는지 확인
function pwCheck(){
	var checkPw = $("#pw").val();
	var pwRepeat = $("#pwRepeat").val();
	if(!nullCheck("password", checkPw)){
		return false;
	}
	if(!nullCheck("password", pwRepeat)){
		return false;
	}
	if(checkPw != pwRepeat){
		alert("password가 서로 틀립니다.");
		return false;
	}
	return true;	
}
function nickCheck(){
	var checkNick = $("#nick").val();
	if(!nullCheck("nickname" + checkNick)){
		return false;
	}
	return true;
}
function nullCheck(where, val){
	checkVal = val.replace(" ", "");
	if(checkVal.length <= 0){
		alert(where + "입력해주세요");
		return false;
	}
	return true;
}
/*
 * function _nullCheck(form){
		if(document.getElementById("userId").value == "null" || document.getElementById("userId").value == "" || document.getElementById("userId").value.length < 6 || document.getElementById("userId").value.length > 16){
			alert("Wrong ID");
		}else if(document.getElementById("userPw").value == "null" || document.getElementById("userPw").value == "" || document.getElementById("userPw").value.length < 6 || document.getElementById("userPw").value.length > 16){
			alert("Wrong PW ");
		}else if( document.getElementById("userPw").value != document.getElementById("userPw2").value ){
			alert("Not Match PW");
		}else if(document.getElementById("userName").value == "null" || document.getElementById("userName").value == "" || document.getElementById("userName").value.length < 2 || document.getElementById("userName").value.length > 4){
			alert("Wrong Name ");
		}else if(document.getElementById("userPhone").value == "null" ||document.getElementById("userPhone").value == "" || document.getElementById("userPhone").value.length < 0 || document.getElementById("userPhone").value.length > 11 ){
			alert("Wrong Phone ");
		}else if(document.getElementById("zipCode").value == "null" || document.getElementById("zipCode").value == "" || document.getElementById("zipCode").value.length < 7 || document.getElementById("zipCode").value.length > 7 ){
			alert("Wrong Zipcode ");
		}else if(document.getElementById("userAddress").value == "null" || document.getElementById("userAddress").value == "" || document.getElementById("userAddress").value.length < 0 || document.getElementById("userAddress").value.length > 50 ){
			alert("Wrong Address ");
		}else if(document.getElementById("userEmail").value == "null" || document.getElementById("userEmail").value == "" || document.getElementById("userEmail").value.length < 0 || document.getElementById("userEmail").value.length > 30 ){
			alert("Wrong Email ");
		}else if(document.getElementById("ssn").value == "null" ||document.getElementById("ssn").value == "" || document.getElementById("ssn").value.length < 13 || document.getElementById("ssn").value.length > 13){
			alert("Wrong SSN ");
		}else{
			form.submit();
		}
	}
*/