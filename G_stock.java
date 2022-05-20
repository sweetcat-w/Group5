package pojo;

public class G_stock {
	private String g_name;//商品名称
	private String g_barCode;//商品条形码
	private int g_shelfLife;//保质期
	private String g_type;//商品类型
	private int s_num;//库存数量
	private String g_nuit;//单位
	private int g_lsexpired;//是否过期
	
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_barCode() {
		return g_barCode;
	}
	public void setG_barCode(String g_barCode) {
		this.g_barCode = g_barCode;
	}
	public int getG_shelfLife() {
		return g_shelfLife;
	}
	public void setG_shelfLife(int g_shelfLife) {
		this.g_shelfLife = g_shelfLife;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public String getG_nuit() {
		return g_nuit;
	}
	public void setG_nuit(String g_nuit) {
		this.g_nuit = g_nuit;
	}
	public int getG_lsexpired() {
		return g_lsexpired;
	}
	public void setG_lsexpired(int g_lsexpired) {
		this.g_lsexpired = g_lsexpired;
	}
//无参构造方法
	public G_stock() {
		super();
	}
//	有参构造方法
	public G_stock(String g_name, String g_barCode, int g_shelfLife, String g_type, int s_num, String g_nuit,
			int g_lsexpired) {
		super();
		this.g_name = g_name;
		this.g_barCode = g_barCode;
		this.g_shelfLife = g_shelfLife;
		this.g_type = g_type;
		this.s_num = s_num;
		this.g_nuit = g_nuit;
		this.g_lsexpired = g_lsexpired;
	}

}
