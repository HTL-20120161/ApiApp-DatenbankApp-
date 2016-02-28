package com.example.user.apiapp;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper neueDatenbank;
    EditText name,preis;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //neueDatenbank = new DatabaseHelper(this);

        //name = (EditText)findViewById(R.id.name);
        //preis = (EditText)findViewById(R.id.preis);

        //addButton = (Button)findViewById(R.id.add);
        //ausleseButton = (Button)findViewById(R.id.auslesen);
        //löschenButton = (Button) findViewById(R.id.löschen);
        //naviButton = (Button) findViewById(R.id.navigation);
        startButton = (Button) findViewById(R.id.MainButton);


        //Add();
        //Ausgeben();
        //Löschen();
        WechselnZuHome();



    }

    /*public void Add()
    {
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean wahr = neueDatenbank.Insert(name.getText().toString(), preis.getText().toString());

                if (wahr == true) {
                    Toast.makeText(MainActivity.this, "Insert Erfolgreisch", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Fehler", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public void Ausgeben()
    {
        ausleseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cursor res = neueDatenbank.getTableData();
                if (res.getCount() == 0)
                {
                    zeigNachricht("Fail", "Nix drin");
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID :"+res.getString(0) +"\n");
                    buffer.append("NAME :"+res.getString(2)+"\n");
                    buffer.append("PREIS :"+res.getString(1)+"\n");

                }
                zeigNachricht("Daten",buffer.toString());
            }
        });


    }

    public void zeigNachricht(String titel, String nachricht)
    {
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titel);
        builder.setMessage(nachricht);
        builder.show();

    }

    public void Löschen()
    {
        löschenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Integer gelöschteZeilen = neueDatenbank.Löschen("6");
                if (gelöschteZeilen > 0) {
                    Toast.makeText(MainActivity.this, "Gelöscht", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "nix", Toast.LENGTH_LONG).show();

                }
            }
        });
    }*/

    public void WechselnZuHome ()
    {
        startButton.setOnClickListener(new View.OnClickListener()
         {
            public void onClick(View view)
            {
               Wechsel();
            }

         });

    }

    public void Wechsel()
    {
        Intent intent = new Intent(this,Navigation.class);
        startActivity(intent);
    }









}

