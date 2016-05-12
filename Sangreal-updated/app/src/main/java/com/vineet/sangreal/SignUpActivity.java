package com.vineet.sangreal;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    Button datePickerButton;
    TextView datePickerText;
    Button otp,resend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        datePickerText = (TextView) findViewById(R.id.datePickerText);

        datePickerButton = (Button) findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        SignUpActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        otp = (Button) findViewById(R.id.SubmitButton);
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(SignUpActivity.this);
                dialog.setTitle("Kindly enter the OTP");
                dialog.setContentView(R.layout.otp);
                dialog.show();
                resend =(Button)dialog.findViewById(R.id.resend);
                resend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "OTP has been resend", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });

    }



    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Date of Birth: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        datePickerText.setText(date);
    }

}
