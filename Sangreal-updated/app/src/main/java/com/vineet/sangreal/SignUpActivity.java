package com.vineet.sangreal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
   DatabaseHelper helper = new DatabaseHelper(this);

    Button datePickerButton;
    TextView datePickerText;
    String namestr,emailstr ,passwordstr;

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
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Date of Birth: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        datePickerText.setText(date);
    }
    {
        Contact c= new Contact();
        c.setName(namestr);
        c.setEmail(emailstr);
        c.setPassword(passwordstr);
        helper.insertContact(c);



    }
}
