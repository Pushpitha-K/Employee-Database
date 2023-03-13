
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,  java.util.Locale, java.util.Date , java.text.SimpleDateFormat, java.text.ParseException, java.util.* , employee_data.Emp_Var  " %>
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
    <h1>Attendance List</h1>
    <form action="ShowAttendance.jsp">
<input type="date" class="sbut" name="tday"><input type="submit"  class='btn btn-secondary' name="search" value="search"></form>
    <table class="table table-striped-columns table-striped " style="width: 100%;">
   <thead class="table-group-divider">     <tr><th>S.No</th>
       <th>Date</th>
        <th>Month</th>
        <th>Name</th>
     </tr></thead>
      <jsp:useBean id="obj" class="employee_data.StoreData" />
      <div id="cha">
           <%String str=request.getParameter("tday"); 
           List <Emp_Var> list=  new ArrayList<Emp_Var>();
           if(str==null || str.isEmpty())
           {
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);   
            System.out.println(date);
            list=obj.ADisplay(date);
            request.setAttribute("list",list);}else{
            	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            	java.util.Date date = sdf1.parse(str);  
            	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
            	list=obj.ADisplay(sqlStartDate);
            	 request.setAttribute("list",list);
            }
            %><% if (list.isEmpty()){
            out.print("No Data found");
            }
            	%>
              <tbody class="table-group-divider">    <c:forEach items="${list}" var="u">  
             <tr><td>${u.getId()}</td><td>${u.getDate()}</td><td>${u.getName()}</td> 
  <td>${u.getStatus()}</td> <td></td></tr> </c:forEach></tbody></table></div></div>
</body>

</html>