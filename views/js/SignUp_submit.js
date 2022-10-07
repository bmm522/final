$("#submit").click(function(){
    var params={
        userId : $("#userId").val(),
        userPwd : $("#password").val(),
        userName : $("#userName").val(),
        userEmail : $("#email").val(),
        userBirth : $("#birth").val(),
        userPhone : $("#phoneNumber").val(),
        userAddress : $("#address").val()
                     +$("#postcode").val()
                     +$("#extraAddress").val()
                     +$("#detailAddress").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/signup/register",
        data : params,
        success:function(res){
            alert("성공");
            // TIMER();
            
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
    });
});

// var registerData = {
//     dataType:'json',
//     url:"http://localhost:8080/signup/register",
//     success:function(res){
//         alert('성공');
//     },
//     error:function(res){
//         alert('오류');
//     }
// }

// $('#submit').submit(function(){
//     $(this).ajaxSubmit(registerData);
//     return false;
// })