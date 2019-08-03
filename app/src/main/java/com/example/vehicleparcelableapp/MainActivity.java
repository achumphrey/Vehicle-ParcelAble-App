package com.example.vehicleparcelableapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "message";
    Button btn_get_vehicle_details;
    TextView tv_make_value;
    TextView tv_colour_value;
    TextView tv_no_of_door_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get_vehicle_details = findViewById(R.id.btn_get_veh_details);
        tv_make_value =findViewById(R.id.tv_make_value);
        tv_colour_value = findViewById(R.id.tv_colour_value);
        tv_no_of_door_value = findViewById(R.id.tv_door_value);

        btn_get_vehicle_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Vehicle vehicle = data.getParcelableExtra(INTENT_MESSAGE);

                tv_make_value.setText(vehicle.getVehicleMake());
                tv_colour_value.setText(vehicle.getColour());
                tv_no_of_door_value.setText(String.valueOf(vehicle.getNumberOfDoors()));

            }
            if (resultCode == RESULT_CANCELED) {
                //Handle case
            }
        }
    }
}
