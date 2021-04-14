package com.example.projekt_mobilny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class ListaElem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_elem);
        String zwrocone_dane = getIntent().getStringExtra("output");
        String nazwa_elem = getIntent().getStringExtra("nazwa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("INFO");

        if(nazwa_elem.isEmpty()) {
            alertDialog.setMessage("Error");
        } else {
            alertDialog.setMessage(zwrocone_dane);
        }

        alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                alertDialog.dismiss();
                startActivity(intent);
            }
        });
        alertDialog.show();

    }


}
