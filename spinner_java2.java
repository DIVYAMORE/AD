package com.example.expt4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     Intent intent =getIntent();
     Bundle extras = intent.getExtras();

        textView = findViewById(R.id.textView2);
        textView.setText(extras.getString("SUB")+"\n\n"+ extras.getString("Gender"));

    }
}