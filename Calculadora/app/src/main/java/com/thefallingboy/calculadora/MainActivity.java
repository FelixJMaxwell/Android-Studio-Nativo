package com.thefallingboy.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvPant;

    private float resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPant = (TextView)findViewById(R.id.pantalla);

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

                    break;
                case R.id.buttonPunto:
                    tvPant.setText(tvPant.getText()+ ".");
                    break;
            }
        }
    };
}
