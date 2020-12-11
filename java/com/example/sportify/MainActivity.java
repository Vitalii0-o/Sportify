package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

import static com.example.sportify.utils.NetworkUtils.LogIn;
import static com.example.sportify.utils.NetworkUtils.generateLoginURL;
import static com.example.sportify.utils.NetworkUtils.generateUpdateProfileURL;
import static com.example.sportify.utils.NetworkUtils.updateProfile;

public class MainActivity extends AppCompatActivity {
    private EditText newName, newAge, newWeight;
    private TextView  profileName, profileAge;
    private Button editProfile, edit, startTrain;

    class task extends AsyncTask<URL, Void, String> {


        String token = getResources().getString(R.string.token);
        String name = newName.getText().toString();
        String age = newAge.getText().toString();
        String weight = newWeight.getText().toString();
        @Override
        protected String doInBackground(URL... urls) {
            String res = null;
            Log.i("JSON token", token);
            Log.i("JSON token", "111111111111");
            try {
                res = updateProfile(urls[0], name, age, weight, token);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            Log.i("JSON", res);
            return res;
        }
    }

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit();
    }
    public void edit(){
        profileName = (TextView)findViewById(R.id.profile_name);
        profileAge = (TextView)findViewById(R.id.profile_age);
        newName = (EditText)findViewById(R.id.new_name);
        newWeight = (EditText)findViewById(R.id.new_weight);
        newAge = (EditText)findViewById(R.id.new_age);
        edit = (Button)findViewById(R.id.edit);
        startTrain = (Button)findViewById(R.id.start_train);
        editProfile = (Button)findViewById(R.id.edit_profile);
        edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        URL generatedURL = generateUpdateProfileURL();
                        new task().execute(generatedURL);
                        profileName.setText(newName.getText());
                        profileAge.setText(newAge.getText());
                        newName.setVisibility(View.INVISIBLE);
                        newAge.setVisibility(View.INVISIBLE);
                        newWeight.setVisibility(View.INVISIBLE);
                        edit.setVisibility(View.INVISIBLE);

                    }
                }
        );
        startTrain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent Choice_train = new Intent(".TrainList");
                        startActivity(Choice_train);
                    }
                }
        );
        editProfile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newName.setVisibility(View.VISIBLE);
                        newAge.setVisibility(View.VISIBLE);
                        newWeight.setVisibility(View.VISIBLE);
                        edit.setVisibility(View.VISIBLE);

                    }
                }
        );
    }
}