package com.vineet.sangreal;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tag extends AppCompatActivity {
    Button otp, resend;

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
                resend =(Button)dialog.findViewById(R.id.resend);
                resend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "OTP has been resend to your family/friend", Toast.LENGTH_SHORT).show();
                    }

                });


            }
        });
    }
}