<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/admindashboard.css">
</head>
<body style="background-color: LightGoldenRodYellow" background-color:opacity
background="https://images.unsplash.com/photo-1578916171728-46686eac8d58?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8c3VwZXJtYXJrZXR8ZW58MHx8MHx8&w=1000&q=80">
<div class="container">
<div class="card bg-primary text-black">
<div class="card-body">
<h1>ADMIN DASHBOARD</h1>
</div>
</div>
<br>
<div class="row">
<div class="col">
<div class="card h-60">
<div class="card-body">
<h4 class="card-title">View Account</h4>
<br> <a href="viewAdmin" class="btn btn-primary">Click Here</a>
</div>
</div>
</div>
<div class="col">
<div class="card h-60">
<div class="card-body">
<h4 class="card-title">View Products</h4>
<br> <a href="viewallProducts" class="btn btn-primary">Click Here</a>
</div>
</div>
</div>
<div class="col">
<div class="card h-60">
<div class="card-body">
<h4 class="card-title">View All Users</h4>

<a href="viewcustomers" class="btn btn-primary">View Users</a> 
</div>
</div>
</div>
</div>
</div>

<div class="container">
<div class="row">
<div class="col">
<div class="card h-60">
<div class="card-body">
<h4 class="card-title">Add Food Item</h4>
<br> <a href="addProductlink" class="btn btn-primary">Click Here</a>
</div>
</div>
</div>
<div class="col">
<div class="card h-60">
<div class="card-body">
<h4 class="card-title">Total Orders</h4>
<br> <a href="#" class="btn btn-primary">${order.size()}</a>
</div>
</div>
</div>
<div class="col">
<div class="card h-60">

<div class="card-body">
<h4 class="card-title">coming soon..</h4>
<br>
<br> <a href="#" class="btn btn-primary">Click Here</a>
</div>
</div>
</div>
</div>

<div class="container text-side">
<a href="backtoadminlogin"><button class="btn btn-light" style="font-color:black">Logout</button></a>
</div>	
</div>
</body>
</html>
