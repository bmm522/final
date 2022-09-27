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