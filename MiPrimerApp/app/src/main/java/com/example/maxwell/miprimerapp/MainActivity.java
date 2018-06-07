package com.example.maxwell.miprimerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText)findViewById(R.id.txt_num1);
        txt2 = (EditText)findViewById(R.id.txt_num2);
        res = (TextView)findViewById(R.id.txt_resultado);
    }

    //Este metodo realiza la suma
    public void SumaValores(View view){
        String valor1 = txt1.getText().toString();
        String valor2 = txt2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        int suma = num1 + num2;

        String result = String.valueOf(suma);
        res.setText(result);
    }
}
