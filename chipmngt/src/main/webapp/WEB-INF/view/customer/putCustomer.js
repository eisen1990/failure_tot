<script>
$(function() {
	$("#submit_customer").on("click", function() {
		$.ajax({
			url : "/customer/insert",
			type : "post",
			data : $("#insert_customer_form").serialize(),
			dataType : "json",
			success : function(data) {
				console.log(data);
				alert(JSON.stringify(data));
				$("#tc_customer").val("");
				$("#end_customer").val("");
			},
			error : function(error) {
				console.log(error);
				alert("서버에서 문제가 발생하였습니다.");
			},

		})
	})
})
</script>