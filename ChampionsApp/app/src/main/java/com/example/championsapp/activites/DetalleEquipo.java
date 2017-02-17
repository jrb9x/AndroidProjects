package com.example.championsapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsapp.R;
import com.example.championsapp.adapters.AdaptadorJugadores;
import com.example.championsapp.beans.Entrenador;
import com.example.championsapp.beans.Equipo;
import com.example.championsapp.beans.Jugador;
import com.example.championsapp.repositories.Repositorio;

public class DetalleEquipo extends AppCompatActivity {

    private TextView nombreEquipo;
    private ImageView escudoEquipo;
    private TextView nombreEntrenador;
    private ImageView imagenEntrenador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipo);

        Intent intent = getIntent();
        int idEquipo = intent.getIntExtra("idEquipo", 4);

        Repositorio repositorio = new Repositorio();

        Equipo equipo = repositorio.getEquipo(idEquipo);

        getEquipo(equipo);
        getEntrenador(equipo);
        getJugadores(equipo);

    }

    private void getEquipo(Equipo detalleEquipo) {
        nombreEquipo = (TextView) findViewById(R.id.textView);
        escudoEquipo = (ImageView) findViewById(R.id.imageView3);
        nombreEquipo.setText(detalleEquipo.getNombreEquipo());
        escudoEquipo.setImageResource(detalleEquipo.getEscudo());
    }


    private void getEntrenador(Equipo detalleEquipo) {
        final Entrenador entrenador = detalleEquipo.getEntrenador();

        nombreEntrenador = (TextView) findViewById(R.id.txt2);
        imagenEntrenador = (ImageView) findViewById(R.id.imagen_entrenador);
        nombreEntrenador.setText(entrenador.getNombre());
        imagenEntrenador.setImageResource(entrenador.getImagen());

    }

    private void getJugadores(Equipo detalleEquipo) {
        Jugador[] jugadores = detalleEquipo.getJugadores();

        AdaptadorJugadores adaptadorJugadores = new AdaptadorJugadores(this,jugadores);

        GridView gridView = (GridView) findViewById(R.id.grid_jugadores);
        gridView.setAdapter(adaptadorJugadores);
    }
}

