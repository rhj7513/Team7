import java.util.*;

public class Salary {
	private int id;//��� �������� Ȯ�� �� ��
	private String typei;//������, ��������
	private FEmployeeInfo[] fei; //������ Ŭ����
	private PEmployeeInfo[] pei; //�������� Ŭ����
	private int fpos;//������ Ŭ���� �迭 index
	private int ppos;//�������� Ŭ���� �迭 index
	private static int check=1; //1�� ������ 0�� �����
	
	public void loginAdmin() {
		Scanner sc=  new Scanner(System.in);
		
		String id;
		String pw;
		
		System.out.print("���̵� �Է����ּ��� : ");
		id = sc.next();
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		pw = sc.next();
		
		if (id.equals("admin")) {
			if (pw.equals("admin")) {
				System.out.println("������ ��� ");
				check=1;
				typei="admin";
				for(;;) {
					System.out.println("1. �Է� 2. ���� 3. ���� 4. �˻� 5.��� 0.�α׾ƿ�");
					int num =sc.nextInt();
					switch(num) {
					case 1:
						System.out.println("<<<<�Է�>>>>");
						addInfo();
						break;
					case 0:
						System.out.println("�α׾ƿ�");
						check=0;
						break;
					case 2:
						System.out.println("<<<<����>>>>");
						modifyInfo(sc);
						break;
					case 3:
						System.out.println("<<<<����>>>>");
						deleteInfo(sc);
						break;
					case 4:
						System.out.println("<<<<�˻�>>>>");
						findInfo(sc);
						break;
					case 5:
						System.out.println("<<<<���>>>>");
						dispInfo(sc);
						break;
					}
					if(check==0) {
						break; //���ѷ���Ż��
					}
				}
				
			}
		}else {
			System.out.println("������ ���̵� �ƴմϴ�.");
		}
		
	}
	
