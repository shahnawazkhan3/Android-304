package com.zaaviyah.etech_intent_304;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1FIRE ,b2_305;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1FIRE= (Button )findViewById(R.id.btFireBaseData);
        b2_305=(Button)findViewById(R.id.bt_305);

       b1FIRE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent firebaseDATA = new Intent(MainActivity.this, FirebaseActivity.class);
               startActivity(firebaseDATA);
           }
       });


        b2_305.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent INTEN_305 = new Intent(MainActivity.this, A305_Activity.class);
                startActivity(INTEN_305);
            }
        });





    }
}
