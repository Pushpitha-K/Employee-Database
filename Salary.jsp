<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
</head>
<body>
<body style="background-color: white; background-image: none;">
<jsp:include page="newNav.html"/>
<div>
<div class="main">
<div><h1>Salary Details</h1></div>

    <form action="Salary">
 <table>
  <tr> <div id="invalid"></div>  </tr> 
   <tr><td> <label> Year </label></td>
 <td><input type="text" name="year" class="UpLog" placeholder="Year"></td></tr>
 <tr><td><label> Month </label></td><td>
 <input type="text" name="month" class="UpLog" placeholder="Month"></td></tr>
  <tr><td><label> Emp_id </label></td><td>
 <input type="text" name="code" class="UpLog" placeholder="Emp_id"></td></tr>
  <tr><td>  <label> Emp_Name </label></td><td>
 <input type="text" name="ename" class="UpLog" placeholder="Emp_name"></td></tr> 
 <tr><td><label> Working days </label></td><td>
 <input type="text" name="wday" class="UpLog" placeholder="Enter no: of working days"></td></tr> 
 <tr><td><label> Paid Off days </label></td><td>
 <input type="text" name="pday" class="UpLog" placeholder="Enter no: of paid-off days"></td></tr> 
 <tr><td><label>Basic</label></td><td>
 <input type="text" name="basic" class="UpLog" placeholder="Basic"></td></tr> 
 <tr><td><label> DA </label></td><td>
 <input type="text" name="da" class="UpLog" placeholder="Enter DA"></td></tr> 
<tr><td> <label> HRA </label></td><td>
 <input type="text" name="hra" class="UpLog" placeholder="Enter HRA"></td></tr> 
 <tr><td><label> PF </label></td><td>
 <input type="text" name="pf" class="UpLog" placeholder="Enter PF"></td></tr>
<tr><td> <label> PT </label></td><td>
 <input type="text" name="pt" class="UpLog" placeholder="Enter PF"></td></tr> 
 <tr><td><label> Remark </label></td><td>
     <textarea name="remark" class="UpLog" rows="4" cols="50"></textarea> </td></tr>
 <tr><td><input class="butt" type="submit" value="Update"></td><td><input type="reset" class="butt" value="Reset"></td></tr></p>
</table></form></div></div></body>
</body>
</body>
</html>