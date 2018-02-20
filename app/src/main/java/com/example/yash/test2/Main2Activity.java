package com.example.yash.test2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUIViews();
        firebaseAuth=FirebaseAuth.getInstance();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String user_email= userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Main2Activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(Main2Activity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }

    private void setupUIViews() {
        userName= (EditText) findViewById(R.id.etUsername);
        userEmail=(EditText) findViewById(R.id.etUserEmail);
        userPassword=(EditText) findViewById(R.id.etPassword);
        userLogin= (TextView) findViewById(R.id.tvUserLogin);
        regButton=(Button) findViewById(R.id.btnRegister);

    }
    private Boolean validate(){
        Boolean result = false;
        String name = userName.getText().toString();
        String password =userPassword.getText().toString();
        String email= userEmail.getText().toString();
        if (name.isEmpty() || password.isEmpty() || email.isEmpty())
        {
            Toast.makeText(this,"Please Enter the missing details!",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;

        }
        return result;
    }
}
