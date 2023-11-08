package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroClientesActivity extends AppCompatActivity {
    Button btn_registro,btn_regresar;
    EditText nombre,correo,telefono,direccion,contacto;

    FirebaseFirestore db;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);
        db = FirebaseFirestore.getInstance();
        nombre = (EditText) findViewById(R.id.ed_nombre);
        correo = (EditText) findViewById(R.id.ed_correo);
        telefono = (EditText) findViewById(R.id.ed_telefono);
        direccion = (EditText) findViewById(R.id.ed_direccion);
        contacto = (EditText) findViewById(R.id.ed_contacto);
        btn_regresar = (Button) findViewById(R.id.btn_regresar);
        btn_registro = (Button) findViewById(R.id.btn_agregarCliente);


        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreEmp = nombre.getText().toString().trim();
                String correoEmp = correo.getText().toString().trim();
                String telefonoEmp = telefono.getText().toString().trim();
                String direccionEmp = direccion.getText().toString().trim();
                String contactoEmp = contacto.getText().toString().trim();

                Map<String,Object> clientes = new HashMap<>();
                clientes.put("Nombre_Empresa",nombreEmp);
                clientes.put("Correo",correoEmp);
                clientes.put("Telefono_contacto",telefonoEmp);
                clientes.put("Direccion_Empresa",direccionEmp);
                clientes.put("Nombre_Contacto",contactoEmp);

                db.collection("Clientes")
                        .add(clientes)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(RegistroClientesActivity.this,"Registro Correcto",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegistroClientesActivity.this,"Error en registro",Toast.LENGTH_SHORT).show();
                            }
                        });


            }

        });
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(RegistroClientesActivity.this, ClientesActivity.class);
                startActivity(regresar);
            }
        });

    }


}



