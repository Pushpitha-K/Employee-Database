<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
<style type="text/css">
td{
padding:2rem;}
input{padding:.5rem;
}</style>

</head>
<body style="background-color: white; background-image: none;">
<div class="main">
    <h1>Employee List</h1>
<%
response.setContentType("text/html");
		
		System.out.print(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String pass= request.getParameter("pass");
		String country= request.getParameter("country");
		String phone_no= request.getParameter("phone");
		String Email_id= request.getParameter("email");
		System.out.print(name);
		out.print("<form action='hides' style='text-align:'>");
		out.print("<table>");
		out.print("<tr><td>Emp_id</td><td>"+id+"</td><td><input type='hidden' name='hideid' value='"+id+"'></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' placeholder='name' name='name' ></td></tr>");
		out.print("<tr><td>Password</td><td><input type='text' name='pass' ></td></tr>");
		out.print("<tr><td>Country</td><td>");
		out.print("<select style='padding:1rem' name='country'><option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>other</option>");
		out.print("</select></td></tr>");
		out.print("<tr><td>Phone</td><td><input type='text' name='phone' ></td></tr>");
		out.print("<tr><td>Email</td><td><input type='text' name='email' ></td></tr>");
		out.print("</table>");
		out.print("<input type='submit' class='butt' value='submit'><br>");
		
		%>
		</div>
</body>
</html>