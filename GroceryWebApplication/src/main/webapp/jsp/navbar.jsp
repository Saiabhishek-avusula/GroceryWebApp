<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- <link rel="stylesheet" href="navbar.css"> -->
  <link rel="stylesheet" href="/resources/css/navbar.css">
  <title></title>
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
    integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>
 
<body>
  <div class="navbar">
 
    <!-- Navbar logo -->
     <a class="navbar-brand" href="#">
    <img src="../resources/img/basket.png" width="30" height="30" class="d-inline-block align-top" alt="">
   <b>Grocery Mart</b>
  </a>
 
    <!-- responsive navbar toggle button -->
    <input type="checkbox" id="nav-check">
    <div class="nav-btn">
      <label for="nav-check">
        <span></span>
        <span></span>
        <span></span>
      </label>
    </div>
 
    <!-- Navbar items -->
    <div class="nav-links">
      <a href="backtoproducts">Home<i class="fa fa-home" aria-hidden="true"></i>
      </a>
      <!-- Dropdown menu -->
      <div class="dropdown1">
        <a class="dropBtn" href="#"><%-- ${customer.customerUsername} --%>
          <i class="fas fa-angle-down"></i>
        </a>
        <div class="drop-content1">
          <a href="viewuserorders">orders
          <i class="fa fa-shopping-basket" aria-hidden="true"></i>
          </a>
          <a href="viewcustomer">view profile
          <i class="fa fa-user" aria-hidden="true"></i>
          </a>
          <a href="logoutpage">logout
          <i class="fa fa-sign-out" aria-hidden="true"></i>
          </a>
            </div>
          </div>
          <!-- Dropdown menu -->
      <div class="dropdown1">
        <a class="dropBtn" href="#">Filter
         <i class="fa fa-filter" aria-hidden="true"></i>
        </a>
        <div class="drop-content1">
          <a href="getbyprice">By Price</a>
          <a href="getbyname">By alphabetical order</a>
            </div>
          </div>
         <!--  <button class="loginBtn"><a href="displaycart">cart</a></button> -->
          <a href="displaycart">Cart
          <i class="fa fa-shopping-cart" aria-hidden="true"></i>
          </a>
        </div>
      </div>
</body>
 
</html>




