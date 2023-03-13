package employee_data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StoreData extends Emp_Var{

	public static Connection connect() throws ClassNotFoundException, SQLException {

	Class.forName("com.mysql.cj.jdbc.Driver"); 
	    
    	String url="jdbc:mysql://localhost:3306/employee";
      String user="root";
      String pass="LucAshe@4";
	Connection con= DriverManager.getConnection(url,user,pass);
	return con;
}

public static int insert(Emp_Var emp)  {
	int status = 0;
	
	System.out.println("insert called");
	Connection con;
	try {
		con = connect();
	String query="insert into employee.detail values(?,?,?,?,?,?.?);";
	PreparedStatement st= con.prepareStatement(query);
	st.setString(1,emp.getName());
	st.setString(2,emp.getPass());
	st.setString(3,emp.getEmail());
	st.setString(4,emp.getCountry());
	st.setInt(5,emp.getId());
	st.setString(6,emp.getPhone_no());
	st.setString(7, emp.getType());
	status=st.executeUpdate();
	con.close();
	System.out.print(status+"task1 completed");
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}
	return status;
	
	}


public static int insertAtt(Emp_Var emp)  {
	int status = 0;
	
	System.out.println("attendance add called");
	Connection con;
	try {
		con = connect();
	String query="insert into employee.attendance  (att_date,Status,Emp_name,Emp_id) values(?,?,?,?);";
	PreparedStatement st= con.prepareStatement(query);
	st.setString(1,emp.getDate());
	st.setString(2,emp.getStatus());
	st.setString(3,emp.getName());
	st.setInt(4,emp.getId());
	status=st.executeUpdate();
	con.close();
	System.out.print(status+"task1 completed ");
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}
	return status;
	
	}
public static int insertLeave(Emp_Var emp)  {
	int status = 0;
	
	System.out.println("LeaveDetails add called");
	Connection con;
	try {
		con = connect();
	String query="insert into employee.LeaveDetails  (leave_date,leave_type,leave_reason,Emp_name,Emp_id) values(?,?,?,?,?);";
	PreparedStatement st= con.prepareStatement(query);
	st.setString(1,emp.getDate());
	st.setString(2,emp.getType());
	st.setString(3,emp.getReason());
	st.setString(4,emp.getName());
	st.setInt(5,emp.getId());
	status=st.executeUpdate();
	con.close();
	System.out.print(status+"task1 completed");
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}
	return status;
	
	}

public static int insertHoli(Emp_Var emp)  {
	int status = 0;
	
	System.out.println("LeaveDetails add called");
	Connection con;
	try {
		con = connect();
	String query="insert into employee.holiday  (year,month,date,details) values(?,?,?,?);";
	PreparedStatement st= con.prepareStatement(query);
	st.setString(1,emp.getYear());
	st.setString(2,emp.getMonth());
	st.setString(3,emp.getDate());
	st.setString(4,emp.getName());
	status=st.executeUpdate();
	con.close();
	System.out.print(status+"task1 completed");
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}
	return status;
	
	}
public static int insertSalary(Emp_Var emp)  {
	int status = 0;
	
	System.out.println("LeaveDetails add called");
	Connection con;
	try {
		con = connect();
	String query="insert into employee.Salary  (S_year,S_month,Emp_id,Emp_name,W_day,p_day,basic,da,hra,pf,gross,Tot_dec,net,pt,remarks) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	PreparedStatement st= con.prepareStatement(query);
	st.setString(1,emp.getYear());
	st.setString(2,emp.getMonth());
	st.setInt(3, emp.getId());
	st.setString(4,emp.getName());
	st.setInt(5, emp.getWday());
	st.setInt(6, emp.getPday());
	st.setFloat(7, emp.getBasic());
	st.setFloat(8, emp.getDa());
	st.setFloat(9, emp.getHra());
	st.setFloat(10, emp.getPf());
	st.setFloat(11, emp.getGross());
	st.setFloat(12, emp.getDed());
	st.setFloat(13, emp.getNet());
	st.setFloat(14, emp.getPt());
	st.setString(15, emp.getReason());
	status=st.executeUpdate();
	con.close();
	System.out.print(status+"task1 completed");
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}
	return status;
	
	}
public static int update(Emp_Var emp) {
   Connection con;
   int status = 0;
   System.out.println("update called");
try {
	con = connect();
	
	 PreparedStatement st= con.prepareStatement("update employee.detail set emp_name=?, pass=?, email=?, country=?, phone_no=? where Emp_id=?");
		st.setString(1,emp.getName());
		st.setString(2,emp.getPass());
		st.setString(3,emp.getEmail());
		st.setString(4,emp.getCountry());
		st.setString(5,emp.getPhone_no());
		st.setInt(6,emp.getId());
	 status=st.executeUpdate();
	 con.close();
		
		System.out.print(emp.getId()+" "+status+"task1 completed"+status);
} catch (ClassNotFoundException e) {
	System.out.println("Class not found");
}catch( SQLException e) {
	System.out.println(e);
}
return status;
}

public static List<Emp_Var> display() {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.detail;";
	Connection con;
	System.out.println("select called");
	
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
			emp.setName(rs.getString(1));
	    emp.setPass(rs.getString(2));
	    emp.setEmail(rs.getString(3));
	    emp.setCountry(rs.getString(4));
	    emp.setId(rs.getInt(5));
	    emp.setPhone_no(rs.getString(6));
	    emp.setType(rs.getString(7));
	    list.add(emp);
	    System.out.print(emp.getId()+"  "+emp.getName());}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}

