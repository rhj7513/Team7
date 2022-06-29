public class SalaryOp {
	private int insentive; //insentive
	private int basicSalary; //입력받은 값
	private int realSalary; //실급여

	public int getSalaryOp() {
		return realSalary; //실급여 출력
	}

	
	public void setSalaryOp(int bs, String en, String po) { //급여, 사원번호, 직책
		basicSalary = bs; //급여
		if(en.charAt(0)=='F') //사원번호 첫번째 글자가 F인 경우, 정규직 급여 적용
		{
			realSalary = basicSalary; //실급여에 저장
		}
		else if(en.charAt(0)=='P') //사원번호 첫번째 글자가 P인 경우, 비정규직 급여 적용
		{
			realSalary = (int)(basicSalary*0.8); //실급여에 저장
		}
		
		if(po.equals("사원")) //직책이 사원인 경우
		{
			insentive = (int)(basicSalary*0.1); //insentive=급여*0.1
		}
		else if(po.equals("팀장")) //직책이 팀장인 경우
		{
			insentive = (int)(basicSalary*0.3); //insentive=급여*0.3
		}
		else if(po.equals("과장")) //직책이 과장인 경우
		{
			insentive = (int)(basicSalary*0.5); //insentive=급여*0.5
		}
		else if(po.equals("사장")) //직책이 사장인 경우
		{
			insentive = (int)(basicSalary*0.7); //insentive=급여*0.7
		}else if(po.equals(null)){
			insentive=0;
		}else {
			insentive=0;
		}
		
		this.realSalary = realSalary + insentive; //실급여= 정규직과 비정규직에 따른 급여+insentive
	}
} 