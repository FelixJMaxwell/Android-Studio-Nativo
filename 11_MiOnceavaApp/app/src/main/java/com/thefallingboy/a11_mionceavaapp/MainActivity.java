package com.thefallingboy.a11_mionceavaapp;

import android.content.Intent;
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

        et1 = (EditText) findViewById(R.id.txt_web);
    }

    public void Navegar(View view){
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("direccionWeb", et1.getText().toString());
        startActivity(i);
    }
}
