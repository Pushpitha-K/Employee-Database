<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, java.time.LocalDate,employee_data.Emp_Var, java.time.Month, java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="GetCSS.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="main1.css">
</head>
<body style="background-color: white; background-image: none;">
	<jsp:include page="newNav.html" /><div class="main">
		<h2 >Update Attendance</h2>
		<jsp:useBean id="obj" class="employee_data.StoreData"></jsp:useBean>
		<% String str= "GetAttendance.jsp";
  session.setAttribute("attpage",str); 
		List<Emp_Var> list = new <Emp_Var>ArrayList();
		list = obj.display();

		

		System.out.print("Entered");
		out.print("<table>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th class='name-col'>Employee Name </th>");
		out.print("<th class='name-col'>Employee Code </th>");
		out.print("<th class='name-col'>Date </th>");
		out.print("<th class='name-col'>Status </th>");
		out.print("<th class='name-col'>Action </th>");
		out.print(" </tr>");
		out.print("</thead>   <tbody>");

		Iterator itr = list.iterator();
		for (Emp_Var emp : list) {
			out.print("<form action='updateAttend'><tr class='student'>");
			out.print(" <div id='invalid'></div>");
			out.print("<td  class='attend-col'><input type='text' class='form-control-plaintext' value='" + emp.getName()
			+ "'readonly></td><td class='attend-col'  ><input type='text' class='form-control-plaintext' value='"
			+ emp.getId() + "'readonly></td> ");
			out.print("<input type='hidden' ' name='ename' value='" + emp.getName()
			+ "'readonly><input type='hidden' name='code' value='" + emp.getId() + "'readonly> ");
			out.print("<td class='attend-col'><input name='date'  style='float:right' type='date'</td>");
			out.print(
			"<td><select name='status' class='attend-col'><option>Present</option><option>Absent</option><option>Permission</option></td>");
			out.print(
			"<td><input class='attend-col' class='form-control-plaintext'  type='submit' value='Update'></td></tr></tbody></form>");
		}
		
		%>
	</div>
</body>
</html>