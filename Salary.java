//package main1;

import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;


public class Salary {
	private int id;//사번 개인정보 확인 할 때
	private String typei;//정규직, 비정규직
	private FEmployeeInfo[] fei; //정규직 클래스
	private PEmployeeInfo[] pei; //비정규직 클래스
	private int fpos;//정규직 클래스 배열 index
	private int ppos;//비정규직 클래스 배열 index
	
//	public void login(String empnum, String empw) {
//		//1. 관리자 모드 로그인
//		//id : admin pw : admin
//		//2. 사용자 모드 로그인
//		//id : 사원번호feimployeeInfo/peimployeeInfo의 employeeNum(String)  pw : peirsonInfo의 password(String)
//		
//		//정규직 클래스에서 사번을 찾음
//		for (int i =0; i<feimployeeInfo.length; i++) {
//			if (feiployeeInfo[i].getEmployeeNum.equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(feimployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
//				if (feiployeeInfo[i].getPassword.equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
//					System.out.println("로그인 성공!");
//					id = i;
//					typei = "F";
//					//메뉴가기?!
//				}
//				else{
//					System.out.println("로그인 실패");
//				}
//			}
//		}
//		//비정규직 클래스에서 사번을 찾음
//		for (int i =0; i<peimployeeInfo.length; i++) {
//			if (peiployeeInfo[i].getEmployeeNum.equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(peimployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
//				if (peiployeeInfo[i].getPassword.equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
//					System.out.println("로그인 성공!");
//					id = i;
//					typei="P";
//					//메뉴가기?!
//				}
//				else {
//					System.out.println("로그인 실패");
//				}
//			}
//			
//		}
//		
//	}
	
	
	

	//생성자
	public Salary(int num) {
		fpos=0;
		ppos=0;
		
		fei = new FEmployeeInfo[num];
		pei = new PEmployeeInfo[num];
		
		for (int i=0; i<num; i++) {
			
				fei[i] = new FEmployeeInfo();
	
			
			if (pei[i]==null) {
				pei[i] = new PEmployeeInfo();
			}
		}
	}
	
	
	
	
	//정규직 (사원번호, 직책, 부서, 입사년도, 급여)
	public void setfeimployeeInfo(String employeeNum, String position, String department, int year, int salary,
			String name , int birthday, int call, String address, int accountNum, String password ){
		fei[fpos].setEmployeeNum(employeeNum);
		fei[fpos].setPosition(position);
		fei[fpos].setDepartment(department);
		fei[fpos].setYear(year);
		fei[fpos].setSalary(salary);
		fei[fpos].setRealSalary(salary,fei[fpos].getEmployeeNum(),fei[fpos].getPosition());
		fei[fpos].setName(name);
		fei[fpos].setBirthday(birthday);
		fei[fpos].setCall(call);
		fei[fpos].setAddress(address);
		fei[fpos].setAccountNum(accountNum);
		fei[fpos].setPassword(password);
		fpos++;
	}
	
