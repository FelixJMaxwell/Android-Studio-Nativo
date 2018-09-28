package com.thefallingboy.ahorroapp;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Ahorro> ListaDeAhorros;
    RecyclerView listaPrincipal;

    private Integer contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDeAhorros = new ArrayList<Ahorro>();

        listaPrincipal = findViewById(R.id.listaPrincipal);
        listaPrincipal.setLayoutManager(new LinearLayoutManager(this));

        AgregarAhorros();
    }

    private void AgregarAhorros() {
        /*
        ListaDeAhorros.add(new Ahorro(1,
                "Algo que no necesito",
                10,
                10,
                10));
        ListaDeAhorros.add(new Ahorro(2,
                "Algo que igual quiero",
                10,
                10,
                10));
        ListaDeAhorros.add(new Ahorro(3,
                "Algo que pagare con dinero que no tengo",
                10,
                10,
                10));
        ListaDeAhorros.add(new Ahorro(4,
                "Prestamo para pagar otro prestamo",
                10,
                10,
                10));
        ListaDeAhorros.add(new Ahorro(5,
                "Botella de agua y un chicle",
                10,
                10,
                10));
                */

        AdaptadorDeDatos adaptador = new AdaptadorDeDatos(ListaDeAhorros);
        listaPrincipal.setAdapter(adaptador);
    }

    public void AddNewAhorro(View view){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_new_ahorro);

        final EditText et_nuevoAhorro = dialog.findViewById(R.id.et_nuevoAhorroCantidad);
        final EditText et_nombreNuevoAhorro = dialog.findViewById(R.id.et_nombreNewAhorro);
        final Button btn_AceptarAhorro = dialog.findViewById(R.id.btn_AceptarNewAhorro);
        final Button btn_CancelarAhorro = dialog.findViewById(R.id.btn_CancelarNewAhorro);

        dialog.show();

        btn_AceptarAhorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_nuevoAhorro.getText().toString().isEmpty()){
                    ListaDeAhorros.add(new Ahorro(
                            contador,
                            et_nombreNuevoAhorro.getText().toString(),
                            Integer.parseInt(et_nuevoAhorro.getText().toString()),
                            0,
                            10));
                    dialog.dismiss();
                }
            }
        });

        btn_CancelarAhorro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