public static List<Emp_Var> display(String id) {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.detail where Emp_id="+id+";";
	Connection con;
	System.out.println("select called");
	
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
			emp.setName(rs.getString(1));
	    emp.setPass(rs.getString(2));
	    emp.setEmail(rs.getString(3));
	    emp.setCountry(rs.getString(4));
	    emp.setId(rs.getInt(5));
	    emp.setPhone_no(rs.getString(6));
	    emp.setType(rs.getString(7));
	    list.add(emp);
	    System.out.print(emp.getId()+"  "+emp.getName());}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}
public static List<Emp_Var> HoliDisplay() {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.holiday;";
	Connection con;
	System.out.println("select called");
	
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
			emp.setYear(rs.getString(1));
	    emp.setMonth(rs.getString(2));
	    emp.setDate(rs.getString(3));
	    emp.setReason(rs.getString(4));
	    emp.setId(rs.getInt(5));
	    list.add(emp);}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}



public static List<Emp_Var> LeaveDisplay(Date date) {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.leavedetails where leave_date='"+date+"';";
	Connection con;
	System.out.println("select called");
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
			emp.setDate(rs.getString(1));
			emp.setId(rs.getInt(2));
	    emp.setName(rs.getString(3));
	    emp.setType(rs.getString(4));
	    emp.setReason(rs.getString(5));
	    emp.setSno(rs.getInt(6));
	    list.add(emp);}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}

public static List<Emp_Var> SDisplay(){
	List <Emp_Var> list= new ArrayList<Emp_Var>();
	String query="select * from employee.salary;";
	Connection con;
	try {Emp_Var emp= new Emp_Var();
		con= connect();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			emp.setSno(rs.getInt(1));
			emp.setId(rs.getInt(2));
			emp.setName(rs.getString(3));
			emp.setWday(rs.getInt(4));
			emp.setPday(rs.getInt(5));
			emp.setBasic(rs.getFloat(6));
			emp.setDa(rs.getFloat(7));
			emp.setHra(rs.getFloat(8));
			emp.setPf(rs.getFloat(9));
			emp.setGross(rs.getFloat(10));
			emp.setDed(rs.getFloat(11));
			emp.setNet(rs.getFloat(12));
			emp.setPf(rs.getFloat(13));
			emp.setReason(rs.getString(14));
		emp.setYear(rs.getString(15));
		emp.setMonth(rs.getString(16));
		list.add(emp);
		}}catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}catch( SQLException e) {
			System.out.println(e);
		}return list;
	
}
public static List<Emp_Var> SDisplay(int id){
	List <Emp_Var> list= new ArrayList<Emp_Var>();
	String query="select * from employee.salary where Emp_id="+id+";";
	Connection con;
	try {Emp_Var emp= new Emp_Var();
		con= connect();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			emp.setSno(rs.getInt(1));
			emp.setId(rs.getInt(2));
			emp.setName(rs.getString(3));
			emp.setWday(rs.getInt(4));
			emp.setPday(rs.getInt(5));
			emp.setBasic(rs.getFloat(6));
			emp.setDa(rs.getFloat(7));
			emp.setHra(rs.getFloat(8));
			emp.setPf(rs.getFloat(9));
			emp.setGross(rs.getFloat(10));
			emp.setDed(rs.getFloat(11));
			emp.setNet(rs.getFloat(12));
			emp.setPf(rs.getFloat(13));
			emp.setReason(rs.getString(14));
		emp.setYear(rs.getString(15));
		emp.setMonth(rs.getString(16));
		list.add(emp);
		}}catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}catch( SQLException e) {
			System.out.println(e);
		}return list;
	
}
public static List<Emp_Var> HoliDisplay(String name) {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.holiday where month='"+name+"';";
	Connection con;
	System.out.println("select called");
	
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
		emp.setYear(rs.getString(1));
	    emp.setMonth(rs.getString(2));
	    emp.setDate(rs.getString(3));
	    emp.setReason(rs.getString(4));
	    emp.setId(rs.getInt(5));
	    list.add(emp);}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}

public static List<Emp_Var> ADisplay(Date date) {
	List <Emp_Var> list= new ArrayList <Emp_Var>();
	String query="select * from employee.attendance where att_date='"+date+"';";
	Connection con;
	System.out.println("select called"+date);
	
	try {
		con = connect();
		PreparedStatement ps= con.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) { 
			Emp_Var emp= new Emp_Var();
			emp.setDate(rs.getString(1));
	    emp.setStatus(rs.getString(2));
	    emp.setName(rs.getString(3));
	    emp.setId(rs.getInt(4));
	    emp.setSno(rs.getInt(5));
	    list.add(emp);

	    }Iterator itr= list.iterator();
		
		while(itr.hasNext()) {
			Emp_Var var=(Emp_Var) itr.next();
			System.out.print(var.getName());
		}
	}catch (ClassNotFoundException e) {
		System.out.println("Class not found");
	}catch( SQLException e) {
		System.out.println(e);
	}return list;
	}


public static int delete(int id) throws ClassNotFoundException, SQLException {
	String query="Delete from employee.detail where Emp_id=?;";
System.out.println("delete called");
int status=0;
	try {
		Connection con;
		
	con = connect();
	PreparedStatement ps= con.prepareStatement(query);
	ps.setInt(1, id);
	status=ps.executeUpdate();
	con.close();  
}catch (ClassNotFoundException e) {
	System.out.println("Class not found");
}catch( SQLException e) {
	System.out.println(e);
}
	return status;
}}
