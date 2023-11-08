package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocalizadorejecutivos17.Adapter.ClienteAdapter;
import com.example.geolocalizadorejecutivos17.Modelo.Clientes;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ClientesActivity extends AppCompatActivity {
    Button btnRegistro,btnRegresar;
    RecyclerView mRcycler;
    ClienteAdapter madapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        btnRegistro = (Button) findViewById(R.id.btn_agregar);
        mFirestore = FirebaseFirestore.getInstance();
        mRcycler = findViewById(R.id.recyclerView);
        mRcycler.setLayoutManager(new LinearLayoutManager(this));
        btnRegresar = (Button)findViewById(R.id.btn_regresarclientes);
        Query query = mFirestore.collection("Clientes");

        FirestoreRecyclerOptions<Clientes> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Clientes>().setQuery(query,Clientes.class).build();

        madapter = new ClienteAdapter(firestoreRecyclerOptions);
        madapter.notifyDataSetChanged();
        mRcycler.setAdapter(madapter);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(ClientesActivity.this,RegistroClientesActivity.class);
                startActivity(registro);

            }

        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(ClientesActivity.this, UserActivity.class);
                startActivity(regresar);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        madapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        madapter.stopListening();
    }
}