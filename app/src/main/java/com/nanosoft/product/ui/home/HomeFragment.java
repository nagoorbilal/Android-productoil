package com.nanosoft.product.ui.home;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.github.clans.fab.FloatingActionButton;
import com.nanosoft.product.MainActivity;
import com.nanosoft.product.R;
import com.nanosoft.product.SalesdetailsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {

    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Set title bar


        //setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        floatingActionButton = root.findViewById(R.id.fab_employee);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent got = new Intent(getActivity(), SalesdetailsActivity.class);
                startActivity(got);
                getActivity().finish();
            }
        });

        return root;
    }





}