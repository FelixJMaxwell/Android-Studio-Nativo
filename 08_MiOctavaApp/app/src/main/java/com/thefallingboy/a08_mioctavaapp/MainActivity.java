package com.thefallingboy.a08_mioctavaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensajeGeekipedia(View v){
        Toast.makeText(this, "La Geekipedia de Ernesto", Toast.LENGTH_SHORT).show();
    }

    public void mensajeMano(View v){
        Toast.makeText(this, "La mano de Ernesto", Toast.LENGTH_SHORT).show();
    }
}
