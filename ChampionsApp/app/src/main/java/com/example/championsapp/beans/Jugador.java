package com.example.championsapp.beans;

public class Jugador extends Persona {

    private int dorsal;
    private String posicion;

    public Jugador(int id, String nombre, Integer edad, int idImagen, int dorsal, String posicion) {
        super(id, nombre, edad, idImagen);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
