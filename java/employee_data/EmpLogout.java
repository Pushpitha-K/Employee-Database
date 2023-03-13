package employee_data;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/loging")
public class EmpLogout extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	HttpSession session=req.getSession();  
	List<String> values = (ArrayList)session.getAttribute("lists");
	System.out.println(values.get(0));
	if (session!=null) {
        session.invalidate();
        req.getRequestDispatcher("Emp_login.html").include(req, res);;
      }else {
    	  res.sendRedirect("Emp_login.html");
      }
}
}
