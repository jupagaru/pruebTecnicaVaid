package com.valid.jpgarcia.topartists.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.valid.jpgarcia.topartists.R;

public class MainActivity extends AppCompatActivity {

    Button btnTopArtists;
    Button btnTopTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView(){
        btnTopArtists = findViewById(R.id.btn_top_artists);
        btnTopArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TopArtistsActivity.class));
            }
        });

        btnTopTracks = findViewById(R.id.btn_top_tracks);
        btnTopTracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TopTracksActivity.class));
            }
        });
    }
}
