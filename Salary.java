import java.util.*;

public class Salary {
	private int id;//사번 개인정보 확인 할 때
	private String typei;//정규직, 비정규직
	private FEmployeeInfo[] fei; //정규직 클래스
	private PEmployeeInfo[] pei; //비정규직 클래스
	private int fpos;//정규직 클래스 배열 index
	private int ppos;//비정규직 클래스 배열 index
	private static int check=1; //1이 괸리자 0이 사용자
	
	private String aid, apw;//관리자 아이디 비밀번호 값 저장
	
	//생성자
	public Salary(int num) {
		fpos=0;
		ppos=0;
		
		fei = new FEmployeeInfo[num];
		pei = new PEmployeeInfo[num];
		
		for (int i=0; i<num; i++) {
			
			fei[i] = new FEmployeeInfo();
			pei[i] = new PEmployeeInfo();
			/*
			if (pei[i]==null) {
				pei[i] = new PEmployeeInfo();
			}
			*/
		}
	}
	
	public Salary(int f, int p) {
        fpos=0;
        ppos=0;
        
        fei = new FEmployeeInfo[f];
        pei = new PEmployeeInfo[p];
        
        for (int i=0; i<fei.length; i++) {            
           fei[i] = new FEmployeeInfo();
        }
        for(int i=0;i<pei.length;i++) {
           pei[i]=new PEmployeeInfo();
        }
	}
	
	public void loginAdmin() {
		Scanner sc=  new Scanner(System.in);
		
		String id;
		String pw;
		
		System.out.print("아이디를 입력해주세요 : ");
		id = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		pw = sc.next();
		
		
		
		if (id.equals("admin")) {
			if (pw.equals("admin")) {
				System.out.println("관리자 모드 ");
				check=1;
				typei="admin";
				for(;;) {
					System.out.println("1. 입력 2. 수정 3. 삭제 4. 검색 5.출력 0.로그아웃");
					int num =sc.nextInt();
					switch(num) {
					case 1:
						System.out.println("<<<<입력>>>>");
						addInfo();
						break;
					case 0:
						System.out.println("로그아웃");
						check=0;
						break;
					case 2:
						System.out.println("<<<<수정>>>>");
						modifyInfo(sc);
						break;
					case 3:
						System.out.println("<<<<삭제>>>>");
						deleteInfo(sc);
						break;
					case 4:
						System.out.println("<<<<검색>>>>");
						findInfo(sc);
						break;
					case 5:
						System.out.println("<<<<출력>>>>");
						dispInfo(sc);
						break;
					}
					if(check==0) {
						break; //무한루프탈출
					}
				}
				
			}
		}else {
			System.out.println("관리자 아이디가 아닙니다.");
		}
		
	}
	
