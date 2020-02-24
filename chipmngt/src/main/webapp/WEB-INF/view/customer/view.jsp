<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file = "../header.jsp" %>

<%@include file = "../nav.jsp" %>

<%@include file = "getCustomers.js" %>
<%@include file = "putCustomer.js" %>
<%@include file = "postCustomer.js" %>


<div class="container-fluid col-sm-9 col-md-10">

	<div id="list_contents">
		<table id="customer_table" class="table">
			<thead>
				<tr>
					<th data-field="id"> Customer ID</th>
					<th data-field="tc_customer">TC Customer</th>
					<th data-field="end_customer">End Customer</th>
					<th><a>수정</a></th>
				</tr>
			</thead>
			<tbody id="customer_tbody">
				
			</tbody>
		</table>
	</div>


	<form method="post" id="insert_customer_form" name="insert_customer_form">
		<input type="text" id="tc_customer" name="tc_customer"> 
		<input type="text" id="end_customer" name="end_customer">
		<button type="button" id="submit_customer">등록</button>
	</form>
</div>


<%@include file = "../footer.jsp" %>
