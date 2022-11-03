<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<%@include file="navbar.jsp"%>
    <div class="jumbotron big-banner" style="height: 800px; padding-top: 20px;">
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		<div class="card">
		<div class="card-body">
				<h3 class="text-center my-3">Register</h3>
	
			<form:form action="customerSignUp" modelAttribute="custRegist" method="post">
				<!--product title  -->
				 <div class="form-group">
    <label for="customerName">Enter name</label>
    <input type="text" class="form-control" name="customerName"  placeholder="Enter here">
    </div>
    
    			 <div class="form-group">
    <label for="customerUsername">Enter user-name</label>
    <form:input path="customerUsername" class="form-control"  placeholder="Enter here"/>
    <form:errors path="customerUsername" cssClass="text-danger"/>
    </div>
    
  			 <div class="form-group">
    <label for="customerPassword">Enter password</label>
    <form:input path="customerPassword" class="form-control" placeholder="Enter here"/>
    <form:errors path="customerPassword" cssClass="text-danger"/>
    </div>
    
		 <div class="form-group">
    <label for="customerEmail">Enter email-address</label>
    <input type="text" class="form-control" name="customerEmail"  placeholder="Enter here">
    </div>
    
    	 <div class="form-group">
    <label for="customerPhone">Enter mobile-number</label>
    <input type="number" class="form-control" name="customerPhone" placeholder="Enter here">
    </div>
    			 <div class="form-group">
    <label for="customerAddress">Enter address</label>
    <textarea class="form-control" name="customerAddress" placeholder="Enter address"></textarea>
    </div>
    
   		
			
				      			
				      			<div class="container text-center">
					<button class="btn btn-outline-success">Register</button>
				</div>	
				
				      				<div class="container text-side">
					<button class="btn btn-outline-success"><a href="backtologin">Back</a></button>
				</div>	
    
</form:form>
</div>
</div>
		</div>
 </div>
  </div>
		</body>
			<!--end form  -->