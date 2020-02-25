<script type="text/javascript" charset="utf-8">
	function putCustomer(id_val) {
		
		if(confirm("Are you sure you want to Modify?")) {
		var customer = $("#customer_id_"+id_val).val();
		var tc_customer = $("#tc_customer_id_"+id_val).val();
		var end_customer = $("#end_customer_id_"+id_val).val();
		
		console.log(id_val + ", " + customer + ", " + tc_customer + ", " + end_customer);
		
		if(id_val > 0 && 
				customer != "" && check_param(customer) &&
				tc_customer != "" && check_param(tc_customer) &&
				end_customer != "" && check_param(end_customer)) {
			console.log("url : " + "/customer/put/" + id_val + "/" + customer + "/" + tc_customer + "/" + end_customer)
			$.ajax({
				url : "/customer/put/" + id_val + "/" + customer + "/" + tc_customer + "/" + end_customer,
				type : "post",
				dataType : "json",
				success : function(data) {
					console.log(data);
// alert(JSON.stringify(data));
					
					if(data.result  == true) {
						$("#customer").val("");
						$("#tc_customer").val("");
						$("#end_customer").val("");
					} else {
						alert("Fail to Change.");						
					}
				},
				error : function(error) {
					console.log(error);
					alert("Server error.");
				},
			})
		} else {
			alert("Please input the Customer correctly.")
		}
		} else {
			
		}
	}
</script>