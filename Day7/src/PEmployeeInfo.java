
public class PEmployeeInfo {
	private PersonInfo[]person;
	//private SalaryOp[]salaryop; -> SalaryOp class생성 후 추가

	//필드
	private String employeeNum;
	private String department;
	private int salary;
	
	//생성자
	public PEmployeeInfo() {//빈
		
	}
	
	public PEmployeeInfo(String en, String d, int s) { //전체
		employeeNum = en;
		department = d;
		salary = s;
	}
	
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
