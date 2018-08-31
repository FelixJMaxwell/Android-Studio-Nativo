package com.thefallingboy.todoapp;

public class Tarea {

    private int CodigoTarea;
    private String TituloTarea;

    public Tarea(int codigoTarea, String tituloTarea) {
        CodigoTarea = codigoTarea;
        TituloTarea = tituloTarea;
    }

    public int getCodigoTarea(){
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
}
