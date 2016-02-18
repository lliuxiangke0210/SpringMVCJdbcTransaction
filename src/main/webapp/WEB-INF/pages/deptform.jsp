<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>New/Edit Department</title>
  </head>
  <body>
      <div align="center">
          <h1>New/Edit Contact</h1>
        <form:form action="saveDepartment" method="post" modelAttribute="department">
        <table>
            <form:hidden path="deptId"/>
            <tr>
                <td>DeptNo:</td>
                <td><form:input path="deptNo" /></td>
            </tr>
            <tr>
                <td>DeptName:</td>
                <td><form:input path="deptName" /></td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><form:input path="location" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
      </div>
  </body>
</html>