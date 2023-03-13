<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body style="background-color: white; background-image: none;">
<% String str= "Leave.jsp";
  session.setAttribute("currpage",str);  %>

<jsp:include page="newNav.html"/>
<div class="main">
<div><h1>Leave Request</h1></div>
    <form action="Leave"><table>
    <tr><div id="invalid"></div></tr>
       <tr> <td><label>Emp_id</label></td><td>
 <input type="text" name="code" class="UpLog" placeholder="Emp_id"></td></tr>
 <tr> <td>    <label>Emp_Name</label></td><td>
 <input type="text" name="ename" class="UpLog" placeholder="Emp_name"></td></tr>
  <tr> <td> <label>Date</label></td><td>
     <input type="date"  name="date" class="UpLog" value=date></td></tr>
    <tr> <td>   <label>Leave Type</label></td><td>
     <select name="type" class="UpLog"><option>Sick Leave</option><option>Casual Leave</option></select></td></tr>
  <tr> <td>  <label>Reason</label></td><td>
     <textarea name="reason" class="UpLog" rows="4" cols="50"></textarea></td></tr>
     <p>
 <tr> <td>  <input class="butt open_button" type="submit" value="Request"></td><td><input type="reset" class="butt" value="Reset"></td></tr></p>
</table></form></div>



</body>
</html>