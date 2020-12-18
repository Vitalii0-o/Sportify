package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.example.sportify.utils.NetworkUtils.LogIn;
import static com.example.sportify.utils.NetworkUtils.generateLoginURL;
import static com.example.sportify.utils.NetworkUtils.generategetAllWorkoutURL;
import static com.example.sportify.utils.NetworkUtils.getAllWorkout;


public class TrainList extends AppCompatActivity {
    private TextView trainsList;
    private Button start, addNewTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list);
        trains_list_onCreate();


    }




    public void trains_list_onCreate(){
        trainsList = (TextView)findViewById(R.id.textView7);
        start = (Button)findViewById(R.id.start_curent_train);
        addNewTrain = (Button)findViewById(R.id.add_new_train);
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent Training = new Intent(".Training");
                        startActivity(Training);


                    }
                }
        );
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

}