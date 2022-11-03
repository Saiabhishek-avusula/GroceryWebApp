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
<table Class="table table-striped" >
<thead>
<tr>
<th>CustomerId</th>
<th>OrderId</th>
<th>Card</th>
<th>PaymentType</th>
<th>Payment price</th>
<th>Return</th>
</tr>
</thead>
<tbody>
	<c:forEach var="i" items="${order}">
	
	<tr>
      <td>${i.customer.customerId}</td>
      <td>${i.order.orderId}</td>
      <td>${i.card}</td>
      <td>${i.paymentType}</td>
      <td>${i.totalAmount}</td>
      <td>
      <form action="return" method="post">
      <input type="hidden" name="id" value= ${i.paymentId }>
       <button type="submit" class="btn btn-warning">Return</button>
       </form>
      </td>
   </tr>
	</c:forEach>
</tbody>
</table>
<button><a href="backtoproducts">Back</a></button>
</body>
	</html>