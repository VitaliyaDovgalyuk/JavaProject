//function api() {
//	var input = "";
//	input = document.getElementById("myInput").value;
//	console.log("Hello000");
//// $.ajax({
//// type : "GET",
//// url : "http://numbersapi.com/" + input + "?json",
//// dataType : "json",
//// success : function(response) {
//// document.getElementById("lol").innerHTML = response.text;
////
//// }
//// });
//	
//	var xhr = $.get(`https://api.giphy.com/v1/gifs/random?api_key=g52ORoGmlnO0MLOFMfWrCJBq0ukDiQgd&tag=$('#myInput.')`
//			);
//}

callApi = (n) => {
	var url = `https://api.giphy.com/v1/gifs/random?api_key=g52ORoGmlnO0MLOFMfWrCJBq0ukDiQgd&tag=${n.value.toLowerCase()}&limit=1`;
	document.getElementById("sKeyword").value = n.value.toLowerCase();
	var xhr = $.get(url);
	xhr.done(function(data) {
	  document.getElementById("genImage").src = data.data.images.original.url;
	  document.getElementById("sUrl").value = data.data.images.original.url;
	  document.getElementById("save").style.visibility = "visible";
	  document.getElementById("userIdInput").style.visibility = "visible";
	  document.getElementById("labeUserId").style.visibility = "visible";
	});
}

saveGif = (n) => {
	
	document.getElementById("sUserId").value = n.value;
    document.getElementById("saveFormHome").submit();
	

}


