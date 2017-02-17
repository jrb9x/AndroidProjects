package com.example.championsappextra.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.championsappextra.R;
import com.example.championsappextra.adapters.AdaptadorJugadores;
import com.example.championsappextra.beans.Entrenador;
import com.example.championsappextra.beans.Equipo;
import com.example.championsappextra.beans.Jugador;
import com.example.championsappextra.repositories.Repositorio;

public class DetalleEquipo extends AppCompatActivity {

    private TextView nombreEquipo;
    private ImageView escudoEquipo;
    private TextView nombreEstadio;
    private TextView nombreEntrenador;
    private ImageView imagenEntrenador;
    private ScrollView scrollView;
    private GridView gridJugador;

    private String club;
    private int idEscudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipo);

        Intent intent = getIntent();
        int idEquipo = intent.getIntExtra("idEquipo", 4);

        Repositorio repositorio = new Repositorio();

        Equipo equipo = repositorio.getEquipo(idEquipo);

        club = equipo.getNombreEquipo();
        idEscudo = equipo.getEscudo();

        getEquipo(equipo);
        getEscudo(equipo);
        getEntrenador(equipo);
        getJugadores(equipo);

        gridJugador = (GridView)findViewById(R.id.grid_jugadores);
        gridJugador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Jugador jugador = (Jugador)parent.getItemAtPosition(position);
                Intent intent = new Intent(DetalleEquipo.this, DetalleJugador.class);
                intent.putExtra("idJugador",jugador.getId());
                intent.putExtra("nombreEquipo",club);
                intent.putExtra("escudoEquipo",idEscudo);
                startActivity(intent);
            }
        });

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }

    private void getEquipo(Equipo detalleEquipo) {
        nombreEquipo = (TextView) findViewById(R.id.textView);
        nombreEstadio = (TextView) findViewById(R.id.textView4);
        nombreEquipo.setText(detalleEquipo.getNombreEquipo());
        nombreEstadio.setText(detalleEquipo.getNombreEstadio());
    }

    private void getEscudo(Equipo detalleEquipo){
        escudoEquipo = (ImageView) findViewById(R.id.imagen_escudo);
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

