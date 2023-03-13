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
@WebServlet("/updateAttend")
public class AdminAttendance extends HttpServlet {
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
		HttpSession session=req.getSession(false);
		String pagename = (String) session.getAttribute("attpage");
		System.out.println("session"+pagename);
		
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
			if(pagename == null) {
			System.out.print("Successful"+success);
			req.getRequestDispatcher("EmpAttendance.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
			out.println("</script>");
		}else{
			System.out.print("Successful"+success);
			req.getRequestDispatcher("GetAttendance.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
			out.println("</script>");}
		}else {
		System.out.print("not Successful"+success);}
	}else if(pagename == null)  {
		req.getRequestDispatcher("EmpAttendance.jsp").include(req, res);
		out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"already updated\"");  
		out.println("</script>");
	}else {
		req.getRequestDispatcher("GetAttendance.jsp").include(req, res);
		out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"already updated\"");  
		out.println("</script>");
	}}
}
