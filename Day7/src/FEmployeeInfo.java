
public class FEmployeeInfo {
	private PersonInfo name;
	//private SalaryOp[]salaryop; -> SalaryOp class생성 후 추가
	//필드
	private String employeeNum;
	private String position;
	private String department;
	private int year;
	private int salary;
	
	//생성자
	public FEmployeeInfo() {//빈
		
	}
	
	public FEmployeeInfo(String en, String p, String d, int y, int s) { //전체
		employeeNum = en;
		position = p;
		department = d;
		year = y;
		salary = s;
	}

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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