	public void loginUser() {
		String empnum;
		String empw;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("사번을 입력해주세요 : ");
		empnum = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		empw = sc.next();
		
		//정규직 클래스에서 사번을 찾음
		 if(empnum.charAt(0)=='F') {
			 for (int i =0; i<fei.length; i++) {
				 if (fei[i]!=null) {
					if (empnum.equals(fei[i].getEmployeeNum())) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(FEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
						if (empw.equals(fei[i].getPassword())) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
							System.out.println("로그인 성공!");
							id = i;
							typei = "F";
							check = 0;
							 for(;;) {
				            	   System.out.println("1. 검색 2. 수정 3. 출력 0.로그아웃");
					               int userNum=sc.nextInt();//입력
					               switch(userNum) {
				               		case 1:
				               			findInfo(sc);
				               			break;
				               		case 2:
				               			modifyInfo(sc);
				               			break;
				               		case 3:
				               			dispInfo(sc);
				               			break;		
				               		case 0:
				               			break;
					               }
					               if (userNum==0) {
					            	   break;
					               }
				           
				               }
							 break;
						}else{
							System.out.println("비번오류 다시입력해주세요");
							loginUser();
							break;
						}
					}
				}else if(check!=0) {
					break;
				}
				
			 }
			 
		 }else if(empnum.charAt(0)=='P') {
			//비정규직 클래스에서 사번을 찾음
				for (int i =0; i<pei.length; i++) {
					if(pei[i]!=null) {
						if (empnum.equals(pei[i].getEmployeeNum())) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(PEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
							if (empw.equals(pei[i].getPassword())) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
								System.out.println("로그인 성공!");
								id = i;
								typei="P";
								check =0;
								for(;;) {
					            	   System.out.println("1. 검색 2. 수정 3. 출력 0.로그아웃");
						               int userNum=sc.nextInt();//입력
						               switch(userNum) {
					               		case 1:
					               			findInfo(sc);
					               			break;
					               		case 2:
					               			modifyInfo(sc);
					               			break;
					               		case 3:
					               			dispInfo(sc);
					               			break;		
					               		case 0:
					               			break;
						               }
						               if (userNum==0) {
						            	   break;
						               }
					           
					               }
								break;
							}
							else {
								System.out.println("로그인 실패 다시 입력해주세요");
								break;
							}
						}
					}
				} 
		 }else {		
			 System.out.println("저장되어 있는 데이터가 없습니다.");			  
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
	public void setPEmployeeInfo(String employeeNum, String department, int salary,
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
			System.out.print("번호를 입력해주세요(숫자): ");
			empnum = sc.nextInt();
			employeenum = workerType+empnum;
			System.out.println("사번 : " + employeenum);
			System.out.print("직책을 입력해주세요 ex)사원, 과장, 팀장, 사장: ");
			position = sc.next();
			System.out.print("부서를 입력해주세요 ex)총무, 인사, 홍보, 기획: ");
			department = sc.next();
			System.out.print("입사년도를 입력해주세요 ex)2022: ");
			year = sc.nextInt();
			System.out.print("급여를 입력해주세요(100): ");
			salary = sc.nextInt();
			
			
			//개인정보 입력 (처음에는 그냥 넣음)
			System.out.print("이름을 입력해주세요:");
			name = sc.next();
			System.out.print("출생년도를 입력해주세요 ex)011013: ");
			birthday = sc.nextInt();
			System.out.print("전화번호를 입력해주세요 ex)01012341234: ");
			call = sc.nextInt();
			System.out.print("주소를 입력해주세요 ex)충남: ");
			address = sc.next();
			System.out.print("계좌번호를 입력해주세요 ex)0123456789: ");
			accountNum = sc.nextInt();
			System.out.print("비밀번호를 입력해주세요 ex)1234: ");
			password = sc.next();

			setFEmployeeInfo(employeenum, position, department, year, salary, name, birthday, call, address, accountNum, password);
			
		}else if (workerType.equals("P")||workerType.equals("p")) { //비정규직 (사원번호, 급여, 부서, 개인정보)
			System.out.print("번호를 입력해주세요(숫자): ");
	        empnum = sc.nextInt();
	        employeenum = workerType+empnum;
	        System.out.println("사원번호 : "+employeenum);

	        System.out.print("부서를 입력해주세요 ex)총무, 인사, 홍보, 기획: ");
	        department = sc.next();
	        System.out.print("급여를 입력해주세요(만원): ");
	        salary = sc.nextInt();

	         
	        //개인정보 입력 (처음에는 그냥 넣음)
	        System.out.print("이름을 입력해주세요: ");
	        name = sc.next();
	        System.out.print("출생년도를 입력해주세요 ex)011013: ");
	        birthday = sc.nextInt();
	        System.out.print("전화번호를 입력해주세요 ex)01012341234: ");
	        call = sc.nextInt();
	        System.out.print("주소를 입력해주세요 ex)충남: ");
	        address = sc.next();
	        System.out.print("계좌번호를 입력해주세요 ex)0123456789: ");
	        accountNum = sc.nextInt();
	        System.out.print("비밀번호를 입력해주세요 ex)1234: ");
			password = sc.next();
			//set
			setPEmployeeInfo(employeenum, department, salary, name, birthday, call, address, accountNum, password);
			
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
						if(fei[i]!=null) {
							if(eNum.equals(fei[i].getEmployeeNum())) {
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
										System.out.println("---사원으로 변경완료---");
									}else if(jobN.equals("2")||jobN.equals("팀장")) {
										fei[i].setPosition("팀장");
										System.out.println("---팀장으로 변경완료---");
									}else if(jobN.equals("3")||jobN.equals("과장")) {
										fei[i].setPosition("과장");
										System.out.println("---과장으로 변경완료---");
									}else if(jobN.equals("4")||jobN.equals("사장")) {
										fei[i].setPosition("사장");
										System.out.println("---사장으로 변경완료---");
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
										System.out.println("---총무로 변경완료---");
									}else if(departN.equals("2")||departN.equals("인사")) {
										fei[i].setDepartment("인사");
										System.out.println("---인사로 변경완료---");
									}else if(departN.equals("3")||departN.equals("홍보")) {
										fei[i].setDepartment("홍보");
										System.out.println("---홍보로 변경완료---");
									}else if(departN.equals("4")||departN.equals("기획")) {
										fei[i].setDepartment("기획");
										System.out.println("---기획으로 변경완료---");
									}else {
										System.out.println("입력오류");
									}
									break;							
								}else if(n==3) {
									System.out.println("변경된 급여 입력");
									int sal=sc.nextInt();
									fei[i].setSalary(sal);
									fei[i].setRealSalary(sal,fei[i].getEmployeeNum(),fei[i].getPosition());
									System.out.println("---급여변경 완료---");
									break;
								}else if(n==0) {
									System.out.println("종료");
									break;
								}
							} else {
								System.out.println("err");
							}
						}
					}				
				}else if(eNum.charAt(0)=='P') {//비정규직
					for(int i=0;i<pei.length;i++) {
						if(pei[i]!=null) {
							if(eNum.equals(pei[i].getEmployeeNum())) {
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
										System.out.println("---총무로 변경완료---");
									}else if(departN.equals("2")||departN.equals("인사")) {
										pei[i].setDepartment("인사");
										System.out.println("---인사로 변경완료---");
									}else if(departN.equals("3")||departN.equals("홍보")) {
										pei[i].setDepartment("홍보");
										System.out.println("---홍보로 변경완료---");
									}else if(departN.equals("4")||departN.equals("기획")) {
										pei[i].setDepartment("기획");
										System.out.println("---기획으로 변경완료---");
									}else {
										System.out.println("입력오류");
									}				
									break;
								}else if(n==2) {
									System.out.println("변경된 급여 입력");
									int sal=sc.nextInt();
									pei[i].setSalary(sal);
									pei[i].setRealSalary(sal,pei[i].getEmployeeNum(),"");
									System.out.println("---급여변경 완료---");
									break;
								}else if(n==0) {
									System.out.println("종료");
									break;
								}
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
					System.out.println("---"+fei[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						fei[id].setBirthday(sc.nextInt());
						System.out.println("---"+fei[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						fei[id].setCall(sc.nextInt());
						System.out.println("---"+fei[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						fei[id].setAddress(sc.next());
						System.out.println("---"+fei[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						fei[id].setAccountNum(sc.nextInt());
						System.out.println("---"+fei[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						fei[id].setPassword(sc.next());
						System.out.println("---"+fei[id].getPassword()+"으로 변경완료");
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
					System.out.println("---"+pei[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						pei[id].setBirthday(sc.nextInt());
						System.out.println("---"+pei[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						pei[id].setCall(sc.nextInt());
						System.out.println("---"+pei[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						pei[id].setAddress(sc.next());
						System.out.println("---"+pei[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						pei[id].setAccountNum(sc.nextInt());
						System.out.println("---"+pei[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						pei[id].setPassword(sc.next());
						System.out.println("---"+pei[id].getPassword()+"으로 변경완료");
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
						//fei[i].setEmployeeNum(null); //필요없을수도?
						fei[i]=null;

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
						//pei[i].setEmployeeNum(null); //필요없을수도? 	
						pei[i]=null;
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
	      if(typei.equals("admin"))
	      {
	         System.out.println("1 이름 검색    2 직책 검색    3 부서 검색");
	         System.out.print("검색하고 싶은 숫자를 입력하세요:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. 이름 검색
	               System.out.print("검색하고 싶은 이름을 입력하세요: ");
	               String name = sc.next();
	               
	               System.out.println("========================================"+name+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && name.equals(fei[i].getName())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<비정규직>");
	               System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && name.equals(pei[i].getName())) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;   
	            case 2: //직책 검색
	               System.out.print("검색하고 싶은 직책을 입력하세요: ");
	               String pos = sc.next();
	               
	               System.out.println("========================================"+pos+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && pos.equals(fei[i].getPosition())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //부서 검색
	               System.out.print("검색하고 싶은 부서를 입력하세요: ");
	               String dep = sc.next();
	               
	               System.out.println("========================================"+dep+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && dep.equals(fei[i].getDepartment())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<비정규직>");
	               System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && dep.equals(pei[i].getDepartment())) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	         }
	      }
	      else
	      {
	         System.out.println("1 이름 검색    2 직책 검색    3 부서 검색");
	         System.out.print("검색하고 싶은 숫자를 입력하세요:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. 이름 검색
	               System.out.print("검색하고 싶은 이름을 입력하세요: ");
	               String name = sc.next();
	               
	               System.out.println("========================================"+name+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && name.equals(fei[i].getName())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println("<비정규직>");
	               System.out.println("사원번호\t이름\t부서");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && name.equals(pei[i].getName())) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment());
	                  }
	               }
	               System.out.println();
	               break;   
	            case 2: //직책 검색
	               System.out.print("검색하고 싶은 직책을 입력하세요: ");
	               String pos = sc.next();
	               
	               System.out.println("========================================"+pos+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && pos.equals(fei[i].getPosition())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //부서 검색
	               System.out.print("검색하고 싶은 부서를 입력하세요: ");
	               String dep = sc.next();
	               
	               System.out.println("========================================"+dep+"출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && dep.equals(fei[i].getDepartment())) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println("<비정규직>");
	               System.out.println("사원번호\t이름\t부서");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && dep.equals(pei[i].getDepartment())) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment());
	                  }
	               }
	               System.out.println();
	               break;
	         }
	      }
	      
	   }
	
	
	public void dispInfo(Scanner sc) { //출력 메소드
	      
	      if(typei.equals("admin"))
	      {
	         System.out.println("1 전체 출력    2 정규직 전체 출력    3 비정규직 전체 출력");
	         System.out.print("출력하고 싶은 숫자를 입력하세요:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. 전체 출력
	               System.out.println("========================================전체 출력========================================");
	               System.out.println("<정규직>");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && fei[i].getEmployeeNum()!=null) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<비정규직>");
	               System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && pei[i].getEmployeeNum()!=null) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	               
	            case 2: //2. 정규직 전체 출력
	               System.out.println("========================================정규직 출력========================================");
	               System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<fei.length; i++) //정규직 출력
	               {
	                  if(fei[i]!=null && fei[i].getEmployeeNum()!=null) //null값이 아니면 출력
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //3. 비정규직 전체 출력
	               System.out.println("========================================비정규직 출력========================================");
	               System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	               for(int i=0; i<pei.length; i++) //비정규직 출력
	               {
	                  if(pei[i]!=null && pei[i].getEmployeeNum()!=null) //null값이 아니면 출력
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	               
	         }
	      }
	      else if(typei.equals("F"))
	      {   
	    	  System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	         System.out.println(fei[id].getEmployeeNum()+"\t"+fei[id].getName()+"\t"+fei[id].getPosition()+"\t"+fei[id].getDepartment()+"\t"+fei[id].getYear()+"\t"+fei[id].getRealSalary()+"\t"+
	               fei[id].getBirthday()+"\t"+fei[id].getCall()+"\t"+fei[id].getAddress()+"\t"+fei[id].getAccountNum()+"\t"+fei[id].getPassword());
	      }
	      else if(typei.equals("P"))
	      {
	    	  System.out.println("사원번호\t이름\t부서\t실급여\t생년월일\t전화번호\t\t주소\t계좌번호\t\t비밀번호");
	         System.out.println(pei[id].getEmployeeNum()+"\t"+pei[id].getName()+"\t"+pei[id].getDepartment()+"\t"+pei[id].getRealSalary()+"\t"+
	               pei[id].getBirthday()+"\t"+pei[id].getCall()+"\t"+pei[id].getAddress()+"\t"+pei[id].getAccountNum()+"\t"+pei[id].getPassword());
	      }
	      
	   }

	public static void main(String[] args) {	
		
		Scanner sc= new Scanner(System.in);
		//Salary iidd = new Salary(50);
		System.out.println("첫실행입니다 관리자로그인부터 해주십쇼");
		
		System.out.println("정규직 인원수를 입력하시오: ");
	    int pop=sc.nextInt();
	    System.out.println("비정규직인원수를 입력하시오: ");
	    int pop2=sc.nextInt();
	      
	    Salary iidd=new Salary(pop,pop2);
	    
		for(;;) {
			System.out.println("1. 관리자 로그인 2. 사용자 로그인 0. 시스템종료");
			int loginN=sc.nextInt();
			
			if(loginN==1) {
				iidd.loginAdmin();
			}else if(loginN==2) {
				iidd.loginUser();				
			}else if(loginN==0) {
				System.out.println("시스템을 종료합니다");
				break;
			}			
		}
	}
	
	
}