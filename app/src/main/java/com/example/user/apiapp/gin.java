package com.example.user.apiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 28.02.2016.
 */
public class gin extends Activity
{
    DatabaseHelper helper;
    Button hinzuButton,deleteButton,ausgabeButton;
    EditText name,preis;


    protected void onCreate(Bundle b)
    {
        //Konstruktor und onCreate
        super.onCreate(b);
        setContentView(R.layout.gin);
        //Variable der Datenbank
        helper = new DatabaseHelper(this);
        //Button Variablen
        hinzuButton = (Button) findViewById(R.id.GinHinzufügen);
        deleteButton= (Button) findViewById(R.id.GinLöschen);
        ausgabeButton = (Button) findViewById(R.id.GinAusgeben);
        //Edit Text Variablen
        name = (EditText) findViewById(R.id.GinNamensEingabe);
        preis = (EditText) findViewById(R.id.GinPreisEingabe);
        //Methoden
        Add();
        Ausgeben();
        Löschen();
    }

    public void Add()
    {
        hinzuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              boolean erg = helper.InsertTable_first(name.getText().toString(), preis.getText().toString());
                if(erg == true)
                {
                    Toast.makeText(gin.this,"Daten wurden gespeichert",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(gin.this, "Fehler", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Ausgeben()
    {
        ausgabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              Cursor res = helper.getTableDataTable_first();
                if(res.getCount()==0)
                {
                    Nachricht("Fehler", "Keine Daten gefunden");
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID :"+res.getString(0) +"\n");
                    buffer.append("NAME :"+res.getString(2)+"\n");
                    buffer.append("PREIS :"+res.getString(1)+"\n");

                }
                Nachricht("Daten",buffer.toString());
            }
        });
    }

    public void Nachricht(String titel,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titel);
        builder.setMessage(message);
        builder.show();
    }
    public void Löschen()
    {
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Integer erg = helper.LöschenTable_first("1");
                if(erg > 0)
                {
                    Toast.makeText(gin.this,"Gelöscht",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(gin.this,"Nix zum Löschen",Toast.LENGTH_LONG).show();
                }
            }
        });
    }






}
