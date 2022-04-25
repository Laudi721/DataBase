package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button btn_insert;
    public EditText edit_imie;
    public EditText edit_nazwisko;
    public EditText edit_pesel;
    public EditText edit_adresZamieszkania;
    public EditText edit_nrTelefonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_insert = (Button) findViewById(R.id.button_insert);
        edit_imie = (EditText) findViewById(R.id.editTextText_id_imie);
        edit_nazwisko = (EditText) findViewById(R.id.editTextText_id_nazwisko);
        edit_pesel = (EditText) findViewById(R.id.editTextText_id_pesel);
        edit_adresZamieszkania = (EditText) findViewById(R.id.editTextText_id_adresZamieszkania);
        edit_nrTelefonu = (EditText) findViewById(R.id.editTextPhone__id_nrTelefonu);
    }
}