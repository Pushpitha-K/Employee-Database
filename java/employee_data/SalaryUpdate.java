package employee_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Salary")
public class SalaryUpdate extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("code");
		int code=Integer.parseInt(id);
		String name=req.getParameter("ename");
		String month=req.getParameter("month");
		String year=req.getParameter("year");
		int wday=Integer.parseInt(req.getParameter("wday"));
		int pday=Integer.parseInt(req.getParameter("pday"));
		float pt=Float.parseFloat(req.getParameter("pt"));float pf=Float.parseFloat(req.getParameter("pf"));float hra=Float.parseFloat(req.getParameter("hra"));
		float basic=Float.parseFloat(req.getParameter("basic"));
		float da=Float.parseFloat(req.getParameter("da"));
		float ded=da+hra;float gross=basic+da+hra;float net=gross-ded;
		String des=req.getParameter("remark");
		List <Emp_Var>list= new ArrayList<Emp_Var>();
		StoreData store= new StoreData();
		list=store.display(id);
		String d=" ";
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
			Emp_Var emp=(Emp_Var) itr.next();
			d=emp.getName();
		}
		if(d.equals(name) ) {
		Emp_Var var= new Emp_Var();
		var.setBasic(basic);
		var.setDa(da);
		var.setHra(hra);var.setDed(ded);var.setId(code);var.setName(name);var.setMonth(month);var.setWday(wday);var.setYear(year);
		var.setPday(pday);var.setPt(pt);var.setPf(pf);var.setGross(gross);var.setNet(net);var.setReason(des);
		StoreData data=new StoreData();
		int success=data.insertSalary(var);
		if(success>0) {
			System.out.print("Successful"+success);
			req.getRequestDispatcher("Salary.jsp").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"invalid\").innerHTML = \"succesfully updated\"");  
			out.println("</script>");
		}else {
			System.out.print("not Successful"+success);
		}
	}else{
		req.getRequestDispatcher("Salary.jsp").include(req, res);
		out.println("<script type=\"text/javascript\">");  
		out.println("document.getElementById(\"invalid\").innerHTML = \"invalid details\"");  
		out.println("</script>");
	}}
	}
