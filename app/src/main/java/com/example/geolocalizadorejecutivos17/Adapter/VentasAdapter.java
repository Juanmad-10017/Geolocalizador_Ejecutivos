package com.example.geolocalizadorejecutivos17.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocalizadorejecutivos17.Modelo.Ventas;
import com.example.geolocalizadorejecutivos17.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class VentasAdapter extends FirestoreRecyclerAdapter <Ventas,VentasAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public VentasAdapter(@NonNull FirestoreRecyclerOptions<Ventas> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull VentasAdapter.ViewHolder holder, int position, @NonNull Ventas Ventas) {
        holder.Cantidad.setText(Ventas.getCantidad());
        holder.Codigo.setText(Ventas.getCodigo());
        holder.MontoTotal.setText(Ventas.getMontoTotal());
        holder.MontoUnitario.setText(Ventas.getMontoUnitario());
        holder.Producto.setText(Ventas.getProducto());
    }

    @NonNull
    @Override
    public VentasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Cantidad,Codigo,MontoTotal,MontoUnitario,Producto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Cantidad = itemView.findViewById(R.id.ed_cantidad);
            Codigo = itemView.findViewById(R.id.ed_codigo);
            MontoTotal = itemView.findViewById(R.id.textView);
            MontoUnitario = itemView.findViewById(R.id.ed_montoUnitario);
            Producto = itemView.findViewById(R.id.ed_producto);
        }
    }
}
