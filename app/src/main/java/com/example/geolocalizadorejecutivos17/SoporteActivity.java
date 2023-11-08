package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SoporteActivity extends AppCompatActivity {
    Button btn_regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soporte);
        btn_regresar = findViewById(R.id.btn_regresarSoporte);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(SoporteActivity.this,UserActivity.class);
                startActivity(regresar);
            }
        });
    }
}