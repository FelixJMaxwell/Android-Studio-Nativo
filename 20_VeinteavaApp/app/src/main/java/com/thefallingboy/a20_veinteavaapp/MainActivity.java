package com.thefallingboy.a20_veinteavaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para poner el icono en el actionbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Seleccion(View view){
        switch(view.getId()){
            case R.id.fresas:
                Toast.makeText(this, "Estas son fresas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.peras:
                Toast.makeText(this, "Estas son peras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sandia:
                Toast.makeText(this, "Estas son sandias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zarzamora:
                Toast.makeText(this, "Estas son zarzamoras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.uvas:
                Toast.makeText(this, "Estas son uvas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cerezas:
                Toast.makeText(this, "Estas son cerezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pina:
                Toast.makeText(this, "Estas son piñas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.manzanas:
                Toast.makeText(this, "Estas son manzanas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.platanos:
                Toast.makeText(this, "Estas son platanos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.frambuezas:
                Toast.makeText(this, "Estas son frambuezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kiwis:
                Toast.makeText(this, "Estas son kiwis", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mangos:
                Toast.makeText(this, "Estas son mangos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.melon:
                Toast.makeText(this, "Estas son melon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.naranjas:
                Toast.makeText(this, "Estas son naranjas", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
