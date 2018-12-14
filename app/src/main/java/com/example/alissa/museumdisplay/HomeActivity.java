package com.example.alissa.museumdisplay;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button secret = findViewById(R.id.secretButton);
        Button submit = findViewById(R.id.submitHome);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ExhibitActivity.class);
                startActivity(i);
            }
        });

        // Der versteckte Button soll der einzige Weg sein, zurück zur vorherigen Activity zu kommen
        // Dies soll nur nach Eingabe eines Passworts funktionieren
        secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Erstellen eines Dialogs zur Passwort-Abfrage
                AlertDialog.Builder alert = new AlertDialog.Builder(new ContextThemeWrapper(HomeActivity.this, R.style.AlertTheme));
                final LayoutInflater inflater = HomeActivity.this.getLayoutInflater();
                alert.setTitle("Passwort plox");
                final View vieww = inflater.inflate(R.layout.password_dialog, null);
                alert.setView(vieww);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edit = vieww.findViewById(R.id.passwordInput);
                        String passwordinput = edit.getText().toString();
                        if(checkPassword(passwordinput)) {
                            Intent ii = new Intent(HomeActivity.this, MainActivity.class);
                            startActivity(ii);
                        }
                        else{
                            dialogInterface.cancel();
                            Toast.makeText(getApplicationContext(), passwordinput, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });


    }
    @Override
    public void onBackPressed() {
        //nothing
    }


    // Compares password with input
    public boolean checkPassword(String input){
        if (input.equals("09052009")) return true;
        else return false;
    }
}
