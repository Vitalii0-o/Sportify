package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Training extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        tv = (TextView)findViewById(R.id.name_of_workout);
        tv.setText(name);
    }
}