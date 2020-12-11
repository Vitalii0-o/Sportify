package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Choice_train extends AppCompatActivity {
    private Button addNewTrain;
    private Button back;
    private TextView trainsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trains_list_onCreate();

        addTrain();
    }

    public void addTrain(){
        addNewTrain = (Button)findViewById(R.id.add_new_train);
        addNewTrain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".AddNewTrain");
                        startActivity(intent);
                    }
                }
        );

    }
    public void trains_list_onCreate(){
        String[] trains = {"prised", "dqwdwad", "adadawd"};
        trainsList = (TextView)findViewById(R.id.textView7);
        for(String name:trains){
            trainsList.append(name + "/n");
        }

    }
}