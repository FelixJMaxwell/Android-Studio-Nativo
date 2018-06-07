package com.thefallingboy.misegundaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvStatus;
    EditText et1;
    EditText et2;
    EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_matematicas);
        et2 = (EditText)findViewById(R.id.txt_fisica);
        et3 = (EditText)findViewById(R.id.txt_quimica);

        tvStatus = (TextView)findViewById(R.id.tv_status);
    }

    public void evaluarAlumno(View view){
        String matematicas_string = et1.getText().toString();
        String fisica_string = et2.getText().toString();
        String quimica_string = et3.getText().toString();

        int matematica_int = Integer.parseInt(matematicas_string);
        int fisica_int = Integer.parseInt(fisica_string);
        int quimica_int = Integer.parseInt(quimica_string);

        int resul = (matematica_int + fisica_int + quimica_int)/3;

        if (resul >= 7){
            tvStatus.setText("Estado del alumno: Aprovado" + resul);
        }else if (resul < 7){
            tvStatus.setText("Estado del alumno: Reprovado" + resul);
        }
    }
}
