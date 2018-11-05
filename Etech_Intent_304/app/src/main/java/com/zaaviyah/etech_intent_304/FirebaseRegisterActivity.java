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

public class FirebaseRegisterActivity extends AppCompatActivity {


    Button b1LOGIN,b2Register;
    EditText etEMAIL, Etpass;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_register);



        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        etEMAIL=(EditText) findViewById(R.id.etFireREGemail);
        Etpass=(EditText) findViewById(R.id.etFireREGPass);

        b2Register =(Button)findViewById(R.id.btFireREGregister);


        b2Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = etEMAIL.getText().toString();
                String password = Etpass.getText().toString();

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(FirebaseRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(FirebaseRegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(FirebaseRegisterActivity.this, "fail REGISTER" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(FirebaseRegisterActivity.this, HomeActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });

    }
}
