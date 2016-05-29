package com.vineet.sangreal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by vineet on 5/20/2016.
 */
public class DriverInfo extends AppCompatActivity
{
    Button driver;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = this;

        driver = (Button) findViewById(R.id.book);
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, DriverInfo.class));
            }
        });
    }

}

