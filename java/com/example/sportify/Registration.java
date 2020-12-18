package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

import static com.example.sportify.utils.NetworkUtils.LogIn;
import static com.example.sportify.utils.NetworkUtils.Register;
import static com.example.sportify.utils.NetworkUtils.generateLoginURL;
import static com.example.sportify.utils.NetworkUtils.generateRegisterURL;

public class Registration extends AppCompatActivity {
    private Button register;
    private EditText name, age, weight, email, password;

    class task extends AsyncTask<URL, Void, String> {

        String Name = name.getText().toString();
        String Age = age.getText().toString();
        String Weight = weight.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        @Override
        protected String doInBackground(URL... urls) {
            String res = null;
            String str = null;
            try {
                res = Register(urls[0], Name, Age, Weight, Email, Password);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }




            return res;


        }
        @Override
        protected void onPostExecute(String res) {

            //Intent LogIn = new Intent(".LoginActivity");
            //startActivity(LogIn);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        onClickListener();
    }
    public void onClickListener(){
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        weight = (EditText)findViewById(R.id.weight);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.Rpassword);
        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        URL generatedURL = generateRegisterURL();
                        new task().execute(generatedURL);
                    }
                }
        );


    }
}