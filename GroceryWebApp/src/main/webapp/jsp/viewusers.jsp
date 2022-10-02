<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateProducts"> 
<table>
  <c:forEach items="${product}" var="i">
  
  <tr>
   <td>${i}</td>
      <td>${i.pDesc}</td> 
      <td>${i.pId}</td>
      <td>${i.pName}</td>
      <td>${i.pDiscount}</td>
      <td>${i.pPrice}</td>
    </tr>
  </c:forEach>
   </table>
  

</form>
</body>
</html>