<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Cart</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/cart.css">
<script>
 	function addToCart(productId){
		let quantity=document.getElementById(""+productId).value
		 fetch("addtocart?product="+productId+"&quantity="+quantity);
		
		setTimeout(function(){window.location.href="http://localhost:8080/displaycart"},500);
	}
 	function removeProduct(cartItemId){
		 console.log("In remove js")
		 fetch("removeProduct?cartItemId="+cartItemId);
		
		setTimeout(function(){window.location.href="http://localhost:8080/displaycart"},500);
	}
</script>
</head>
<body>
	<%@include file="navbar.jsp"%>



	<div class="jumbotron">
		<c:if test="${errorCode eq  '606'}">
			  <h5 class="text-center my-3 alert alert-danger" role="alert">${errorMessage} Please Choose Again!</h5> 
		</c:if>
		<h3 class="text-center my-3">Yayy! ${customer.customerUsername}</h3>
		<h4 class="text-center my-3">CART ITEMS</h4>
		<h3>No.of cart items: ${cartitems.size()}</h3>
		<div class="justify-content-center">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">product Name</th>
						<th scope="col">product</th>
						<th scope="col">quantity</th>
						<th scope="col">unit price</th>
						<th scope="col">Sub Total</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartitems}" var="i">
						<tr class="checkoutrow">
							<td><c:out value="${i.product.pName}" /></td>
							<td><img src=${i.product.pPhoto
								} style="max-height: 80px; max-width: 80px; width: auto; margin-right: 10px;"
								alt="..."></td>
							<td><input type="number" min=1 max=10 value="${i.noItems}"
								onchange="addToCart(${i.product.pId})" id="${i.product.pId}"></td>
							<td>${i.product.pPrice-i.product.pPrice*0.01*i.product.pDiscount}</td>
							<td>${(i.product.pPrice-i.product.pPrice*0.01*i.product.pDiscount) * i.noItems}</td>
							<td><button onclick="removeProduct(${i.cartitemId})">x</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h4 class="text-center my-3">Total:${total}</h4>
		<form action="paymentcontrol" class="justify-content-center">
			<div class="container text-center">
				<button class="btn btn-outline-success">CheckOut</button>
			</div>
		</form>
		<div class="container text-side">
			<a href="backtoproducts"><button class="btn btn-outline-success">
				Back
			</button></a>
		</div>


	</div>


</body>
<%-- <h1>total: <c:out value="${total}"></c:out></h1> --%>