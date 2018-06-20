<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css" >
</head>
<body>
   <div id="wrapper" >
   <h2>CRM-Customer Relationship Management</h2>
   
   </div>
   <div class=container>
    <table>
    <tr>
     <th>First Name</th><th>Last Name</th><th>Email</th>
    </tr>
     <c:forEach var="tempCustomer" items="${customers}">
     <tr>
     <td>${tempCustomer.firstName}</td>
      <td>${tempCustomer.lastName}</td>
       <td>${tempCustomer.email}</td>
     
     </tr>
     </c:forEach>
    
    </table>
   
   </div>

</body>
</html>