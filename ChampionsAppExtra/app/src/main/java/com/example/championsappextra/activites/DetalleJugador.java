package com.example.championsappextra.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsappextra.R;
import com.example.championsappextra.beans.Jugador;
import com.example.championsappextra.repositories.Repositorio;

public class DetalleJugador extends AppCompatActivity {

    private ImageView imagenJugador, escudo;

    private TextView nombreEquipo, nombreJugador, dorsal, posicion, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_jugador);

        Intent intent = getIntent();
        int idJugador = intent.getIntExtra("idJugador", 1);
        String equipo = intent.getStringExtra("nombreEquipo");
        int idEscudo = intent.getIntExtra("escudoEquipo", 1);

        Repositorio repositorio = new Repositorio();

        Jugador jugador = repositorio.getJugador(idJugador);

        imagenJugador = (ImageView)findViewById(R.id.imageJugador);
        escudo = (ImageView)findViewById(R.id.escudo);

        imagenJugador.setImageResource(jugador.getImagen());
        escudo.setImageResource(idEscudo);

        nombreEquipo = (TextView)findViewById(R.id.textEquipo);
        nombreJugador = (TextView)findViewById(R.id.textNombre);
        dorsal = (TextView)findViewById(R.id.textDorsal);
        posicion = (TextView)findViewById(R.id.textPosicion);
        edad = (TextView)findViewById(R.id.textEdad);

        nombreEquipo.setText(equipo);
        nombreJugador.setText(jugador.getNombre());
        dorsal.setText(""+jugador.getDorsal());
        posicion.setText(jugador.getPosicion());
        edad.setText(""+jugador.getEdad());

    }
}
