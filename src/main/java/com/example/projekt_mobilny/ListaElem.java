package com.example.projekt_mobilny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaElem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_elem);
        String zwrocone_dane = getIntent().getStringExtra("output");
        String nazwa_elem = getIntent().getStringExtra("nazwa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if(nazwa_elem.isEmpty()) {
            final ArrayList<String> lista_elem = new ArrayList<String>();
            String elem= "";
            for(char i: zwrocone_dane.toCharArray()){
                if(i == '\n') {
                    lista_elem.add(elem);
                    elem = "";
                }
                elem += i;
            }

            final ListView listView = findViewById(R.id.listview);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista_elem);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String a = "";
                    if (i == 0) {
                        a = lista_elem.get(i).substring(2);
                    }
                    else {
                        a = lista_elem.get(i).substring(3);
                    }
                    String npzl = a.trim();
                    String nazwa_kategorii = getIntent().getStringExtra("kategoria");

                    if (npzl.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Choose something", Toast.LENGTH_SHORT).show();
                    } else {
                        background2 bg = new background2(ListaElem.this);
                        bg.execute(npzl, nazwa_kategorii);
                    }
                }
            });
        } else {
            final AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("INFO");
            alertDialog.setMessage(zwrocone_dane);
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


}
