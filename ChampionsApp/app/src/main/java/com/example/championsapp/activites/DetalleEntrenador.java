package com.example.championsapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsapp.R;
import com.example.championsapp.beans.Entrenador;
import com.example.championsapp.repositories.Repositorio;

public class DetalleEntrenador  extends AppCompatActivity {

    private ImageView imagenEntrenador, escudo;

    private TextView nombreEquipo, nombreEntrenador,  edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);

        Intent intent = getIntent();
        int idEntrenador = intent.getIntExtra("idEntrnador", 1);
        String equipo = intent.getStringExtra("nombreEquipo");
        int idEscudo = intent.getIntExtra("escudoEquipo", 1);

        Repositorio repositorio = new Repositorio();

        Entrenador entrenador = repositorio.getEntrenador(idEntrenador);

        imagenEntrenador = (ImageView)findViewById(R.id.imageEntrenador);
        escudo = (ImageView)findViewById(R.id.escudo);

        imagenEntrenador.setImageResource(entrenador.getImagen());
        escudo.setImageResource(idEscudo);

        nombreEquipo = (TextView)findViewById(R.id.textEquipo);
        nombreEntrenador = (TextView)findViewById(R.id.textNombre);
        edad = (TextView)findViewById(R.id.textEdad);

        nombreEquipo.setText(equipo);
        nombreEntrenador.setText(entrenador.getNombre());
        edad.setText(""+entrenador.getEdad());
    }
}
