<script type="text/javascript" charset="utf-8">
$(function() {
	$("#submit_customer").on("click", function() {
		
		var tc_customer = $("#tc_customer").val();
		var end_customer = $("#end_customer").val();
		
		if(tc_customer != "" && end_customer != "") {
			$.ajax({
				url : "/customer/" + tc_customer + "/" + end_customer,
				type : "post",
				dataType : "json",
				success : function(data) {
//					console.log(data);
//					alert(JSON.stringify(data));
					$("#tc_customer").val("");
					$("#end_customer").val("");
					
					free_list();
					get_list();
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