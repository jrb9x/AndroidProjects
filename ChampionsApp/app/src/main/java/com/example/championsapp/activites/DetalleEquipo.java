package com.example.championsapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.championsapp.R;
import com.example.championsapp.adapters.AdaptadorJugadores;
import com.example.championsapp.beans.Entrenador;
import com.example.championsapp.beans.Equipo;
import com.example.championsapp.beans.Jugador;
import com.example.championsapp.beans.Partido;
import com.example.championsapp.repositories.Repositorio;

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

    private void getEntrenador(final Equipo detalleEquipo) {
        final Entrenador entrenador = detalleEquipo.getEntrenador();

        nombreEntrenador = (TextView) findViewById(R.id.txt2);
        imagenEntrenador = (ImageView) findViewById(R.id.imagen_entrenador);
        nombreEntrenador.setText(entrenador.getNombre());
        imagenEntrenador.setImageResource(entrenador.getImagen());
        imagenEntrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleEquipo.this,DetalleEntrenador.class);
                intent.putExtra("idEntrnador", entrenador.getId());
                intent.putExtra("nombreEquipo",detalleEquipo.getNombreEquipo());
                intent.putExtra("escudoEquipo",detalleEquipo.getEscudo());
                startActivity(intent);
            }
        });
    }

    private void getJugadores(Equipo detalleEquipo) {
        Jugador[] jugadores = detalleEquipo.getJugadores();

        AdaptadorJugadores adaptadorJugadores = new AdaptadorJugadores(this,jugadores);

        GridView gridView = (GridView) findViewById(R.id.grid_jugadores);
        gridView.setAdapter(adaptadorJugadores);
    }
}

