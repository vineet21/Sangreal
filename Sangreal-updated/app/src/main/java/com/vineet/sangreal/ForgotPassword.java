package com.vineet.sangreal;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText mobileNum, EmailID;
    String Password;
    Button submit;
    public String Tag = "Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        mobileNum = (EditText)findViewById(R.id.ForgotPassPhoneNum);
        EmailID = (EditText)findViewById(R.id.ForgotEmailID);
        submit = (Button)findViewById(R.id.forgotpasswordsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(Tag, "Now Inside forgot class");
                Cursor cursor = dataBaseHelper.FetchPassword(mobileNum.getText().toString(), EmailID.getText().toString());
                if(cursor.getCount()<1 || cursor == null ){
                    Log.i(Tag,"Inside if of forgot passward class");
                    Toast.makeText(ForgotPassword.this, "Mobile or Email Doesnot Exist", Toast.LENGTH_SHORT).show();
                }
                else{
                    cursor.moveToNext();
                    Log.i(Tag,"Inside else of forgot passwye ard class");
                    Password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
                    Toast.makeText(ForgotPassword.this, "Password : "+Password, Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
    }
}
