<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
</head>
<body style="background-color: white; background-image: none;">
<jsp:include page="newNav.html"></jsp:include>
<div class="main">
<div><h1 class="loghead" >Add Holiday</h1></div>
    <form action="Holiday">
   <table ><div id="invalid"></div>

  <tr><td><label>Holiday Name</label></td><td>
 <input type="text" name="type" class="UpLog" placeholder="Holiday name"></td></tr>
  <tr><td><label>Year</label></td><td>
 <input type="text" name="year" class="UpLog" placeholder="Year"></td></tr>
  <tr><td><label>Month</label></td><td>
 <input type="text" name="month" class="UpLog" placeholder="Month"></td></tr>
  <tr><td><label>Date</label></td><td>
 <input type="date" name="date" class="UpLog" ></td></tr>
  <tr><td><input class="butt" type="submit" value="Request"></td><td><input type="reset" class="butt" value="Reset"></p>
</table> </form></div></body>
</body>
</html>