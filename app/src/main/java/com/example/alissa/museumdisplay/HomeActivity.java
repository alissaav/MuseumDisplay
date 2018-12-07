package com.example.alissa.museumdisplay;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button secret = findViewById(R.id.secretButton);
        secret.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                Intent i = new Intent (HomeActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
    public void exit(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Passwort plox");
        //Push Test111
    }
}
