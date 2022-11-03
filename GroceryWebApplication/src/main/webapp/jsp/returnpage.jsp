<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>View users</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

	<%@include file="navbar.jsp"%>
	<form action="returnConfirm" method="post">
<table Class="table table-striped" >
<thead>
<tr>
<th>CustomerId</th>
<th>OrderId</th>
<th>Card</th>
<th>PaymentType</th>
<th>Return reason</th>
</tr>
</thead>
<tbody>
	<tr>
      <td>${payment.customer.customerId}</td>
      <td>${payment.order.orderId}</td>
      <td>${payment.card}</td>
      <td>${payment.paymentType}</td>
      <td><input type="text" name="rreason"/></td>
      </tr>
</tbody>
</table>
 <input type="hidden" name="id" value= ${payment.paymentId}>
      <button type="submit" class="btn btn-outline-success">Confirm</button>
</form>
<button><a href="backtoproducts">Back</a></button>
</body>
	</html>