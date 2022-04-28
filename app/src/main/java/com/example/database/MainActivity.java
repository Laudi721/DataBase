package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.util.Log;
import android.database.Cursor;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener
{

    public Button btn_insert;
    public EditText edit_imie;
    public EditText edit_nazwisko;
    public EditText edit_pesel;
    public EditText edit_adresZamieszkania;
    public EditText edit_nrTelefonu;

    ZarzadzajDanymi zd;

    private String getRandomString()
    {
        StringBuffer randStr = new StringBuffer();
        Random rnd = new Random();

        for(int i = 0; i < rnd.nextInt(40); i++)
        {
            randStr.append((char) (rnd.nextInt(126-40) + 40));
        }

        return  randStr.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_insert = (Button) findViewById(R.id.button_insert);
        edit_imie = (EditText) findViewById(R.id.editTextText_id_imie);
        edit_nazwisko = (EditText) findViewById(R.id.editTextText_id_nazwisko);
        edit_pesel = (EditText) findViewById(R.id.editTextText_id_pesel);
        edit_adresZamieszkania = (EditText) findViewById(R.id.editTextText_id_adresZamieszkania);
        edit_nrTelefonu = (EditText) findViewById(R.id.editTextPhone_id_phone);

        zd = new ZarzadzajDanymi(this);

        btn_insert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String imie = "";
        String nazwisko = "";
        String pesel = "";
        String adresZamieszkania = "";
        String nrTelefonu = "";

        if(edit_imie.length() == 0) { imie = getRandomString(); }
        else {  imie = edit_imie.getText().toString(); }

        if(edit_nazwisko.length() == 0) { nazwisko = getRandomString(); }
        else { nazwisko = edit_nazwisko.getText().toString(); }

        if(edit_pesel.length() == 0) { pesel = getRandomString(); }
        else {  pesel = edit_pesel.getText().toString(); }

        if(edit_adresZamieszkania.length() == 0) { adresZamieszkania = getRandomString(); }
        else {  adresZamieszkania = edit_adresZamieszkania.getText().toString(); }

        if(edit_nrTelefonu.length() == 0) { nrTelefonu = getRandomString(); }
        else {  nrTelefonu = edit_nrTelefonu.getText().toString(); }

        zd.insert(imie,
                nazwisko,
                pesel,
                adresZamieszkania,
                nrTelefonu);
    }
}