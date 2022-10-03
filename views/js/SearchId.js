$("#searchId").click(function(){
	var params={
		searchName : $("#searchName").val(),
		searchEmail : $("#searchEmail").val(),
		searchBirth : $("#searchBirth").val(),
		searchIdResult : $("#searchIdResult").val()
	}
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/searchId/result",
		data : params,
		success:function(res){
			document.getElementById('searchIdResult').value = res.searchIdResult;
			
			resultOfSearchId();
			console.log(document.getElementById('searchIdResult').value);
			console.log("실행되긴함");
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

const resultOfSearchId = () =>{
	let searchIdResult = document.getElementById('searchIdResult').value;
	if(document.getElementById('searchIdResult').value == 'notExist'){
		$('#inputform').css('display','none');
		document.getElementById('result').innerHTML = "검색 결과가 없습니다.";
		$('#result').css('display','block');
	} else {
		$('#inputform').css('display', 'none');
		document.getElementById('result').innerHTML = "회원님의 아이디는 "+searchIdResult+" 입니다";
		$('#result').css('display','block');
	}
}