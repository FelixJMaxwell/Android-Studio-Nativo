package com.thefallingboy.a12_midoceavaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);

        SharedPreferences DatosGuardados = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        et1.setText(DatosGuardados.getString("mail", ""));
    }

    public void GuardarDatos(View view){
        SharedPreferences NuevosDatos = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = NuevosDatos.edit();
        Obj_editor.putString("mail", et1.getText().toString());
        Obj_editor.commit();
        finish();
    }
}
