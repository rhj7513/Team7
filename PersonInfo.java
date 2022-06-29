public class PersonInfo {
   //필드
   private String name; //수정
   private int birthday;
   private int call; //수정
   private String address; //수정
   private int accountNum; //수정
   private String password; //수정
   private SalaryOp so;

   //생성자
   public PersonInfo() {//빈
      
   }
   
   public PersonInfo(String n, int b, int c, String ad, int an, String pw) {//전체
      name = n;
      birthday = b;
      call = c;
      address = ad;
      accountNum = an;
      password = pw;
      so = new SalaryOp();
   }
   
   
   
   //get추가함
   public String getName() {
      return name;
   }
   public int getBirthday() {
      return birthday;
   }
   public int getCall() {
      return call;
   }
   public String getAddress() {
      return address;
   }
   public int getAccountNum() {
      return accountNum;
   }
   public String getPassword() {
      return password;
   }
   
   
   
   //set추가함
   public void setName(String n) {
      this.name=n;
   }
   public void setBirthday(int b) {
      this.birthday = b;
   }
   public void setCall(int c) {
      this.call = c;
   }
   public void setAddress(String ad) {
      this.address = ad;
   }
   public void setAccountNum(int an) {
      this.accountNum = an;
   }
   public void setPassword(String pw) {
      this.password = pw;
   }
}