function checkEmail(){
	let emailForm = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	let email = document.getElementById('email').value;
	let notification = document.getElementById('alertCheckEmail');
	
	if(emailForm.test(email)){
		notification.style.color='yellowgreen';
		notification.innerHTML = 'Ok!';
	} else {
		notification.style.color='red';
		notification.innerHTML = '형식이 올바르지 않습니다.';
	}
}

function outFocusFromEmail(){
    document.getElementById('alertCheckEmail').innerHTML = '';
}

$("#emailButton").click(function(){
    var params={
        email : $("#email").val(),
        randomnumber : $("#randomnumber").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/signup/email/randomnumber",
        data : params,
        success:function(res){
            document.getElementById("randomnumber").value=res.randomNumber;
            // TIMER();
            
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
    });

});

function outFocusFromCheckEmail() {
    document.getElementById('alertCheckEmail').innerHTML = '';
}

function comeButton(){
    let button = document.getElementById('checkButton');
     button.style.display='inline';

}

const checkRandomNumber = () => {
    const randomNumber = document.getElementById("randomnumber").value;
    const inputRandomNumber = document.getElementById("inputRandomNumber").value;

    if(randomNumber == inputRandomNumber){
		return true;
    } else {
		// alert('올바른 이메일 인증코드를 입력해주세요.');
		return false;
    }	
}

const alertCheckRandomNumber =() =>{
	let button = document.getElementById('checkButton');
	
	if(checkRandomNumber()){
		alert('인증되었습니다.');
		button.style.display='none';
		document.getElementById('alertCheckRandomNumber').innerHTML = 'Ok!';
		document.getElementById('alertCheckRandomNumber').style.color='yellowgreen';
	} else {
		alert('올바른 이메일 인증코드를 입력해주세요.');
	
	}
}

$("#phoneButton").click(function(){
    var params={
        phoneNumber : $("#phoneNumber").val(),
        authenticationNumber : $("#authenticationNumber").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/signup/phone/authenticationNumber",
        data : params,
        success:function(res){
            document.getElementById("authenticationNumber").value=res.authenticationNumber;
            
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            console.log("실패");
        }
    });

});

$("#phoneButton").click(function(){
	$("#checkAuthenticationNumberButton").css('display','inline');
})

const alertCheckauthenticationNumber = () =>{
    const authenticationNumber = $("#authenticationNumber").val();
    const inputAuthenticationNumber = $("#inputAuthenticationNumber").val();
    console.log(authenticationNumber);
    console.log(inputAuthenticationNumber);
    if(authenticationNumber == inputAuthenticationNumber){
        return true;
    } else {
        // alert('올바른 인증번호를 입력해주세요.');
        return false;
    }
}

$("#checkAuthenticationNumberButton").click(function(){
    if(alertCheckauthenticationNumber()){
        alert('인증되었습니다.')
        $("#checkAuthenticationNumberButton").css('display', 'none');
        $("#checkAuthenticationNumberButton").innerHTML='Ok!';
    } else {
        alert('올바른 인증코드를 입력해주세요.');
    }
})

const checkSubmit = () => {
    console.log("실행되긴함");
    
    if(!checkRandomNumber()){
        alert('이메일 인증을 완료하세요.');
        return false;
    }
   
   
    if(!alertCheckauthenticationNumber()){
        alert('핸드폰 인증을 완료하세요.');
        return false;
    }

    
    return true;
    
}