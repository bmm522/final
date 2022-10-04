$("#checkEmailForm").click(function(){
    var params={
		userID : $("#userId").val(),
		userEmail : $("#userEmail").val(),
        certificationEmailCode: $("#certificationEmailCode").val(),
		certificationEmailCodeResult : $("#certificationEmailCodeResult").val()
	}
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/change/password/email",
		data : params,
		success:function(res){
			let check = document.getElementById('certificationEmailCodeResult').value; 
            check = res.certificationEmailCodeResult;
			if(check == "true"){
                em();
            } else {
                alert('잘못된 인증코드 또는 없는 정보 입니다.')
            }
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

const em=()=>{
    var e = document.getElementById('email-form');
    var c = document.getElementById('changeByEmail');
    e.style.transform="translateY(-1000px)";
    e.style.transition="2s";
    c.style.transform="translateY(-400px)";
    c.style.transition="2s";
}

$("#changeNewPwd").click(function changePwdAction(){
    var params={
		userID : $("#newPwd").val(),
		userEmail : $("#checkNewPwd").val()
	}
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/",
		data : params,
		success:function(res){
			if(document.getElementById('newPwd').value == document.getElementById('newEmail').value){
                alert('변경되었습니다. 다시 로그인 해주세요.');
                window.close();
                return true;
            } else {
                alert('비밀번호가 일치하지 않습니다.');
                return false;
            }
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});


