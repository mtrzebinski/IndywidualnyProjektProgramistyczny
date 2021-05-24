package com.example.projekt_mobilny;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class NowyElem extends AppCompatActivity {
    EditText nazwa;
    Spinner myspinner;
    EditText sklad;
    EditText opisy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowy_elem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nazwa = (EditText) findViewById(R.id.nowa_nazwa);
        myspinner = (Spinner) findViewById(R.id.spinner2);


        ArrayAdapter<String> lista = new ArrayAdapter<String>(NowyElem.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.nazwy_z_lity));
        lista.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(lista);
        sklad = (EditText) findViewById(R.id.sklady);
        opisy = (EditText) findViewById(R.id.opis);

    }

    public void DodajNowe(View view){
        final String nazw = nazwa.getText().toString();
        final String kategorie = myspinner.getSelectedItem().toString();
        final String sklady = sklad.getText().toString();
        final String opis = opisy.getText().toString();
        background3 bg3 = new background3(NowyElem.this);
        bg3.execute(nazw, kategorie, sklady, opis);

    }

  /*  public void Back(View view){
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

   */
}