package com.example.championsapp.dao;

import com.example.championsapp.R;
import com.example.championsapp.beans.Entrenador;
import com.example.championsapp.beans.Equipo;
import com.example.championsapp.beans.Jugador;
import com.example.championsapp.beans.Partido;

public class Repositorio {

    private Entrenador rui = new Entrenador(1, "Rui Vitória", 40, R.mipmap.ic_en_benfica, true);
    private Entrenador thomas = new Entrenador(2, "Thomas Tuchel", 40, R.mipmap.ic_en_dortmund, true);
    private Entrenador unai = new Entrenador(3, "Unai Emery", 40, R.mipmap.ic_en_psg, true);
    private Entrenador luis = new Entrenador(4, "Luis Enrique", 40, R.mipmap.ic_en_barcelona, true);
    private Entrenador carlo = new Entrenador(5, "Carlo Ancelotti", 40, R.mipmap.ic_en_bayern, true);
    private Entrenador arsene = new Entrenador(6, "Arsène Wenger", 40, R.mipmap.ic_en_arsenal, true);
    private Entrenador zidane = new Entrenador(7, "Zinedine Zidane", 40, R.mipmap.ic_en_madrid, true);
    private Entrenador sarri = new Entrenador(8, "Maurizio Sarri", 40, R.mipmap.ic_en_napoles, true);

    private Entrenador[] entrenadores = {rui, thomas, unai, luis, carlo, arsene, zidane, sarri};

    private Jugador stegen = new Jugador(1,"ter Stegen",24,R.mipmap.ic_bcn_stegen,1,"Portero");
    private Jugador pique = new Jugador(2,"Gerard Piqué",30,R.mipmap.ic_bcn_pique,3,"Defensa");
    private Jugador alba = new Jugador(3,"Jordi Alba",27,R.mipmap.ic_bcn_alba,18,"Defensa");
    private Jugador mathieu = new Jugador(4,"Jérémy Mathieu",33,R.mipmap.ic_bcn_mathieu,24,"Defensa");
    private Jugador roberto = new Jugador(5,"Sergi Roberto",25,R.mipmap.ic_bcn_sergi,20,"Defensa");
    private Jugador busquets = new Jugador(6,"Sergio Busquets",28,R.mipmap.ic_bcn_busquets,5,"Centrocampista");
    private Jugador iniesta = new Jugador(7,"Andres Iniesta",32,R.mipmap.ic_bcn_iniesta,8,"Centrocampista");
    private Jugador rakitic = new Jugador(8,"Ivan Rakitic",24,R.mipmap.ic_bcn_rakitic,1,"Centrocampista");
    private Jugador messi = new Jugador(9,"Lionel Messi",29,R.mipmap.ic_bcn_messi,10,"Delantero");
    private Jugador neymar = new Jugador(10,"Neymar",25,R.mipmap.ic_bcn_neymar,11,"Delantero");
    private Jugador suarez = new Jugador(11,"ter Stegen",30,R.mipmap.ic_bcn_suarez,9,"Delantero");

    private Jugador[] jugadores = {stegen,pique,alba,mathieu,roberto,busquets,iniesta,rakitic,messi,neymar,suarez};

    private Equipo benfica = new Equipo(1, "Benfica", "Motivados", "Estadio da Luz", rui, jugadores, R.mipmap.ic_benfica, R.mipmap.ic_est_campnou);
    private Equipo dortmund = new Equipo(2, "Dortmund", "Motivados", "Signal Iduna Park", thomas, jugadores, R.mipmap.ic_dortmund, R.mipmap.ic_est_campnou);

    private Equipo paris = new Equipo(3, "PSG", "Motivados", "Parc des Princes", unai, jugadores, R.mipmap.ic_psg, R.mipmap.ic_est_campnou);
    private Equipo barca = new Equipo(4, "Barcelona", "Motivados", "Camp Nou", luis, jugadores, R.mipmap.ic_fcb, R.mipmap.ic_est_campnou);

    private Equipo bayern = new Equipo(5, "Bayern", "Motivados", "Allianz Arena", carlo, jugadores, R.mipmap.ic_bayern, R.mipmap.ic_est_campnou);
    private Equipo arsenal = new Equipo(6, "Arsenal", "Motivados", "Emirates Stadium", arsene, jugadores, R.mipmap.ic_arsenal, R.mipmap.ic_est_campnou);

    private Equipo madrid = new Equipo(7, "Real Madrid", "Motivados", "Estadio Santiago Bernabéu", zidane, jugadores, R.mipmap.ic_realmadrid, R.mipmap.ic_est_campnou);
    private Equipo napoli = new Equipo(8, "Napoli", "Motivados", "Estadio San Paolo", sarri, jugadores, R.mipmap.ic_napoli, R.mipmap.ic_est_campnou);

    private Equipo[] equipos = {benfica, dortmund, paris, barca, bayern, arsenal, madrid, napoli};

    private Partido partido1 = new Partido(1, benfica, dortmund, "14/02", "20:45");
    private Partido partido2 = new Partido(2, paris, barca, "14/02", "20:45");

    private Partido partido4 = new Partido(3, madrid, napoli, "15/02", "20:45");
    private Partido partido3 = new Partido(4, bayern, arsenal, "15/02", "20:45");

    private Partido[] partidos = {partido1, partido2, partido3, partido4};


    public Equipo getEquipo(int id) {
        for (Equipo equipo : equipos) {
            if (equipo.getId() == id) {
                return equipo;
            }
        }
        return null;
    }

    public Jugador getJugador(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }

    public Entrenador getEntrenador(int id) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId() == id) {
                return entrenador;
            }
        }
        return null;
    }

    public Partido getPartido(int id) {
        for (Partido partido : partidos) {
            if (partido.getId() == id) {
                return partido;
            }
        }
        return null;
    }


}
