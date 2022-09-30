<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="uploadProduct" enctype="multipart/form-data" method="post">
<h2>enter products details</h2>
title:<input type="text" name="pName"><br><br>
desc:<input type="text" name="pDesc"><br><br>
price:<input type="number" name="pPrice"><br><br>
discount:<input type="number" name="pDiscount"><br><br>
category_id:<select name="categoryId" id="category" class="category">
					<option disabled selected>Category</option>
					<option value="1">Fruits</option>
					<option value="2">Vegetables</option>
					<option value="3">Atta, Flours & Sooji</option>
					<option value="4">Masalas & Spices</option>
					<option value="5">Rice & Rice Products</option>
					<option value="6">Eggs</option>
					<option value="7">Fish & Seafood</option>
					<option value="8">Poultry</option>
					<option value="9">Cakes & Pastries</option>
					<option value="10">Dairy</option>
				</select><br><br>
file:<input type="file" name="multipartfile"><br><br>
<input type="submit" value="submit">
</form>
</center>

</body>
</html>