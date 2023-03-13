package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addatt")
public class GetUpdateAttendance extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String date=req.getParameter("Adate");
		int id=Integer.parseInt(req.getParameter("eid"));
		String name= req.getParameter("ename");
		String status=req.getParameter("status");
		System.out.print(name+" "+date+" "+status+" "+id);
		Emp_Var var= new Emp_Var();
	 var.setId(id);var.setDate(date);var.setName(name);var.setStatus(status);
	StoreData send = new StoreData();
	int check=send.insertAtt(var);
	if(check>0) {
		System.out.print("Successful"+check);
		req.getRequestDispatcher("GetAttendance.html").forward(req, res);
	out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully Registered\"");  
		out.println("</script>");
	}else {
		System.out.print("not Successful"+check);
	}}catch(Exception e) {
		System.out.print(e);
	}
	}
	
}
