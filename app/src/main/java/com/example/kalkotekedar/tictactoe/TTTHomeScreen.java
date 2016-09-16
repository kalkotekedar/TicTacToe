package com.example.kalkotekedar.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TTTHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttthome_screen);
    }

    public void startSinglePlayer(View view) {
        startActivity(new Intent(getApplicationContext(), TTTOnePlayer.class));
    }

    public void startTwoPlayer(View view) {
        startActivity(new Intent(getApplicationContext(), TTTTwoPlayer.class));
    }
}