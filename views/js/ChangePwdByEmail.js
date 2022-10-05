$("#checkEmailForm").click(function(){
    var params={
		userId : $("#userId").val(),
		userEmail : $("#userEmail").val(),
		randomNumber: $('#randomNumber').val()
	}
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/change/password/email",
		data : params,
		success:function(res){
			let randomNumber = document.getElementById('randomNumber').value
            randomNumber = res.randomNumber;
			if(randomNumber != ""){
                em();
            } else {
                alert('없는 정보 입니다.')
            }
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

// $("#chcekCode").click(function(){
//     var params={
// 		userEmail : $("#userEmail").val(),
// 		randomNumber: $('#randomNumber').val(),
// 	}
// 	$.ajax({
// 		type: "POST",
// 		url: "http://localhost:8080/change/password/email/certificationEmailCode",
// 		data : params,
// 		success:function(res){
// 			document.getElementById('randomNumber').value = res.randomNumber;
// 			checkCertificationEmailCode();
			
// 		},
// 		error : function(XMLHttpRequest, textStatus, errorThrown){
//             alert("오류")
//         }
// 	});
// });

const checkCertificationEmailCode = () =>{
	if(document.getElementById('checkCertificationEmailCode').value == document.getElementById('randomNumber').value){
		dm();
	} else {
		console.log(document.getElementById('randomNumber').value);
		alert('올바른 인증코드를 입력해주세요.');
	}
}

const em=()=>{
    var e = document.getElementById('email-form');
    var c = document.getElementById('email-check');
    e.style.transform="translateY(-1000px)";
    e.style.transition="2s";
    c.style.transform="translateY(-400px)";
    c.style.transition="2s";
}

const dm=()=>{
	var e = document.getElementById('email-check');
    var c = document.getElementById('changeByEmail');
    e.style.transform="translateY(-1000px)";
    e.style.transition="2s";
    c.style.transform="translateY(-600px)";
    c.style.transition="2s";

}
// $("#changeNewPwd").click(function changePwdAction(){
//     var params={
// 		userID : $("#newPwd").val(),
// 		userEmail : $("#checkNewPwd").val()
// 	}
// 	$.ajax({
// 		type: "POST",
// 		url: "http://localhost:8080/change/password",
// 		data : params,
// 		success:function(res){
// 			if(document.getElementById('newPwd').value == document.getElementById('newEmail').value){
//                 alert('변경되었습니다. 다시 로그인 해주세요.');
//                 window.close();
//                 return true;
//             } else {
//                 alert('비밀번호가 일치하지 않습니다.');
//                 return false;
//             }
			
// 		},
// 		error : function(XMLHttpRequest, textStatus, errorThrown){
//             alert("오류")
//         }
// 	});
// });
const checkPwd = () =>{
	if(document.getElementById('newPwd').value == document.getElementById('checkNewPwd').vlaue){
		changePwdAction();
		alert('변경되었습니다.');
		return true;
	} else {
		alert('비밀번호가 일치하지 않습니다.');
		return true;
	}
}


const changePwdAction = () =>{
	let data = {
		'newPwd' : document.getElementById('newPwd').value,
		'checkNewPwd' : document.getElementById('checkNewPwd').value
	};
	let res = fetch("http://localhost:8080/change/password",
				{method:'POST',
				headers:{'Content-type' : 'application/json'},
				body:JSON.stringify(data)
				}).then(res => res.json());
	
};


