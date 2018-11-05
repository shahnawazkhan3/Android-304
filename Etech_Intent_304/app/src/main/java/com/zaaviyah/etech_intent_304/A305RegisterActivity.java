package com.zaaviyah.etech_intent_304;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class A305RegisterActivity extends AppCompatActivity {


    Button b1BACK, b2REGSITER;
    EditText etEMAIL, etpasas;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a305_register);

        auth=FirebaseAuth.getInstance();

        b1BACK=(Button)findViewById(R.id.bt305_reg_back);
        b2REGSITER=(Button)findViewById(R.id.bt305_REGIS_REGIST);

        etEMAIL=(EditText)findViewById(R.id.et305_regis_email);
        etpasas=(EditText)findViewById(R.id.et305_REG_PASS);


        b2REGSITER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEMAIL.getText().toString();
                String pass = etpasas.getText().toString();

                auth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(A305RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(getApplicationContext(),"EMAIL PASS COMPLELET",Toast.LENGTH_SHORT).show();

                      if (task.isSuccessful()){

                          Intent homeACTIVITY = new Intent(A305RegisterActivity.this, HomeActivity.class);
                          startActivity(homeACTIVITY);
                      } else{
                          Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
                      }
                    }
                });


            }
        });


        b1BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homeACTIVITY = new Intent(A305RegisterActivity.this, A305_Activity.class);
                startActivity(homeACTIVITY);
                finish();
            }
        });


    }
}
