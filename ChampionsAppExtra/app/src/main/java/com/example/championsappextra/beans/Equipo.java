package com.example.championsappextra.beans;

public class Equipo {

    private int id;
    private String nombreEquipo;
    private String estado;
    private String nombreEstadio;
    private Entrenador entrenador;
    private Jugador[] jugadores;
    private int escudo;
    private int estadio;

    public Equipo(int id, String nombreEquipo, String estado, String nombreEstadio, Entrenador entrenador, Jugador[] jugadores, int escudo, int estadio) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.nombreEstadio = nombreEstadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.escudo = escudo;
        this.estadio = estadio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getEstadio() {
        return estadio;
    }

    public void setEstadio(int estadio) {
        this.estadio = estadio;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
}
