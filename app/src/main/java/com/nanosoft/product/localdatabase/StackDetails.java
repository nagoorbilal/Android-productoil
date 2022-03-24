package com.nanosoft.product.localdatabase;

public class StackDetails {

    public static final String TABLE_NAME = "StackDetails";
    public static final String IDPK = "StackIDPK";
    public static final String Item_Code = "Itemcode";
    public static final String Item_Name = "ItemName";
    public static final String UOM_ = "Uom";
    public static final String Rate_ = "Rate";
    public static final String Discount_ = "Discount";
    public static final String DIS_Price = "Disprice";
    public static final String Amount_ = "Amount";
    public static final String Timestamp_ = "Timestamp";


    private int Itemcode;
    private String ItemName;
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
                    + UOM_ + " TEXT,"
                    + Rate_ + " TEXT,"
                    + Discount_ + " TEXT,"
                    + DIS_Price + " TEXT,"
                    + Amount_ + " TEXT,"
                    + Timestamp_ + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";



    public StackDetails() {
    }


    public StackDetails(int itemcode, String itemName, String uom, String rate, String discount,
                        String disprice, String amount, String timestamp) {
        Itemcode = itemcode;
        ItemName = itemName;
        Uom = uom;
        Rate = rate;
        Discount = discount;
        Disprice = disprice;
        Amount = amount;
        Timestamp = timestamp;
    }


    public int getItemcode() {
        return Itemcode;
    }

    public void setItemcode(int itemcode) {
        Itemcode = itemcode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
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
