package com.vineet.sangreal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper helper =new DatabaseHelper(this);
    EditText userName, password;
    Button login, signup;
    Context context;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        context = this;

        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Logic to verify credentials
                String password1 = helper.searchPassword(str);
                if (password.equals(password1)) {
                    BC.userName = userName.getText().toString();
                    startActivity(new Intent(context, MainActivity.class));
                } else {
                    Snackbar.make(v, "Invalid username or password", Snackbar.LENGTH_LONG).show();
                }
            }
        });


        signup = (Button) findViewById(R.id.signUpButton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, SignUpActivity.class));
            }
        });
    }

    /*private boolean isUserValid(EditText userName, EditText password) {
        return userName.getText().toString().equals("vineet") && password.getText().toString().equals("vineet");
    }*/
}
