package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/saving")
public class SaveServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");

		PrintWriter out= res.getWriter();
		String name= req.getParameter("name");
		String pass= req.getParameter("pass");
		String country= req.getParameter("country");
		String phone_no= req.getParameter("phone");
		String Email_id= req.getParameter("email");
		String code=req.getParameter("id");
		int id=Integer.parseInt(code);
		List <Emp_Var>list= new ArrayList<Emp_Var>();
		StoreData data= new StoreData();
		list=data.display(code);
		if(list==null) {
		
		Emp_Var emp=new Emp_Var();
		emp.setCountry(country) ;
		emp.setEmail(Email_id);
		emp.setId(id);
		emp.setName(name);
		emp.setPass(pass);
		emp.setPhone_no(phone_no);		
		
		int check=StoreData.insert(emp);
		
		if(check>0) {
			System.out.print("Successful"+check);
			req.getRequestDispatcher("AddEmp.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"updated successully\"");  
			out.println("</script>");
		}else {
			System.out.print("not Successful"+check);
		}}else {
			req.getRequestDispatcher("AddEmp.jsp").include(req, res);
			
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"existing user\"");  
			out.println("</script>");
		}
		}
	
}
