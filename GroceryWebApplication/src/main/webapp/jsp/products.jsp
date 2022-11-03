<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Products</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/product.css">

<script>
	window.onload=()=>{
		console.log("In")
		setTimeout(function(){
			console.log("1");
		document.getElementById("cart-status").style.display="none"	;
		},2000);
	};
</script>

</head>
<body>

	<%@include file="navbar.jsp"%>
	<div class="row mt-3 mx-2">

		<!-- show categories -->
		<div class="col-md-2">

			<div class="list-group mt-4">

				<a href="getspecificproducts?category=all" class="list-group-item list-group-item-action active"
					aria-current="true"> All Products </a>

				<c:forEach items="${category}" var="i">
					<a href="getspecificproducts?category=${i.categoryId}" class="list-group-item list-group-item-action">${i.categoryTitle}</a>
				</c:forEach>
			</div>
		</div>
		<!-- show products  -->
		<div class="col-md-10">
	

			<!-- rows -->
			<div class="row mt-4">

				<!-- col:12 -->
				<div class="col-md-12">
				
	<c:if test="${status==1}">
<div class="alert alert-success" role="alert" id="cart-status">
  <strong >Item added succesfully!</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

</c:if>	

  <div id="carouselExampleSlidesOnly " class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <a href="getspecificproducts?category=9"><img class="d-block w-100" src="../resources/img/combo.jpg" alt="First slide"></a>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../resources/img/combofood.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../resources/img/favs.jpg" alt="Third slide">
    </div>
  </div>
</div>

					<div class="card-columns">

						<!-- traversing products -->
						<c:forEach items="${product}" var="i">
						
							<div class="card" style="width: 18rem;">
								<div class="container text-center">
								<img src=${i.pPhoto} style="max-height:200px;max-width: 100%;width: auto;" class="card-img-top m-2" alt="...">
								</div>
								<div class="card-body">
									<h5 class="card-title">${i.pName}</h5>
									<p class="card-text">${i.pDesc}</p>
									<div class="card-footer">
									<a href="addtocart?product=${i.pId}&quantity=${1}" class="btn custom-bg text-white">Add Cart</a>
								    <a href="#" class="btn btn-outline-primary">&#8377 ${i.pPrice-i.pDiscount*0.01*(i.pPrice)}</a>
								    <p class="float-right" style="color:green">
								<span><s style="color:black">${i.pPrice}</s></span>
								${i.pDiscount}%OFF</p>
								</div>
								 
							</div>
							</div>
							
						</c:forEach>
					</div>
					
					
					
				</div>
			</div>

		</div>
	</div>
</body>
</html>

</body>

