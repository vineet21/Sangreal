package com.vineet.sangreal;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tag extends AppCompatActivity {
    Button otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        otp = (Button) findViewById(R.id.SubmitButton);
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Tag.this);
                dialog.setTitle("Kindly enter the OTP");
                dialog.setContentView(R.layout.otp1);
                dialog.show();

            }
        });


    }
}
