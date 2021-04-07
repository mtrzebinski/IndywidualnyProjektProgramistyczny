package com.example.projekt_mobilny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity {
    EditText nazwa_p; 
    Spinner mySpinner; 
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nazwa_p = (EditText) findViewById(R.id.nazwa);
        mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> lista = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.nazwy_z_lity));
        lista.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(lista);
    }


    public void searchBtn(View view) {
        final String nazwa= nazwa_p.getText().toString();
        final String kategorie = mySpinner.getSelectedItem().toString();

    }

}