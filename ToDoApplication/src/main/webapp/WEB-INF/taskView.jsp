<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Task Details</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/task/saveTask" var="saveURL" />
  <br><br>
  <h2>Task Details</h2>
  <br>
  <label></label>
  <form:form modelAttribute="taskForm" method="get" action="${list}" cssClass="form" >
 <div class="form-group">
   <h4>${taskForm.taskName}</h4>
    <label><b>Task Description:</b> &nbsp;${taskForm.taskDescription}</label>
    <br>
    <label><b>Status: </b>&nbsp;${taskForm.status} </label>
    <br>
    <label><b>Priority: </b>&nbsp;${taskForm.priority}</label>
   </div>
   <spring:url value="/task/list" var="listURL" />
       <a class="btn btn-primary" href="${listURL }" role="button" >Ok</a>
  
  </form:form>
  
 </div>
</body>
</html>