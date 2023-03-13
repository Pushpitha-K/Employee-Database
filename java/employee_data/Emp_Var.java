package employee_data;

public class Emp_Var {

	private String name,pass,email,country, phone_no, date,status,type,reason,year,month;
	int sno;
	private int wday,pday;private float hra,da,pf,pt,basic,gross,net, ded ;
	
	public int getWday() {
		return wday;
	}
	public void setWday(int wday) {
		this.wday = wday;
	}
	public int getPday() {
		return pday;
	}
	public void setPday(int pday) {
		this.pday = pday;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getDa() {
		return da;
	}
	public void setDa(float da) {
		this.da = da;
	}
	public float getPf() {
		return pf;
	}
	public void setPf(float pf) {
		this.pf = pf;
	}
	public float getPt() {
		return pt;
	}
	public void setPt(float pt) {
		this.pt = pt;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public float getGross() {
		return gross;
	}
	public void setGross(float gross) {
		this.gross = gross;
	}
	public float getNet() {
		return net;
	}
	public void setNet(float net) {
		this.net = net;
	}
	public float getDed() {
		return ded;
	}
	public void setDed(float ded) {
		this.ded = ded;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	private int id;
	public void setName(String name) {
		this.name = name;

	}
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//public static void main(String []args) {
//	Emp_Var onj = new Emp_Var() ;
//	onj.setName("Pushpitha");
//	onj.getName();
//	}
}
