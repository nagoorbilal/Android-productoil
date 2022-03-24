package com.nanosoft.product;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nanosoft.product.localdatabase.DatabaseHelper;
import com.nanosoft.product.ui.gallery.GalleryFragment;
import com.nanosoft.product.ui.home.HomeFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SalesdetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseHelper db;
    CardView cardView1;
    TextView tv_invoice_no,tv_sales_date;
    EditText et_customer_name ,et_beat ,et_telephone ,et_closing_bal ,et_address;
    DatePickerDialog datePickerDialog;
    int mYear, mMonth, mDay;
    private static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_salesdetails);

        fragmentManager = getSupportFragmentManager();//Get Fragment Manager

        db = new DatabaseHelper(this);
        onfindViewbyID();



        cardView1.setOnClickListener(this);

        onLoadData();


    }

    private void onfindViewbyID() {

        cardView1 = (CardView) findViewById(R.id.cv_sales_date);
        tv_invoice_no = (TextView) findViewById(R.id.tv_invoice_no);
        tv_sales_date = (TextView) findViewById(R.id.tv_sales_date);
        et_customer_name = (EditText) findViewById(R.id.et_customer_name);
        et_address = (EditText) findViewById(R.id.et_address);
        et_beat = (EditText) findViewById(R.id.et_beat);
        et_closing_bal = (EditText) findViewById(R.id.et_closing_bal);
        et_telephone = (EditText) findViewById(R.id.et_telephone);


    }

    private void onLoadData() {

        tv_sales_date.setText(getDateTime());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv_sales_date:

                DateClickEvent();

                break;

        }
    }
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public boolean onSupportNavigateUp() {

            Intent got = new Intent(SalesdetailsActivity.this, MainActivity.class);
            startActivity(got);
            finish();

        return true;
    }

    @Override
    public void onBackPressed() {

        Intent got = new Intent(SalesdetailsActivity.this, MainActivity.class);
        startActivity(got);
        finish();
        //super.onBackPressed();
    }

    private void DateClickEvent() {
        try {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            datePickerDialog = new DatePickerDialog(SalesdetailsActivity.this,  R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    Calendar date1 = Calendar.getInstance();
                    date1.set(Calendar.YEAR, year);
                    date1.set(Calendar.MONTH, monthOfYear);
                    date1.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    tv_sales_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);


                }


            }, mYear, mMonth, mDay);
            c.add(Calendar.MONTH, +1);
            long oneMonthAhead = c.getTimeInMillis();
//            datePickerDialog.getDatePicker().setFirstDayOfWeek(Calendar.SATURDAY);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.getDatePicker().setMaxDate(oneMonthAhead);
            datePickerDialog.show();

        } catch (Exception e) {


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.action_submit){

            String invoiceno =  tv_invoice_no.getText().toString();
            String customername =  et_customer_name.getText().toString();
            String beat =  et_beat.getText().toString();
            String address =  et_address.getText().toString();
            String closingbal =  et_closing_bal.getText().toString();
            String salesdate =  tv_sales_date.getText().toString();
            String telephone =  et_telephone.getText().toString();



            //long id = db.insertData(invoiceno,customername,beat,address,closingbal,salesdate,salesdate);



           // Toast.makeText(this, "Success"+id, Toast.LENGTH_LONG).show();

//            Log.i(""+id,"invoiceno"+invoiceno
//                    +"customername"+customername+"beat"+beat+"address"+address
//                    +"closingbal"+closingbal+"salesdate"+salesdate+"telephone"+ telephone.toString());

            Intent got = new Intent(SalesdetailsActivity.this, OrderdetailsActivity.class);
            startActivity(got);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}
