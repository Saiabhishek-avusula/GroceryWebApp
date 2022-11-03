<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>View Products</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

	<%@include file="navbar.jsp"%>


    <div class="jumbotron">
				<h3 class="text-center my-3">Hello ${show.adminUsername} !</h3> 
				<h4 class="text-center my-3">view product details</h4> 
				<h3>No.of Products: ${product.size()}</h3>       
			 
			<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc</th>
       <th scope="col">Product Discount</th>
        <th scope="col">Product price</th>
        <th scope="col">Product Stock</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${product}" var="i">
  <form action="updateProducts" class="justify-content-center">
    <tr>
    
    
      <td><input type="text" name="pId" value="${i.pId}"></td>
      <td><input type="text" name="pName" value="${i.pName}"></td>
      <td><input type="text" name="pDesc" value="${i.pDesc}"></td>
      <td><input type="text" name="pDiscount" value="${i.pDiscount}"></td>
      <td><input type="text" name="pPrice" value="${i.pPrice}"></td>
      <td><input type="text" name="stock" value="${i.stock}"></td>
      <td><input type="hidden" name="pPhoto" value="${i.pPhoto}"></td>
     <td><input type="submit" value="update">
      
    </tr>
    <input type="hidden" name="id" value="${i.category.categoryId}">
   </form> 
 </c:forEach>
 </tbody>
 </table>
  <div class="container text-side">
<button class="btn btn-outline-success">
<a href="back">Back</a></button>
</div>	
    


  
</div>


		</body>