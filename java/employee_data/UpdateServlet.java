package employee_data;
import java.io.IOException;
import java.io.PrintWriter;

import employee_data.Emp_Var;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EmpEdit")
public class UpdateServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		Emp_Var emp= new Emp_Var();
		System.out.print(req.getParameter("id"));
		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		String pass= req.getParameter("pass");
		String country= req.getParameter("country");
		String phone_no= req.getParameter("phone");
		String Email_id= req.getParameter("email");
		System.out.print(name);
		out.print("<form action='hides'>");
		out.print("<table>");
		out.print("<tr><td>Emp_id</td><td>"+id+"</td><td><input type='hidden' name='hideid' value='"+id+"'></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' placeholder='name' name='name' ></td></tr>");
		out.print("<tr><td>Password</td><td><input type='text' name='pass' ></td></tr>");
		out.print("<tr><td>Country</td><td>");
		out.print("<select name='country'><option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>other</option>");
		out.print("</select></td></tr>");
		out.print("<tr><td>Phone</td><td><input type='text' name='phone' ></td></tr>");
		out.print("<tr><td>Email</td><td><input type='text' name='email' ></td></tr>");
		out.print("</table>");
		out.print("<input type='submit' value='submit'><br>");
		
		
	}
}
