package com.thefallingboy.ahorroapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorDeDatos extends RecyclerView.Adapter<AdaptadorDeDatos.ViewHolderDatos> {

    private ArrayList<Ahorro> ListaDeAhorros;

    public AdaptadorDeDatos(ArrayList<Ahorro> ListaDeAhorros){
        this.ListaDeAhorros = ListaDeAhorros;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ahorro, parent, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.NombreAhorro.setText(ListaDeAhorros.get(position).getNombreAhorro());
        holder.prevAhorro.setText(ListaDeAhorros.get(position).getCantidadAhorrada() + "/" + ListaDeAhorros.get(position).getCantidadPorAhorrar());
    }

    @Override
    public int getItemCount() {
        return ListaDeAhorros.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView NombreAhorro;
        TextView prevAhorro;


        public ViewHolderDatos(View itemView) {
            super(itemView);

            NombreAhorro = itemView.findViewById(R.id.tv_nombreAhorro);
            prevAhorro = itemView.findViewById(R.id.tv_previewAhorro);
        }
    }
}
