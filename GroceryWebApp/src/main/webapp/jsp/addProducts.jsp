<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Add Products</title>

<%@include file="common_css_js.jsp"%>
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

	<%@include file="navbar.jsp"%>


    <div class="jumbotron big-banner" style="height: 800px; padding-top: 20px;">

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		<div class="card">
		<div class="card-body">
				<h3 class="text-center my-3">Add products here</h3>
	
			<form action="uploadProduct" enctype="multipart/form-data" method="post">
				<!--product title  -->
				 <div class="form-group">
    <label for="pName">Enter name of the product</label>
    <input type="text" class="form-control" name="pName" aria-describedby="products" placeholder="Enter here">
    </div>
    
    			 <div class="form-group">
    <label for="pDesc">Enter Description</label>
    <textarea class="form-control" name="pDesc" aria-describedby="products" placeholder="Enter description"></textarea>
    </div>
    
      			 <div class="form-group">
    <label for="pPrice">Enter price </label>
    <input type="number" class="form-control" name="pPrice" aria-describedby="products" placeholder="Enter here">
    </div>
    
    <div class="form-group">
    <label for="pDiscount">Enter discount </label>
    <input type="number" class="form-control" name="pDiscount" aria-describedby="products" placeholder="Enter here">
    </div>
    
        			
    
   		<div class="form-group">
   		<label for="categoryId">select category </label>
					<select name="categoryId" class="form-control" id="categoryId">
						<option disabled selected>Category</option>
					<option value="1">Fruits</option>
					<option value="2">Vegetables</option>
					<option value="3">Atta, Flours & Sooji</option>
					<option value="6">Masalas & Spices</option>
					<option value="4">Rice & Food Grains</option>
					<option value="5">Eggs</option>
					<option value="7">Fish & Seafood</option>
					<option value="8">Dairy</option>
					</select>
				</div>
				
   		            <div class="form-group"> 
     				file:<input type="file" name="multipartfile"><br>
				</div>
				      			
				      			<div class="container text-center">
					<button class="btn btn-outline-success">Add Product</button>
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




