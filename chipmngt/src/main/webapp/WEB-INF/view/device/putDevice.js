<script>
$(function() {
	$("#submit_device").on("click", function() {
		$.ajax({
			url : "/device/insert",
			type : "post",
			data : $("#insert_device_form").serialize(),
			dataType : "json",
			success : function(data) {
				console.log(data);
				alert(JSON.stringify(data));
				$("#device").val("");
				$("#device").val("");
			},
			error : function(error) {
				console.log(error);
				alert("서버에서 문제가 발생하였습니다.");
			},

		})
	})
})
</script>