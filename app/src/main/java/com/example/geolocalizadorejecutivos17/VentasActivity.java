package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocalizadorejecutivos17.Adapter.VentasAdapter;
import com.example.geolocalizadorejecutivos17.Modelo.Ventas;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;



public class VentasActivity extends AppCompatActivity {

    Button btn_registro,btn_regresar;
    RecyclerView mRecycler;

    VentasAdapter mAdapter;

    FirebaseFirestore mFirestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        btn_registro = findViewById(R.id.btn_registroVenta);
        btn_regresar = findViewById(R.id.btn_regresarVentas);
        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.RecyclerViewVentas);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("Ventas");

        FirestoreRecyclerOptions<Ventas> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Ventas>().setQuery(query,Ventas.class).build();

        mAdapter = new VentasAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);


        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(VentasActivity.this,RegistroVentasActivity.class);
                startActivity(registro);
            }
        });
        btn_regresar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(VentasActivity.this, UserActivity.class);
                startActivity(regresar);
            }
        }));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}