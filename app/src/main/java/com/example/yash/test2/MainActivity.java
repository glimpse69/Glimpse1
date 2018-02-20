package com.example.yash.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button login;
    private TextView userRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= (EditText)findViewById(R.id.etUsername);
        Password= (EditText)findViewById(R.id.etPassword);
        login= (Button) findViewById(R.id.etButton);
        userRegistration=(TextView)findViewById(R.id.tvReg);
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
    private void validate(String userName, String userPassword)
    {
        if(((userName.equals("admin")) || (userName.equals("Admin")))  && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);

        }
        else{
            login.setEnabled(false);
        }
    }
}
