<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file = "../header.jsp" %>

<%@include file = "../nav.jsp" %>

<%@include file = "putDevice.js" %>
<%@include file = "getDevices.js" %>

<div class="container-fluid col-sm-9 col-md-10">

	<div id="list_contents">
	
	</div>


	<form method="post" id="insert_device_form" name="insert_device_form">
		<input type="text" id="device" name="device"> 
		<input type="text" id="family" name="family">
		<button type="button" id="submit_device">등록</button>
	</form>
</div>


<%@include file = "../footer.jsp" %>
