public class Registration {
    private String transactionNo;
    private String supplier;
    private int p_category;
    private date transactionDate;
    private String remarks;

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getP_category() {
        return p_category;
    }

    public void setP_category(int p_category) {
        this.p_category = p_category;
    }

    public date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Registration(String transactionNo, String supplier, int p_category, date transactionDate, String remarks) {
        this.transactionNo = transactionNo;
        this.supplier = supplier;
        this.p_category = p_category;
        this.transactionDate = transactionDate;
        this.remarks = remarks;
    }

    public Registration() {
    }
}
