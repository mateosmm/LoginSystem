package com.example.loginsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.room.Room;

public class CreateEventActivity extends Activity {

    EditText title, description, day, year, time;
    Spinner month;
    Button post, cancel;
    //DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createevent);

        Toast.makeText(CreateEventActivity.this, "in correct place!", Toast.LENGTH_SHORT).show();

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);
        time = findViewById(R.id.time);

        post = findViewById(R.id.post);
        cancel = findViewById(R.id.cancel);

        //databaseHelper = new DatabaseHelper(this);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event_title = title.getText().toString();
                String event_description = description.getText().toString();
                String event_month = month.getSelectedItem().toString();
                int event_day = Integer.parseInt(day.getText().toString());
                int event_year = Integer.parseInt(year.getText().toString());
                int event_time = Integer.parseInt(time.getText().toString());
                double lat = getIntent().getDoubleArrayExtra("latlng")[0];
                double lng = getIntent().getDoubleArrayExtra("latlng")[1];
                int month = 0;
                switch(event_month){
                    case("January"):
                        month = 1;
                        break;
                    case("February"):
                        month = 2;
                        break;
                    case("March"):
                        month = 3;
                        break;
                    case("April"):
                        month = 4;
                        break;
                    case("May"):
                        month = 5;
                        break;
                    case("June"):
                        month = 6;
                        break;
                    case("July"):
                        month = 7;
                        break;
                    case("August"):
                        month = 8;
                        break;
                    case("September"):
                        month = 9;
                        break;
                    case("October"):
                        month = 10;
                        break;
                    case("November"):
                        month = 11;
                        break;
                    case("December"):
                        month = 12;
                        break;
                }

                if (title.length() > 1) {
                    Event new_event = new Event(event_title, event_description, month, event_day, event_year, event_time, lat, lng);

                    db.eventDao().insertAll(new_event);
                    Toast.makeText(CreateEventActivity.this, "Event posted!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateEventActivity.this, MapActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(CreateEventActivity.this, "Please Enter all Information.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}