<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>View Customers</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

	<%@include file="navbar.jsp"%>


    <div class="jumbotron admin-banner" style="height: 680px; padding-top: 5px;">

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		<div class="card">
		<div class="card-body">
				<h3 class="text-center my-3">Hello ${customer.customerUsername} !</h3> 
				<h4 class="text-center my-3">view details</h4> 
				      
			<form action="updatecustomer">
				<!-- View Admin Details -->
				
				<table class="table table-striped">
  <thead>
    <tr>
    <th scope="col">S no</th>
      <th scope="col">Titles</th>
      <th scope="col">Details</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <tr>
      <th scope="row">1</th>
      <td>Customer Id</td>
      <td><input type="text" name="customerId" value="${customer.customerId}"></td>
    </tr>
      <th scope="row">2</th>
      <td>Username</td>
      <td><input type="text" name="customerUsername" value="${customer.customerUsername}"></td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Password</td>
      <td><input type="password" name="customerPassword" value="${customer.customerPassword}"></td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>Address</td>
      <td><input type="text" name="customerAddress" value="${customer.customerAddress}"></td>
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>Mobile No</td>
      <td><input type="text" name="customerPhone" value="${customer.customerPhone}"></td>
    </tr>
    <tr>
      <th scope="row">6</th>
      <td>Mail Id</td>
      <td><input type="text" name="customerEmail" value="${customer.customerEmail}"></td>
    </tr>
  </tbody>
</table>
    			 
				      			
				      			<div class="container text-center">
					<button class="btn btn-outline-success">submit</button>
				</div>	
				
				      			<div class="container text-side">
					<button class="btn btn-outline-success"><a href="backtoproducts">Back</a></button>
				</div>	
    
</form>
</div>
</div>
		</div>

 </div>
  </div>
		</body>
