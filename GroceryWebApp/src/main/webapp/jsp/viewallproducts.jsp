<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>View Admin</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

	<%@include file="navbar.jsp"%>


    <div class="jumbotron">
				<h3 class="text-center my-3">Hello ${show.adminUsername} !</h3> 
				<h4 class="text-center my-3">view product details</h4>       
			<form action="updateProducts" class="justify-content-center">
			<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc</th>
       <th scope="col">Product Discount</th>
        <th scope="col">Product price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product}" var="i">
    <tr>
      <td>${i.pId}</td>
      <td><input type="text" name="adminUsername" value="${i.pName}"></td>
      <td><input type="text" name="adminUsername" value="${i.pDesc}"></td>
      <td><input type="text" name="adminUsername" value="${i.pDiscount}"></td>
      <td><input type="text" name="adminUsername" value="${i.pPrice}"></td>
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