package com.example.sportify.utils;

import android.net.Uri;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils extends AppCompatActivity {

    public static final String Sportify_BASE_URL = "http://192.168.1.4:6000/api/";
    public static final String LOGIN = "auth/login";
    public static final String REGISTER = "auth/register";
    public static final String WORKOUT = "workout/?=";
    public static final String PROFILE = "profile/update";


    public static URL generateLoginURL(){
        Uri builtUri = Uri.parse(Sportify_BASE_URL + LOGIN);
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i("JSON", url.toString());
        return url;
    }
    public static URL generateRegisterURL(){
        Uri builtUri = Uri.parse(Sportify_BASE_URL + REGISTER);
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i("JSON", url.toString());
        return url;
    }
    public static URL generateUpdateProfileURL(){
        Uri builtUri = Uri.parse(Sportify_BASE_URL + PROFILE);
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i("JSON", url.toString());
        return url;
    }
    public static URL generategetAllWorkoutURL(){

        Uri builtUri = Uri.parse(Sportify_BASE_URL + WORKOUT);
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    public static String getAllWorkout(URL url, String token) throws IOException, JSONException{
        Log.i("JSON", url.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-length", "0");
            urlConnection.setUseCaches(false);
            urlConnection.setAllowUserInteraction(false);




            urlConnection.setRequestProperty("Authorization", token);
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            
            urlConnection.connect();;
            Log.i("JSON", urlConnection.getRequestMethod());

            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                return "" + sb.toString();
            } else {
                return urlConnection.getResponseMessage();
            }

        } finally {
            urlConnection.disconnect();
        }

    }
    /*public static String ProfileGetById(URL url) throws IOException{

    }*/
    public static String LogIn(URL url, String log, String pass) throws IOException, JSONException {


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            JSONObject logIn   = new JSONObject();
            //logIn.put("email","kiril@gmail.com");
            //logIn.put("password", "123456");
            logIn.put("email",log);
            logIn.put("password", pass);
            Log.i("JSON", logIn.toString());
            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(logIn.toString());
            bw.flush();
            //RELEASE RES
            bw.close();
            os.close();
            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                JSONObject jObject = new JSONObject(sb.toString());
                String aJsonString = jObject.getString("token");
                Log.i("JSON", aJsonString);
                return aJsonString;
            } else {
                Log.i("JSON error", urlConnection.getResponseMessage());
                return urlConnection.getResponseMessage();
            }
            
        } finally {
            urlConnection.disconnect();
            Log.i("JSON", "urlConnection.disconnect()");
        }
    }
    public static String Register(URL url, String name, String age, String weight, String log, String pass) throws IOException, JSONException {


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            JSONObject register   = new JSONObject();
            register.put("name",name);
            register.put("age",age);
            register.put("weight",weight);
            register.put("email",log);
            register.put("password", pass);
            Log.i("JSON", register.toString());
            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(register.toString());
            bw.flush();
            //RELEASE RES
            bw.close();
            os.close();
            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                JSONObject jObject = new JSONObject(sb.toString());
                String aJsonString = jObject.getString("token");
                Log.i("JSON", aJsonString);
                return aJsonString;
            } else {
                Log.i("JSON error", urlConnection.getResponseMessage());
                return urlConnection.getResponseMessage();
            }

        } finally {
            urlConnection.disconnect();
            Log.i("JSON", "urlConnection.disconnect()");
        }
    }
    public static String updateProfile(URL url, String name, String age, String weight, String token) throws IOException, JSONException {


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            Log.i("JSON token", token);
            //urlConnection.setDoOutput(true);
            //urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Authorization", token);
            urlConnection.setRequestMethod("PATCH");
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            JSONObject update   = new JSONObject();
            update.put("name",name);
            update.put("age", age);
            update.put("weight", weight);
            Log.i("JSON", update.toString());
            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(update.toString());
            bw.flush();
            //RELEASE RES
            bw.close();
            os.close();
            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                JSONObject jObject = new JSONObject(sb.toString());
                String aJsonString = jObject.getString("token");
                Log.i("JSON", aJsonString);
                return aJsonString;
            } else {
                Log.i("JSON error", urlConnection.getResponseMessage());
                return urlConnection.getResponseMessage();
            }


        } finally {
            urlConnection.disconnect();
            Log.i("JSON", "urlConnection.disconnect()");
        }
    }


}
