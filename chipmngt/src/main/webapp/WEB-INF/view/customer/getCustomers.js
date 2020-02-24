<script type="text/javascript" charset="utf-8">
function get_list() {
	$.ajax({
		url : "/customer/list",
		type : "get",
		dataType : "json",
		success : function(data) {
			console.log(data);
			//alert(JSON.stringify(data));
			//$("#list_contents").append(JSON.stringify(data));
			var customer_tbody = $("#customer_tbody");
			var html_code = "";
			for(var i = 0; i < data.list.length; i++) {
				var obj = data.list[i];
				html_code += "<tr>";
				html_code += "<td>";
				html_code += obj.id +"";
				html_code += "</td>";
				html_code += "<td><input type='text' id='tc_customer_id_" + obj.id + "' value='"+ obj.tc_customer +"'>";
				html_code += "</input></td>";
				html_code += "<td><input type='text' id='end_customer_id_" + obj.id + "' value='" + obj.end_customer + "'>";
				html_code += "</td>";
				html_code += "<td>";
				html_code += "<a onclick='putCustomer(\"" + obj.id + "\", \"" + obj.tc_customer + "\", \"" + obj.end_customer + "\")'>";
				html_code += "수정 버튼";
				html_code += "</a>";
				html_code += "</td>";
				html_code += "</tr>";	
				
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