<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>New Task</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/task/saveTask" var="saveURL" />
  <br><br>
  <h2>Add New Task</h2>
  <br>
  <form:form modelAttribute="taskForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="task_id"/>
   <div class="form-group">
    <label>Task Name</label>
    <form:input path="taskName" cssClass="form-control" id="taskName" minlength="6"  required="required" />
   </div>
   <div class="form-group">
    <label>Task Description</label>
    <form:input path="taskDescription" cssClass="form-control" id="taskDescription" minlength="10" />
   </div>
    <div class="form-group">
    <label>Task Status</label>
    <form:input path="status" cssClass="form-control" id="status" required="required" minlength="6"/>
   </div>
    <div class="form-group">
    <label>Task Priority</label>
    <form:input path="priority" cssClass="form-control" id="priority" required="required" minlength="6"/>
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
  
 </div>
</body>
</html>