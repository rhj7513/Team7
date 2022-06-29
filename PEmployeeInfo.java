
public class PEmployeeInfo {
	private PersonInfo person;
	//private SalaryOp salaryop; -> SalaryOp class���� �� �߰�

	//�ʵ�
	private String employeeNum;
	private String department;
	private int salary;
	private SalaryOp so;
	//������
	public PEmployeeInfo() {//��
		person = new PersonInfo();
		so=new SalaryOp();
	}
	
//	public PEmployeeInfo(String en, String d, int s) { //��ü
//		employeeNum = en;
//		department = d;
//		salary = s;
//	}
	
	//get�߰���
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
	
	
	
	//set�߰���
	public void setEmployeeNum(String en) {
		this.employeeNum = en;
	}
	public void setDepartment(String d) {
		this.department = d;
	}
	public void setSalary(int s,String en, String po) { //�޿�, �����ȣ, ��å
		so.setSalaryOp(s, en, po);
		this.salary=so.getSalaryOp();
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