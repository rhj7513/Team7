package main1;

import java.util.*;
import java.time.LocalDate;import java.time.ZoneId;


public class Salary {
	private int id;//사번 개인정보 확인 할 때
	private String type;//정규직, 비정규직
	
	
	
	
	/*
	public void login(String empnum, String empw) {
		//1. 관리자 모드 로그인
		//id : admin pw : admin
		//2. 사용자 모드 로그인
		//id : 사원번호FEmployeeInfo/PEmployeeInfo의 employeeNum(String)  pw : PersonInfo의 password(String)
		
		//정규직 클래스에서 사번을 찾음
		for (int i =0; i<FEmployeeInfo.length; i++) {
			if (FEployeeInfo[i].getEmployeeNum.equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(FEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
				if (FEployeeInfo[i].getPassword.equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
					System.out.println("로그인 성공!");
					id = i;
					type = "F";
					//메뉴가기?!
				}
				else{
					System.out.println("로그인 실패");
				}
			}
		}
		//비정규직 클래스에서 사번을 찾음
		for (int i =0; i<PEmployeeInfo.length; i++) {
			if (PEployeeInfo[i].getEmployeeNum.equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(PEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
				if (PEployeeInfo[i].getPassword.equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
					System.out.println("로그인 성공!");
					id = i;
					type="P";
					//메뉴가기?!
				}
				else {
					System.out.println("로그인 실패");
				}
			}
			
		}
		
	}*/
	
	
	
	
	
	
	private FEmployeeInfo[] fei; //정규직 클래스
	private PEmployeeInfo[] pei; //비정규직 클래스
	private int fpos;//정규직 클래스 배열 index
	private int ppos;//비정규직 클래스 배열 index
	//생성자
	public Salary() {
		fpos=0;
		fei = new FEmployeeInfo[50];
		pei = new PEmployeeInfo[50];
		
		for (int i=0; i<fei.length; i++) {
			
			fei[i] = new FEmployeeInfo();
			
			if (pei[i]==null) {
				pei[i] = new PEmployeeInfo();
			}
		}
	}
	
	
	
	
	//정규직 (사원번호, 직책, 부서, 입사년도, 급여)
	public void setFEmployeeInfo(String employeeNum, String position, String department, int year, int salary,
			String name , int birthday, int call, String address, int accountNum, String password ){
		fei[fpos].setEmployeeNum(employeeNum);
		fei[fpos].setPosition(position);
		fei[fpos].setDepartment(department);
		fei[fpos].setYear(year);
		fei[fpos].setSalary(salary);
		fei[fpos].setName(name);
		fei[fpos].setBirthday(birthday);
		fei[fpos].setCall(call);
		fei[fpos].setAddress(address);
		fei[fpos].setAccountNum(accountNum);
		fei[fpos].setPassword(password);
		fpos++;
	}
	
	//비정규직 (사원번호, 급여, 부서)
	public void setPEmployeeInfo(String employeeNum, String department, int salary,
			String name, int birthday, int call, String address, int accountNum, String password) {
		pei[ppos].setEmployeeNum(employeeNum);
		pei[ppos].setDepartment(department);
		pei[ppos].setSalary(salary);
		pei[ppos].setName(name);
		pei[ppos].setBirthday(birthday);
		pei[ppos].setCall(call);
		pei[ppos].setAddress(address);
		pei[ppos].setAccountNum(accountNum);
		pei[ppos].setPassword(password);
		ppos++;
	}
	

	
	public void addInfo() {
		Salary sl = new Salary();
		
		//feild
		//정규직/비정규직 + 번호 = 사번
		String workerType; //정규직인지 비정규직인지 물어볼때
		int empnum;//사번의 번호는 int형 
		String employeenum;//정규직/비정규직 + 번호 = 사번
		String position; //직책
		String department; //부서
		int year; //입사년도(몇년찬지) = 정규직만 해당
		int salary;//급여
		//개인정보 처음에 입력은 그대로 
		String name;
		int birthday;
		int call;
		String address;
		int accountNum;
		String password;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정규직(F) / 비정규직(P)인가요? : ");
		workerType = sc.next();
		
		if (workerType.equals("F")||workerType.equals("f")) {//정규직 (사원번호, 직책, 부서, 입사년도, 급여, 개인정보)
			System.out.print("번호를 입력해주세요 : ");
			empnum = sc.nextInt();
			employeenum = workerType+empnum;
			System.out.println("사번 : " + employeenum);
			System.out.print("직책을 입력해주세요 : ");
			position = sc.next();
			System.out.print("부서를 입력해주세요 : ");
			department = sc.next();
			System.out.print("입사년도를 입력해주세요 : ");
			year = sc.nextInt();
			System.out.print("급여를 입력해주세요 : ");
			salary = sc.nextInt();
			
			
			//개인정보 입력 (처음에는 그냥 넣음)
			System.out.print("이름을 입력해주세요 :");
			name = sc.next();
			System.out.print("출생년도를 입력해주세요 :");
			birthday = sc.nextInt();
			System.out.print("전화번호를 입력해주세요 :");
			call = sc.nextInt();
			System.out.print("주소를 입력해주세요 :");
			address = sc.next();
			System.out.print("계좌번호를 입력해주세요 :");
			accountNum = sc.nextInt();
			System.out.print("비밀번호를 입력해주세요 :");
			password = sc.next();
			sl.setFEmployeeInfo(employeenum, position, department, year, salary, name, birthday, call, address, accountNum, password);
			
			
		}else if (workerType.equals("P")||workerType.equals("p")) { //비정규직 (사원번호, 급여, 부서, 개인정보)
			System.out.print("번호를 입력해주세요 : ");
			empnum = sc.nextInt();
			employeenum = workerType+empnum;
			System.out.println("사원번호 : "+employeenum);

			System.out.print("부서를 입력해주세요 : ");
			department = sc.next();
			System.out.print("급여를 입력해주세요 : ");
			salary = sc.nextInt();

			
			//개인정보 입력 (처음에는 그냥 넣음)
			System.out.print("이름을 입력해주세요 :");
			name = sc.next();
			System.out.print("출생년도를 입력해주세요 :");
			birthday = sc.nextInt();
			System.out.print("전화번호를 입력해주세요 :");
			call = sc.nextInt();
			System.out.print("주소를 입력해주세요 :");
			address = sc.next();
			System.out.print("계좌번호를 입력해주세요 :");
			accountNum = sc.nextInt();
			System.out.print("비밀번호를 입력해주세요 :");
			password = sc.next();
			//set
			sl.setPEmployeeInfo(employeenum, department, salary, name, birthday, call, address, accountNum, password);
			
		}else {
			System.out.println("잘못 입력했습니다.");
			//메뉴로 가기?
			//while문으로 할건
		}
	}
	
	
	public void disp() {
		System.out.println("------출력---------");
		for (int i=0; i<50; i++) {
			System.out.print("이름 : "+fei[i].getEmployeeNum());
			System.out.print("부서 : "+fei[i].getDepartment());
		}
		
		
		
	}
	
	
	public static void main (String[] args) {
		Salary sl = new Salary();
		sl.addInfo();
		sl.disp();
		
		
		
	}
	
	
}
