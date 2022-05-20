package java6732.lesson13;

import java.util.Date;

/**
 * @Time : 2022/05/20 21:58
 * @Author : 212106732田薇
 * @software : IntelliJ IDEA
 */
public class details {
    private String transactionNo;   //交易单号
    private String suppler; //供货商
    private Date transactionDate;   //交易日期
    private String g_name;  //商品名称
    private String g_barCode;   //商品条形码
    private Date g_manufactureDate; //生产日期
    private int g_num;  //数量
    private String g_specification; //规格
    private String g_unit;  //单位
    private String g_type;  //商品类型
    private int g_shelfLife;    //保质期

    public details(){
        
    }

    public details(String transactionNo, String suppler, Date transactionDate, String g_name, String g_barCode, Date g_manufactureDate, int g_num, String g_specification, String g_unit, String g_type, int g_shelfLife) {
        this.transactionNo = transactionNo;
        this.suppler = suppler;
        this.transactionDate = transactionDate;
        this.g_name = g_name;
        this.g_barCode = g_barCode;
        this.g_manufactureDate = g_manufactureDate;
        this.g_num = g_num;
        this.g_specification = g_specification;
        this.g_unit = g_unit;
        this.g_type = g_type;
        this.g_shelfLife = g_shelfLife;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getSuppler() {
        return suppler;
    }

    public void setSuppler(String suppler) {
        this.suppler = suppler;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

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

    public Date getG_manufactureDate() {
        return g_manufactureDate;
    }

    public void setG_manufactureDate(Date g_manufactureDate) {
        this.g_manufactureDate = g_manufactureDate;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public String getG_specification() {
        return g_specification;
    }

    public void setG_specification(String g_specification) {
        this.g_specification = g_specification;
    }

    public String getG_unit() {
        return g_unit;
    }

    public void setG_unit(String g_unit) {
        this.g_unit = g_unit;
    }

    public String getG_type() {
        return g_type;
    }

    public void setG_type(String g_type) {
        this.g_type = g_type;
    }

    public int getG_shelfLife() {
        return g_shelfLife;
    }

    public void setG_shelfLife(int g_shelfLife) {
        this.g_shelfLife = g_shelfLife;
    }
}
