package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
    private Button start1, start2, start3, start4,  delete1,  delete2,  delete3,  delete4,addNewTrain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list);

        trains_list_onCreate();


    }




    public void trains_list_onCreate(){
        start1 = (Button)findViewById(R.id.start_curent_train1);
        start2 = (Button)findViewById(R.id.start_curent_train2);
        start3 = (Button)findViewById(R.id.start_curent_train3);
        start4 = (Button)findViewById(R.id.start_curent_train4);
        delete1 = (Button)findViewById(R.id.delete_curent_train1);
        delete2 = (Button)findViewById(R.id.delete_curent_train2);
        delete3 = (Button)findViewById(R.id.delete_curent_train3);
        delete4 = (Button)findViewById(R.id.delete_curent_train4);
        addNewTrain = (Button)findViewById(R.id.add_new_train);
        start1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent Training = new Intent(".Training");
                        Training.putExtra("name", "Отжымания");
                        startActivity(Training);
                    }
                }
        );
        start2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent Training = new Intent(".Training");
                        Training.putExtra("name", "Подтягивания");
                        startActivity(Training);
                    }
                }
        );
        start3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent Training = new Intent(".Training");
                        Training.putExtra("name", "Упражнения на прес");
                        startActivity(Training);
                    }
                }
        );
        start4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent Training = new Intent(".Training");
                        Training.putExtra("name", "Приседания");
                        startActivity(Training);
                    }
                }
        );
        delete1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
                        ll.setVisibility(View.GONE);
                    }
                }
        );
        delete2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);
                        ll.setVisibility(View.GONE);
                    }
                }
        );
        delete3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout3);
                        ll.setVisibility(View.GONE);
                    }
                }
        );
        delete4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout4);
                        ll.setVisibility(View.GONE);
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