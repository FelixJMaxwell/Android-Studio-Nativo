package com.thefallingboy.recyclerviewejemplo2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes>{

    ArrayList<Personaje> listaPersonajes;

    public AdaptadorPersonajes(ArrayList<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_personajes, null, false);
        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonajes holder, int position) {
        holder.nombrePersonaje.setText(listaPersonajes.get(position).getNombre());
        holder.descPersonaje.setText(listaPersonajes.get(position).getInfo());
        holder.fotoPersonaje.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView nombrePersonaje, descPersonaje;
        ImageView fotoPersonaje;

        public ViewHolderPersonajes(View itemView) {
            super(itemView);

            nombrePersonaje = (TextView) itemView.findViewById(R.id.nombrePersonaje);
            descPersonaje = (TextView) itemView.findViewById(R.id.descPersonaje);
            fotoPersonaje = (ImageView) itemView.findViewById(R.id.fotoPersonaje);
        }
    }
}
