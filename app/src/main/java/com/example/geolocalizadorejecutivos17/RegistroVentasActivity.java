package com.example.geolocalizadorejecutivos17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegistroVentasActivity extends AppCompatActivity {
    Button registro;

    EditText producto,codigo,cantidad,monto;

    TextView montoTotal;

    FirebaseFirestore mfirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ventas);

        mfirestore = FirebaseFirestore.getInstance();
        registro = (Button) findViewById(R.id.btn_Producto);
        producto = (EditText) findViewById(R.id.ed_producto);
        codigo = (EditText) findViewById(R.id.ed_codigo);
        cantidad = (EditText) findViewById(R.id.ed_cantidad);
        monto = (EditText) findViewById(R.id.ed_montoUnitario);
        montoTotal=(TextView)findViewById(R.id.textView);


    registro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String productoV = producto.getText().toString().trim();
            String codigoV = codigo.getText().toString().trim();
            String cantidadV = cantidad.getText().toString().trim();
            String montoV = monto.getText().toString().trim();

            int Cantidad = Integer.parseInt(cantidadV);
            float monto = Integer.parseInt(montoV);

            float resultado = Cantidad*monto;
            String Montototal = String.valueOf(resultado);
            montoTotal.setText(Montototal);

            Map<String,Object> map = new HashMap<>();
            map.put("Producto",productoV);
            map.put("Codigo",codigoV);
            map.put("Cantidad",cantidadV);
            map.put("MontoUnitario",montoV);
            map.put("MontoTotal",Montototal);

            mfirestore.collection("Ventas")
                    .add(map)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RegistroVentasActivity.this,"Venta Agregada",Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegistroVentasActivity.this,"Error de Registro",Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    });




    }
    public void regresar (View view){
        Intent regresar = new Intent(RegistroVentasActivity.this,VentasActivity.class);
        startActivity(regresar);


    }
}