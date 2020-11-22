package supermarket.entity;

public class Customer {
    private int id; // The employee ID
    private String userName; // The name of the employee
    private String mobileNo;
    private String mailId;

    public Customer() {

    }
    public Customer(int id, String userName, String mobileNo, String mailId) {
        this.id = id;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.mailId = mailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}
