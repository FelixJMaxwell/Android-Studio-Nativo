package com.thefallingboy.todoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.MainThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.Closeable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tarea> ListaDeTareas;
    RecyclerView listaPrincipal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDeTareas = new ArrayList<Tarea>();
        RecyclerViewMarginItem decoration = new RecyclerViewMarginItem(15, 1);
        listaPrincipal = findViewById(R.id.listaPrincipal);
        listaPrincipal.addItemDecoration(decoration);
        listaPrincipal.setLayoutManager(new LinearLayoutManager(this));

        BuscarTareasPrevias();
    }

    public void AgregarTareaBtn(View view){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_agregar_tarea, null);
        LinearLayout container = (LinearLayout)mView.findViewById(R.id.ContainerDialog);
        final EditText TituloTarea = (EditText)mView.findViewById(R.id.TituloTarea);
        final EditText ContenidoTarea = (EditText)mView.findViewById(R.id.ContenidoTarea);
        Button addTaskDialogBtn = (Button)mView.findViewById(R.id.add_TaskBtn);

        addTaskDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TituloTarea.getText().toString().isEmpty() ||
                        ContenidoTarea.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                RegistrarTarea(TituloTarea.getText().toString(), ContenidoTarea.getText().toString());

                recreate();
            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    private void RegistrarTarea(String _TituloTarea, String _ContenidoTarea) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String tituloTarea = _TituloTarea;
        String contenidoTarea = _ContenidoTarea;

        if (!tituloTarea.isEmpty() && !contenidoTarea.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("titulotarea", tituloTarea);
            registro.put("contenidotarea", contenidoTarea);

            BaseDeDatos.insert("tareas", null, registro);

            BaseDeDatos.close();
            Toast.makeText(this, "Tarea registrada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Deber rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void BuscarTareasPrevias(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery( "SELECT * FROM tareas", null );
        try{
            while(fila.moveToNext()){
                ListaDeTareas.add(new Tarea(fila.getInt(0), fila.getString(1), fila.getString(2)));

                AdaptadorDeDatos adaptador = new AdaptadorDeDatos(ListaDeTareas);

                adaptador.setOnClickListenner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                getApplicationContext(),
                                "Codigo de la tarea: " + ListaDeTareas.get
                                        (listaPrincipal.getChildAdapterPosition(v)).getCogidoTarea(), Toast.LENGTH_SHORT).show();
                    }
                });

                listaPrincipal.setAdapter(adaptador);
            }
        } finally{
            fila.close();
        }
    }
}
