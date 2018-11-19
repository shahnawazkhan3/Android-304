package com.zaaviyah.etech_one;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

    EditText etEamil;
    Button b1Send;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etEamil = (EditText)findViewById(R.id.etSendEmAIL);
        b1Send = (Button) findViewById(R.id.btEmailSend);
        tv = (TextView) findViewById(R.id.tv);

        b1Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEmail ();
            }
        });
    }

    private void sendEmail() {

        Log.d("yes" ,"yes");

        String [] TO = {" "};
        String [] CC = {" "};

        Intent emailIntent = new Intent( Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("MailTo"));

        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"xyz");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"are u here");
        emailIntent.putExtra(Intent.EXTRA_CC,CC);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);

        try {

         startActivity(Intent.createChooser(emailIntent,"sending"));
            Log.d("send" ,"send");
            Toast.makeText(getApplicationContext()," send", Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"not send", Toast.LENGTH_SHORT).show();
        }
    }
}
