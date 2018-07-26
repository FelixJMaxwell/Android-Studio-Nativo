package com.thefallingboy.a10_midecimaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et2 = (TextView) findViewById(R.id.tv1);
        String dato = getIntent().getStringExtra("dato");
        et2.setText("Hola " + dato);
    }

    public void Regresar(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
