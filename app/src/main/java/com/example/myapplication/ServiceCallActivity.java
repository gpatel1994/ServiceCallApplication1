package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.MainResponse;
import com.example.myapplication.model.MobileInitialize;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class ServiceCallActivity extends AppCompatActivity {
    private int responseCode;
    private String responseMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_call_screen);
        MakeServiceCall task = new MakeServiceCall();
        task.execute();
    }

    public class MakeServiceCall extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... objects) {
            HttpClient httpClient = new DefaultHttpClient();
            try {

                HttpGet httpGet = new HttpGet("https://mservice.bankofamerica.com/mgateway/public/v5/bootstrap/mobileInitialize/BA_APPLE_HANDSET/8.1.0/subsequentUse");
                httpGet.addHeader("Accept-Language", "en-US");
                httpGet.addHeader("Accept-Language", "en-US");
                httpGet.addHeader("Accept", "application/json");
                httpGet.addHeader("Content-Type", "application/json");
                httpGet.addHeader("device-type", "APPLE");
                httpGet.addHeader("platformType", "SMRTPH");

                getServiceResponse(httpClient.execute(httpGet));
            } catch (IOException e) {
                e.printStackTrace();
                httpClient.getConnectionManager().shutdown();
            }
            return null;
        }

    }

    private void getServiceResponse(HttpResponse execute) throws IOException {
        responseCode = execute.getStatusLine().getStatusCode();
        responseMessage = execute.getStatusLine().getReasonPhrase();
        MobileInitialize.clearInstance();
        InputStream inputStream = getAssets().open("response.json");
        int size = inputStream.available();
        byte[] bytes = new byte[size];
        inputStream.read(bytes);
        inputStream.close();
        String response = new String(bytes, "UTF-8");
       MainResponse mobileInitialize = getObjectMapper().readValue(response, MainResponse.class);
       MainResponse.setResponse(mobileInitialize);
        callNextScreen();
    }

    private void callNextScreen() {
        Intent intent = new Intent(this, ResponseViewActivity.class);
        startActivity(intent);
    }

    public ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(PropertyAccessor.IS_GETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.GETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.CREATOR,JsonAutoDetect.Visibility.NONE);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return objectMapper;

    }
}
