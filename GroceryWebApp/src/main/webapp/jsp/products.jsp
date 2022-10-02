<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Add Products</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

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
									<a href="#" class="btn custom-bg text-white">Add Cart</a>
								    <a href="#" class="btn btn-outline-primary">&#8377 ${i.pPrice}</a>
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

<%-- <table border=2>

 <tr>
    <th>name</th>
    <th>desc</th>
    <th>Discount</th>
    <th>pic</th>
    <th>price</th>
  </tr>
    <c:forEach items ="${product}" var = "i">
  <tr>
  <td>${i.pName}</td>
<td>${i.pDesc}</td>
<td>${i.pDiscount}</td>
<td>${i.pPhoto}</td>
<td>${i.pPrice}</td>
</tr>
</c:forEach>
</table> --%>