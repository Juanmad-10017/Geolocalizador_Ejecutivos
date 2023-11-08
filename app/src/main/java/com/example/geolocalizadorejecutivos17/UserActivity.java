package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    Button btnLogOut,btnGeolozalizador,btnClientes,btnVentas,btnAyuda;
    TextView txtUser;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnGeolozalizador = (Button) findViewById(R.id.btn_geolozalizador);
        btnClientes = (Button) findViewById(R.id.btn_clientes);
        btnVentas = (Button) findViewById(R.id.btn_ventas);
        btnAyuda = (Button) findViewById(R.id.btn_ayuda);
        firebaseAuth = FirebaseAuth.getInstance();
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        txtUser = (TextView) findViewById(R.id.txtUser);
        user = firebaseAuth.getCurrentUser();

        btnGeolozalizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geolocalizador = new Intent(UserActivity.this,MapsActivity.class);
                startActivity(geolocalizador);
            }
        });
        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clientes =new Intent(UserActivity.this,ClientesActivity.class);
                startActivity(clientes);
            }
        });
        btnVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventas = new Intent(UserActivity.this,VentasActivity.class);
                startActivity(ventas);
            }
        });
        btnAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayuda = new Intent(UserActivity.this, SoporteActivity.class);
                startActivity(ayuda);
            }
        });

        if (user == null ) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            txtUser.setText(user.getEmail());
        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(I);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id == R.id.geolozalizador){
            Intent intentgeo =new Intent(UserActivity.this,GeolocalizadorActivity.class);
            startActivity(intentgeo);
        }else if (id == R.id.clientes){
            Intent intetcliente = new Intent(UserActivity.this,ClientesActivity.class);
            startActivity(intetcliente);
        }else if (id == R.id.ventas){
            Intent intentventas = new Intent(UserActivity.this,VentasActivity.class);
            startActivity(intentventas);
        }else if (id == R.id.ayuda) {
            Intent intentayuda = new Intent(UserActivity.this, VentasActivity.class);
            startActivity(intentayuda);
        }
        return super.onOptionsItemSelected(item);
    }



}