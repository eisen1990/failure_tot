<script>
$(function() {
	$.ajax({
		url : "/device/list",
		type : "post",
		dataType : "json",
		success : function(data) {
			console.log(data);
			//alert(JSON.stringify(data));
			$("#list_contents").append(JSON.stringify(data));
		},
		error : function(error) {
			console.log(error);
			alert("서버에서 문제가 발생하였습니다.");
		},
	})
})
</script>