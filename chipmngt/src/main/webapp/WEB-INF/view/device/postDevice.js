<script type="text/javascript">
$(function() {
	$("#submit_device").on("click", function() {
		
		var device = $("#device").val();
		var family = $("#family").val();
		
		if(device != "" && family != "") {
			$.ajax({
				url : "/device/" + device + "/" + family,
				type : "post",
				dataType : "json",
				success : function(data) {
					console.log(data);
					alert(JSON.stringify(data));
					$("#device").val("");
					$("#family").val("");
				},
				error : function(error) {
					console.log(error);
					alert("서버에서 문제가 발생하였습니다.");
				},
			})
		} else {
			alert("Customer를 입력하세요.")
		}
		
		
	})
})
</script>