<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1 class="loghead" >Add Employee Record</h1>
<form action="saving"><table>
<div id="invalid"></div>
<tr><td><label for="id">Enter EmP_ID: </label></td><td><input class="UpLog" type="text" name="id"></td></tr>
<tr><td><label for="name">Enter Name: </label></td><td><input class="loginp" type="text" name="name"></td></tr>
<tr><td><label for="user">User type</label></td><td><select  name="type" class="loginp"><option>Employee</option><option>Admin</option></select></td></tr>
<tr><td><label for="pass">Enter Password: </label></td><td><input class="UpLog" type="text" name="pass"></td></tr>
<tr><td><label for="country" >Select a country: </label></td><td><select class="UpLog" name="country">
<option>India</option>
<option>US</option>
<option>Other</option></select></td></tr>
<tr><td><label for="phone">Enter Phone Number: </label></td><td><input class="UpLog" type="text" name="phone"></td></tr>
<tr><td><label for="email">Enter Email_id: </label></td><td><input class="UpLog" type="text" name="email"></td></tr>
<tr><td><input type="submit" class="butt" value="Add"></td><td><input class="butt" type="reset" value="Reset"></td></tr>
</table></form>
</body>
</html>