
public class FEmployeeInfo {
	private PersonInfo person;
	//private SalaryOp salaryop; -> SalaryOp class생성 후 추가
	//필드
	private String employeeNum;
	private String position;
	private String department;
	private int year;
	private int salary;
	
	//생성자
	public FEmployeeInfo() {
		 person = new PersonInfo();
	}
	
	

	
//	public FEmployeeInfo(String en, String p, String d, int y, int s) { //전체
//		employeeNum = en;
//		position = p;
//		department = d;
//		year = y;
//		salary = s;
//	}

	//get추가함
	public String getEmployeeNum() {
		return employeeNum;
	}
	public String getPosition() {
		return position;
	}
	public String getDepartment() {
		return department;
	}
	public int getYear() {
		return year;
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
	public void setPosition(String p) {
		this.position = p;
	}
	public void setDepartment(String d) {
		this.department = d;
	}
	public void setYear(int y) {
		this.year = y;
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
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
