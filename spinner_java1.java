package com.example.expt4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Spinner spin;
Button btn;
TextView textView;
RadioGroup radioGroup;
CheckBox HighSchool,Bachelor,Master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        spin = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radiogroup);
        HighSchool = findViewById(R.id.checkBox);
        Bachelor = findViewById(R.id.checkBox2);
        Master = findViewById(R.id.checkBox3);
        Intent intent = new Intent(this, MainActivity2.class);
        Bundle extras = new Bundle();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subjects = spin.getSelectedItem().toString();

              extras.putString("SUB",subjects);
              intent.putExtras(extras);
                startActivity(intent);

            }

        });
        Bachelor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    // Do your coding
                    Toast.makeText(MainActivity.this, "Bachelor's Degree", Toast.LENGTH_LONG).show();
                }
                else{
                    // Do your coding
                }
            }
        });
        HighSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    // Do your coding
                    Toast.makeText(MainActivity.this, "High School", Toast.LENGTH_LONG).show();
                }
                else{
                    // Do your coding
                }
            }
        });
        Master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    // Do your coding
                    Toast.makeText(MainActivity.this, "Master's Degree", Toast.LENGTH_LONG).show();

                }
                else{
                    // Do your coding
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selid = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selid);
                String gender = radioButton.getText().toString();
                extras.putString("Gender",gender);
                intent.putExtras(extras);


            }
        });
    }






}