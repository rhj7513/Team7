import java. util.*;

public class Test2 {
	
	static int check = 1;
	
	private String aid, apw;//관리자 아이디 비밀번호 값 저장
	
	public Test2(String id, String pw) {
		aid = id;
		apw = pw;
	}
	
	public String getAid() {
		return aid;
	}
	public String getApw() {
		return apw;
	}

	public static void main(String[] args) {
		int num;
		// TODO Auto-generated method stub
		
			Scanner sc= new Scanner(System.in);
			Test iidd = new Test("admin", "admin");
			
			
			System.out.println("관리자 모드입니다.");
			System.out.println("아이디와 비번을 입력해주세요.");
			String a = sc.next();//관리자가 입력한 id
			String b = sc.next();//관리자가 입력한 pw
			
			while(true) {
			if(iidd.getAid().equals(a) && iidd.getApw().equals(b)) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("바보");
				break;
			}
			
			System.out.println("기능성택하시오");
			num =sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("기능");
				break;
			case 2:
				System.out.println("로그아웃");
				check=0;
				break;
			}
			while(check==0) {
				int num2;
				System.out.println("관리자 사용자 선택 ㄱ");
				Scanner sc2= new Scanner(System.in);
				num2 =sc2.nextInt();
				switch(num2) {
				case 1:
					System.out.println("1. 관리자");
					String id;
					String pw;
					
					Scanner sc3 = new Scanner(System.in);
					System.out.println("아이디를 입력하세요 : ");
					id = sc3.next();
					System.out.println("비밀번호를 입력하세요 : ");
					pw = sc3.next();
					if (id.equals("admin")) {
						if (pw.equals("admin")) {
							check=1;
						}
					}
					break;
				case 2:
					System.out.println("2. 사용자");
					 String empnum;
				      String empw;
				      
				      Scanner sc4= new Scanner(System.in);
				      
				      System.out.print("사번을 입력해주세요 : ");
				      empnum = sc4.next();
				      System.out.print("비밀번호를 입력해주세요 : ");
				      empw = sc4.next();
				      
				      //정규직 클래스에서 사번을 찾음
				      for (int i =0; i<fei.length; i++) {
				         if (fei[i].getEmployeeNum().equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(FEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
				            if (fei[i].getPassword().equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
				               System.out.println("로그인 성공!");
				               id = i;
				               type = "F";
				               check = 0;
				               
				               //메뉴가기?!
				            }
				            else{
				               System.out.println("로그인 실패");
				            }
				         }
				      }
				      //비정규직 클래스에서 사번을 찾음
				      for (int i =0; i<pei.length; i++) {
				         if (pei[i].getEmployeeNum().equals(empnum)) { //empnum(사용자가 입력한 사번)과 getEmployeeNum(PEmployeeInfo 클래스에서 사원 번호를 가져오기) 비교 
				            if (pei[i].getPassword().equals(empw)) { //getPassword = 사원이 입력해둔 비밀번호 가져오기
				               System.out.println("로그인 성공!");
				               id = i;
				               type="P";
				               check =0;
				               
				               //메뉴가기?!
				            }
				            else {
				               System.out.println("로그인 실패");
				            }
				         }
				         
				      }

					break;
				}
			}
		}
	}

}
