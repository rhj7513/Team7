
public class SalaryOp {
	private int insentive; //insentive
	private int basicSalary; //�Է¹��� ��
	private int realSalary; //�Ǳ޿�

	public int getSalaryOp() {
		return realSalary; //�Ǳ޿� ���
	}
	
	public void setSalaryOp(int bs, String en, String po) { //�޿�, �����ȣ, ��å
		basicSalary = bs; //�޿�
		if(en.charAt(0)=='F') //�����ȣ ù��° ���ڰ� F�� ���, ������ �޿� ����
		{
			realSalary = basicSalary; //�Ǳ޿��� ����
		}
		else if(en.charAt(0)=='P') //�����ȣ ù��° ���ڰ� P�� ���, �������� �޿� ����
		{
			realSalary = (int)(basicSalary*0.8); //�Ǳ޿��� ����
		}
		
		if(po.equals("���")) //��å�� ����� ���
		{
			insentive = (int)(basicSalary*0.1); //insentive=�޿�*0.1
		}
		else if(po.equals("����")) //��å�� ������ ���
		{
			insentive = (int)(basicSalary*0.3); //insentive=�޿�*0.3
		}
		else if(po.equals("����")) //��å�� ������ ���
		{
			insentive = (int)(basicSalary*0.5); //insentive=�޿�*0.5
		}
		else if(po.equals("����")) //��å�� ������ ���
		{
			insentive = (int)(basicSalary*0.7); //insentive=�޿�*0.7
		}else {
			insentive=0;
		}
		
		realSalary = realSalary + insentive; //�Ǳ޿�= �������� ���������� ���� �޿�+insentive
	}
} 