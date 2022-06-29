
public class PEmployeeInfo {
	private PersonInfo person;
	//private SalaryOp salaryop; -> SalaryOp class생성 후 추가

	//필드
	private String employeeNum;
	private String department;
	private int salary;
	
	//생성자
	public PEmployeeInfo() {//빈
		
	}
	
//	public PEmployeeInfo(String en, String d, int s) { //전체
//		employeeNum = en;
//		department = d;
//		salary = s;
//	}
	
	//get추가함
	public String getEmployeeNum() {
		return employeeNum;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}
	
	public String getName() {
		return person.getName();
	}
	public int getBirthday() {
		return person.getBirthday();
	}
	public int getCall() {
		return person.getCall();
	}
	public String getAddress() {
		return person.getAddress();
	}
	public int getAccountNum() {
		return person.getAccountNum();
	}
	public String getPassword() {
		return person.getPassword();
	}
	
	
	
	//set추가함
	public void setEmployeeNum(String en) {
		this.employeeNum = en;
	}
	public void setDepartment(String d) {
		this.department = d;
	}
	public void setSalary(int s) {
		this.salary = s;
	}
	
	public void setName(String name) {
		this.person.setName(name);
	}
	public void setBirthday(int birthday) {
		this.person.setBirthday(birthday);
	}
	public void setCall(int call) {
		this.person.setCall(call);
	}
	public void setAddress(String address) {
		this.person.setAddress(address);
	}
	public void setAccountNum(int accountnum) {
		this.person.setAccountNum(accountnum);
	}
	public void setPassword(String password) {
		this.person.setPassword(password);
	}
	


}
