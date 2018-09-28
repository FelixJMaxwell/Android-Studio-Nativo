package com.thefallingboy.ahorroapp;

import android.app.Dialog;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AhorroProyecto extends AppCompatActivity {

    private SeekBar barra;

    private TextView tv_CantMax, tv_AhorroXDia, tv_CantAhorro, tv_diasFaltantes, tv_fechaFinal;

    Integer valor = 100, cantidadAhorrar = 0;

    Calendar calendario;
    Date fechaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahorroproyecto_layout);

        tv_CantMax       = findViewById(R.id.tv_cantMaximaBarra);
        tv_AhorroXDia    = findViewById(R.id.tv_CantAhorroPorDia);
        tv_CantAhorro    = findViewById(R.id.tv_CantAhorro);
        tv_diasFaltantes = findViewById(R.id.tv_CantDiasFaltantes);
        tv_fechaFinal    = findViewById(R.id.tv_fechaFinal);

        barra = findViewById(R.id.barraDinero);
        barra.setMax(valor);
        barra.setProgress(0);
        barra.setOnSeekBarChangeListener(new barraListener());

        calendario = Calendar.getInstance();
        fechaActual = calendario.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd '/' MMMM '/' yyyy", new Locale("ES"));
        tv_fechaFinal.setText(format.format(fechaActual));

        cantidadAhorrar = Integer.parseInt(tv_CantAhorro.getText().toString());

        tv_CantMax.setText(valor.toString());

        tv_CantAhorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditAhorroDialog();
            }
        });
    }

    public void showEditAhorroDialog(){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.editahorrolayout, null);

        final EditText et_nuevoAhorro = alertLayout.findViewById(R.id.et_nuevoAhorro);
        final Button btnAceptar = alertLayout.findViewById(R.id.AceptarAhorroBtn);
        final Button btnCancelar = alertLayout.findViewById(R.id.CancelAhorroBtn);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);

        final AlertDialog dialog = alert.create();
        dialog.show();

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_nuevoAhorro.getText().toString().isEmpty()){
                    cantidadAhorrar = Integer.parseInt(et_nuevoAhorro.getText().toString());
                    tv_CantAhorro.setText(et_nuevoAhorro.getText().toString());
                    dialog.dismiss();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void cambiarValores(Integer _ahorro){
        Integer resultadoDivision = cantidadAhorrar / _ahorro;

        calendario = Calendar.getInstance();

        calendario.add(Calendar.DAY_OF_MONTH, resultadoDivision);
        fechaActual = calendario.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd '/' MMMM '/' yyyy", new Locale("ES"));
        tv_fechaFinal.setText(format.format(fechaActual));

        tv_diasFaltantes.setText(resultadoDivision.toString());
        tv_AhorroXDia.setText("$" + _ahorro);
    }

    private class barraListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (progress == 0) { return; }
            cambiarValores(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    public void AhorrarBtn(View view){
        Log.d("AHORRAR BTN", "hoy ahorre");
    }
}
