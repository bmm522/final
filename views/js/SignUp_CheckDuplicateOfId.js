

$("#idButton").click(function(){
    var params={
        userId : $("#userId").val(),
        checkIdResult : $("#checkIdResult").val()
    }
    $.ajax({
        type :"POST",
        url:"http://localhost:8080/signup/id/checkresult",
        data : params,
        success:function(res){
            document.getElementById('checkIdResult').value = res.checkIdResult;
            checkDuplicateOfId(); 
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
    });

});

const checkDuplicateOfId = () =>{
    let notification = document.getElementById('alertCheckId');
    let check = document.getElementById('checkIdResult').value;
    console.log(check);
    if(check == "true"){
        notification.innerHTML="이미 중복된 아이디입니다.";
        
    } else {
        alert('사용 가능');
        notification.innerHTML="";
        
    }
}

// $("#idButton").click(function(){
//     var params={
//         userId : $("#userId").val(),
//         checkIdResult : $("#checkIdResult").val()
//     }
//     $.ajax({
//         type :"POST",
//         url:"http://localhost:8080/signup/id/checkresult",
//         data : params,
//         success:function(res){
//             document.getElementById('checkIdResult').value = res.checkIdResult;
//         },
//         error : function(XMLHttpRequest, textStatus, errorThrown){
//             alert("오류")
//         }    
//     })

// });
