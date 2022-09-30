<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Store</title>

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<!-- custom css file link -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<!-- header section starts here -->
	<header>
		<div class="header-1">
			<a href="#" class="logo"><i class="fas fa-shopping-basket"></i>grocery</a>

			<form action="" class="search-box-container">
				<input type="search" id="search-box" placeholder="search here...">
				<label for="search-box" class="fas fa-search"></label>
			</form>

			<div class="header-2">

				<div id="menu-bar" class="fas fa-bars"></div>

				<nav class="navbar">
					<a href="#home">home</a> 
					<a href="#category">category</a>
					<a href="#product">product</a>
				    <a href="#deal">deal</a> 
				    <a href="#aboutus">aboutus</a>
				</nav>

				<div class="icons">
					<a href="#" class="fas fa-shopping-cart"></a> <a href="#"
						class="fas fa-heart"></a> <a href="#" class="fas fa-user-circle"></a>
				</div>
			</div>
	</header>



	<!-- custom js file link -->
	<script src="js/script.js"></script>
</body>
</html>