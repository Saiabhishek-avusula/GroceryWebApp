<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/admin.css">
</head>

<body>
<%@include file="navbar.jsp"%>
<section class="form my-4 mx-5">
<div class="container">
<div class="row">
<div class="col-lg-5">
<img src="../resources/img/admin.png" class="img-fluid" alt="" >
</div>
<div class="col-lg-7 px-5 pt-5">
<h1 class="font-weight-bold py-3">Hi Admin!!</h1>
<h4>Login to your account</h4>

<form:form action="adminLogin" method="post" modelAttribute="adminLogin">
<div class="form-row">
<div class="col-lg-7">
<form:input path="adminUsername" placeholder="username" class="form-control my-3 " />
<form:errors path="adminUsername" cssClass="text-danger"/>

</div>
</div>
<div class="form-row">
<div class="col-lg-7">
<form:input path="adminPass" placeholder="*******" class="form-control my-3 "/>
<form:errors path="adminPass" cssClass="text-danger"/>
</div>
</div>
<div class="form-row">
<div class="col-lg-7">
<button type="submit" class="btn1 mt-3 mb-5">Login</button><br><br><br><br><br><br>
</div>
</div>
</form:form>
</div>
</div>
</div>
</section>
</body>
</html>