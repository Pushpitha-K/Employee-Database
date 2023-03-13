<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
<style>
.head{
margin-bottom:2rem;
color:black;}
.lab{
padding:1rem;}
.box{
padding: .5rem;
border-radius:5px;'}

</style>
</head>
<body>

<jsp:useBean id="obj" class="employee_data.Emp_Var"></jsp:useBean>
<jsp:include page="Home.jsp"></jsp:include>
<% List<String> value = (ArrayList)session.getAttribute("lists");

obj.setType(value.get(0));
obj.setName(value.get(1));
%>
<form action="updateAttend">
    <div id="invalid"></div>
    <table>
        <tr><div><h2 class="head">Attendance </h2></div></tr>
       <tr><td> <label class="lab"><h4>Emp_id</h4></label></td>
<td> <input type="text" class="box" name="code"  value="${obj.getType() }" readonly="true" placeholder="Emp_id"></td></tr>
   <tr><td> <label class="lab"><h4>Emp_Name</h4></label></td>
 <td><input type="text" name="ename" class="box" value="${obj.getName()}" readonly="true" placeholder="Emp_name"></td></tr>
 <tr><td> <label class="lab"><h4>Date</h4></label></td>
    <td> <input type="date"  name="date" class="box" value=date><br> </td></tr>
   <tr><td> <label class="lab"><h4>Status</h4></label></td>
   <td>  <select name="status" class="box" ><option>Present</option><option>absent</option></select></td></tr>
    </table>
  <p style="margin:2rem"> <span style="margin:3rem"><input class="btn btn-dark" type="submit" value="Request"></span><input type="reset" class="btn btn-dark" value="Reset"></p>
</form></div><dialog  id="model">
<h4>Updated Successfully</h4>
<button class="button close_button">Close</button>
</dialog></body>
</body>
</html>