	public void loginUser() {
		String empnum;
		String empw;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("����� �Է����ּ��� : ");
		empnum = sc.next();
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		empw = sc.next();
		
		//������ Ŭ�������� ����� ã��
		 if(empnum.charAt(0)=='F') {
			 for (int i =0; i<fei.length; i++) {
				 if (fei[i]!=null) {
					if (empnum.equals(fei[i].getEmployeeNum())) { //empnum(����ڰ� �Է��� ���)�� getEmployeeNum(FEmployeeInfo Ŭ�������� ��� ��ȣ�� ��������) �� 
						if (empw.equals(fei[i].getPassword())) { //getPassword = ����� �Է��ص� ��й�ȣ ��������
							System.out.println("�α��� ����!");
							id = i;
							typei = "F";
							check = 0;
							 for(;;) {
				            	   System.out.println("1. �˻� 2. ���� 3. ��� 0.�α׾ƿ�");
					               int userNum=sc.nextInt();//�Է�
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
							System.out.println("������� �ٽ��Է����ּ���");
							loginUser();
							break;
						}
					}
				}else if(check!=0) {
					break;
				}
				
			 }
			 
		 }else if(empnum.charAt(0)=='P') {
			//�������� Ŭ�������� ����� ã��
				for (int i =0; i<pei.length; i++) {
					if(pei[i]!=null) {
						if (empnum.equals(pei[i].getEmployeeNum())) { //empnum(����ڰ� �Է��� ���)�� getEmployeeNum(PEmployeeInfo Ŭ�������� ��� ��ȣ�� ��������) �� 
							if (empw.equals(pei[i].getPassword())) { //getPassword = ����� �Է��ص� ��й�ȣ ��������
								System.out.println("�α��� ����!");
								id = i;
								typei="P";
								check =0;
								for(;;) {
					            	   System.out.println("1. �˻� 2. ���� 3. ��� 0.�α׾ƿ�");
						               int userNum=sc.nextInt();//�Է�
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
								System.out.println("�α��� ���� �ٽ� �Է����ּ���");
								break;
							}
						}
					}
				} 
		 }else {		
			 System.out.println("����Ǿ� �ִ� �����Ͱ� �����ϴ�.");			  
		 }
	}
	
	//������
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
	
	//������ (�����ȣ, ��å, �μ�, �Ի�⵵, �޿�)
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
	
	//�������� (�����ȣ, �޿�, �μ�)
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
		//������/�������� + ��ȣ = ���
		String workerType; //���������� ������������ �����
		int empnum;//����� ��ȣ�� int�� 
		String employeenum;//������/�������� + ��ȣ = ���
		String position; //��å
		String department; //�μ�
		int year; //�Ի�⵵(�������) = �������� �ش�
		int salary;//�޿�
		//�������� ó���� �Է��� �״�� 
		String name;
		int birthday;
		int call;
		String address;
		int accountNum;
		String password;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������(F) / ��������(P)�ΰ���? : ");
		workerType = sc.next();
		
		if (workerType.equals("F")||workerType.equals("f")) {//������ (�����ȣ, ��å, �μ�, �Ի�⵵, �޿�, ��������)
			System.out.print("��ȣ�� �Է����ּ��� : ");
			empnum = sc.nextInt();
			employeenum = workerType+empnum;
			System.out.println("��� : " + employeenum);
			System.out.print("��å�� �Է����ּ��� : ");
			position = sc.next();
			System.out.print("�μ��� �Է����ּ��� : ");
			department = sc.next();
			System.out.print("�Ի�⵵�� �Է����ּ��� : ");
			year = sc.nextInt();
			System.out.print("�޿��� �Է����ּ��� : ");
			salary = sc.nextInt();
			
			
			//�������� �Է� (ó������ �׳� ����)
			System.out.print("�̸��� �Է����ּ��� :");
			name = sc.next();
			System.out.print("����⵵�� �Է����ּ��� :");
			birthday = sc.nextInt();
			System.out.print("��ȭ��ȣ�� �Է����ּ��� :");
			call = sc.nextInt();
			System.out.print("�ּҸ� �Է����ּ��� :");
			address = sc.next();
			System.out.print("���¹�ȣ�� �Է����ּ��� :");
			accountNum = sc.nextInt();
			System.out.print("��й�ȣ�� �Է����ּ��� :");
			password = sc.next();

			setFEmployeeInfo(employeenum, position, department, year, salary, name, birthday, call, address, accountNum, password);
			
		}else if (workerType.equals("P")||workerType.equals("p")) { //�������� (�����ȣ, �޿�, �μ�, ��������)
			System.out.print("��ȣ�� �Է����ּ��� : ");
			empnum = sc.nextInt();
			employeenum = workerType+empnum;
			System.out.println("�����ȣ : "+employeenum);

			System.out.print("�μ��� �Է����ּ��� : ");
			department = sc.next();
			System.out.print("�޿��� �Է����ּ��� : ");
			salary = sc.nextInt();

			
			//�������� �Է� (ó������ �׳� ����)
			System.out.print("�̸��� �Է����ּ��� :");
			name = sc.next();
			System.out.print("����⵵�� �Է����ּ��� :");
			birthday = sc.nextInt();
			System.out.print("��ȭ��ȣ�� �Է����ּ��� :");
			call = sc.nextInt();
			System.out.print("�ּҸ� �Է����ּ��� :");
			address = sc.next();
			System.out.print("���¹�ȣ�� �Է����ּ��� :");
			accountNum = sc.nextInt();
			System.out.print("��й�ȣ�� �Է����ּ��� :");
			password = sc.next();
			//set
			setPEmployeeInfo(employeenum, department, salary, name, birthday, call, address, accountNum, password);
			
		}else {
			System.out.println("�߸� �Է��߽��ϴ�.");
			//�޴��� ����?
			//while������ �Ұ�
		}
	}
	
	public void modifyInfo(Scanner sc) {		
		if(typei.equals("admin")) {
				System.out.println("������ ����� �����ȣ�� �Է��Ͻÿ�");
				String eNum=sc.next();
				if(eNum.charAt(0)=='F') {					
					for(int i=0;i<fei.length;i++) {
						if(fei[i]!=null) {
							if(eNum.equals(fei[i].getEmployeeNum())) {
								System.out.println("�����ȣ: "+fei[i].getEmployeeNum());
								System.out.println("������ ������ �����Ͻÿ�");
								System.out.print("��å: "+fei[i].getPosition()+"\t");
								System.out.print("�μ�: "+fei[i].getDepartment()+"\t");
								System.out.println("�޿�: "+fei[i].getSalary()+"\t");
								System.out.println("1.��å 2. �μ� 3.�޿� 0.����");
								int n=sc.nextInt();
								if(n==1) {
									System.out.println("��å�� �������� �����Ͻðڽ��ϴ�.");
									System.out.println("1.��� 2. ���� 3. ���� 4. ����");
									String jobN=sc.next();
									if(jobN.equals("1")||jobN.equals("���")) {
										fei[i].setPosition("���");
										System.out.println("������� ����Ϸ�");
									}else if(jobN.equals("2")||jobN.equals("����")) {
										fei[i].setPosition("����");
										System.out.println("�������� ����Ϸ�");
									}else if(jobN.equals("3")||jobN.equals("����")) {
										fei[i].setPosition("����");
										System.out.println("�������� ����Ϸ�");
									}else if(jobN.equals("4")||jobN.equals("����")) {
										fei[i].setPosition("����");
										System.out.println("�������� ����Ϸ�");
									}else {
										System.out.println("�Է¿���");
									}
									fei[i].setRealSalary(fei[i].getSalary(),fei[i].getEmployeeNum(),fei[i].getPosition());
									break;
								}else if(n==2) {
									System.out.println("�μ��� �������� ���� �Ͻðڽ��ϱ�");
									System.out.println("1.�ѹ� 2. �λ� 3. ȫ�� 4. ��ȹ");
									String departN=sc.next();
									if(departN.equals("1")||departN.equals("�ѹ�")) {
										fei[i].setDepartment("�ѹ�");
										System.out.println("�ѹ��� ����Ϸ�");
									}else if(departN.equals("2")||departN.equals("�λ�")) {
										fei[i].setDepartment("�λ�");
										System.out.println("�λ�� ����Ϸ�");
									}else if(departN.equals("3")||departN.equals("ȫ��")) {
										fei[i].setDepartment("ȫ��");
										System.out.println("ȫ���� ����Ϸ�");
									}else if(departN.equals("4")||departN.equals("��ȹ")) {
										fei[i].setDepartment("��ȹ");
										System.out.println("��ȹ���� ����Ϸ�");
									}else {
										System.out.println("�Է¿���");
									}
									break;							
								}else if(n==3) {
									System.out.println("����� �޿� �Է�");
									int sal=sc.nextInt();
									fei[i].setSalary(sal);
									fei[i].setRealSalary(sal,fei[i].getEmployeeNum(),fei[i].getPosition());
									System.out.println("�޿����� �Ϸ�");
									break;
								}else if(n==0) {
									System.out.println("����");
									break;
								}
							} else {
								System.out.println("err");
							}
						}
					}				
				}else if(eNum.charAt(0)=='P') {//��������
					for(int i=0;i<pei.length;i++) {
						if(pei[i]!=null) {
							if(eNum.equals(pei[i].getEmployeeNum())) {
								System.out.println("�����ȣ: "+pei[i].getEmployeeNum());
								System.out.println("������ ������ �����Ͻÿ�");
								System.out.print("�μ�:"+pei[i].getDepartment()+" \t");
								System.out.println("�޿�: "+pei[i].getSalary()+"\t");
								System.out.println("1.�μ� 2.�޿� 0.����");
								int n=sc.nextInt();//�Է� ����
								 if(n==1) {
									System.out.println("�μ��� �������� ���� �Ͻðڽ��ϱ�");
									System.out.println("1.�ѹ� 2. �λ� 3. ȫ�� 4. ��ȹ");
									String departN=sc.next();
									if(departN.equals("1")||departN.equals("�ѹ�")) {
										pei[i].setDepartment("�ѹ�");
										System.out.println("�ѹ��� ����Ϸ�");
									}else if(departN.equals("2")||departN.equals("�λ�")) {
										pei[i].setDepartment("�λ�");
										System.out.println("�λ�� ����Ϸ�");
									}else if(departN.equals("3")||departN.equals("ȫ��")) {
										pei[i].setDepartment("ȫ��");
										System.out.println("ȫ���� ����Ϸ�");
									}else if(departN.equals("4")||departN.equals("��ȹ")) {
										pei[i].setDepartment("��ȹ");
										System.out.println("��ȹ���� ����Ϸ�");
									}else {
										System.out.println("�Է¿���");
									}				
									break;
								}else if(n==2) {
									System.out.println("����� �޿� �Է�");
									int sal=sc.nextInt();
									pei[i].setSalary(sal);
									pei[i].setRealSalary(sal,pei[i].getEmployeeNum(),"");
									System.out.println("�޿����� �Ϸ�");
									break;
								}else if(n==0) {
									System.out.println("����");
									break;
								}
							}
						}
					}
				}				
		}else if(typei.equals("F")){
			for(;;) {
				System.out.println("������ ���������� �����Ͻÿ�");
				System.out.println("�̸�"+fei[id].getName());
				System.out.print("�������: "+fei[id].getBirthday()+"\t");
				System.out.print("��ȭ��ȣ: "+fei[id].getCall()+"\t");
				System.out.print("�ּ�: "+fei[id].getAddress()+"\t");
				System.out.print("���¹�ȣ: "+fei[id].getAccountNum()+"\t");
				System.out.println("��й�ȣ: "+fei[id].getPassword());
				System.out.println();
				System.out.println("1.�̸� 2. ������� 3. ��ȭ��ȣ 4. �ּ� 5. ���¹�ȣ 6. ��й�ȣ 0.����");
				int n=sc.nextInt(); // �Է� ����
				if(n==1) {
					System.out.println("�̸��� �������� �����Ͻʴϱ�?");
					fei[id].setName(sc.next());	
					System.out.println(fei[id].getName()+":���� ����Ϸ�");
					}else if(n==2) {
						System.out.println("��������� �����Ͻʽÿ�");
						fei[id].setBirthday(sc.nextInt());
						System.out.println(fei[id].getBirthday()+"���� ����Ϸ�");
					}else if(n==3) {
						System.out.println("��ȭ��ȣ�� �������ּ���");
						fei[id].setCall(sc.nextInt());
						System.out.println(fei[id].getCall()+"���� ����Ϸ�");
					}else if(n==4) {
						System.out.println("�ּҸ� �������ּ���");
						fei[id].setAddress(sc.next());
						System.out.println(fei[id].getAddress()+"���� ����Ϸ�");
					}else if(n==5) {
						System.out.println("���¹�ȣ�� �������ּ���");
						fei[id].setAccountNum(sc.nextInt());
						System.out.println(fei[id].getAccountNum()+"���� ����Ϸ�");
					}else if(n==6) {
						System.out.println("��й�ȣ�� �������ּ���");
						fei[id].setPassword(sc.next());
						System.out.println(fei[id].getPassword()+"���� ����Ϸ�");
					}else if(n==0) {
						System.out.println("������������ ����");
						break;
					}
			}			
		}else if(typei.equals("P")){
			for(;;) {
				System.out.println("������ ���������� �����Ͻÿ�");
				System.out.println("�̸�"+pei[id].getName());
				System.out.print("�������: "+pei[id].getBirthday()+"\t");
				System.out.print("��ȭ��ȣ: "+pei[id].getCall()+"\t");
				System.out.print("�ּ�: "+pei[id].getAddress()+"\t");
				System.out.print("���¹�ȣ: "+pei[id].getAccountNum()+"\t");
				System.out.println("��й�ȣ: "+pei[id].getPassword());
				System.out.println();
				System.out.println("1.�̸� 2. ������� 3. ��ȭ��ȣ 4. �ּ� 5. ���¹�ȣ 6. ��й�ȣ 0.����");
				int n=sc.nextInt(); // �Է� ����
				if(n==1) {
					System.out.println("�̸��� �������� �����Ͻʴϱ�?");
					pei[id].setName(sc.next());	
					System.out.println(pei[id].getName()+":���� ����Ϸ�");
					}else if(n==2) {
						System.out.println("��������� �����Ͻʽÿ�");
						pei[id].setBirthday(sc.nextInt());
						System.out.println(pei[id].getBirthday()+"���� ����Ϸ�");
					}else if(n==3) {
						System.out.println("��ȭ��ȣ�� �������ּ���");
						pei[id].setCall(sc.nextInt());
						System.out.println(pei[id].getCall()+"���� ����Ϸ�");
					}else if(n==4) {
						System.out.println("�ּҸ� �������ּ���");
						pei[id].setAddress(sc.next());
						System.out.println(pei[id].getAddress()+"���� ����Ϸ�");
					}else if(n==5) {
						System.out.println("���¹�ȣ�� �������ּ���");
						pei[id].setAccountNum(sc.nextInt());
						System.out.println(pei[id].getAccountNum()+"���� ����Ϸ�");
					}else if(n==6) {
						System.out.println("��й�ȣ�� �������ּ���");
						pei[id].setPassword(sc.next());
						System.out.println(pei[id].getPassword()+"���� ����Ϸ�");
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
			for(int i=0;i<fei.length;i++) {
				if(eNum.equals(fei[i].getEmployeeNum())) {
					System.out.print("�̸�: "+fei[i].getName()+"\t");
					System.out.println("��å: "+fei[i].getPosition()+"��  ��������� �����Ͻô°� �½��ϱ�?");
					System.out.println("1.��(����) 2. ���");
					int dN=sc.nextInt();
					if(dN==1) {
						//fei[i].setEmployeeNum(null); //�ʿ��������?
						fei[i]=null;

					}else {
						break;
					}					
				}
			}
		}else if(eNum.charAt(0)=='P') {
			for(int i=0;i<pei.length;i++) {
				if(eNum.equals(pei[i].getEmployeeNum())) {
					System.out.print("�̸�: "+pei[i].getName()+"\t");
					System.out.println("�μ�: "+pei[i].getDepartment()+"��  ��������� �����Ͻô°� �½��ϱ�?");
					System.out.println("1.��(����) 2. ���");
					int dN=sc.nextInt();
					if(dN==1) {
						//pei[i].setEmployeeNum(null); //�ʿ��������? 	
						pei[i]=null;
					}else {
						break;
					}					
				}
			}
		}else {
			System.out.println("�����ȣ �߸��Է��ϼ̽��ϴ�.");
		}
		
	}
	
	public void findInfo(Scanner sc) { //�˻� �޼ҵ�
	      if(typei.equals("admin"))
	      {
	         System.out.println("1 �̸� �˻�    2 ��å �˻�    3 �μ� �˻�");
	         System.out.print("�˻��ϰ� ���� ���ڸ� �Է��ϼ���:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. �̸� �˻�
	               System.out.print("�˻��ϰ� ���� �̸��� �Է��ϼ���: ");
	               String name = sc.next();
	               
	               System.out.println("========================================"+name+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && name.equals(fei[i].getName())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<��������>");
	               System.out.println("�����ȣ\t�̸�\t�μ�\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && name.equals(pei[i].getName())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;   
	            case 2: //��å �˻�
	               System.out.print("�˻��ϰ� ���� ��å�� �Է��ϼ���: ");
	               String pos = sc.next();
	               
	               System.out.println("========================================"+pos+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && pos.equals(fei[i].getPosition())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //�μ� �˻�
	               System.out.print("�˻��ϰ� ���� �μ��� �Է��ϼ���: ");
	               String dep = sc.next();
	               
	               System.out.println("========================================"+dep+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && dep.equals(fei[i].getDepartment())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<��������>");
	               System.out.println("�����ȣ\t�̸�\t�μ�\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && dep.equals(pei[i].getDepartment())) //null���� �ƴϸ� ���
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
	         System.out.println("1 �̸� �˻�    2 ��å �˻�    3 �μ� �˻�");
	         System.out.print("�˻��ϰ� ���� ���ڸ� �Է��ϼ���:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. �̸� �˻�
	               System.out.print("�˻��ϰ� ���� �̸��� �Է��ϼ���: ");
	               String name = sc.next();
	               
	               System.out.println("========================================"+name+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && name.equals(fei[i].getName())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println("<��������>");
	               System.out.println("�����ȣ\t�̸�\t�μ�");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && name.equals(pei[i].getName())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment());
	                  }
	               }
	               System.out.println();
	               break;   
	            case 2: //��å �˻�
	               System.out.print("�˻��ϰ� ���� ��å�� �Է��ϼ���: ");
	               String pos = sc.next();
	               
	               System.out.println("========================================"+pos+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && pos.equals(fei[i].getPosition())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //�μ� �˻�
	               System.out.print("�˻��ϰ� ���� �μ��� �Է��ϼ���: ");
	               String dep = sc.next();
	               
	               System.out.println("========================================"+dep+"���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && dep.equals(fei[i].getDepartment())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear());
	                  }
	               }
	               System.out.println("<��������>");
	               System.out.println("�����ȣ\t�̸�\t�μ�");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && dep.equals(pei[i].getDepartment())) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment());
	                  }
	               }
	               System.out.println();
	               break;
	         }
	      }
	      
	   }
	
	
	public void dispInfo(Scanner sc) { //��� �޼ҵ�
	      
	      if(typei.equals("admin"))
	      {
	         System.out.println("1 ��ü ���    2 ������ ��ü ���    3 �������� ��ü ���");
	         System.out.print("����ϰ� ���� ���ڸ� �Է��ϼ���:");
	         int num = sc.nextInt();
	         
	         switch(num)
	         {
	            case 1: //1. ��ü ���
	               System.out.println("========================================��ü ���========================================");
	               System.out.println("<������>");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && fei[i].getEmployeeNum()!=null) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println("<��������>");
	               System.out.println("�����ȣ\t�̸�\t�μ�\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && pei[i].getEmployeeNum()!=null) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(pei[i].getEmployeeNum()+"\t"+pei[i].getName()+"\t"+pei[i].getDepartment()+"\t"+pei[i].getRealSalary()+"\t"+
	                           pei[i].getBirthday()+"\t"+pei[i].getCall()+"\t"+pei[i].getAddress()+"\t"+pei[i].getAccountNum()+"\t"+pei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	               
	            case 2: //2. ������ ��ü ���
	               System.out.println("========================================������ ���========================================");
	               System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<fei.length; i++) //������ ���
	               {
	                  if(fei[i]!=null && fei[i].getEmployeeNum()!=null) //null���� �ƴϸ� ���
	                  {
	                     System.out.println(fei[i].getEmployeeNum()+"\t"+fei[i].getName()+"\t"+fei[i].getPosition()+"\t"+fei[i].getDepartment()+"\t"+fei[i].getYear()+"\t"+fei[i].getRealSalary()+"\t"+
	                           fei[i].getBirthday()+"\t"+fei[i].getCall()+"\t"+fei[i].getAddress()+"\t"+fei[i].getAccountNum()+"\t"+fei[i].getPassword());
	                  }
	               }
	               System.out.println();
	               break;
	            case 3: //3. �������� ��ü ���
	               System.out.println("========================================�������� ���========================================");
	               System.out.println("�����ȣ\t�̸�\t�μ�\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	               for(int i=0; i<pei.length; i++) //�������� ���
	               {
	                  if(pei[i]!=null && pei[i].getEmployeeNum()!=null) //null���� �ƴϸ� ���
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
	    	  System.out.println("�����ȣ\t�̸�\t��å\t�μ�\t�Ի�⵵\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	         System.out.println(fei[id].getEmployeeNum()+"\t"+fei[id].getName()+"\t"+fei[id].getPosition()+"\t"+fei[id].getDepartment()+"\t"+fei[id].getYear()+"\t"+fei[id].getRealSalary()+"\t"+
	               fei[id].getBirthday()+"\t"+fei[id].getCall()+"\t"+fei[id].getAddress()+"\t"+fei[id].getAccountNum()+"\t"+fei[id].getPassword());
	      }
	      else if(typei.equals("P"))
	      {
	    	  System.out.println("�����ȣ\t�̸�\t�μ�\t�Ǳ޿�\t�������\t��ȭ��ȣ\t\t�ּ�\t���¹�ȣ\t\t��й�ȣ");
	         System.out.println(pei[id].getEmployeeNum()+"\t"+pei[id].getName()+"\t"+pei[id].getDepartment()+"\t"+pei[id].getRealSalary()+"\t"+
	               pei[id].getBirthday()+"\t"+pei[id].getCall()+"\t"+pei[id].getAddress()+"\t"+pei[id].getAccountNum()+"\t"+pei[id].getPassword());
	      }
	      
	   }
	
	
	private String aid, apw;//������ ���̵� ��й�ȣ �� ����

	public static void main(String[] args) {	
		
		Scanner sc= new Scanner(System.in);
		Salary iidd = new Salary(50);
		System.out.println("ù�����Դϴ� �����ڷα��κ��� ���ֽʼ�");
		for(;;) {
			System.out.println("1. ������ �α��� 2. ����� �α��� 0. �ý�������");
			int loginN=sc.nextInt();
			
			if(loginN==1) {
				iidd.loginAdmin();
			}else if(loginN==2) {
				iidd.loginUser();				
			}else if(loginN==0) {
				System.out.println("�ý����� �����մϴ�");
				break;
			}			
		}
	}
	
	
}