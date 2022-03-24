package com.nanosoft.product.localdatabase;

public class OrderDetails {

    public static final String TABLE_NAME = "OrderDetails";
    public static final String IDPK = "OrderIDPK";
    public static final String Invoice_No = "Invoiceno";
    public static final String Item_Code = "ItemCode";
    public static final String Item_Name = "ItemName";
    public static final String Quantity_ = "Quantity";
    public static final String UOM_ = "Uom";
    public static final String Rate_ = "Rate";
    public static final String Discount_ = "Discount";
    public static final String DIS_Price = "Disprice";
    public static final String Amount_ = "Amount";
    public static final String Timestamp_ = "Timestamp";

    private int OrderIDPK;
    private int Invoiceno;
    private String ItemCode;
    private String ItemName;
    private String Quantity;
    private String Uom;
    private String Rate;
    private String Discount;
    private String Disprice;
    private String Amount;
    private String Timestamp;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + IDPK + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + Item_Code + " TEXT,"
                    + Item_Name + " TEXT,"
                    + Quantity_ + " TEXT,"
                    + UOM_ + " TEXT,"
                    + Rate_ + " TEXT,"
                    + Discount_ + " TEXT,"
                    + DIS_Price + " TEXT,"
                    + Amount_ + " TEXT,"
                    + Timestamp_ + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    public OrderDetails() {
    }

    public OrderDetails(int orderIDPK, String itemCode, String itemName, String quantity, String uom,
                        String rate, String discount, String disprice, String amount, String timestamp) {
        OrderIDPK = orderIDPK;
        ItemCode = itemCode;
        ItemName = itemName;
        Quantity = quantity;
        Uom = uom;
        Rate = rate;
        Discount = discount;
        Disprice = disprice;
        Amount = amount;
        Timestamp = timestamp;
    }

    public int getInvoiceno() {
        return Invoiceno;
    }

    public void setInvoiceno(int invoiceno) {
        Invoiceno = invoiceno;
    }

    public int getOrderIDPK() {
        return OrderIDPK;
    }

    public void setOrderIDPK(int orderIDPK) {
        OrderIDPK = orderIDPK;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getUom() {
        return Uom;
    }

    public void setUom(String uom) {
        Uom = uom;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getDisprice() {
        return Disprice;
    }

    public void setDisprice(String disprice) {
        Disprice = disprice;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }


}
