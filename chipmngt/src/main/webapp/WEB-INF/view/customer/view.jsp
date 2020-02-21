<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file = "../header.jsp" %>

<%@include file = "../nav.jsp" %>

<%@include file = "putCustomer.js" %>
<%@include file = "getCustomers.js" %>

<div class="container-fluid col-sm-9 col-md-10">

	<div id="list_contents">
	
	</div>


	<form method="post" id="insert_customer_form" name="insert_customer_form">
		<input type="text" id="tc_customer" name="tc_customer"> 
		<input type="text" id="end_customer" name="end_customer">
		<button type="button" id="submit_customer">등록</button>
	</form>
</div>


<%@include file = "../footer.jsp" %>
