<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Department List</title>
  </head>
  <body>
      <div align="center">
          <h1>Department List</h1>
          <table border="1">
              <tr>
                <th>No</th>
                <th>Dept No</th>
                <th>Dept Name</th>
                <th>Location</th>
                 <th>operater</th>
              </tr>
              <c:forEach var="dept" items="${departments}" varStatus="status">
              <tr>
                  <td>${dept.deptId}</td>
                  <td>${dept.deptNo}</td>
                  <td>${dept.deptName}</td>
                  <td>${dept.location}</td> 
                  <td><a href="editDepartment?deptId=${dept.deptId}">Edit</a>
                   &nbsp;
                   <a href="deleteDepartment?deptId=${dept.deptId}">Delete</a>
                   </td>                           
              </tr>
              </c:forEach>                
          </table>
      </div>
  </body>
</html>