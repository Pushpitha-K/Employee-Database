<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , employee_data.Emp_Var"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
</head>
<body>
<jsp:useBean id="obj" class="employee_data.Emp_Var"></jsp:useBean>
<jsp:include page="Home.jsp"></jsp:include>
<% List<String> value = (ArrayList)session.getAttribute("lists");

obj.setType(value.get(0));
obj.setName(value.get(1));
%>
 <h1>Salary detail</h1>
      <div class="main"> <table class="btable" style="width: 100%;">
       <tr>
       <th>Emp_id</th>
        <th>Emp_Name</th>
        <th>Year</th><th>Month</th>
        <th>W_day</th>
        <th>P_day</th>
        <th>Basic</th><th>DA</th><th>HRA</th><th>PF</th><th>PT</th><th>Gross</th><th>Ded</th><th>Net</th><th>Remark</th>
     </tr>
      <jsp:useBean id="obj1" class="employee_data.StoreData" />
     <% 
     List <Emp_Var> list= new <Emp_Var> ArrayList();
   
    	 list=obj1.SDisplay(Integer.parseInt(value.get(0)));
         request.setAttribute("list", list);
     
     %>
   <c:forEach items="${list}" var="u">  
             <tr><td>${u.getId()}</td>
    <td>${u.getName()}</td>
    <td>${u.getYear()}</td>
    <td>${u.getMonth()}</td>
    <td>${u.getWday()}</td>
    <td>${u.getPday()}</td>
    <td>${u.getBasic()}</td>
    <td>${u.getDa()}</td>
    <td>${u.getHra()}</td>
    <td>${u.getPf()}</td>
     <td>${u.getPt()}</td>
    <td>${u.getGross()}</td>
    <td>${u.getDed()}</td>
    <td>${u.getNet()}</td>
    <td>${u.getReason()}</td>
    </tr></c:forEach></table></div>
</body>
</html>