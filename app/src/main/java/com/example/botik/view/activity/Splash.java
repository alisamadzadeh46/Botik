package com.example.botik.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.botik.R;

import java.util.Objects;

public class Splash extends AppCompatActivity {
    ConnectionCheck connectionCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    @Override
    protected void onStart() {
        connectionCheck=new ConnectionCheck();
        registerReceiver(connectionCheck,new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(connectionCheck,new IntentFilter("android.net.android.net.wifi.WIFI_STATE_CHANGE"));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(connectionCheck);
        super.onStop();
    }

    void MethoidCheckIntent(){
        StringRequest stringRequest=new StringRequest(0, "https://alisamadzadeh.ir/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialogmsg da= new  dialogmsg(Splash.this,"خطا در ارتباط با سرور");
                da.show();

            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }

    class ConnectionCheck extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            boolean checkinfo=networkInfo!=null && networkInfo.isConnectedOrConnecting();
            if(checkinfo){
                MethoidCheckIntent();
            }else
            {
                startActivity(new Intent(getApplicationContext(), NoInternet.class));
                finish();
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}