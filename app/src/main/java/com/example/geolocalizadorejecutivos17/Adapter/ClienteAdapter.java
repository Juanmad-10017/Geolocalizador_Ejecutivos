package com.example.geolocalizadorejecutivos17.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocalizadorejecutivos17.Modelo.Clientes;
import com.example.geolocalizadorejecutivos17.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class ClienteAdapter extends FirestoreRecyclerAdapter<Clientes, ClienteAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ClienteAdapter(@NonNull FirestoreRecyclerOptions<Clientes> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Clientes Clientes) {
        holder.nombre.setText(Clientes.getNombre_Empresa());
        holder.correo.setText(Clientes.getCorreo());
        holder.telefono.setText(Clientes.getTelefono_contacto());
        holder.direccion.setText(Clientes.getDireccion_Empresa());
        holder.contacto.setText(Clientes.getNombre_Contacto());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cliente_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,correo,telefono,direccion,contacto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre);
            correo = itemView.findViewById(R.id.correo);
            telefono = itemView.findViewById(R.id.telefono);
            direccion = itemView.findViewById(R.id.direccion);
            contacto = itemView.findViewById(R.id.contacto);

        }
    }
}
