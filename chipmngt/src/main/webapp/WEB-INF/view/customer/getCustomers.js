<script type="text/javascript" charset="utf-8">
function get_list() {
	$.ajax({
		url : "/customer/list",
		type : "get",
		dataType : "json",
		success : function(data) {
			console.log(data);
			// alert(JSON.stringify(data));
			// $("#list_contents").append(JSON.stringify(data));
			var customer_tbody = $("#customer_tbody");
			var html_code = "";
			if(data.result == true) {
				for(var i = 0; i < data.list.length; i++) {
					var obj = data.list[i];
					var o_id = obj.id;
					var o_cus = obj.customer;
					var o_tc = obj.tc_customer;
					var o_end = obj.end_customer;
					
					if(o_cus == null) {
						o_cus = "";
					} else {
						;
					}
					
					if(o_tc == null) {
						o_tc = "";
					} else {
						;
					}
					
					if(o_end == null) {
						o_end = "";
					} else {
						;
					}
					
					html_code += "<tr>";
					html_code += "<td>";
					html_code += o_id +"";
					html_code += "</td>";
					html_code += "<td><input type='text' id='customer_id_" + o_id + "' value='"+ o_cus +"'>";
					html_code += "</input></td>";
					html_code += "<td><input type='text' id='tc_customer_id_" + o_id + "' value='"+ o_tc +"'>";
					html_code += "</input></td>";
					html_code += "<td><input type='text' id='end_customer_id_" + o_id + "' value='" + o_end + "'>";
					html_code += "</input></td>";
					html_code += "<td>";
					html_code += "<a onclick='putCustomer(\"" + o_id + "\")'>";
					html_code += "Mod";
					html_code += "</a>";
					html_code += "</td>";
					html_code += "<td>";
					html_code += "<a onclick='deleteCustomer(\"" + o_id + "\")'>";
					html_code += "Delete";
					html_code += "</a>";
					html_code += "</td>";
					html_code += "</tr>";	
				}
			} else {
				html_code = "목록이 존재하지 않습니다.";	
			}
			customer_tbody.append(html_code);
		},
		error : function(error) {
			console.log(error);
			alert("서버에서 문제가 발생하였습니다.");
		},
	})
}

function free_list() {
	var customer_tbody = $("#customer_tbody");
	var html_code = "";
	customer_tbody.empty();
}

$(function() {
	get_list();
})
</script>