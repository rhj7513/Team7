import java.util.Scanner;

public class Operator {
	private FEmployeeInfo[] fe; //정규직 사원 정보
	private PEmployeeInfo[] pe; //비정규직 사원 정보
	private SalaryOp so;
	private int num;
	
	/*
	//객체 생성
	public Operator(int num) {
		this.num = num;
		fe = new FEmployeeInfo[this.num];
		for(int i=0; i<fe.length; i++)
		{
			fe[i]=new FEmployeeInfo();
		}
	}
	*/
	
	public void findInfo(Scanner sc) { //검색 메소드
		System.out.println("1 이름 검색    2 정규직 검색    3 비정규직 검색");
		System.out.print("검색하고 싶은 숫자를 입력하세요:");
		int num = sc.nextInt();
		
		so = new SalaryOp();
		switch(num)
		{
			case 1: //1. 이름 검색
				System.out.print("검색하고 싶은 이름 입력하세요: ");
				String name = sc.next();
				
				System.out.println("========================================"+name+"출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fe.length; i++) //정규직 출력
				{
					if(name.equals(fe[i].getName()) && fe[i]!=null) //검색하고 싶은 반과 일치, null값이 아니면 출력하라
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(fe[i].getEmployeeNum()+"\t"+fe[i].getName()+"\t"+fe[i].getPosition()+"\t"+fe[i].getDepartment()+"\t"+fe[i].getYear()+"\t"+so.getSalaryOp()+"\t"+
								fe[i].getBirthday()+"\t"+fe[i].getCall()+"\t"+fe[i].getAddress()+"\t"+fe[i].getAccountNum()+"\t"+fe[i].getPassword());
					}
				}
				for(int i=0; i<pe.length; i++) //비정규직 출력
				{
					if(name.equals(pe[i].getName())&& pe[i]!=null) //검색하고 싶은 반과 일치, null값이 아니면 출력하라
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(pe[i].getEmployeeNum()+"\t"+pe[i].getName()+"\t"+"Null"+"\t"+pe[i].getDepartment()+"\t"+"Null"+"\t"+so.getSalaryOp()+"\t"+
								pe[i].getBirthday()+"\t"+pe[i].getCall()+"\t"+pe[i].getAddress()+"\t"+pe[i].getAccountNum()+"\t"+pe[i].getPassword());
					}
				}
				break;				
			case 2: //2.  정규직 검색
				System.out.println("========================================정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fe.length; i++) //정규직 출력
				{
					if(fe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(fe[i].getEmployeeNum()+"\t"+fe[i].getName()+"\t"+fe[i].getPosition()+"\t"+fe[i].getDepartment()+"\t"+fe[i].getYear()+"\t"+so.getSalaryOp()+"\t"+
								fe[i].getBirthday()+"\t"+fe[i].getCall()+"\t"+fe[i].getAddress()+"\t"+fe[i].getAccountNum()+"\t"+fe[i].getPassword());
					}
				}
				break;
			case 3: //3. 비정규직 검색
				System.out.println("========================================비정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<pe.length; i++) //비정규직 출력
				{
					if(pe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(pe[i].getEmployeeNum()+"\t"+pe[i].getName()+"\t"+"Null"+"\t"+pe[i].getDepartment()+"\t"+"Null"+"\t"+so.getSalaryOp()+"\t"+
								pe[i].getBirthday()+"\t"+pe[i].getCall()+"\t"+pe[i].getAddress()+"\t"+pe[i].getAccountNum()+"\t"+pe[i].getPassword());
					}
				}
				break;
		}
	}
	
	public void dispInfo(Scanner sc) { //출력 메소드
		System.out.println("1 전체 출력    2 정규직 전체 출력    3 비정규직 전체 출력");
		System.out.print("출력하고 싶은 숫자를 입력하세요:");
		int num = sc.nextInt();
		switch(num)
		{
			case 1: //1. 전체 출력
				System.out.println("========================================전체 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fe.length; i++) //정규직 출력
				{
					if(fe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(fe[i].getEmployeeNum()+"\t"+fe[i].getName()+"\t"+fe[i].getPosition()+"\t"+fe[i].getDepartment()+"\t"+fe[i].getYear()+"\t"+so.getSalaryOp()+"\t"+
								fe[i].getBirthday()+"\t"+fe[i].getCall()+"\t"+fe[i].getAddress()+"\t"+fe[i].getAccountNum()+"\t"+fe[i].getPassword());
					}
				}
				
				for(int i=0; i<pe.length; i++) //비정규직 출력
				{
					if(pe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(pe[i].getEmployeeNum()+"\t"+pe[i].getName()+"\t"+"Null"+"\t"+pe[i].getDepartment()+"\t"+"Null"+"\t"+so.getSalaryOp()+"\t"+
								pe[i].getBirthday()+"\t"+pe[i].getCall()+"\t"+pe[i].getAddress()+"\t"+pe[i].getAccountNum()+"\t"+pe[i].getPassword());
					}
				}
				break;
				
			case 2: //2. 정규직 전체 출력
				System.out.println("========================================정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<fe.length; i++) //정규직 출력
				{
					if(fe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(fe[i].getEmployeeNum()+"\t"+fe[i].getName()+"\t"+fe[i].getPosition()+"\t"+fe[i].getDepartment()+"\t"+fe[i].getYear()+"\t"+so.getSalaryOp()+"\t"+
								fe[i].getBirthday()+"\t"+fe[i].getCall()+"\t"+fe[i].getAddress()+"\t"+fe[i].getAccountNum()+"\t"+fe[i].getPassword());
					}
				}
				break;
			case 3: //3. 비정규직 전체 출력
				System.out.println("========================================비정규직 출력========================================");
				System.out.println("사원번호\t이름\t직책\t부서\t입사년도\t급여\t생년월일\t전화번호\t주소\t계좌번호\t비밀번호\t");
				for(int i=0; i<pe.length; i++) //비정귲기 출력
				{
					if(pe[i]!=null) //null값이 아니면 출력
					{
						so.setSalaryOp(fe[i].getSalary(), fe[i].getEmployeeNum(), fe[i].getDepartment());
						System.out.println(pe[i].getEmployeeNum()+"\t"+pe[i].getName()+"\t"+"Null"+"\t"+pe[i].getDepartment()+"\t"+"Null"+"\t"+so.getSalaryOp()+"\t"+
								pe[i].getBirthday()+"\t"+pe[i].getCall()+"\t"+pe[i].getAddress()+"\t"+pe[i].getAccountNum()+"\t"+pe[i].getPassword());
					}
				}
				break;
		}
	}
/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		Operator op = new Operator();

		op.dispInfo(sc);
		op.findInfo(sc);
		
		

	}
*/
}
