package com.thefallingboy.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tarea> ListaDeTareas;
    RecyclerView listaPrincipal;

    private String SelectedCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDeTareas = new ArrayList<Tarea>();
        listaPrincipal = findViewById(R.id.listaPrincipal);
        listaPrincipal.setLayoutManager(new LinearLayoutManager(this));

        BuscarTareasPrevias();
    }

    public void AgregarTareaBtn(View view){

        Intent i = new Intent(this, AddNewTask.class);
        startActivity(i);
    }

    public void RemoverTareaBtn(String codigo){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        final SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        SelectedCode = codigo;

        if (!SelectedCode.isEmpty()){
            BaseDeDatos.delete("tareas", "codigotarea=" + SelectedCode,null);
            recreate();
        }else{
            Toast.makeText(this, "No hay un codigo seleccionado", Toast.LENGTH_SHORT).show();
        }
    }

    public void BuscarTareasPrevias(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        final SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery( "SELECT * FROM tareas", null );
        try{
            while(fila.moveToNext()) {
                ListaDeTareas.add(new Tarea(fila.getInt(0), fila.getString(1)));

                AdaptadorDeDatos adaptador = new AdaptadorDeDatos(ListaDeTareas, new AdaptadorDeDatos.AdapterListener() {
                    @Override
                    public void buttonOnClick(View v, int position) {
                        RemoverTareaBtn(String.valueOf(ListaDeTareas.get(position).getCodigoTarea()));
                    }
                });

                adaptador.setOnClickListenner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent editTarea = new Intent(MainActivity.this, EditTask.class);

                        editTarea.putExtra("CodigoTarea",
                                ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getCodigoTarea());
                        editTarea.putExtra("TituloTarea",
                                ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getTituloTarea());

                        startActivity(editTarea);
                    }
                });
                listaPrincipal.setAdapter(adaptador);
            }
        } finally{
            fila.close();
            BaseDeDatos.close();
        }
    }
}
