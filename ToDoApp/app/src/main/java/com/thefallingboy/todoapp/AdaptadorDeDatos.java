package com.thefallingboy.todoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorDeDatos
        extends RecyclerView.Adapter<AdaptadorDeDatos.ViewHolderDatos>
            implements View.OnClickListener{

    ArrayList<Tarea> ListaDeTareas;
    private View.OnClickListener listener;

    public AdaptadorDeDatos(ArrayList<Tarea> ListaDeTareas){
        this.ListaDeTareas = ListaDeTareas;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tarea, parent, false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.TituloTarea.setText(ListaDeTareas.get(position).getTituloTarea());
        holder.ContenidoTarea.setText(ListaDeTareas.get(position).getContenido());
    }

    @Override
    public int getItemCount() {
        return ListaDeTareas.size();
    }

    public void setOnClickListenner(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView TituloTarea, ContenidoTarea;

        public ViewHolderDatos(View itemView) {
            super(itemView);


            TituloTarea = (TextView)itemView.findViewById(R.id.TituloTarea);
            ContenidoTarea = (TextView)itemView.findViewById(R.id.Contenido);
        }
    }
}
