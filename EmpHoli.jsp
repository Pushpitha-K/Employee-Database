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
 <jsp:useBean id="obj1" class="employee_data.Emp_Var" />
<jsp:include page="Home.jsp"></jsp:include>
<% List<String> value = (ArrayList)session.getAttribute("lists");

obj1.setType(value.get(0));
obj1.setName(value.get(1));
%>
 <div class="main">
    <h1>Holiday List</h1>
    <form action="ShowHoli.jsp">
<input type="text" class="sbut" placeholder="search by month" name="tday"><input type="submit"  class="butt" name="search" value="search"></form>
    <table class="btable" style="width: 100%;">
       <tr><th>S.No</th>
       <th>Date</th>
        <th>Month</th>
        <th>Name</th>
     </tr>
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
            
            
            <c:forEach items="${list}" var="u">  
             <tr><td>${u.getId()}</td><td>${u.getDate()}</td><td>${u.getMonth()}</td> 
  <td>${u.getReason()}</td> <td></td></tr> </c:forEach>  
    </table>
</div>
</body>
</html>