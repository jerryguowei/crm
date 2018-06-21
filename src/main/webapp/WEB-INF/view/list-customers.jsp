<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
   <div>
   <input type="button" onClick="window.location.href='showAddForm';return false;" class="add-button" value="Add Customer"/>  
   </div>
   <div>
   <form:form action="searchCustomer" method="POST">
   Search Customer:<input type="text" name="theSearchName"/>
    <input type="submit" value="Search" class="add-button"/>
   </form:form>
   </div>
   <div class=container>
    <table>
    <tr>
     <th>First Name</th><th>Last Name</th><th>Email</th><th>Action</th>
    </tr>
     <c:forEach var="tempCustomer" items="${customers}">
     <c:url var="updateLink" value="/customer/showFormForUpdate">
      <c:param name="customerId" value="${tempCustomer.id}"/>
     </c:url>
     <c:url var="deleteLink" value="/customer/deleteCustomer">
      <c:param name="customerId" value="${tempCustomer.id}"></c:param>
     </c:url>
     <tr>
     <td>${tempCustomer.firstName}</td>
      <td>${tempCustomer.lastName}</td>
      <td>${tempCustomer.email}</td>
      <td><a href="${updateLink}">Update</a>
          <a href="${deleteLink}" onClick="if(!confirm('Are you Sure to Delete This Record?')) return false;">Delete</a>      
      </td>         
     </tr>
     </c:forEach>
    
    </table>
   
   </div>

</body>
</html>