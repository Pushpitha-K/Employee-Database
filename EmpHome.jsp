<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<style>
.padd{
margin-top:10rem;}</style>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Employee Database</a></div></nav>
<%  request.getSession(false);  
List<String> values = (ArrayList)session.getAttribute("lists");
out.print("<h1 class='navbar-dark bg-dark' style='color:white'>Hello "+values.get(1)+" </h1>"); %>
<div class="d-grid gap-2 col-6 mx-auto padd">

        <a class="btn btn-primary " href="EmpLeave.jsp">Apply Leave</a>
        <a class="btn btn-primary" href="EmpAttendance.jsp">Show Attendance</a>
        
        <a class="btn btn-primary" href="EmpHoli.jsp">Holiday List</a>
        <a class="btn btn-primary" href="EmpSalary.jsp">Show Salary</a>
        <a class="btn btn-primary" href="loging">Logout</a>

      </div>
</body>
</html>