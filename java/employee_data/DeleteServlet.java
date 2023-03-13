package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {

		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id= Integer.parseInt(req.getParameter("id"));
		System.out.println("delete servlet "+id);
		
	   
	    PrintWriter out= res.getWriter();
	    StoreData store=new StoreData();
	    int check = 0;
		try {
			check = store.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    res.sendRedirect(""); 
	    if(check>0)
	    {  
			req.getRequestDispatcher("ShowEmplyee.jsp").include(req, res);
			
			System.out.println("updated sucessfully");
		}else {
			out.println("unable to deleted details in server");
		}
		}
}
