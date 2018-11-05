package com.zaaviyah.etech_fragment_304;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        Configuration confiq = getResources().getConfiguration();

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if(confiq.orientation==Configuration.ORIENTATION_LANDSCAPE){

            Lm_Frgments ls_frgments = new Lm_Frgments();
            fragmentTransaction.replace(android.R.id.content, ls_frgments);

        }else{

            Pm_Frgments ps_frgments = new Pm_Frgments();
            fragmentTransaction.replace(android.R.id.content, ps_frgments);
        }

        fragmentTransaction.commit();
    }
}
