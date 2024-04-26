package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DBhelper;

public class MainActivity extends AppCompatActivity {
    EditText user,pass,repass;
    Button btn;

    DBhelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        db = new DBhelper(this);
        user = findViewById(R.id.editTextText);
        pass = findViewById(R.id.editTextText2);
        repass = findViewById(R.id.editTextText3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();


                if(password.equals(repassword))
                {
                    Boolean checkuser = db.checkUserName(username);
                    if(checkuser == false)
                    {
                        Boolean insert =  db.insertdata(username,password);
                        if (insert == true)
                        {
                            Toast.makeText(MainActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Registration Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Username already exits",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Password do not match",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
