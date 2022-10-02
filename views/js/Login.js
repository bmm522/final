$("#loginButton").click(function login(){
    var result = false;
    var params={
        userId : $("#inputId").val(),
        userPwd : $("#inputPwd").val(),
        loginResult : $("loginResult").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/login",
        data : params,
        async:false,
        success:function(res){
            document.getElementById('loginResult').value=res.loginResult;
            
            if(loginCheck() == true){
                result = true;
            } else {
                result = false;
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
            
        }
        
    });
    console.log(result);
    return result;
});

const loginCheck = () =>{
    var result = false;
    if(document.getElementById('loginResult').value == "true"){
        sessionStorage.setItem('id',document.getElementById('inputId').value);
        result = true;
    } else{
        alert('아이디 또는 비밀번호가 없거나 틀렸습니다.');
        
    }
    console.log(result);
    return result;
}


