package com.nanosoft.product.localdatabase;

public class CustomerDetails {

    public static final String TABLE_NAME = "CustomerDetails";
    public static final String IDPK = "CusIDPK";
    public static final String Invoice_No = "InvoiceNo";
    public static final String Customer_Name = "CustomerName";
    public static final String Beat_ = "Beat";
    public static final String Closing_Bal = "ClosingBal";
    public static final String Address_ = "Address";
    public static final String TelePhone = "Telephone";
    public static final String Sales_Date = "SalesDate";
    public static final String Timestamp = "Timestamp";

    private int CusIDPK;
    private int InvoiceNo;
    private String CustomerName;
    private String Beat;
    private String ClosingBal;
    private String Address;
    private String Telephone;
    private String SalesDate;
    private String timestamp;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + IDPK + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + Invoice_No + " INTEGER,"
                    + Customer_Name + " TEXT,"
                    + Beat_ + " TEXT,"
                    + Closing_Bal + " TEXT,"
                    + Address_ + " TEXT,"
                    + TelePhone + " TEXT,"
                    + Sales_Date + " TEXT,"
                    + Timestamp + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    public CustomerDetails() {
    }

    public CustomerDetails(int cusIDPK, int invoiceNo, String customerName, String beat, String closingBal,
                           String address, String telephone, String salesDate, String timestamp) {
        CusIDPK = cusIDPK;
        InvoiceNo = invoiceNo;
        CustomerName = customerName;
        Beat = beat;
        ClosingBal = closingBal;
        Address = address;
        Telephone = telephone;
        SalesDate = salesDate;
        this.timestamp = timestamp;
    }

    public int getCusIDPK() {
        return CusIDPK;
    }

    public void setCusIDPK(int cusIDPK) {
        CusIDPK = cusIDPK;
    }

    public int getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getBeat() {
        return Beat;
    }

    public void setBeat(String beat) {
        Beat = beat;
    }

    public String getClosingBal() {
        return ClosingBal;
    }

    public void setClosingBal(String closingBal) {
        ClosingBal = closingBal;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getSalesDate() {
        return SalesDate;
    }

    public void setSalesDate(String salesDate) {
        SalesDate = salesDate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
