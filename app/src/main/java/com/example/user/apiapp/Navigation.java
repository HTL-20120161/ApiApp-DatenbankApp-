package com.example.user.apiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by User on 28.02.2016.
 */
public class Navigation extends Activity
{
    Button ginButton,rumButton;


    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.navigation);

        ginButton = (Button) findViewById(R.id.GinButton);
        rumButton = (Button) findViewById(R.id.RumButton);

        WechselnZuGin();
        WechselZuRum();

    }

    public void WechselnZuGin()
    {
        ginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wechsel();
            }
        });
    }

    public void Wechsel()
    {
        Intent intent = new Intent(this,gin.class);
        startActivity(intent);
    }

    public void WechselZuRum()
    {
        rumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wechsel1();
            }
        });
    }
    public void Wechsel1()
    {
        Intent intent = new Intent(this,rum.class);
        startActivity(intent);
    }




}
