package com.thefallingboy.calculadora;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView tvRes;
    private EditText tvPant;
    private float resultado = 0;
    private boolean Inicio = false, NewOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicio = false;

        tvPant = (EditText) findViewById(R.id.pantalla);
        tvRes = (TextView)findViewById(R.id.resultado);

        DefinirBotones();
    }

    public void DefinirBotones(){
        findViewById(R.id.button1).setOnClickListener(BtnClickListener);
        findViewById(R.id.button2).setOnClickListener(BtnClickListener);
        findViewById(R.id.button3).setOnClickListener(BtnClickListener);
        findViewById(R.id.button4).setOnClickListener(BtnClickListener);
        findViewById(R.id.button5).setOnClickListener(BtnClickListener);
        findViewById(R.id.button6).setOnClickListener(BtnClickListener);
        findViewById(R.id.button7).setOnClickListener(BtnClickListener);
        findViewById(R.id.button8).setOnClickListener(BtnClickListener);
        findViewById(R.id.button9).setOnClickListener(BtnClickListener);
        findViewById(R.id.button0).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonAC).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonB).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonDividir).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonSumar).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonMenos).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonMultiplo).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonIgual).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonPorcentaje).setOnClickListener(BtnClickListener);
        findViewById(R.id.buttonPunto).setOnClickListener(BtnClickListener);
    }

    private View.OnClickListener BtnClickListener = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            if (Inicio == false){
                Inicio = true;
                tvPant.setText("");
            }

            if (NewOperation){
                NewOperation = false;
                tvPant.setText("");
            }

            switch(v.getId()){
                case R.id.button1:
                    tvPant.setText(tvPant.getText() + "1");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button2:
                    tvPant.setText(tvPant.getText() + "2");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button3:
                    tvPant.setText(tvPant.getText() + "3");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button4:
                    tvPant.setText(tvPant.getText() + "4");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button5:
                    tvPant.setText(tvPant.getText() + "5");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button6:
                    tvPant.setText(tvPant.getText() + "6");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button7:
                    tvPant.setText(tvPant.getText() + "7");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button8:
                    tvPant.setText(tvPant.getText() + "8");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button9:
                    tvPant.setText(tvPant.getText() + "9");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.button0:
                    tvPant.setText(tvPant.getText() + "0");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonSumar:
                    tvPant.setText(tvPant.getText() + " + ");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonMenos:
                    tvPant.setText(tvPant.getText() + " - ");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonMultiplo:
                    tvPant.setText(tvPant.getText() + " * ");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonDividir:
                    tvPant.setText(tvPant.getText() + " / ");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonB:
                    tvPant.setText("BACK");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonAC:
                    Inicio = false;
                    tvPant.setText("0");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonPorcentaje:
                    tvPant.setText(tvPant.getText() + " % ");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonPunto:
                    tvPant.setText(tvPant.getText()+ ".");
                    tvPant.setSelection(tvPant.getText().length());
                    break;
                case R.id.buttonIgual:
                    NewOperation = true;
                    Calcular(tvPant.getText().toString());
                    break;
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Calcular(String _Operacion){
        String[] partes = _Operacion.split(" ");
        int suma = 0, resta = 0, mult = 0, div = 0;
        for (int i = 0; i < partes.length; i++){
            if (partes[i].equals("+")){
                suma++;
            }
            if (partes[i].equals("-")){
                resta++;
            }
            if (partes[i].equals("*")){
                mult++;
            }
            if (partes[i].equals("/")){
                div++;
            }
            if (partes[i].equals("%")){
                porcentaje(_Operacion);
                return;
            }

            Operacion(_Operacion, div, mult, resta, suma);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Operacion(String _TextoPantalla, int divs, int mults, int restas, int sumas){
        String[] partes = _TextoPantalla.split(" ");
        float operando1 = 0, operando2 = 0;
        float resultadoOperacion = 0;

        if (divs >= 1){
            for (int e = 0; e < divs; e++){
                for (int j = 0; j < partes.length; j++){
                    if (partes[j] != null && partes[j].equals("/")){
                        operando1 = Float.parseFloat(partes[j-1]);
                        operando2 = Float.parseFloat(partes[j+1]);
                        resultadoOperacion = operando1 / operando2;
                        partes[j-1] = String.valueOf(resultadoOperacion);
                        partes[j+1] = null;
                        partes[j] = null;
                    }

                    partes = Arrays.stream(partes)
                            .filter(s -> (s != null && s.length() > 0))
                            .toArray(String[]::new);
                }
            }
        }
        if (mults >= 1){
            for (int e = 0; e < mults; e++){
                for (int j = 0; j < partes.length; j++){
                    if (partes[j] != null && partes[j].equals("*")){
                        operando1 = Float.parseFloat(partes[j-1]);
                        operando2 = Float.parseFloat(partes[j+1]);
                        resultadoOperacion = operando1 * operando2;
                        partes[j-1] = String.valueOf(resultadoOperacion);
                        partes[j+1] = null;
                        partes[j] = null;
                    }

                    partes = Arrays.stream(partes)
                            .filter(s -> (s != null && s.length() > 0))
                            .toArray(String[]::new);
                }
            }
        }
        if (restas >= 1){
            for (int e = 0; e < restas; e++){
                for (int j = 0; j < partes.length; j++){
                    if (partes[j] != null && partes[j].equals("-")){
                        operando1 = Float.parseFloat(partes[j-1]);
                        operando2 = Float.parseFloat(partes[j+1]);
                        resultadoOperacion = operando1 - operando2;
                        partes[j-1] = String.valueOf(resultadoOperacion);
                        partes[j+1] = null;
                        partes[j] = null;
                    }

                    partes = Arrays.stream(partes)
                            .filter(s -> (s != null && s.length() > 0))
                            .toArray(String[]::new);
                }
            }
        }
        if (sumas >= 1){
            for (int e = 0; e < sumas; e++){
                for (int j = 0; j < partes.length; j++){
                    if (partes[j] != null && partes[j].equals("+")){
                        operando1 = Float.parseFloat(partes[j-1]);
                        operando2 = Float.parseFloat(partes[j+1]);
                        resultadoOperacion = operando1 + operando2;
                        partes[j-1] = String.valueOf(resultadoOperacion);
                        partes[j+1] = null;
                        partes[j] = null;
                    }

                    partes = Arrays.stream(partes)
                            .filter(s -> (s != null && s.length() > 0))
                            .toArray(String[]::new);
                }
            }
        }

        for (int m = 0; m < partes.length; m++){
            tvRes.setText(partes[m]);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void porcentaje(String _TextoPantalla){
        String[] partes = _TextoPantalla.split(" ");
        float operando1 = 0, operando2 = 0;
        float resultadoOperacion = 0;

        for (int j = 0; j < partes.length; j++){
            if (partes[j] != null && partes[j].equals("%")){
                operando1 = Float.parseFloat(partes[j-1]);
                operando2 = Float.parseFloat(partes[j+1]);
                resultadoOperacion = (operando1 / 100) * operando2;
                partes[j-1] = String.valueOf(resultadoOperacion);
                partes[j+1] = null;
                partes[j] = null;
            }

            partes = Arrays.stream(partes)
                    .filter(s -> (s != null && s.length() > 0))
                    .toArray(String[]::new);
        }

        for (int m = 0; m < partes.length; m++){
            tvRes.setText(partes[m]);
        }
    }
}
