package com.thefallingboy.todoapp;

public class Tarea {

    private int CodigoTarea;
    private String TituloTarea;
    private String Contenido;

    public Tarea(int codigoTarea, String tituloTarea, String contenido) {
        CodigoTarea = codigoTarea;
        TituloTarea = tituloTarea;
        Contenido = contenido;
    }

    public int getCogidoTarea(){
        return CodigoTarea;
    }

    public void setCodigoTarea(int codigoTarea){
        CodigoTarea = codigoTarea;
    }

    public String getTituloTarea() {
        return TituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        TituloTarea = tituloTarea;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }
}
