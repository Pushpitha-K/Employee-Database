package employee_data;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Holiday")
public class HolidayUpdate extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("type");
		String date=req.getParameter("date");
		String year= req.getParameter("year");
		String month= req.getParameter("month");
		Emp_Var var= new Emp_Var();
		var.setName(name);
		var.setDate(date);
		var.setYear(year);
		var.setMonth(month);
		StoreData data= new StoreData();
		int success=data.insertHoli(var);
		if(success>0) {
			System.out.print("Successful"+success);
			req.getRequestDispatcher("Holiday.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
			out.println("</script>");
		}else {
			System.out.print("not Successful"+success);
		}	
	}}
