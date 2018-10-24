package com.zaaviyah.etech_304_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1login, b2call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1login=(Button) findViewById(R.id.btLOGIN);
        b2call =(Button)findViewById(R.id.btCall);

        b1login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "yes login",Toast.LENGTH_SHORT).show();

                Intent loginintent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginintent);
            }
        });

        b2call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CALL",Toast.LENGTH_SHORT).show();

                Intent callINTENT = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0343555"));
                startActivity(callINTENT);
            }
        });
    }
}
