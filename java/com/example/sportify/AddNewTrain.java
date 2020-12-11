package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewTrain extends AppCompatActivity {

    private Button exit;
    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_train);
        clickListener();
    }
    public void clickListener(){
        exit = (Button)findViewById(R.id.exit);
        done = (Button)findViewById(R.id.done);
        done.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Choice_train");
                        startActivity(intent);
                    }
                }
        );
        exit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Choice_train");
                        startActivity(intent);
                    }
                }
        );

    }
}