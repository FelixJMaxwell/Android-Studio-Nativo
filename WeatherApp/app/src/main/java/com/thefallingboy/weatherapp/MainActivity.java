package com.thefallingboy.weatherapp;

import android.os.StrictMode;
import android.renderscript.Matrix2f;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Spinner Spinner1;
    private TextView tv_ciudadpais, tv_temperatura, tv_climagral;
    private EditText et_nombreciudad, et_codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner1 = findViewById(R.id.Spinner1);
        tv_ciudadpais = findViewById(R.id.tv_ciudadpais);
        tv_temperatura = findViewById(R.id.tv_temperatura);
        tv_climagral = findViewById(R.id.tv_climagral);
        et_nombreciudad = findViewById(R.id.et_nombreCiudad);
        et_codigo = findViewById(R.id.et_codigopostal);

        String[] opciones = {"Escoge una opcion", "Codigo Postal", "Ciudad/Pais"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,opciones);
        Spinner1.setAdapter(adapter);

        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        et_nombreciudad.setEnabled(false);
                        et_codigo.setEnabled(false);
                        break;
                    case 1:
                        et_nombreciudad.setEnabled(false);
                        et_codigo.setEnabled(true);
                        break;
                    case 2:
                        et_nombreciudad.setEnabled(true);
                        et_codigo.setEnabled(false);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void checkClimate(View view){
        getData();
    }

    public void getData(){

        String apikey = "&appid=76cbc912cc2841e4230479edb865e374";
        String sql_cp = "http://api.openweathermap.org/data/2.5/weather?zip=";
        String sql_ciudad = "http://api.openweathermap.org/data/2.5/weather?q=";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            if (Spinner1.getSelectedItem().toString() == "Codigo Postal"){
                url = new URL(sql_cp + et_codigo.getText().toString() + apikey);
            }
            if (Spinner1.getSelectedItem().toString() == "Ciudad/Pais"){
                url = new URL(sql_ciudad + et_nombreciudad.getText().toString() + apikey);
            }

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONObject ObjetoPrincipal = new JSONObject(json);
            JSONObject ObjetoSecundario_main = ObjetoPrincipal.getJSONObject("main");
            JSONObject ObjetoSecundario_sys = ObjetoPrincipal.getJSONObject("sys");
            JSONArray Jarray = ObjetoPrincipal.getJSONArray("weather");
            JSONObject JObject = Jarray.getJSONObject(0);

            //Ciudad
            String Ciudad = ObjetoPrincipal.optString("name");
            String ClimaGral = JObject.optString("main");
            String Pais = ObjetoSecundario_sys.optString("country");
            float Temperatura = ObjetoSecundario_main.optInt("temp") - 273.15f;

            tv_ciudadpais.setText(Ciudad + "/" + Pais);
            tv_climagral.setText(ClimaGral);
            tv_temperatura.setText(Math.round(Temperatura) + "° C");

            System.out.println("Ciudad: " + Ciudad + "/" + Pais + " hay un clima: " +
                    ClimaGral + " la temperatura es de: " + Math.round(Temperatura) + "° Celsius");

        } catch (MalformedURLException e) {
            System.out.println("MALFORMED URL");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOEXECPTION");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON EXCEPTION");
            e.printStackTrace();
        }
    }
}