package com.mx.gem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.Ar.UnityPlayerActivity;


public class QrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
     intent.putExtra("name","value");
     startActivity(intent);
    }
}