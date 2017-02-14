package com.example.championsapp.beans;

public class Equipo {

    private String nombre;
    private String escudo;
    private String estadio;
    private String entrenador;
    private String estado;

    public Equipo() {}

    public Equipo(String nombre, String escudo, String estadio, String entrenador, String estado) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
