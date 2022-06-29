import java.util.Scanner;

public class Operator {
	private FEmployeeInfo fe[];
	private PEmployeeInfo pe[];
	private int id;
	private String type;
	
	public void login(){}
	public void addInfo() {}
	public void modifyInfo(Scanner sc) {		
		if(type.equals("admin")) {
				System.out.println("변경할 사원의 사원번호를 입력하시오");
				String eNum=sc.next();
				if(eNum.charAt(0)=='F') {
					for(int i=0;i<fe.length;i++) {
						if(fe[i].getEmployeeNum().equals(eNum)) {
							System.out.println("사원번호: "+fe[i].getEmployeeNum());
							System.out.println("수정할 정보를 선택하시오");
							System.out.print("직책: "+fe[i].getPosition()+"\t");
							System.out.print("부서: "+fe[i].getDepartment()+"\t");
							System.out.println("급여: "+fe[i].getSalary()+"\t");
							System.out.println("1.직책 2. 부서 3.급여 0.종료");
							int n=sc.nextInt();
							if(n==1) {
								System.out.println("직책을 무엇으로 변경하시겠습니다.");
								System.out.println("1.사원 2. 팀장 3. 과장 4. 사장");
								String jobN=sc.next();
								if(jobN.equals("1")||jobN.equals("사원")) {
									fe[i].setPosition("사원");
									System.out.println("사원으로 변경완료");
								}else if(jobN.equals("2")||jobN.equals("팀장")) {
									fe[i].setPosition("팀장");
									System.out.println("팀장으로 변경완료");
								}else if(jobN.equals("3")||jobN.equals("과장")) {
									fe[i].setPosition("과장");
									System.out.println("과장으로 변경완료");
								}else if(jobN.equals("4")||jobN.equals("사장")) {
									fe[i].setPosition("사장");
									System.out.println("사장으로 변경완료");
								}else {
									System.out.println("입력오류");
								}
							}else if(n==2) {
								System.out.println("부서를 무엇으로 변경 하시겠습니까");
								System.out.println("1.총무 2. 인사 3. 홍보 4. 기획");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("총무")) {
									fe[i].setDepartment("총무");
									System.out.println("총무로 변경완료");
								}else if(departN.equals("2")||departN.equals("인사")) {
									fe[i].setDepartment("인사");
									System.out.println("인사로 변경완료");
								}else if(departN.equals("3")||departN.equals("홍보")) {
									fe[i].setDepartment("홍보");
									System.out.println("홍보로 변경완료");
								}else if(departN.equals("4")||departN.equals("기획")) {
									fe[i].setDepartment("기획");
									System.out.println("기획으로 변경완료");
								}else {
									System.out.println("입력오류");
								}							
							}else if(n==3) {
								System.out.println("변경된 급여 입력");
								int sal=sc.nextInt();
								fe[i].setSalary(sal);
								System.out.println("급여변경 완료");
							}else if(n==0) {
								System.out.println("종료");
								break;
							}
						}
					}				
				}else if(eNum.charAt(0)=='P') {
					for(int i=0;i<pe.length;i++) {
						if(fe[i].getEmployeeNum().equals(eNum)) {
							System.out.println("사원번호: "+pe[i].getEmployeeNum());
							System.out.println("수정할 정보를 선택하시오");
							System.out.print("부서: "+pe[i].getDepartment()+"\t");
							System.out.println("급여: "+pe[i].getSalary()+"\t");
							System.out.println("1.부서 2.급여 0.종료");
							int n=sc.nextInt();//입력 숫자
							 if(n==1) {
								System.out.println("부서를 무엇으로 변경 하시겠습니까");
								System.out.println("1.총무 2. 인사 3. 홍보 4. 기획");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("총무")) {
									pe[i].setDepartment("총무");
									System.out.println("총무로 변경완료");
								}else if(departN.equals("2")||departN.equals("인사")) {
									pe[i].setDepartment("인사");
									System.out.println("인사로 변경완료");
								}else if(departN.equals("3")||departN.equals("홍보")) {
									pe[i].setDepartment("홍보");
									System.out.println("홍보로 변경완료");
								}else if(departN.equals("4")||departN.equals("기획")) {
									pe[i].setDepartment("기획");
									System.out.println("기획으로 변경완료");
								}else {
									System.out.println("입력오류");
								}							
							}else if(n==3) {
								System.out.println("변경된 급여 입력");
								int sal=sc.nextInt();
								pe[i].setSalary(sal);
								System.out.println("급여변경 완료");
							}else if(n==0) {
								System.out.println("종료");
								break;
							}
						}
					}
				}				
		}else if(type.equals("F")){
			for(;;) {
				System.out.println("수정할 개인정보를 선택하시오");
				System.out.println("이름"+fe[id].getName());
				System.out.print("생년월일: "+fe[id].getBirthday()+"\t");
				System.out.print("전화번호: "+fe[id].getCall()+"\t");
				System.out.print("주소: "+fe[id].getAddress()+"\t");
				System.out.print("계좌번호: "+fe[id].getAccountNum()+"\t");
				System.out.println("비밀번호: "+fe[id].getPassword());
				System.out.println();
				System.out.println("1.이름 2. 생년월일 3. 전화번호 4. 주소 5. 계좌번호 6. 비밀번호 0.종료");
				int n=sc.nextInt(); // 입력 숫자
				if(n==1) {
					System.out.println("이름을 무엇으로 변경하십니까?");
					fe[id].setName(sc.next());	
					System.out.println(fe[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						fe[id].setBirthday(sc.nextInt());
						System.out.println(fe[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						fe[id].setCall(sc.nextInt());
						System.out.println(fe[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						fe[id].setAddress(sc.next());
						System.out.println(fe[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						fe[id].setAccountNum(sc.nextInt());
						System.out.println(fe[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						fe[id].setPassword(sc.next());
						System.out.println(fe[id].getPassword()+"으로 변경완료");
					}else if(n==0) {
						System.out.println("개인정보수정 종료");
						break;
					}
			}			
		}else if(type.equals("P")){
			for(;;) {
				System.out.println("수정할 개인정보를 선택하시오");
				System.out.println("이름"+pe[id].getName());
				System.out.print("생년월일: "+pe[id].getBirthday()+"\t");
				System.out.print("전화번호: "+pe[id].getCall()+"\t");
				System.out.print("주소: "+pe[id].getAddress()+"\t");
				System.out.print("계좌번호: "+pe[id].getAccountNum()+"\t");
				System.out.println("비밀번호: "+pe[id].getPassword());
				System.out.println();
				System.out.println("1.이름 2. 생년월일 3. 전화번호 4. 주소 5. 계좌번호 6. 비밀번호 0.종료");
				int n=sc.nextInt(); // 입력 숫자
				if(n==1) {
					System.out.println("이름을 무엇으로 변경하십니까?");
					pe[id].setName(sc.next());	
					System.out.println(pe[id].getName()+":으로 변경완료");
					}else if(n==2) {
						System.out.println("생년월일을 변경하십시오");
						pe[id].setBirthday(sc.nextInt());
						System.out.println(pe[id].getBirthday()+"으로 변경완료");
					}else if(n==3) {
						System.out.println("전화번호를 변경해주세요");
						pe[id].setCall(sc.nextInt());
						System.out.println(pe[id].getCall()+"으로 변경완료");
					}else if(n==4) {
						System.out.println("주소를 변경해주세요");
						pe[id].setAddress(sc.next());
						System.out.println(pe[id].getAddress()+"으로 변경완료");
					}else if(n==5) {
						System.out.println("계좌번호를 변경해주세요");
						fe[id].setAccountNum(sc.nextInt());
						System.out.println(pe[id].getAccountNum()+"으로 변경완료");
					}else if(n==6) {
						System.out.println("비밀번호를 변경해주세요");
						fe[id].setPassword(sc.next());
						System.out.println(pe[id].getPassword()+"으로 변경완료");
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
			for(int i=0;i<fe.length;i++) {
				if(eNum.equals(fe[i].getEmployeeNum())) {
					System.out.print("이름: "+fe[i].getName()+"\t");
					System.out.println("직책: "+fe[i].getPosition()+"의  사원정보를 삭제하시는게 맞습니까?");
					System.out.println("1.예(삭제) 2. 취소");
					int dN=sc.nextInt();
					if(dN==1) {
						fe[i].setEmployeeNum(null); //필요없을수도? 
					}else {
						break;
					}					
				}
			}
		}else if(eNum.charAt(0)=='P') {
			for(int i=0;i<pe.length;i++) {
				if(eNum.equals(pe[i].getEmployeeNum())) {
					System.out.print("이름: "+pe[i].getName()+"\t");
					System.out.println("부서: "+pe[i].getDepartment()+"의  사원정보를 삭제하시는게 맞습니까?");
					System.out.println("1.예(삭제) 2. 취소");
					int dN=sc.nextInt();
					if(dN==1) {
						pe[i].setEmployeeNum(null); //필요없을수도? 
						pe[i]=null;
					}else {
						break;
					}					
				}
			}
		}else {
			System.out.println("사원번호 잘못입력하셨습니다.");
		}
		
	}
	public void findInfo() {}
	public void dispInfo(Scanner sc) {}
	
	
	
	public static void main(String[] args) {
		

	}

}
