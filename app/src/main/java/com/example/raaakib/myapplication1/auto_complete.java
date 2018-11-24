package com.example.raaakib.myapplication1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class auto_complete extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Button pick_button;
    TextView set_picked;
    int day, month, year;
    int dayFinal, monthFinal, yearFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        String[] countries = getResources().getStringArray(R.array.countries);
        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteTextView editText2 = findViewById(R.id.actv2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_list_item, R.id.text_view_list_item, countries);
        editText.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.custom_list_item, R.id.text_view_list_item, countries);
        editText2.setAdapter(adapter2);

        pick_button = (Button) findViewById(R.id.pick_button);
        set_picked = (TextView) findViewById(R.id.set_picked);
        pick_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar. getInstance();
                year= c.get(Calendar.YEAR);
                day= c.get(Calendar.DAY_OF_MONTH);
                month= c.get(Calendar.MONTH);

                DatePickerDialog datePickerDialog =  new DatePickerDialog(auto_complete.this, auto_complete.this,year,month,day);
                datePickerDialog.show();
            }
        });
    }
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
        yearFinal= i;
        monthFinal = i1+1;
        dayFinal= i2;
        set_picked.setText(dayFinal+"/"+monthFinal+"/"+yearFinal);
    }
}