	//비정규직 (사원번호, 급여, 부서)
	public void setpeimployeeInfo(String employeeNum, String department, int salary,
			String name, int birthday, int call, String address, int accountNum, String password) {
		pei[ppos].setEmployeeNum(employeeNum);
		pei[ppos].setDepartment(department);
		pei[ppos].setSalary(salary);
		pei[ppos].setRealSalary(salary,pei[ppos].getEmployeeNum(),"");
		pei[ppos].setName(name);
		pei[ppos].setBirthday(birthday);
		pei[ppos].setCall(call);
		pei[ppos].setAddress(address);
		pei[ppos].setAccountNum(accountNum);
		pei[ppos].setPassword(password);
		ppos++;
	}
	

	
	public void addInfo() {
		
		
		//feild
		//정규직/비정규직 + 번호 = 사번
		String workerTypei; //정규직인지 비정규직인지 물어볼때
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
		workerTypei = sc.next();
		
		if (workerTypei.equals("F")||workerTypei.equals("f")) {//정규직 (사원번호, 직책, 부서, 입사년도, 급여, 개인정보)
			System.out.print("번호를 입력해주세요 : ");
			empnum = sc.nextInt();
			employeenum = workerTypei+empnum;
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
			//sl.setfeimployeeInfo(employeenum, position, department, year, salary, name, birthday, call, address, accountNum, password);
			for(int i=0;i<fei.length;i++) {
				if(fei[i].getEmployeeNum()==null) {
					setfeimployeeInfo(employeenum, position, department, year, salary, name, birthday, call, address, accountNum, password);
					//fei[i].setEmployeeNum(employeenum);
					break;
				}
			}
			
		}else if (workerTypei.equals("P")||workerTypei.equals("p")) { //비정규직 (사원번호, 급여, 부서, 개인정보)
			System.out.print("번호를 입력해주세요 : ");
			empnum = sc.nextInt();
			employeenum = workerTypei+empnum;
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
			setpeimployeeInfo(employeenum, department, salary, name, birthday, call, address, accountNum, password);
			
		}else {
			System.out.println("잘못 입력했습니다.");
			//메뉴로 가기?
			//while문으로 할건
		}
	}
	
	
	public void modifyInfo(Scanner sc) {		
		if(typei.equals("admin")) {
				System.out.println("변경할 사원의 사원번호를 입력하시오");
				String eNum=sc.next();
				if(eNum.charAt(0)=='F') {					
					for(int i=0;i<fei.length;i++) {
						if(fei[i].getEmployeeNum().equals(eNum)) {
							System.out.println("사원번호: "+fei[i].getEmployeeNum());
							System.out.println("수정할 정보를 선택하시오");
							System.out.print("직책: "+fei[i].getPosition()+"\t");
							System.out.print("부서: "+fei[i].getDepartment()+"\t");
							System.out.println("급여: "+fei[i].getSalary()+"\t");
							System.out.println("1.직책 2. 부서 3.급여 0.종료");
							int n=sc.nextInt();
							if(n==1) {
								System.out.println("직책을 무엇으로 변경하시겠습니다.");
								System.out.println("1.사원 2. 팀장 3. 과장 4. 사장");
								String jobN=sc.next();
								if(jobN.equals("1")||jobN.equals("사원")) {
									fei[i].setPosition("사원");
									System.out.println("사원으로 변경완료");
								}else if(jobN.equals("2")||jobN.equals("팀장")) {
									fei[i].setPosition("팀장");
									System.out.println("팀장으로 변경완료");
								}else if(jobN.equals("3")||jobN.equals("과장")) {
									fei[i].setPosition("과장");
									System.out.println("과장으로 변경완료");
								}else if(jobN.equals("4")||jobN.equals("사장")) {
									fei[i].setPosition("사장");
									System.out.println("사장으로 변경완료");
								}else {
									System.out.println("입력오류");
								}
								fei[i].setRealSalary(fei[i].getSalary(),fei[i].getEmployeeNum(),fei[i].getPosition());
								break;
							}else if(n==2) {
								System.out.println("부서를 무엇으로 변경 하시겠습니까");
								System.out.println("1.총무 2. 인사 3. 홍보 4. 기획");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("총무")) {
									fei[i].setDepartment("총무");
									System.out.println("총무로 변경완료");
								}else if(departN.equals("2")||departN.equals("인사")) {
									fei[i].setDepartment("인사");
									System.out.println("인사로 변경완료");
								}else if(departN.equals("3")||departN.equals("홍보")) {
									fei[i].setDepartment("홍보");
									System.out.println("홍보로 변경완료");
								}else if(departN.equals("4")||departN.equals("기획")) {
									fei[i].setDepartment("기획");
									System.out.println("기획으로 변경완료");
								}else {
									System.out.println("입력오류");
								}
								break;							
							}else if(n==3) {
								System.out.println("변경된 급여 입력");
								int sal=sc.nextInt();
								fei[i].setSalary(sal);
								fei[i].setRealSalary(sal,fei[i].getEmployeeNum(),fei[i].getPosition());
								System.out.println("급여변경 완료");
								break;
							}else if(n==0) {
								System.out.println("종료");
								break;
							}
						}else {
							System.out.println("err");
						}
					}				
				}else if(eNum.charAt(0)=='P') {//비정규직
					for(int i=0;i<pei.length;i++) {
						if(pei[i].getEmployeeNum().equals(eNum)) {
							System.out.println("사원번호: "+pei[i].getEmployeeNum());
							System.out.println("수정할 정보를 선택하시오");
							System.out.print("부서:"+pei[i].getDepartment()+" \t");
							System.out.println("급여: "+pei[i].getSalary()+"\t");
							System.out.println("1.부서 2.급여 0.종료");
							int n=sc.nextInt();//입력 숫자
							 if(n==1) {
								System.out.println("부서를 무엇으로 변경 하시겠습니까");
								System.out.println("1.총무 2. 인사 3. 홍보 4. 기획");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("총무")) {
									pei[i].setDepartment("총무");
									System.out.println("총무로 변경완료");
								}else if(departN.equals("2")||departN.equals("인사")) {
									pei[i].setDepartment("인사");
									System.out.println("인사로 변경완료");
								}else if(departN.equals("3")||departN.equals("홍보")) {
									pei[i].setDepartment("홍보");
									System.out.println("홍보로 변경완료");
								}else if(departN.equals("4")||departN.equals("기획")) {
									pei[i].setDepartment("기획");
									System.out.println("기획으로 변경완료");
								}else {
									System.out.println("입력오류");
								}				
								break;
							}else if(n==2) {
								System.out.println("변경된 급여 입력");
								int sal=sc.nextInt();
								pei[i].setSalary(sal);
								pei[i].setRealSalary(sal,pei[i].getEmployeeNum(),"");
								System.out.println("급여변경 완료");
								break;
							}else if(n==0) {
								System.out.println("종료");
								break;
							}
						}
					}
				}				
		}else if(typei.equals("F")){
			for(;;) {
				System.out.println("수정할 개인정보를 선택하시오");
				System.out.println("이름"+fei[id].getName());
				System.out.print("생년월일: "+fei[id].getBirthday()+"\t");
				System.out.print("전화번호: "+fei[id].getCall()+"\t");
				System.out.print("주소: "+fei[id].getAddress()+"\t");
				System.out.print("계좌번호: "+fei[id].getAccountNum()+"\t");
				System.out.println("비밀번호: "+fei[id].getPassword());
				System.out.println();
				System.out.println("1.이름 2. 생년월일 3. 전화번호 4. 주소 5. 계좌번호 6. 비밀번호 0.종료");
				int n=sc.nextInt(); // 입력 숫자
				if(n==1) {
					System.out.println("이름을 무엇으로 변경하십니까?");
					fei[id].setName(sc.next());	
					System.out.println(fei[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						fei[id].setBirthday(sc.nextInt());
						System.out.println(fei[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						fei[id].setCall(sc.nextInt());
						System.out.println(fei[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						fei[id].setAddress(sc.next());
						System.out.println(fei[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						fei[id].setAccountNum(sc.nextInt());
						System.out.println(fei[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						fei[id].setPassword(sc.next());
						System.out.println(fei[id].getPassword()+"으로 변경완료");
					}else if(n==0) {
						System.out.println("개인정보수정 종료");
						break;
					}
			}			
		}else if(typei.equals("P")){
			for(;;) {
				System.out.println("수정할 개인정보를 선택하시오");
				System.out.println("이름"+pei[id].getName());
				System.out.print("생년월일: "+pei[id].getBirthday()+"\t");
				System.out.print("전화번호: "+pei[id].getCall()+"\t");
				System.out.print("주소: "+pei[id].getAddress()+"\t");
				System.out.print("계좌번호: "+pei[id].getAccountNum()+"\t");
				System.out.println("비밀번호: "+pei[id].getPassword());
				System.out.println();
				System.out.println("1.이름 2. 생년월일 3. 전화번호 4. 주소 5. 계좌번호 6. 비밀번호 0.종료");
				int n=sc.nextInt(); // 입력 숫자
				if(n==1) {
					System.out.println("이름을 무엇으로 변경하십니까?");
					pei[id].setName(sc.next());	
					System.out.println(pei[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						pei[id].setBirthday(sc.nextInt());
						System.out.println(pei[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						pei[id].setCall(sc.nextInt());
						System.out.println(pei[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						pei[id].setAddress(sc.next());
						System.out.println(pei[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						fei[id].setAccountNum(sc.nextInt());
						System.out.println(pei[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						fei[id].setPassword(sc.next());
						System.out.println(pei[id].getPassword()+"으로 변경완료");
					}else if(n==0) {
						System.out.println("개인정보수정 종료");
						break;
					}
			}		
		}
	}
	public void deleteInfo(Scanner sc) {
		System.out.println("삭제할 사원번호");
		String eNum=sc.next();
		if(eNum.charAt(0)=='F') {
			for(int i=0;i<fei.length;i++) {
				if(eNum.equals(fei[i].getEmployeeNum())) {
					System.out.print("이름: "+fei[i].getName()+"\t");
					System.out.println("직책: "+fei[i].getPosition()+"의  사원정보를 삭제하시는게 맞습니까?");
					System.out.println("1.예(삭제) 2. 취소");
					int dN=sc.nextInt();
					if(dN==1) {
						fei[i].setEmployeeNum(null); //필요없을수도? 
					}else {
						break;
					}					
				}
			}
		}else if(eNum.charAt(0)=='P') {
			for(int i=0;i<pei.length;i++) {
				if(eNum.equals(pei[i].getEmployeeNum())) {
					System.out.print("이름: "+pei[i].getName()+"\t");
					System.out.println("부서: "+pei[i].getDepartment()+"의  사원정보를 삭제하시는게 맞습니까?");
					System.out.println("1.예(삭제) 2. 취소");
					int dN=sc.nextInt();
					if(dN==1) {
						pei[i].setEmployeeNum(null); //필요없을수도? 						
					}else {
						break;
					}					
				}
			}
		}else {
			System.out.println("사원번호 잘못입력하셨습니다.");
		}
		
	}
	
	public void findInfo(Scanner sc) { //검색 메소드
		System.out.println("1 이름 검색    2 정규직 검색    3 비정규직 검색");
		System.out.print("검색하고 싶은 숫자를 입력하세요:");
		int num = sc.nextInt();
		
		
		switch(num)
		{
			case 1: //1. 이름 검색
				System.out.print("검색하고 싶은 이름 입력하세요: ");
				String name = sc.next();
				
				System.out.println("========================================"+name+"출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fei.length; i++) //정규직 출력
				{
					if(name.equals(fei[i].getName()) && fei[i].getEmployeeNum()!=null) //검색하고 싶은 반과 일치, null값이 아니면 출력하라
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
								fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
					}
				}
				for(int i=0; i<pei.length; i++) //비정규직 출력
				{
					if(name.equals(pei[i].getName())&& pei[i].getEmployeeNum()!=null) //검색하고 싶은 반과 일치, null값이 아니면 출력하라
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+"Null"+"\t"+pei[i].getDepartment()+"\t"+"Null"+"\t"+pei[i].getRealSalary()+"\t"+
								pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
					}
				}
				break;				
			case 2: //2.  정규직 검색
				System.out.println("========================================정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fei.length; i++) //정규직 출력
				{
					if(fei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
								fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
					}
				}
				break;
			case 3: //3. 비정규직 검색
				System.out.println("========================================비정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<pei.length; i++) //비정규직 출력
				{
					if(pei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+"Null"+"\t"+pei[i].getDepartment()+"\t"+"Null"+"\t"+pei[i].getRealSalary()+"\t"+
								pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
					}
				}
				break;
		}
	}
	
	public void dispInfo(Scanner sc) { //출력 메소드
		System.out.println("1 전체 출력    2 정규직 전체 출력    3 비정규직 전체 출력");
		System.out.print("출력하고 싶은 숫자를 입력하세요:");
		int num = sc.nextInt();
		if(typei.equals("admin"))
		{
			
		}
		switch(num)
		{
			case 1: //1. 전체 출력
				System.out.println("========================================전체 출력========================================");
				System.out.println("<정규직>");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fei.length; i++) //정규직 출력
				{
					if(fei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
								fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
					}
				}
				System.out.println("<비정규직>");
				System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<pei.length; i++) //비정규직 출력
				{
					if(pei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
								pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
					}
				}
				break;
				
			case 2: //2. 정규직 전체 출력
				System.out.println("========================================정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fei.length; i++) //정규직 출력
				{
					if(fei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
								fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
					}
				}
				break;
			case 3: //3. 비정규직 전체 출력
				System.out.println("========================================비정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<pei.length; i++) //비정귲기 출력
				{
					if(pei[i].getEmployeeNum()!=null) //null값이 아니면 출력
					{
						//so.setSalaryOp(fei[i].getSalary(), fei[i].getEmployeeNum(), fei[i].getDepartment());
						System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+"Null"+"\t"+pei[i].getDepartment()+"\t"+"Null"+"\t"+pei[i].getRealSalary()+"\t"+
								pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
					}
				}
				break;
		}
	}
	
	
	public static void main (String[] args) {
		Salary sl = new Salary(50);
		
		//sl.disp();
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1 입력     2 수정    3 삭제    4 검색    5 출력");
			System.out.print("메뉴를 선택하세요: ");
			int a = sc.nextInt();
			switch(a)
			{
				case 1:
					sl.addInfo();
					break;
				case 2:
					sl.typei="admin";
					sl.modifyInfo(sc);
				
					break;
				case 3: 
					sl.deleteInfo(sc);
					break;
				case 4: 
					sl.findInfo(sc);
					break;
				case 5:
					sl.dispInfo(sc);
					break;
				default:
					System.out.println("잘못 입력하였습니다.");
					break;
			}
		}
		
		
	}
	
	
}