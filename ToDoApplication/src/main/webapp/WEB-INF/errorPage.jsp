<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error!!</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>

</head>
<body>
<br style="line-height:6;">

 <div class="form-group" align="center">
   <h1>${msg}!</h1>
   <br>
   <br>
    <spring:url value="/task/list" var="listURL" />
       <a class="btn btn-primary" href="${listURL }" role="button" >Go Home</a>
</body>
</html>