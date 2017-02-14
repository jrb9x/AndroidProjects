package com.example.championsapp.dao;

import com.example.championsapp.beans.Equipo;
import com.example.championsapp.beans.Partido;

public class Repository {

    private Equipo[] equipo;
    private Partido[] partido;

    public void listaEquipos(){
        equipo[0] = new Equipo("F.C. Barcelona","@mipmap/ic_fcb","Camp Nou","Luis Enrique",
                "");
        equipo[1] = new Equipo("Real Madrid","@mipmap/ic_fcb","Santiago Bernabeu","Zinedine Zidane",
                "");
        equipo[2] = new Equipo("Arsenal F.C.","@mipmap/ic_fcb","Emirates Stadium","Arsène Wenger",
                "");
        equipo[3] = new Equipo("Bayern de Múnich","@mipmap/ic_fcb","Allianz Arena","Carlo Ancelotti",
                "");
        equipo[4] = new Equipo("S. L. Benfica","@mipmap/ic_fcb","Da Luz","Rui Vitória",
                "");
        equipo[5] = new Equipo("Borussia Dortmund","@mipmap/ic_fcb","Signal Iduna Park","Thomas Tuchel",
                "");
        equipo[6] = new Equipo("S.S.C. Napoli","@mipmap/ic_fcb","San Paolo","Maurizio Sarri",
                "");
        equipo[7] = new Equipo("París Saint-Germain","@mipmap/ic_fcb","Parc des Princes","Unai Emery",
                "");
    }

    private void listaPartidos(){
        partido[0] = new Partido(equipo[0], equipo[7], "14/02/2017", "20:45");
        partido[1] = new Partido(equipo[4], equipo[5], "14/02/2017", "20:45");
        partido[2] = new Partido(equipo[1], equipo[6], "15/02/2017", "20:45");
        partido[3] = new Partido(equipo[3], equipo[2], "15/02/2017", "20:45");
    }

}
