package com.thefallingboy.ahorroapp;

public class Ahorro {

    private int CodigoAhorro = 0;
    private String nombreAhorro;
    private int cantidadPorAhorrar = 0;
    private int cantidadAhorrada = 0;
    private int cantidadAhorrarPorDia = 0;

    public Ahorro(int _codigoAhorro,
                  String _nombreAhorro,
                  int _cantidadPorAhorrar,
                  int _cantidadAhorrada,
                  int _cantidadAhorrarPorDia){
        CodigoAhorro = _codigoAhorro;
        nombreAhorro = _nombreAhorro;
        cantidadPorAhorrar = _cantidadPorAhorrar;
        cantidadAhorrada = _cantidadAhorrada;
        cantidadAhorrarPorDia = _cantidadAhorrarPorDia;
    }

    public int getCodigoAhorro() {
        return CodigoAhorro;
    }

    public void setCodigoAhorro(int codigoAhorro) {
        CodigoAhorro = codigoAhorro;
    }

    public String getNombreAhorro() {
        return nombreAhorro;
    }

    public void setNombreAhorro(String nombreAhorro) {
        this.nombreAhorro = nombreAhorro;
    }

    public int getCantidadPorAhorrar() {
        return cantidadPorAhorrar;
    }

    public void setCantidadPorAhorrar(int cantidadPorAhorrar) {
        this.cantidadPorAhorrar = cantidadPorAhorrar;
    }

    public int getCantidadAhorrada() {
        return cantidadAhorrada;
    }

    public void setCantidadAhorrada(int cantidadAhorrada) {
        this.cantidadAhorrada = cantidadAhorrada;
    }

    public int getCantidadAhorrarPorDia() {
        return cantidadAhorrarPorDia;
    }

    public void setCantidadAhorrarPorDia(int cantidadAhorrarPorDia) {
        this.cantidadAhorrarPorDia = cantidadAhorrarPorDia;
    }
}
