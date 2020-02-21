<script>
function addRows(val) {
	console.log("company: " + val.company + ", count: " + val.count);
}

function doExcelUploadProcess(){
    
    var f = new FormData(document.getElementById('excel_upload_form'));
    $.ajax({
        url: "/excel/upload",
        data: f,
        processData: false,
        contentType: false,
        dataType: "json",
        type: "POST",
        success: function(data){
            // console.log(data);
            // document.getElementById('result').innerHTML =
			// JSON.stringify(data);
        	if(data.result == "error") {
        		alert("Excep processing error");
        	} else {
	            for(var i = 0; i < data.list.length; i++) {
	                addRows(data.list[i]);
	            }
        	}
        },
        error : function(e) {
            console.log(e);
       	}
    })
}


</script>