package com.thefallingboy.todoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditTask extends AppCompatActivity {

    private EditText TituloTarea;
    String dato_titulo;
    int dato_codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        TituloTarea = findViewById(R.id.et_titulotarea);

        dato_codigo = getIntent().getIntExtra("CodigoTarea", 0);
        dato_titulo = getIntent().getStringExtra("TituloTarea");

        TituloTarea.setText(dato_titulo);
    }

    public void EditTarea(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        final SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        int codigo = getIntent().getIntExtra("CodigoTarea", 0);
        String titulo = TituloTarea.getText().toString();

        if (!titulo.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigotarea", dato_codigo);
            registro.put("titulotarea", titulo);

            BaseDeDatos.update("tareas", registro, "codigotarea=" + dato_codigo, null);
            BaseDeDatos.close();

            Intent mainAct = new Intent(this, MainActivity.class);
            startActivity(mainAct);

        }else{
            Toast.makeText(this, "No puede haber campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
}
