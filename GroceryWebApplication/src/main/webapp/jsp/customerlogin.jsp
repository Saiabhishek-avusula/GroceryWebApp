<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/customer.css">
</head>

<body>
<%@include file="navbar.jsp"%>
<section class="form my-4 mx-5">
<div class="container">
<div class="row no-gutters">
<div class="col-lg-5">
<img src="../resources/img/signinimg1.jpg" class="img-fluid" alt="">
</div>
<div class="col-lg-7 px-5 pt-5">
<h1 class="font-weight-bold py-3">Hi User!!</h1>
<h4>Login to your account</h4>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form:form action="customerLogin" method="post" modelAttribute="custLogin">
<div class="form-row">
<div class="col-lg-7">
<form:input path="customerUsername" placeholder="username" class="form-control my-3 "/>
<form:errors path="customerUsername" cssClass="text-danger"/>
</div>
</div>
<div class="form-row">
<div class="col-lg-7">
<form:input path="customerPassword" placeholder="*******" class="form-control my-3"/>
<form:errors path="customerPassword" cssClass="text-danger"/>
</div>
</div>
<div class="form-row">
<div class="col-lg-7">
<button type="submit" class="btn1 mt-3 mb-5">Login</button>
</div>
</div>
<a href="#">forget password</a>
<p>Don't have an account?<a href="customerregister">Register here</a></p>
<br><br><br><br><br>
</form:form>
</div>
</div>
</div>
</section>
</body>
</html>