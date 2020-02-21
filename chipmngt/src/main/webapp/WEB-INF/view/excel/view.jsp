<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file = "../header.jsp" %>

<%@include file = "../nav.jsp" %>

<%@include file = "putExcel.js" %>

<div class="container-fluid col-sm-9 col-md-10">

	<div id="list_contents">
	
	</div>


<form method="post" enctype="multipart/form-data" id="excel_upload_form" name="excel_upload_form">
	<input type="file" name="excelFile" />
	<button type="button" onclick="doExcelUploadProcess()">upload</button>
	</form>
</div>


<%@include file = "../footer.jsp" %>
