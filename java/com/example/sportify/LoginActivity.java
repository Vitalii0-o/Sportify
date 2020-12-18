package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.StringSearch;
import android.media.session.MediaSession;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.sportify.utils.NetworkUtils.TOKEN;
import static com.example.sportify.utils.NetworkUtils.LogIn;
import static com.example.sportify.utils.NetworkUtils.generateLoginURL;


public class LoginActivity extends AppCompatActivity {
    private EditText login, password;
    private Button sign_in, register;
    private TextView textView9;


    class task extends AsyncTask<URL, Void, String> {

        String log = login.getText().toString();
        String pass = password.getText().toString();
        @Override
        protected String doInBackground(URL... urls) {
            String res = null;
            String str = null;
            try {
                res = LogIn(urls[0], log, pass);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }




            return res;


        }
        @Override
        protected void onPostExecute(String res) {
            if (!res.contains("Not Found")) {
                TOKEN = res;
                Intent Choice_train = new Intent(".MainActivity");
                startActivity(Choice_train);


            }else {
                textView9 = (TextView) findViewById(R.id.textView666);
                textView9.setText(res);
                textView9.setVisibility(View.VISIBLE);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onClickListener();

    }
    public void onClickListener(){
        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        sign_in = (Button)findViewById(R.id.sign_in);
        register = (Button)findViewById(R.id.register);
        sign_in.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        URL generatedURL = generateLoginURL();
                        new task().execute(generatedURL);
                    }
                }
        );
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent Registration = new Intent(".Registration");
                        startActivity(Registration);
                    }
                }
        );

    }

}