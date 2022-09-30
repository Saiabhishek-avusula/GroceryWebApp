<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateAdmin">
username:
<input type="text" name="adminUsername" value="${show.adminUsername}">
id:
<input type="number" name="adminId" value="${show.adminId}">
password:
<input type="text" name="adminPass" value="${show.adminPass}">
mail:
<input type="text" name="adminMail" value="${show.adminMail}">
Mobile:
<input type="text" name="adminMobile" value="${show.adminMobile}">
Address:
<input type="text" name="adminAddress" value="${show.adminAddress}">
<input type="submit" value="submit">
</form>
</body>
</html>