<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , employee_data.Emp_Var"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body style="background-color: white; background-image: none;">
<jsp:include page="newNav.html"></jsp:include>
  <div class="main">
    <h1>Employee List</h1>
    <div id="invalid"></div>
    <form action="">
<input type="text" placeholder="enter Emp_id"class="sbut" name="tday"><input type="submit"  class='btn btn-secondary' name="search" value="search"></form>
    <table class="table table-striped-columns" style="width: 100%;">
      <thead class="table-group-divider">   <tr><th>Emp_Id</th>
       <th>Emp_Name</th>
        <th>Password</th>
        <th>Email</th>
         <th>Country</th>
          <th>Phone</th>
           <th>Edit</th>
            <th>Delete</th>
     </tr></thead>
         <jsp:useBean id="obj" class="employee_data.StoreData" />
         
          <% 
           String str=request.getParameter("tday"); 
           List <Emp_Var> list=  new ArrayList<Emp_Var>();
           if(str==null|| str.isEmpty())
           {
            list=obj.display();
            request.setAttribute("list",list);
            }else
            {
            	 list=obj.display(str);
            	 request.setAttribute("list",list);
            }
            %>
            <% if (list.isEmpty()){
            out.print("Enter a valid ID");
            }
            	
            
        out.print(" <tbody class='table-group-divider'> ")  ;  
         for(Emp_Var emp:list) {
     out.println("<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getPass()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td>"
		+ "<td>"+emp.getPhone_no()+"</td><td><a href='updateEmp.jsp?id="+emp.getId()+"' class='btn btn-secondary'>Edit</a></td><td><a href='del?id="+emp.getId()+"' class='btn btn-secondary'>delete</a></td></tr>");	}
     out.print("<table>");%></tbody>
    </table>
</div>
</body>
</html>