package com.thefallingboy.quintaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txt_valor1, txt_valor2;
    private CheckBox cb_Sumar, cb_Restar;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_valor1 = (EditText)findViewById(R.id.txt_valo1);
        txt_valor2 = (EditText)findViewById(R.id.txt_valor2);
        cb_Sumar = (CheckBox)findViewById(R.id.cb_Sumar);
        cb_Restar = (CheckBox)findViewById(R.id.cb_Restar);
        tv_resultado = (TextView)findViewById(R.id.tv_resultado);
    }

    public void Calcular(View view){
        int valor1 = Integer.parseInt(txt_valor1.getText().toString());
        int valor2 = Integer.parseInt(txt_valor2.getText().toString());

        String resultado = "";

        if (cb_Sumar.isChecked()) {
            int suma = valor1 + valor2;
            resultado = "La suma es: " + suma;
        }
        if (cb_Restar.isChecked() && !cb_Sumar.isChecked()){
            int resta = valor1 - valor2;
            resultado = "La resta es:" + resta;
        }else if (cb_Restar.isChecked()){
            int resta = valor1 - valor2;
            resultado = resultado + "\n La resta es: " + resta;
        }

        tv_resultado.setText(resultado);
    }
}
