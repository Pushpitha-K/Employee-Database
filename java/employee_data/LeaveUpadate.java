package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Leave")
public class LeaveUpadate extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("code");
		int code=Integer.parseInt(req.getParameter("code"));
		String name=req.getParameter("ename");
		String type=req.getParameter("type");
		String rea= req.getParameter("reason");
		String date= req.getParameter("date");
		Emp_Var var= new Emp_Var();
		List <Emp_Var>list= new ArrayList<Emp_Var>();
		List <Emp_Var>list1=new ArrayList<Emp_Var>();
		StoreData store= new StoreData();
		   HttpSession session=req.getSession(false);  
		String pagename = (String) session.getAttribute("currpage");
		System.out.println("session"+pagename);
		list=store.display(id);
		Date leavedate= Date.valueOf(date);
		list1=store.LeaveDisplay(leavedate);
		
		String d=" ";
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
			Emp_Var emp=(Emp_Var) itr.next();
			d=emp.getName();
		}
		if(d.equals(name) ) {
			if(list1==null) {
		var.setDate(date);
		var.setId(code);
		var.setName(name);
		var.setType(type);var.setReason(rea);
		StoreData data= new StoreData();
		int success=data.insertLeave(var);
		
		if(success>0) {
			if(pagename == null) {
			System.out.print("Successful"+success);
			req.getRequestDispatcher("EmpLeave.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"Request Submited\"");  
			out.println("</script>");}
			else {
				req.getRequestDispatcher(pagename).include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"invalid\").innerHTML = \"Request Submited\"");  
				out.println("</script>");}
			}else {
				System.out.print("not Successful"+success);
			}
		}else {
				req.getRequestDispatcher("Leave.jsp").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"invalid\").innerHTML = \"already applied\"");  
				out.println("</script>");
			}
}else {
	req.getRequestDispatcher("Leave.jsp").include(req, res);
	out.println("<script type=\"text/javascript\">");  
	out.println("document.getElementById(\"invalid\").innerHTML = \"id and name do not match\"");  
	out.println("</script>");
}
}}