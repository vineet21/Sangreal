package com.vineet.sangreal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;*/
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity /*implements DatePickerDialog.OnDateSetListener*/ {


    Button datePickerButton;
    TextView datePickerText;
    Button otp, resend;
    Button Submitbutton;
    public String Tag = "Log";
    private DataBaseHelper dataBaseHelper;

    EditText UserName, Password, Password2, MobileNo, Email, EconNo;
    int dob_year, dob_month, dob_days;
    static final int DIALOG_ID = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dataBaseHelper = new DataBaseHelper(this);

        datePickerText = (TextView) findViewById(R.id.datePickerText);

        UserName = (EditText) findViewById(R.id.userName);
        MobileNo = (EditText) findViewById(R.id.phoneNumber);
        Password = (EditText) findViewById(R.id.password1);
        Password2 = (EditText) findViewById(R.id.password2);
        Email = (EditText) findViewById(R.id.email);
        EconNo = (EditText) findViewById(R.id.ename);

        //datePickerButton = (Button) findViewById(R.id.datePickerButton);

        Submitbutton = (Button) findViewById(R.id.SubmitButton);
        Submitbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.i(Tag, "Now will check if passwords matches or not");

                if (Password.getText().toString().equals(Password2.getText().toString())) {

                    Cursor cursor = dataBaseHelper.isValidData(UserName.getText().toString(), "USERNAME");
                    if (cursor.getCount() > 0) {

                        Toast.makeText(SignUpActivity.this, "UserName Already Registerd", Toast.LENGTH_SHORT).show();
                        cursor.close();
                        return;
                    }
                    cursor = dataBaseHelper.isValidData(MobileNo.getText().toString(), "PHONENUMBER");
                    if (cursor.getCount() > 0) {

                        Toast.makeText(SignUpActivity.this, "Phone Number Already Registerd", Toast.LENGTH_SHORT).show();
                        cursor.close();
                        //startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    }
                    cursor = dataBaseHelper.isValidData(Email.getText().toString(), "EMAIL");
                    if (cursor.getCount() > 0) {

                        Toast.makeText(SignUpActivity.this, "Email Already Registerd", Toast.LENGTH_SHORT).show();
                        cursor.close();
                        return;
                    }

                    Log.i(Tag, "Now will call for insert scriptfunction.......");
                    dataBaseHelper.InsertData(UserName.getText().toString(), Password.getText().toString(),
                            MobileNo.getText().toString(), Email.getText().toString(),
                            EconNo.getText().toString());
                    Log.i(Tag, "Returned after inserting into database");
                    cursor.close();

                    Toast.makeText(SignUpActivity.this, "SuccessFully Created User", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));

                } else {
                    Toast.makeText(SignUpActivity.this, "Please Check as Passwords are not same", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void shoDialogOnButton() {
        datePickerButton = (Button) findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DialogFragment;
            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SignUp Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vineet.sangreal/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SignUp Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vineet.sangreal/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
 /*datePickerButton = (Button) findViewById(R.id.datePickerButton);
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
        });*/

//}


/*
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Date of Birth: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        datePickerText.setText(date);
    }
*/
