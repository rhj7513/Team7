
public class PersonInfo {
	//�ʵ�
	private String name; //����
	private int birthday;
	private int call; //����
	private String address; //����
	private int accountNum; //����
	private String password; //����

	//������
	public PersonInfo() {//��
		
	}
	
	public PersonInfo(String n, int b, int c, String ad, int an, String pw) {//��ü
		name = n;
		birthday = b;
		call = c;
		address = ad;
		accountNum = an;
		password = pw;
	}
	
	
	
	//get�߰���
	public String getName() {
		return name;
	}
	public int getBirthday() {
		return birthday;
	}
	public int getCall() {
		return call;
	}
	public String getAddress() {
		return address;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	//set�߰���
	public void setName(String n) {
		this.name=n;
	}
	public void setBirthday(int b) {
		this.birthday = b;
	}
	public void setCall(int c) {
		this.call = c;
	}
	public void setAddress(String ad) {
		this.address = ad;
	}
	public void setAccountNum(int an) {
		this.accountNum = an;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}

}
  