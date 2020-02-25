<script type="text/javascript" charset="utf-8">
	function deleteCustomer(id_val) {
//		console.log(id_val);
		if(confirm("Are you sure you want to Delete?")) {
			if(id_val > 0) {
				$.ajax({
					url : "/customer/delete/" + id_val,
					type : "post",
					dataType : "json",
					success : function(data) {
						console.log(data);
						
						if(data.result  == true) {
							free_list();
							get_list();
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
				alert("Please choose correct customer.")
			}
		} else {
			;
		}
		
	}
</script>