package employee_data;


import java.io.IOException;
import java.text.SimpleDateFormat;  
import java.util.*;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.Date;  
@WebServlet("/recordatt")
public class AttendanceUpdate extends HttpServlet {
public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	int code=Integer.parseInt(req.getParameter("code"));
	String name=req.getParameter("ename");
	String date=req.getParameter("date");
	String status= req.getParameter("status");
	Emp_Var var= new Emp_Var();
	List <Emp_Var>list= new ArrayList<Emp_Var>();
	StoreData store= new StoreData();
	 Date dat=Date.valueOf(date);
	list=store.ADisplay(dat);
	int d=0;
	Iterator itr= list.iterator();
	while(itr.hasNext()) {
		Emp_Var emp=(Emp_Var) itr.next();
		d=emp.getId();
	}
	if(d!=code) {
	var.setId(code);
	var.setName(name);
	var.setDate(date);
	var.setStatus(status);
	StoreData data= new StoreData();
	int success=data.insertAtt(var);
	if(success>0) {
		System.out.print("Successful"+success);
		req.getRequestDispatcher("EmpAttendance.jsp").include(req, res);
		out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
		out.println("</script>");
	}else {
		System.out.print("not Successful"+success);
	}}else {
		req.getRequestDispatcher("EmpAttendance.jsp").include(req, res);
		out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"already updated\"");  
		out.println("</script>");
	}
}
}
