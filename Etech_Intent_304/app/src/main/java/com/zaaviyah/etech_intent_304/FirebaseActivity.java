package com.zaaviyah.etech_intent_304;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {

    Button b1DDartis,b2Register ,b3forgetpass;
    EditText etATISname;
    Spinner spGeneric;

    private FirebaseAuth auth;

    DatabaseReference databaseArtists;
    ListView listViewArtist;

    //a list to store all the artist from firebase database
    List<Artist> artists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        etATISname= (EditText)findViewById(R.id.etArtisName);
        b1DDartis =(Button) findViewById(R.id.btArtistADD);
        spGeneric=(Spinner) findViewById(R.id.spArtisrGenres);

        listViewArtist=(ListView)findViewById(R.id.listViewArtist);

        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");



        //list to store artists
        artists = new ArrayList<>();

        b1DDartis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this method is actually performing the write operation
                addArtist();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //====================1ST DECLEAR====================

                ////a list to store all the artist from firebase database
                //    List<Artist> artists;

                //list to store artists
               // artists = new ArrayList<>();


                ///=========================/////==================
                //clearing the previous artist list

                artists.clear();
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artist artist = postSnapshot.getValue(Artist.class);
                    //adding artist to the list
                    artists.add(artist);
                }

                //creating adapter
                ArtistList artistAdapter = new ArtistList(FirebaseActivity.this, artists);
                //attaching adapter to the listview
                listViewArtist.setAdapter(artistAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addArtist() {

        String name = etATISname.getText().toString().trim();
        String genre = spGeneric.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Artist artist = new Artist(id,name,genre);

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
