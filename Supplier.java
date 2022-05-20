package shangyi;

public class Supplier {
	private String creditCode;	//统一社会信用代码
	private String s_name;	//供应商姓名
	private	String s_type;	//供应商状态
	private String s_liaisoner;	//联系人
	private	String liaisonPhone;	//联系电话
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public String getS_liaisoner() {
		return s_liaisoner;
	}
	public void setS_liaisoner(String s_liaisoner) {
		this.s_liaisoner = s_liaisoner;
	}
	public String getLiaisonPhone() {
		return liaisonPhone;
	}
	public void setLiaisonPhone(String liaisonPhone) {
		this.liaisonPhone = liaisonPhone;
	}
	public supplier(String creditCode, String s_name, String s_type, String s_liaisoner, String liaisonPhone) {
		super();
		this.creditCode = creditCode;
		this.s_name = s_name;
		this.s_type = s_type;
		this.s_liaisoner = s_liaisoner;
		this.liaisonPhone = liaisonPhone;
	}
	public supplier() {}
	
}
