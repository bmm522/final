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
            $("#authenticationNumber").value = res.authenticationNumber;
            
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