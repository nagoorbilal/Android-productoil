package com.nanosoft.product.localdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "products_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(CustomerDetails.CREATE_TABLE);
      //  db.execSQL(OrderDetails.CREATE_TABLE);
        db.execSQL(StackDetails.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + CustomerDetails.TABLE_NAME);
      //  db.execSQL("DROP TABLE IF EXISTS " + OrderDetails.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + StackDetails.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public long insertData(String invoiceno, String customername, String beat, String address, String salesdate,
                           String telephone, String closingbal) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(CustomerDetails.Invoice_No, invoiceno);
        values.put(CustomerDetails.Customer_Name, customername);
        values.put(CustomerDetails.Beat_, beat);
        values.put(CustomerDetails.Address_, address);
        values.put(CustomerDetails.Sales_Date, salesdate);
        values.put(CustomerDetails.TelePhone, telephone);
        values.put(CustomerDetails.Closing_Bal, closingbal);


        // insert row
        long id = db.insert(CustomerDetails.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertOrderDetailsData() {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them

        // insert row
        long id = db.insert(OrderDetails.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertStackDetailsData() {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them

        values.put(StackDetails.Item_Code,"BBB");
        values.put(StackDetails.Item_Name,"Argan oil");

        // insert row
        long id = db.insert(StackDetails.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public CustomerDetails getCustomerDetails(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(CustomerDetails.TABLE_NAME,
                new String[]{CustomerDetails.IDPK, CustomerDetails.Customer_Name, CustomerDetails.Timestamp},
                CustomerDetails.IDPK + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        CustomerDetails note = new CustomerDetails(
                cursor.getInt(cursor.getColumnIndex(CustomerDetails.IDPK)),
                cursor.getInt(cursor.getColumnIndex(CustomerDetails.Invoice_No)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Customer_Name)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Beat_)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Address_)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.TelePhone)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Closing_Bal)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Sales_Date)),
                cursor.getString(cursor.getColumnIndex(CustomerDetails.Timestamp)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<CustomerDetails> getAllCustomerDetails() {
        List<CustomerDetails> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CustomerDetails.TABLE_NAME + " ORDER BY " +
                CustomerDetails.Timestamp + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CustomerDetails note = new CustomerDetails();
                note.setCusIDPK(cursor.getInt(cursor.getColumnIndex(CustomerDetails.IDPK)));
                note.setCustomerName(cursor.getString(cursor.getColumnIndex(CustomerDetails.Customer_Name)));
                note.setBeat(cursor.getString(cursor.getColumnIndex(CustomerDetails.Beat_)));
                note.setAddress(cursor.getString(cursor.getColumnIndex(CustomerDetails.Address_)));
                note.setClosingBal(cursor.getString(cursor.getColumnIndex(CustomerDetails.Closing_Bal)));
                note.setTelephone(cursor.getString(cursor.getColumnIndex(CustomerDetails.TelePhone)));
                note.setSalesDate(cursor.getString(cursor.getColumnIndex(CustomerDetails.Sales_Date)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(CustomerDetails.Timestamp)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getCustomerDetailsCount() {
        String countQuery = "SELECT  * FROM " + CustomerDetails.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(CustomerDetails customerDetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CustomerDetails.Customer_Name, customerDetails.getCustomerName());

        // updating row
        return db.update(CustomerDetails.TABLE_NAME, values, CustomerDetails.IDPK + " = ?",
                new String[]{String.valueOf(customerDetails.getCusIDPK())});
    }
    public void deleteNote(CustomerDetails customerDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CustomerDetails.TABLE_NAME, CustomerDetails.IDPK + " = ?",
                new String[]{String.valueOf(customerDetails.getCusIDPK())});
        db.close();
    }



    public Cursor Select_getSp_Itemcode() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "select "+StackDetails.IDPK+","+StackDetails.Item_Code+","+StackDetails.Item_Name+" from "+StackDetails.TABLE_NAME;
        return db.rawQuery(query, null);

    }

    public String[] getSpinnerSelect() {


        String query = "select "+StackDetails.IDPK+","+StackDetails.Item_Code+","+StackDetails.Item_Name+" from "+StackDetails.TABLE_NAME;

        Log.i("query",query.toString());

        Cursor cursor = getReadableDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        ArrayList<String> names = new ArrayList<String>();
        while (!cursor.isAfterLast()) {

            names.add(cursor.getString(cursor.getColumnIndex(StackDetails.Item_Code)));
            cursor.moveToNext();
            Log.i("names",names.toString());
        }
        cursor.close();
        return names.toArray(new String[names.size()]);
    }


    public Cursor getOrderDetailId(String leavetype) {
        SQLiteDatabase db = getReadableDatabase();
        String query = " select * from "+ StackDetails.TABLE_NAME+" "+"where"+" "+ StackDetails.Item_Code +" = '" + leavetype + "' ";
        return db.rawQuery(query, null);
    }




}
