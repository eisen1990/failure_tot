<script type="text/javascript" charset="utf-8">
	function putCustomer(id_val, tc_customer, end_customer) {
		console.log(id_val + ", " + tc_customer + ", " + end_customer);
		if(0) {
		//if(tc_customer != "" && end_customer != "") {
			$.ajax({
				url : "/customer/" + id_val + "/" + tc_customer + "/" + end_customer,
				type : "put",
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
		} else {
			alert("Customer를 입력하세요.")
		}
	}
</script>