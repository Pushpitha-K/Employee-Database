<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , employee_data.Emp_Var"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="main1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body style="background-color: white; background-image: none;">
<jsp:include page="newNav.html"/>
  <div class="main">
    <h1>Holiday List</h1>
    <form action="ShowHoli.jsp">
<input type="text" class="sbut" placeholder="search by month" name="tday"><input type="submit"  class='btn btn-secondary' name="search" value="search"></form>
    <table class="table table-striped-columns table-striped " style="width: 100%;">
    <thead class="table-group-divider">   <tr><th>S.No</th>
       <th>Date</th>
        <th>Month</th>
        <th>Name</th>
     </tr></thead>
         <jsp:useBean id="obj" class="employee_data.StoreData" />
           <% 
           String str=request.getParameter("tday"); 
           List <Emp_Var> list=  new ArrayList<Emp_Var>();
           if(str==null || str.isEmpty())
           {
            list=obj.HoliDisplay();
            request.setAttribute("list",list);
            }else
            {
            	 list=obj.HoliDisplay(str);
            	 request.setAttribute("list",list);
            }
            %>
            <% if (list.isEmpty()){
            out.print("No Holiday found");
            }
            	%>
            
            
           <tbody class="table-group-divider"> <c:forEach items="${list}" var="u">  
            <tr><td>${u.getId()}</td><td>${u.getDate()}</td><td>${u.getMonth()}</td> 
  <td>${u.getReason()}</td></tr></c:forEach>  </tbody> 
    </table>
</div>
</body>
</html>