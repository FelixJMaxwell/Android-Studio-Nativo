package com.thefallingboy.sextaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et_valor1, et_valor2;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor1 = (EditText)findViewById(R.id.et_valor1);
        et_valor2 = (EditText)findViewById(R.id.et_valor2);
        tv_resultado = (TextView)findViewById(R.id.tv_resultado);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        String[] opciones = { "Sumar", "Restar", "Multiplicar", "Dividir"};

        //Cambiado el spinner por uno de creacion propia.
        //se agrega un nuevo layout en la carpeta layout ubicada en RES
        //formato nombre: spinner_item_NombreIdentificador
        //del archivo xml se borra todo el codigo excepto la primer linea
        ArrayAdapter <String> adapter = new ArrayAdapter<String>( this, R.layout.spinner_item_s01, opciones );
        spinner1.setAdapter(adapter);
    }

    public void Calcular(View view){
        int valor1 = Integer.parseInt(et_valor1.getText().toString());
        int valor2 = Integer.parseInt(et_valor2.getText().toString());
        int resultado = 0;
        String seleccion = spinner1.getSelectedItem().toString();

        if (seleccion.equals("Sumar")){
            resultado = valor1 + valor2;
            tv_resultado.setText(String.valueOf(resultado));
        }else if (seleccion.equals("Restar")){
            resultado = valor1 - valor2;
            tv_resultado.setText(String.valueOf(resultado));
        }else if (seleccion.equals("Multiplicar")){
            resultado = valor1 * valor2;
            tv_resultado.setText(String.valueOf(resultado));
        }else if (seleccion.equals("Dividir")){
            if (valor2 == 0){
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }else{
                resultado = valor1 / valor2;
                tv_resultado.setText(String.valueOf(resultado));
            }
        }
    }
}
