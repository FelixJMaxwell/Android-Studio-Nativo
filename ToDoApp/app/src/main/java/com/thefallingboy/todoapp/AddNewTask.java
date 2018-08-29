package com.thefallingboy.todoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewTask extends AppCompatActivity {

    public EditText TituloTarea, ContenidoTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        TituloTarea = (EditText)findViewById(R.id.et_TituloTarea);
        ContenidoTarea = (EditText)findViewById(R.id.et_contTarea);
    }

    public void OnClickAddTask(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String tituloTarea = TituloTarea.getText().toString();
        String contenidoTarea = ContenidoTarea.getText().toString();

        if (!tituloTarea.isEmpty() && !contenidoTarea.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("titulotarea", tituloTarea);
            registro.put("contenidotarea", contenidoTarea);

            BaseDeDatos.insert("tareas", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Tarea registrada", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(this, "Deber rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
