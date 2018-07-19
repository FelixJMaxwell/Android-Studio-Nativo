package com.thefallingboy.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DefinirBotones();
    }

    public void DefinirBotones(){
        findViewById(R.id.button1).setOnClickListener(BtnClickListenner);
        findViewById(R.id.button2).setOnClickListener(BtnClickListenner);
        findViewById(R.id.button3).setOnClickListener(BtnClickListenner);
    }

    private View.OnClickListener BtnClickListenner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    Toast.makeText(MainActivity.this, "Button 1 pressed", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    Toast.makeText(MainActivity.this, "Button 2 pressed", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button3:
                    Toast.makeText(MainActivity.this, "Button 3 pressed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
