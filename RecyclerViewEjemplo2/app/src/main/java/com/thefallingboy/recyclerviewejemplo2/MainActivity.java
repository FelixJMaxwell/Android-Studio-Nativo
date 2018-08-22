package com.thefallingboy.recyclerviewejemplo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Personaje> listaPersonajes;
    RecyclerView listaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajes = new ArrayList<Personaje>();
        listaPrincipal = findViewById(R.id.listaPrincipal);
        listaPrincipal.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();

        AdaptadorPersonajes adaptador = new AdaptadorPersonajes(listaPersonajes);
        listaPrincipal.setAdapter(adaptador);
    }

    private void llenarPersonajes() {
        listaPersonajes.add(new Personaje("Ahri", "La Vastaya de Nueve Colas", R.drawable.ahri));
        listaPersonajes.add(new Personaje("Annie", "La Hija de la Oscuridad", R.drawable.annie));
        listaPersonajes.add(new Personaje("Ashe", "La Arquera de Hielo", R.drawable.ashe));
        listaPersonajes.add(new Personaje("Caytlin", "La Sheriff de Piltóver", R.drawable.caytlin));
        listaPersonajes.add(new Personaje("Jinx", "La Bala Perdida", R.drawable.jinx));
        listaPersonajes.add(new Personaje("Lux", "La Dama Luminosa", R.drawable.lux));
        listaPersonajes.add(new Personaje("Miss Fortune", "La Cazarrecompensas", R.drawable.missfortune));
        listaPersonajes.add(new Personaje("Nidalee", "La Cazadora Salvaje", R.drawable.nidalee));
        listaPersonajes.add(new Personaje("Poppy", "La Guardiana del Martillo", R.drawable.poppy));
        listaPersonajes.add(new Personaje("Sona", "La Virtuosa de las Cuerdas", R.drawable.sona));
        listaPersonajes.add(new Personaje("Xayah", "La Rebelde", R.drawable.xayah));
        listaPersonajes.add(new Personaje("Zoe", "El Aspecto del Crepúsculo", R.drawable.zoe));
    }
}
