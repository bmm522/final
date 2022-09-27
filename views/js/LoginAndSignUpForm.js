/**
 * 
 */
//  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

 var x = document.getElementById("login");
 var y = document.getElementById("register");
 var z = document.getElementById("btn");
            
            
function login(){
	x.style.left = "50px";
	y.style.left = "450px";
	z.style.left = "0";
	let size = document.getElementsByClassName('form-wrap');
	size[0].style.height = '480px';
	size[0].style.overflowY='hidden';
}

function register(){
	x.style.left = "-400px";
	y.style.left = "50px";
	z.style.left = "110px";
	let size = document.getElementsByClassName('form-wrap');
	size[0].style.height = '800px';
	size[0].style.overflowY='scroll';
}
            
function inputPassword(){
	let str = document.getElementById('password').value;
	let notification = document.getElementById('alertInputPassword');
	if(str.length < 7){
		notification.style.color='red';
		notification.innerHTML = '비밀번호는 최소 8자이상이어야 합니다';
	} else {
		notification.innerHTML = 'Ok!';
		notification.style.color ='yellowgreen';
	}
}
function outFocusFromPassword(){
	document.getElementById('alertInputPassword').innerHTML = '';
}

function check(){
	let prePwd = document.getElementById('password').value;
	let checkPwd = document.getElementById('checkPassword').value;
	let notification = document.getElementById('alertCheckPassword');
	
	if(prePwd != checkPwd){
		console.log(checkPwd);
		notification.style.color='red';
		notification.innerHTML = '비밀번호가 일치하지 않습니다.';
	} else {
		console.log(checkPwd);
		notification.style.color='yellowgreen';
		notification.innerHTML = 'Ok!';
	} 

}

function outFocusFromCheck(){
	document.getElementById('alertCheckPassword').innerHTML = '';
}

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

// function emailAPI() {
// 	console.log("실행됨");
// }

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

// function TIMER(){
//     let time = 180000;
//     let min = 3;
//     let sec = 60;
//     document.getElementById('alertCheckRandomNumber')
//     limitTime = setInterval(function(){
//         console.log(typeof time);
//         time = time - 1000; 
//         min = time/(60*1000);

//         if(sec>0){
//             sec = sec-1;
//             document.getElementById('alertCheckRandomNumber').innerHTML="유효 시간 : "+Math.floor(min)+' : '+sec;
//         }

//         if(sec===0){
//             sec=60;
//             document.getElementById('alertCheckRandomNumber').innerHTML="유효 시간 : " + Math.floor(min) + ' : ' + '00';
//         }
//     }, 1000)
// }

// setTimeout(function(){
//     clearInterval(limitTime);
// }, 5000);

// function checkNumber(){
//     const randomNumber = document.getElementById("randomnumber").value;
//     const inputRandomNumber = document.getElementById("inputRandomNumber").value;
//     let notification = document.getElementById('alertCheckRandomNumber');
//     console.log('실행');
//     if(randomNumber == inputRandomNumber){
//         notification.style.color='yellowgreen';
// 		notification.innerHTML = 'Ok!';
//     } else {
//         notification.style.color='red';
// 		notification.innerHTML = '일치하지 않습니다.';
//     }
// }

function outFocusFromCheckRandomNumber() {
    document.getElementById('alertCheckRandomNumber').innerHTML = '';
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
		alert('올바른 인증번호를 입력해주세요.');
		return false;
    }	
}

const alertCheckRandomNumber =() =>{
	if(checkRandomNumber()){
		alert('인증되었습니다.');;
	} else {
		alert('올바른 인증번호를 입력해주세요.');
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
            document.getElementById("randomnumber").value=res.randomNumber;
            // TIMER();
            
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
    });

});
