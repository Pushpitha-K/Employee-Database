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
<body style="background-color: white; background-image: none;">
<jsp:include page="newNav.html"/>
  <div class="main">
    <h1>Salary detail</h1>
     <form action="ShowSalary.jsp">
<input type="text" class="sbut" name="tday" placeholder="search by ID"><input type="submit"  class="butt" name="search" value="search"></form>
    <table class="btable" style="width: 100%;">
       <tr>
       <th>Emp_id</th>
        <th>Emp_Name</th>
        <th>Year</th><th>Month</th>
        <th>W_day</th>
        <th>P_day</th>
        <th>Basic</th><th>DA</th><th>HRA</th><th>PF</th><th>PT</th><th>Gross</th><th>Ded</th><th>Net</th><th>Remark</th>
     </tr>
      <jsp:useBean id="obj" class="employee_data.StoreData" />
     <% String str= request.getParameter("tday");
     List <Emp_Var> list= new <Emp_Var> ArrayList();
     if(str==null || str.isEmpty()){
     list=obj.SDisplay();
     request.setAttribute("list", list);
     }else{int num=Integer.parseInt(str);
    	 list=obj.SDisplay(num);
         request.setAttribute("list", list);
     }
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