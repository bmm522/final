const checkDuplicateOfId = () =>{
    
    if($("#checkIdResult").val()){
    $("#alertCheckId").text()="사용가능";
    $("#alertCheckId").css('color','yellowgreen');
    return true;
   } else {
    $("#alertCheckId").text()="이미 중복된 아이디입니다.";
    return false;
   }
}

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
            $("#checkIdResult").val()=res.checkIdResult;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }    
    })

});