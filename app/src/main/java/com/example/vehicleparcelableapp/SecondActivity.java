package com.example.vehicleparcelableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Vehicle vehicle = new Vehicle("Toyota", "Brown", 4);

        Intent intent = new Intent();
        intent.putExtra(MainActivity.INTENT_MESSAGE, vehicle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
