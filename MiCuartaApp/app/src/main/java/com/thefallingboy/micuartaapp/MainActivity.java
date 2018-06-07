package com.thefallingboy.micuartaapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private RadioButton rb1, rb2, rb3, rb4;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et_valor1);
        et2 = (EditText)findViewById(R.id.et_valor2);

        rb1 = (RadioButton)findViewById(R.id.rb_sumar);
        rb2 = (RadioButton)findViewById(R.id.rb_restar);
        rb3 = (RadioButton)findViewById(R.id.rb_multi);
        rb4 = (RadioButton)findViewById(R.id.rb_div);

        tv1 = (TextView)findViewById(R.id.tv_resultado);
    }

    public void Calcular(View view){
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());

        int resultado = 0;

        if(rb1.isChecked()){
            resultado = valor1 + valor2;
            tv1.setText(String.valueOf(resultado));
        }else if (rb2.isChecked()){
            resultado = valor1 - valor2;
            tv1.setText(String.valueOf(resultado));
        }else if (rb3.isChecked()){
            resultado = valor1 * valor2;
            tv1.setText(String.valueOf(resultado));
        }else if (rb4.isChecked()){
            if (valor2 == 0){
                Toast toast = Toast.makeText(getApplicationContext(), "No se puede dividir entre cero", Toast.LENGTH_LONG);
                toast.show();
            }else{
                resultado = valor1 / valor2;
                tv1.setText(String.valueOf(resultado));
            }
        }
    }
}
