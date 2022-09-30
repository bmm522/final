$("#login").click(function(){
    var params={
        userId : $("#inputId").val(),
        userPwd : $("#inputPwd").val(),
        loginResult : $("loginResult").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/login",
        data : params,
        success:function(res){
            document.getElementById('loginResult').value=res.loginResult;
            loginCheck();
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
    });

});

const loginCheck = () =>{
    if(document.getElementById('loginResult').value == "true"){
        sessionStorage.setItem('id',document.getElementById('inputId').value);
    } else{

    }
}

const pageMoveCheck = () =>{
    if(document.getElementById('loginResult').value==true){
        return true;
    } else {
        alert('아이디 또는 비밀번호가 없거나 틀렸습니다.');
        return false;
    }
}

