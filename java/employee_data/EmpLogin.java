package employee_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/Emplogin")
public class EmpLogin extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	StoreData data= new StoreData();
	String id=req.getParameter("empid");
	String pass= req.getParameter("pass");
	String type=req.getParameter("type").toLowerCase();
	String name=req.getParameter("name");
	
	List <Emp_Var>list= new ArrayList<Emp_Var>();
	StoreData store = new StoreData();
	list=store.display(id);
	Emp_Var var= new Emp_Var();
	Iterator itr= list.iterator();
	while(itr.hasNext()) {
		Emp_Var emp=(Emp_Var) itr.next();
		var.setId(emp.getId());
		var.setName(emp.getName());
		var.setType(emp.getType());
		var.setPass(emp.getPass());
	}
	List<String> list1=new ArrayList<String>();
	list1.add(id);list1.add(var.getName());
	HttpSession session=req.getSession();
	
	System.out.println("Login: "+var.getId()+pass+type);
	System.out.println("user "+var.getName());
	
	data.display();
	int empid=Integer.parseInt(id);
	if(var.getId()==(empid) && var.getPass().equals(pass)) {
		if(var.getType().equals("admin")) {
			
			req.getRequestDispatcher("ShowEmplyee.jsp").include(req, res);
		}else {
		
			session.setAttribute("lists", list1);
			System.out.println("id: "+list1.get(0));
			System.out.println("name: "+list1.get(1));
			req.getRequestDispatcher("EmpHome.jsp").include(req, res);
		}
	}else {
		
	}
}
}
