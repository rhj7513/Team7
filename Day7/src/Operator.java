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
				System.out.println("������ ����� �����ȣ�� �Է��Ͻÿ�");
				String eNum=sc.next();
				if(eNum.charAt(0)=='F') {
					for(int i=0;i<fe.length;i++) {
						if(fe[i].getEmployeeNum().equals(eNum)) {
							System.out.println("�����ȣ: "+fe[i].getEmployeeNum());
							System.out.println("������ ������ �����Ͻÿ�");
							System.out.print("��å: "+fe[i].getPosition()+"\t");
							System.out.print("�μ�: "+fe[i].getDepartment()+"\t");
							System.out.println("�޿�: "+fe[i].getSalary()+"\t");
							System.out.println("1.��å 2. �μ� 3.�޿� 0.����");
							int n=sc.nextInt();
							if(n==1) {
								System.out.println("��å�� �������� �����Ͻðڽ��ϴ�.");
								System.out.println("1.��� 2. ���� 3. ���� 4. ����");
								String jobN=sc.next();
								if(jobN.equals("1")||jobN.equals("���")) {
									fe[i].setPosition("���");
									System.out.println("������� ����Ϸ�");
								}else if(jobN.equals("2")||jobN.equals("����")) {
									fe[i].setPosition("����");
									System.out.println("�������� ����Ϸ�");
								}else if(jobN.equals("3")||jobN.equals("����")) {
									fe[i].setPosition("����");
									System.out.println("�������� ����Ϸ�");
								}else if(jobN.equals("4")||jobN.equals("����")) {
									fe[i].setPosition("����");
									System.out.println("�������� ����Ϸ�");
								}else {
									System.out.println("�Է¿���");
								}
							}else if(n==2) {
								System.out.println("�μ��� �������� ���� �Ͻðڽ��ϱ�");
								System.out.println("1.�ѹ� 2. �λ� 3. ȫ�� 4. ��ȹ");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("�ѹ�")) {
									fe[i].setDepartment("�ѹ�");
									System.out.println("�ѹ��� ����Ϸ�");
								}else if(departN.equals("2")||departN.equals("�λ�")) {
									fe[i].setDepartment("�λ�");
									System.out.println("�λ�� ����Ϸ�");
								}else if(departN.equals("3")||departN.equals("ȫ��")) {
									fe[i].setDepartment("ȫ��");
									System.out.println("ȫ���� ����Ϸ�");
								}else if(departN.equals("4")||departN.equals("��ȹ")) {
									fe[i].setDepartment("��ȹ");
									System.out.println("��ȹ���� ����Ϸ�");
								}else {
									System.out.println("�Է¿���");
								}							
							}else if(n==3) {
								System.out.println("����� �޿� �Է�");
								int sal=sc.nextInt();
								fe[i].setSalary(sal);
								System.out.println("�޿����� �Ϸ�");
							}else if(n==0) {
								System.out.println("����");
								break;
							}
						}
					}				
				}else if(eNum.charAt(0)=='P') {
					for(int i=0;i<pe.length;i++) {
						if(fe[i].getEmployeeNum().equals(eNum)) {
							System.out.println("�����ȣ: "+pe[i].getEmployeeNum());
							System.out.println("������ ������ �����Ͻÿ�");
							System.out.print("�μ�: "+pe[i].getDepartment()+"\t");
							System.out.println("�޿�: "+pe[i].getSalary()+"\t");
							System.out.println("1.�μ� 2.�޿� 0.����");
							int n=sc.nextInt();//�Է� ����
							 if(n==1) {
								System.out.println("�μ��� �������� ���� �Ͻðڽ��ϱ�");
								System.out.println("1.�ѹ� 2. �λ� 3. ȫ�� 4. ��ȹ");
								String departN=sc.next();
								if(departN.equals("1")||departN.equals("�ѹ�")) {
									pe[i].setDepartment("�ѹ�");
									System.out.println("�ѹ��� ����Ϸ�");
								}else if(departN.equals("2")||departN.equals("�λ�")) {
									pe[i].setDepartment("�λ�");
									System.out.println("�λ�� ����Ϸ�");
								}else if(departN.equals("3")||departN.equals("ȫ��")) {
									pe[i].setDepartment("ȫ��");
									System.out.println("ȫ���� ����Ϸ�");
								}else if(departN.equals("4")||departN.equals("��ȹ")) {
									pe[i].setDepartment("��ȹ");
									System.out.println("��ȹ���� ����Ϸ�");
								}else {
									System.out.println("�Է¿���");
								}							
							}else if(n==3) {
								System.out.println("����� �޿� �Է�");
								int sal=sc.nextInt();
								pe[i].setSalary(sal);
								System.out.println("�޿����� �Ϸ�");
							}else if(n==0) {
								System.out.println("����");
								break;
							}
						}
					}
				}				
		}else if(type.equals("F")){
			for(;;) {
				System.out.println("������ ���������� �����Ͻÿ�");
				System.out.println("�̸�"+fe[id].getName());
				System.out.print("�������: "+fe[id].getBirthday()+"\t");
				System.out.print("��ȭ��ȣ: "+fe[id].getCall()+"\t");
				System.out.print("�ּ�: "+fe[id].getAddress()+"\t");
				System.out.print("���¹�ȣ: "+fe[id].getAccountNum()+"\t");
				System.out.println("��й�ȣ: "+fe[id].getPassword());
				System.out.println();
				System.out.println("1.�̸� 2. ������� 3. ��ȭ��ȣ 4. �ּ� 5. ���¹�ȣ 6. ��й�ȣ 0.����");
				int n=sc.nextInt(); // �Է� ����
				if(n==1) {
					System.out.println("�̸��� �������� �����Ͻʴϱ�?");
					fe[id].setName(sc.next());	
					System.out.println(fe[id].getName()+":���� ����Ϸ�");
					}else if(n==2) {
						System.out.println("��������� �����Ͻʽÿ�");
						fe[id].setBirthday(sc.nextInt());
						System.out.println(fe[id].getBirthday()+"���� ����Ϸ�");
					}else if(n==3) {
						System.out.println("��ȭ��ȣ�� �������ּ���");
						fe[id].setCall(sc.nextInt());
						System.out.println(fe[id].getCall()+"���� ����Ϸ�");
					}else if(n==4) {
						System.out.println("�ּҸ� �������ּ���");
						fe[id].setAddress(sc.next());
						System.out.println(fe[id].getAddress()+"���� ����Ϸ�");
					}else if(n==5) {
						System.out.println("���¹�ȣ�� �������ּ���");
						fe[id].setAccountNum(sc.nextInt());
						System.out.println(fe[id].getAccountNum()+"���� ����Ϸ�");
					}else if(n==6) {
						System.out.println("��й�ȣ�� �������ּ���");
						fe[id].setPassword(sc.next());
						System.out.println(fe[id].getPassword()+"���� ����Ϸ�");
					}else if(n==0) {
						System.out.println("������������ ����");
						break;
					}
			}			
		}else if(type.equals("P")){
			for(;;) {
				System.out.println("������ ���������� �����Ͻÿ�");
				System.out.println("�̸�"+pe[id].getName());
				System.out.print("�������: "+pe[id].getBirthday()+"\t");
				System.out.print("��ȭ��ȣ: "+pe[id].getCall()+"\t");
				System.out.print("�ּ�: "+pe[id].getAddress()+"\t");
				System.out.print("���¹�ȣ: "+pe[id].getAccountNum()+"\t");
				System.out.println("��й�ȣ: "+pe[id].getPassword());
				System.out.println();
				System.out.println("1.�̸� 2. ������� 3. ��ȭ��ȣ 4. �ּ� 5. ���¹�ȣ 6. ��й�ȣ 0.����");
				int n=sc.nextInt(); // �Է� ����
				if(n==1) {
					System.out.println("�̸��� �������� �����Ͻʴϱ�?");
					pe[id].setName(sc.next());	
					System.out.println(pe[id].getName()+":���� ����Ϸ�");
					}else if(n==2) {
						System.out.println("��������� �����Ͻʽÿ�");
						pe[id].setBirthday(sc.nextInt());
						System.out.println(pe[id].getBirthday()+"���� ����Ϸ�");
					}else if(n==3) {
						System.out.println("��ȭ��ȣ�� �������ּ���");
						pe[id].setCall(sc.nextInt());
						System.out.println(pe[id].getCall()+"���� ����Ϸ�");
					}else if(n==4) {
						System.out.println("�ּҸ� �������ּ���");
						pe[id].setAddress(sc.next());
						System.out.println(pe[id].getAddress()+"���� ����Ϸ�");
					}else if(n==5) {
						System.out.println("���¹�ȣ�� �������ּ���");
						fe[id].setAccountNum(sc.nextInt());
						System.out.println(pe[id].getAccountNum()+"���� ����Ϸ�");
					}else if(n==6) {
						System.out.println("��й�ȣ�� �������ּ���");
						fe[id].setPassword(sc.next());
						System.out.println(pe[id].getPassword()+"���� ����Ϸ�");
					}else if(n==0) {
						System.out.println("������������ ����");
						break;
					}
			}		
		}
	}
	public void deleteInfo(Scanner sc) {
		System.out.println("������ �����ȣ");
		String eNum=sc.next();
		if(eNum.charAt(0)=='F') {
			for(int i=0;i<fe.length;i++) {
				if(eNum.equals(fe[i].getEmployeeNum())) {
					System.out.print("�̸�: "+fe[i].getName()+"\t");
					System.out.println("��å: "+fe[i].getPosition()+"��  ��������� �����Ͻô°� �½��ϱ�?");
					System.out.println("1.��(����) 2. ���");
					int dN=sc.nextInt();
					if(dN==1) {
						fe[i].setEmployeeNum(null); //�ʿ��������? 
					}else {
						break;
					}					
				}
			}
		}else if(eNum.charAt(0)=='P') {
			for(int i=0;i<pe.length;i++) {
				if(eNum.equals(pe[i].getEmployeeNum())) {
					System.out.print("�̸�: "+pe[i].getName()+"\t");
					System.out.println("�μ�: "+pe[i].getDepartment()+"��  ��������� �����Ͻô°� �½��ϱ�?");
					System.out.println("1.��(����) 2. ���");
					int dN=sc.nextInt();
					if(dN==1) {
						pe[i].setEmployeeNum(null); //�ʿ��������? 
						pe[i]=null;
					}else {
						break;
					}					
				}
			}
		}else {
			System.out.println("�����ȣ �߸��Է��ϼ̽��ϴ�.");
		}
		
	}
	public void findInfo() {}
	public void dispInfo(Scanner sc) {}
	
	
	
	public static void main(String[] args) {
		

	}

}
