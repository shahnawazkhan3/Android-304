package com.zaaviyah.etech_one;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  Button b1Blue, b2Green;
  ImageView img;

   Bitmap bmp;
   Bitmap operation ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1Blue =(Button)findViewById(R.id.btBlue);
        b2Green= (Button)findViewById(R.id.btGreen);

        img =(ImageView)findViewById(R.id.imageView);

        BitmapDrawable abmp = (BitmapDrawable)img.getDrawable();
        bmp=abmp.getBitmap();

    }
    public  void blue (View view){


     operation=Bitmap.createBitmap(bmp.getHeight(),bmp.getWidth(),bmp.getConfig());

        double red = 0.33;
        double green = 0.59;
        double blue = 0.11;

        for (int i = 0; i < bmp.getWidth(); i++) {
            for (int j = 0; j < bmp.getHeight(); j++) {

                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = (int) red * r;
                g = (int) green * g;
                b = (int) blue * b;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        img.setImageBitmap(operation);
    }
}
