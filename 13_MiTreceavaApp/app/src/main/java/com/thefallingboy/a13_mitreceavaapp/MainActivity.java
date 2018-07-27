package com.thefallingboy.a13_mitreceavaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_datos = (EditText)findViewById(R.id.txt_datos);

    }

    public void GuardarDatos(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Editor = preferencias.edit();
        Obj_Editor.putString(nombre, datos);
        Obj_Editor.commit();

        Toast.makeText(this, "El contacto a sido guardado", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View view){
        String nombre = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if (datos.length() == 0){
            Toast.makeText(this, "Este contacto no existe", Toast.LENGTH_SHORT).show();
        } else {
            et_datos.setText(datos);
        }
    }
}
