package com.nanosoft.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.nanosoft.product.localdatabase.DatabaseHelper;
import com.nanosoft.product.localdatabase.StackDetails;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;
import com.travijuu.numberpicker.library.Listener.DefaultValueChangedListener;
import com.travijuu.numberpicker.library.NumberPicker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderdetailsActivity extends AppCompatActivity implements View.OnClickListener, ValueChangedListener {

    private DatabaseHelper db;
    SearchableSpinner sp_itemcode;
    TextView tv_invoice_no, tv_itemname, tv_uom, tv_rate, tv_discount, tv_disprice, tv_amount;
    Button bt_submit;
    NumberPicker quantity_picker;
    CardView cv_itemcode, cv_check_listner;

    String itemCode = "";
    String itemName = "", uom = "", rate = "", discount = "", disPrice = "", amount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_orderdetails);

        db = new DatabaseHelper(this);
        onFindViewById();

        //   Spinnerviewlist();

        quantity_picker.setValueChangedListener(this);

    }


    private void onFindViewById() {

        sp_itemcode = (SearchableSpinner) findViewById(R.id.sp_itemcode);
        tv_invoice_no = (TextView) findViewById(R.id.tv_invoice_no);
        tv_itemname = (TextView) findViewById(R.id.tv_itemname);
        tv_uom = (TextView) findViewById(R.id.tv_uom);
        tv_rate = (TextView) findViewById(R.id.tv_rate);
        tv_discount = (TextView) findViewById(R.id.tv_discount);
        tv_disprice = (TextView) findViewById(R.id.tv_disprice);
        tv_amount = (TextView) findViewById(R.id.tv_amount);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        quantity_picker = (NumberPicker) findViewById(R.id.number_picker_default);

        cv_itemcode = (CardView) findViewById(R.id.cv_itemcode);
        cv_check_listner = (CardView) findViewById(R.id.cv_check_listner);
        quantity_picker.setMax(15);
        quantity_picker.setMin(1);
        quantity_picker.setUnit(2);

        bt_submit.setOnClickListener(this);

        cv_check_listner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "Checking the click evenr", Toast.LENGTH_LONG).show();
            }
        });

        cv_itemcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "cardview", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {

        Intent got = new Intent(OrderdetailsActivity.this, SalesdetailsActivity.class);
        startActivity(got);
        finish();


        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

//            case R.id.cv_itemcode:
//
//                ItemCodeClickEvent();
//
//                break;

            case R.id.bt_submit:

                ToSubmitClickEvent();

                break;

        }


    }

    private void ItemCodeClickEvent() {

        Spinnerviewlist();
    }

    private void ToSubmitClickEvent() {


        String invoice = tv_invoice_no.getText().toString();
        //String itemcode = sp_itemcode.getText().toString();
        String itemname = tv_itemname.getText().toString();
        int quantity = quantity_picker.getValue();
        String uom = tv_uom.getText().toString();
        String rate = tv_rate.getText().toString();
        String discount = tv_discount.getText().toString();
        String disprice = tv_disprice.getText().toString();
        String amount = tv_amount.getText().toString();


        Log.i("Orderdetails", invoice + " " + itemname + " " + quantity + " " + uom + " " + rate + " " + discount + " " + disprice + " " +
                amount.toString());
    }

    @Override
    public void valueChanged(int value, ActionEnum action) {

        Toast.makeText(this, value + " ",
                Toast.LENGTH_LONG).show();
    }

    private void Spinnerviewlist() {

        try {

            //  Cursor c = db.Select_getSp_Itemcode();

            String[] itemdata = db.getSpinnerSelect();

            Log.i("getSpinnerSelect", itemdata.toString());

            ArrayAdapter<String> list = new ArrayAdapter<String>(OrderdetailsActivity.this, android.R.layout.simple_spinner_item, itemdata);
            list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp_itemcode.setTitle("Select Item Code");
            sp_itemcode.setAdapter(list);

            sp_itemcode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                    itemCode = sp_itemcode.getSelectedItem().toString();

                    doItemCodeTYPE(itemCode);

                    Log.i("itemCode", itemCode.toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }

            });

        } catch (Exception e) {
            Log.i("Spinnererror", e.toString());
        }

    }

    private void doItemCodeTYPE(String leavetype) {


        Cursor cus = db.getOrderDetailId(leavetype);

        if (cus.moveToFirst()) {

            do {


                itemName = cus.getString(cus.getColumnIndex(StackDetails.Item_Name));
                uom = cus.getString(cus.getColumnIndex(StackDetails.UOM_));
                rate = cus.getString(cus.getColumnIndex(StackDetails.Rate_));
                discount = cus.getString(cus.getColumnIndex(StackDetails.Discount_));
                disPrice = cus.getString(cus.getColumnIndex(StackDetails.DIS_Price));
                amount = cus.getString(cus.getColumnIndex(StackDetails.Amount_));


                Log.i("LeaveID", itemName.toString());

            } while (cus.moveToNext());
            cus.close();
        }

        if (!itemName.isEmpty()) {

            tv_itemname.setText(itemName);
            tv_uom.setText(uom);
            tv_rate.setText(rate);
            tv_discount.setText(discount);
            tv_disprice.setText(disPrice);
            tv_amount.setText(amount);
        }

    }


}
