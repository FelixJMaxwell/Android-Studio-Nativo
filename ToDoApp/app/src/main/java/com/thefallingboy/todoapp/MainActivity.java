package com.thefallingboy.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tarea> ListaDeTareas;
    RecyclerView listaPrincipal;


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

        /*
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
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
        */
    }

    public void BuscarTareasPrevias(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tareas", null, 1);
        final SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery( "SELECT * FROM tareas", null );
        try{
            while(fila.moveToNext()){
                ListaDeTareas.add(new Tarea(fila.getInt(0), fila.getString(1), fila.getString(2)));

                AdaptadorDeDatos adaptador = new AdaptadorDeDatos(ListaDeTareas);

                adaptador.setOnClickListenner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //codigoTarea = String.valueOf(ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getCodigoTarea());
                        /*
                        Toast.makeText(MainActivity.this,
                                "Objeto seleccionado: " + ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getTituloTarea(),
                                Toast.LENGTH_SHORT).show();
                                */
                        /*
                        System.out.println("Codigo: " + ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getCodigoTarea()
                                + " Titulo: " + ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getTituloTarea()
                                + " Contenido: " + ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getContenido()
                        );
                        */

                        Intent editTarea = new Intent(MainActivity.this, EditTask.class);

                        editTarea.putExtra("CodigoTarea",
                                ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getCodigoTarea());
                        editTarea.putExtra("TituloTarea",
                                ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getTituloTarea());
                        editTarea.putExtra("ContenidoTarea",
                                ListaDeTareas.get(listaPrincipal.getChildAdapterPosition(v)).getContenido());

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
