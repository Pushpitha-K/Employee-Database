package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		StoreData store= new StoreData();
		List <Emp_Var> list= new ArrayList<Emp_Var>();
		list=store.display();
	PrintWriter out= res.getWriter();
	out.println("<h1>Employee Recordes</h1>");
	out.print("<table>");
    out.print("<th><td>Emp_ID</td><td>Name</td><td>Password</td><td>Email</td><td>Country</td>"
	+ "<td>Phone</td><td>Edit</td><td>delete</td></th>");
     for(Emp_Var emp:list) {
     out.println("<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getPass()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td>"
		+ "<td>"+emp.getPhone_no()+"</td><td><a href='EmpEdit?id="+emp.getId()+"'>Edit</a></td><td><a href='del?id="+emp.getId()+"'>delete</a></td></tr>");	
     out.print("<table>");
}}
}
