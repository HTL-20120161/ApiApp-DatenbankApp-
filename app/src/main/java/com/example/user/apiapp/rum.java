package com.example.user.apiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 28.02.2016.
 */
public class rum extends Activity
{
    DatabaseHelper helper;

    Button hinzuButton,ausgabeButon,deleteButton;
    EditText name,preis;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.rum);

        helper = new DatabaseHelper(this);

        hinzuButton = (Button) findViewById(R.id.RumHinzufügen);
        ausgabeButon = (Button) findViewById(R.id.RumAusgeben);
        deleteButton = (Button) findViewById(R.id.RumLöschen);

        name = (EditText) findViewById(R.id.RumNameEinlesen);
        preis = (EditText) findViewById(R.id.RumPreisEinlesen);

        Hinzufügen();
        Auslesen();
        Löschen();

    }

    public void Hinzufügen()
    {
        hinzuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean erg = helper.InsertTable_secound(name.getText().toString(), preis.getText().toString());
                if (erg == true) {
                    Toast.makeText(rum.this, "Daten wurden gespeichert", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(rum.this, "Fehler", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Auslesen()
    {
        ausgabeButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Cursor res = helper.getTableDataTable_secound();
                if(res.getCount() == 0)
                {
                    Nachricht("Fehler", "Daten konnten nicht gefunden werden");
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID :"+res.getString(0) +"\n");
                    buffer.append("NAME :"+res.getString(1)+"\n");
                    buffer.append("PREIS :"+res.getString(2)+"\n");

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
             Integer erg = helper.LöschenTable_secound("1");
                if(erg > 0)
                {
                    Toast.makeText(rum.this,"Gelöscht",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(rum.this,"Kein Element zum Löschen gefunden",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
