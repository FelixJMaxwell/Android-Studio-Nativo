package com.thefallingboy.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewTask extends AppCompatActivity {

    public EditText TituloTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        TituloTarea = (EditText)findViewById(R.id.et_TituloTarea);
        TituloTarea.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void OnClickAddTask(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String tituloTarea = TituloTarea.getText().toString();

        if (!tituloTarea.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("titulotarea", tituloTarea);

            BaseDeDatos.insert("tareas", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Tarea registrada", Toast.LENGTH_SHORT).show();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(this, "Deber rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
