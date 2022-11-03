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


    <div class="jumbotron admin-banner" style="height: 680px; padding-top: 5px;">

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		<div class="card">
		<div class="card-body">
				<h3 class="text-center my-3">Hello ${show.adminUsername} !</h3> 
				<h4 class="text-center my-3">view details</h4>       
			<form action="updateAdmin">
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
      <td>Admin Id</td>
      <td><input type="text" name="adminId" value="${show.adminId}"></td>
    </tr>
      <th scope="row">2</th>
      <td>Username</td>
      <td><input type="text" name="adminUsername" value="${show.adminUsername}"></td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Password</td>
      <td><input type="text" name="adminPass" value="${show.adminPass}"></td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>Address</td>
      <td><input type="text" name="adminAddress" value="${show.adminAddress}"></td>
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>Mobile No</td>
      <td><input type="text" name="adminMobile" value="${show.adminMobile}"></td>
    </tr>
    <tr>
      <th scope="row">6</th>
      <td>Mail Id</td>
      <td><input type="text" name="adminMail" value="${show.adminMail}"></td>
    </tr>
  </tbody>
</table>
    			 
				      			
				      			<div class="container text-center">
					<button class="btn btn-outline-success">submit</button>
				</div>	
				
				      			<div class="container text-side">
					<button class="btn btn-outline-success"><a href="back">Back</a></button>
				</div>	
    
</form>
</div>
</div>
		</div>

 </div>
  </div>
		</body>
















<%-- <form action="updateAdmin">
username:
<input type="text" name="adminUsername" value="${show.adminUsername}">
id:
<input type="number" name="adminId" value="${show.adminId}">
password:
<input type="text" name="adminPass" value="${show.adminPass}">
mail:
<input type="text" name="adminMail" value="${show.adminMail}">
Mobile:
<input type="text" name="adminMobile" value="${show.adminMobile}">
Address:
<input type="text" name="adminAddress" value="${show.adminAddress}">
<input type="submit" value="submit">
</form>
</body>
</html> --%>