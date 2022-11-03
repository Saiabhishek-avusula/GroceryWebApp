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


    <div class="jumbotron">
				<h3 class="text-center my-3">Hello ${show.adminUsername} !</h3> 
				<h4 class="text-center my-3">view users details</h4>  
				<h3>No.of Users: ${customer.size()}</h3> 
			<form action="updatecustomers" class="justify-content-center">
			<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Customer Id</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Customer Username</th>
       <th scope="col">Customer Phone</th>
        <th scope="col">Customer Email</th>
         <th scope="col">Customer Address</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${customer}" var="i">
    <tr>
      <td>${i.customerId}</td>
      <td><input type="text" name="customerName" value="${i.customerName}"></td>
      <td><input type="text" name="customerUsername" value="${i.customerUsername}"></td>
      <td><input type="text" name="customerPhone" value="${i.customerPhone}"></td>
      <td><input type="text" name="customerEmail" value="${i.customerEmail}"></td>
      <td><input type="text" name="customerAddress" value="${i.customerAddress}"></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
			
			
			      			<div class="container text-center">
					<button class="btn btn-outline-success">update</button>
				</div>	
				
				      			<div class="container text-side">
					<button class="btn btn-outline-success"><a href="back">Back</a></button>
				</div>	
    
</form>
</div>


		</body>