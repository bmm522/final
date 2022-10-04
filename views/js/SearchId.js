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
			search();
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

const resultOfSearchId = () =>{
	let searchIdResult = document.getElementById('searchIdResult').value;
	if(document.getElementById('searchIdResult').value == 'notExist'){
		// $('#inputform').css('display','none');
		document.getElementById('re').innerHTML = "검색 결과가 없습니다.";
		// $('#result').css('display','block');
	} else {
		// $('#inputform').css('display', 'none');
		document.getElementById('re').innerHTML = "회원님의 아이디는 "+searchIdResult+" 입니다";
		// $('#result').css('display','block');
	}
}



const search=()=>{
  var inputForm = document.getElementById('input-form');
  var resultForm = document.getElementById('result');
  console.log("실행됨");
  inputForm.style.transform="translateY(-1000px)";
  inputForm.style.transition="2s";
  
  result.style.transform="translateY(-1200px)";
  result.style.transition="2s";
  let size = document.getElementById('total-form');
  size.style.height='480px';
  size.style.overflowY='hidden';
  result.style.overflowY='hidden';
  // inputForm.style.display="none";
  
  
}