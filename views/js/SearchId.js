$("#searchId").click(function(){
	var params={
		searchName : $("#searchName").val(),
		searchEmail : $("#searchEamil").val(),
		searchBirth : $("#searchEamil").val(),
		searchIdResult : $("#searchIdResult").val()
	}
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/searchId/result",
		data : params,
		success:function(res){
			document.getElementById('searchIdResult').value = res.searchIdResult;
			resultOfSearchId();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

const resultOfSearchId = () =>{
	if($('#searchIdResult').val() == 'notExist'){
		$('#inputform').css('display','none');
		$('#result').val() = "검색 결과가 없습니다."
		$('#result').css('display','content');
	} else {
		$('#inputform').css('display', 'none');
		$('result').val() = $('#searchIdResult').val();
		$('result').css('display','content');
	}
}