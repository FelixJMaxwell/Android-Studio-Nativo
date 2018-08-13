package com.thefallingboy.calculadora;

import android.net.nsd.NsdManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.TextView;

import java.nio.file.attribute.AclEntryPermission;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView tvPant, tvRes;
    private float resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPant = (TextView)findViewById(R.id.pantalla);
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
            switch(v.getId()){
                case R.id.button1:
                    tvPant.setText(tvPant.getText() + "1");
                    break;
                case R.id.button2:
                    tvPant.setText(tvPant.getText() + "2");
                    break;
                case R.id.button3:
                    tvPant.setText(tvPant.getText() + "3");
                    break;
                case R.id.button4:
                    tvPant.setText(tvPant.getText() + "4");
                    break;
                case R.id.button5:
                    tvPant.setText(tvPant.getText() + "5");
                    break;
                case R.id.button6:
                    tvPant.setText(tvPant.getText() + "6");
                    break;
                case R.id.button7:
                    tvPant.setText(tvPant.getText() + "7");
                    break;
                case R.id.button8:
                    tvPant.setText(tvPant.getText() + "8");
                    break;
                case R.id.button9:
                    tvPant.setText(tvPant.getText() + "9");
                    break;
                case R.id.button0:
                    tvPant.setText(tvPant.getText() + "0");
                    break;
                case R.id.buttonSumar:
                    tvPant.setText(tvPant.getText() + " + ");
                    break;
                case R.id.buttonMenos:
                    tvPant.setText(tvPant.getText() + " - ");
                    break;
                case R.id.buttonMultiplo:
                    tvPant.setText(tvPant.getText() + " * ");
                    break;
                case R.id.buttonDividir:
                    tvPant.setText(tvPant.getText() + " / ");
                    break;
                case R.id.buttonB:
                    tvPant.setText("BACK");
                    break;
                case R.id.buttonAC:
                    tvPant.setText("");
                    break;
                case R.id.buttonPorcentaje:
                    tvPant.setText(tvPant.getText() + " % ");
                    break;
                case R.id.buttonIgual:
                    Calcular(tvPant.getText().toString());
                    break;
                case R.id.buttonPunto:
                    tvPant.setText(tvPant.getText()+ ".");
                    break;
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    public float Calcular(String _Operacion){
        String[] partes = _Operacion.split(" ");
        int suma = 0, resta = 0, mult = 0, div = 0;
        float operando1 = 0, operando2 = 0;
        float resultadoOperacion = 0;
        for (int i = 0; i < partes.length; i++){
            if (partes[i] != "+"){
                suma++;
            }
            if (partes[i] != "-"){
                resta++;
            }
            if (partes[i] != "*"){
                mult++;
            }
            if (partes[i] != "/"){
                div++;
            }

            if (div >= 1){
                for (int e = 0; e < div; e++){
                    for (int j = 0; j < partes.length; j++){
                        if (partes[j] != null && partes[j].equals("/")){
                            operando1 = Float.parseFloat(partes[j-1]);
                            operando2 = Float.parseFloat(partes[j+1]);
                            resultadoOperacion = operando1/operando2;
                            partes[j-1] = String.valueOf(resultadoOperacion);
                            partes[j+1] = null;
                            partes[j] = null;
                        }

                        partes = Arrays.stream(partes)
                                .filter(s -> (s != null && s.length() > 0))
                                .toArray(String[]::new);
                    }
                }

                for (int m = 0; m < partes.length; m++){
                    //System.out.print(partes[m] + " ");
                    //tvPant.setText(tvPant.getText() + partes[m]);
                    tvRes.setText(partes[m]);
                }
            }
            if (mult >= 1){
                for (int e = 0; e < mult; e++){
                    for (int j = 0; j< partes.length; j++){
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
                for (int m = 0; m < partes.length; m++){
                    //System.out.print(partes[m] + " ");
                    //tvPant.setText(tvPant.getText() + partes[m]);
                    tvRes.setText(partes[m]);
                }
            }
            if (resta >= 1){
                for (int e = 0; e < resta; e++){
                    for (int j = 0; j < partes.length; j++){
                        if (partes[j] != null && partes[j].equals("-")) {
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
                for (int m = 0; m < partes.length; m++){
                    //System.out.print(partes[m] + " ");
                    //tvPant.setText(tvPant.getText() + partes[m]);
                    tvRes.setText(partes[m]);
                }
            }
            if (suma >= 1){
                for (int e = 0; e < suma; e++){
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
                for (int m = 0; m < partes.length; m++){
                    //System.out.print(partes[m] + " ");
                    //tvPant.setText(tvPant.getText() + partes[m]);
                    tvRes.setText(partes[m]);
                }
            }
        }
        return resultado;
    }
}
