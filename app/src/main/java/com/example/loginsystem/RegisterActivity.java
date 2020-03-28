package com.example.loginsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.room.Room;

public class RegisterActivity extends Activity {
    EditText username, full_name, password;
    Button register, cancel;
    //DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        full_name = findViewById(R.id.full_name);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        //databaseHelper = new DatabaseHelper(this);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String full_nameValue = full_name.getText().toString();
                String passwordValue = password.getText().toString();

                if (usernameValue.length() > 1) {
                    /*ContentValues contentValues = new ContentValues();
                    contentValues.put("username", usernameValue);
                    contentValues.put("full_name", full_nameValue);
                    contentValues.put("password", passwordValue);
                    contentValues.put("email", emailValue);
                    contentValues.put("suid", suidValue);

                    databaseHelper.insertUser(contentValues); */
                    User new_user = new User();
                    new_user.username = usernameValue;
                    new_user.password = passwordValue;
                    db.userDao().insertAll(new_user);
                    Toast.makeText(RegisterActivity.this, "User registered!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Please Enter all Information.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}