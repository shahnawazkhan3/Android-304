package com.zaaviyah.etech_304;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    Button b1add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1add=(Button)findViewById(R.id.btSend);
        etEmail=(EditText)findViewById(R.id.etEmail);

       b1add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               sendindEmail();
           }
       });

    }

    private void sendindEmail() {

       Log.d("YES","SEND");

       String []CC  ={"  "};
       String[] TO ={" "};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailTo"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailIntent.putExtra(Intent.EXTRA_CC,CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"THIS APP");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"i am sending");


        try {
            startActivity(Intent.createChooser(emailIntent,"sending"));
            finish();
            Log.d("yes","sending");

        }catch (Exception e){
            e.printStackTrace();

            Toast.makeText(this, "sending fails", Toast.LENGTH_SHORT).show();
        }


    }
}
