package employee_data;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/hides")
public class UpdateServlet2 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
	String name= req.getParameter("name");
	String pass= req.getParameter("pass");
	String country= req.getParameter("country");
	String phone_no= req.getParameter("phone");
	String Email_id= req.getParameter("email");
	int id=Integer.parseInt(req.getParameter("hideid"));
	Emp_Var emp=new Emp_Var();
	emp.setCountry(country) ;
	emp.setEmail(Email_id);
	emp.setId(id);
	emp.setName(name);
	emp.setPass(pass);
	emp.setPhone_no(phone_no);
	System.out.print("up2: "+id);
	PrintWriter out= res.getWriter();
	int check=StoreData.update(emp);
	if(check>0) {
		req.getRequestDispatcher("ShowEmplyee.jsp").include(req, res);
		out.println("sucessfully updated");
			
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
			out.println("</script>");
		
	}else {
		out.println("unable to update details to server");
}}}
