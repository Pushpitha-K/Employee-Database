package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/attshow")
public class ShowAttendance extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		long date= Long.parseLong(req.getParameter("tday"));
		 java.sql.Date date1=new java.sql.Date(date);
		 List <Emp_Var> list=  new ArrayList<Emp_Var>();
		 StoreData data= new StoreData();
		 PrintWriter out = res.getWriter();
		list= data.ADisplay(date1);
		 RequestDispatcher rd=req.getRequestDispatcher("ShowAttendance.jsp");  
	     rd.forward(req, res);  
	}

}
