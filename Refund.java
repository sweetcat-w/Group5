public class Refund {
    private String g_name;  //商品名称
    private String g_barCode; //商品条形码
    private String g_specifications;//规格
    private String transactionNo; //交易单号
    private String g_manufactureDate; //生产日期
    private int r_num;//退货数量
    private String g_unit;//单位
    private String r_date;//退货日期

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

    public String getG_specifications() {
        return g_specifications;
    }

    public void setG_specifications(String g_specifications) {
        this.g_specifications = g_specifications;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getG_manufactureDate() {
        return g_manufactureDate;
    }

    public void setG_manufactureDate(String g_manufactureDate) {
        this.g_manufactureDate = g_manufactureDate;
    }

    public int getR_num() {
        return r_num;
    }

    public void setR_num(int r_num) {
        this.r_num = r_num;
    }

    public String getG_unit() {
        return g_unit;
    }

    public void setG_unit(String g_unit) {
        this.g_unit = g_unit;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public Refund(String g_name, String g_barCode, String g_specifications, String transactionNo, String g_manufactureDate, int r_num, String g_unit, String r_date) {
        this.g_name = g_name;
        this.g_barCode = g_barCode;
        this.g_specifications = g_specifications;
        this.transactionNo = transactionNo;
        this.g_manufactureDate = g_manufactureDate;
        this.r_num = r_num;
        this.g_unit = g_unit;
        this.r_date = r_date;
    }

    public Refund() {
    }
}
