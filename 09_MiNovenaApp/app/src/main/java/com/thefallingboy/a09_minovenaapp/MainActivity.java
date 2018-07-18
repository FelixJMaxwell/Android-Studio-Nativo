package com.thefallingboy.a09_minovenaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_password = (EditText)findViewById(R.id.txt_password);
    }

    public void Registrar(View view){
        String nombre = et_nombre.getText().toString();
        String password = et_password.getText().toString();

        if (nombre.length() == 0){
            Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if (password.length() == 0){
            Toast.makeText(this, "Debes ingresar una contraseña", Toast.LENGTH_LONG).show();
        }
        if (nombre.length() != 0 && password.length() != 0){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show();
        }
    }
}
