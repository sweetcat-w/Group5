package user;

public class User {
	private String id;
	private String userName;
	private String phoneNum;
	private String password;
	private boolean isAdmain;
	
	public User() {
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String id, String userName, String phoneNum, String password, boolean isAdmain) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.password = password;
		this.isAdmain = isAdmain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmain() {
		return isAdmain;
	}
	public void setAdmain(boolean isAdmain) {
		this.isAdmain = isAdmain;
	}
	
	
}
