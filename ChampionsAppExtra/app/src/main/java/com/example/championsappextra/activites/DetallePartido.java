package com.example.championsappextra.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsappextra.R;
import com.example.championsappextra.beans.Equipo;
import com.example.championsappextra.beans.Partido;
import com.example.championsappextra.repositories.Repositorio;

public class DetallePartido extends AppCompatActivity {

    private ImageView imagenEstadio;
    private TextView nombreEstadio;

    private ImageButton escudoLocal;
    private TextView nombreLocal;
    private TextView estadoLocal;
    private TextView entrenadorLocal;

    private ImageButton escudoVisitante;
    private TextView nombreVisitante;
    private TextView estadoVisitante;
    private TextView entrenadorVisitante;

    private String equipo, entrenador, estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_partido);

        Intent intent = getIntent();
        int idPartido = intent.getIntExtra("idPartido", 2);

        Repositorio repositorio = new Repositorio();
        Partido partido = repositorio.getPartido(idPartido);

        getEstadio(partido);
        getEquipoLocal(partido);
        getEquipoVisitante(partido);
    }

    public void getEstadio(Partido partido){
        nombreEstadio = (TextView) findViewById(R.id.nombre_estadio);
        imagenEstadio = (ImageView) findViewById(R.id.imagen_estadio);

        nombreEstadio.setText(partido.getEquipoLocal().getNombreEstadio());
        imagenEstadio.setImageResource(partido.getEquipoLocal().getEstadio());
    }

    public void getEquipoLocal(Partido partido) {
        final Equipo equipoLocal = partido.getEquipoLocal();

        escudoLocal =(ImageButton) findViewById(R.id.boton_equipo_local);
        escudoLocal.setImageResource(equipoLocal.getEscudo());

        nombreLocal = (TextView) findViewById(R.id.nombre_equipo_local);
        nombreLocal.setText(equipoLocal.getNombreEquipo());

        entrenadorLocal = (TextView) findViewById(R.id.entrenador_local);
        entrenadorLocal.setText("Entrenador: " + equipoLocal.getEntrenador().getNombre());

        estadoLocal = (TextView) findViewById(R.id.estado_local);
        estadoLocal.setText("Estado: " + equipoLocal.getEstado());

        escudoLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetallePartido.this, DetalleEquipo.class);
                intent.putExtra("idEquipo", equipoLocal.getId());
                startActivity(intent);
            }
        });
    }

    public void getEquipoVisitante(Partido partido) {
        final Equipo equipoVisitante = partido.getEquipoVisitante();

        escudoVisitante = (ImageButton) findViewById(R.id.boton_equipo_visitante);
        escudoVisitante.setImageResource(equipoVisitante.getEscudo());

        nombreVisitante = (TextView) findViewById(R.id.nombre_visitante);
        nombreVisitante.setText(equipoVisitante.getNombreEquipo());

        entrenadorVisitante = (TextView) findViewById(R.id.entrenador_visitante);
        entrenadorVisitante.setText("Entrenador: " + equipoVisitante.getEntrenador().getNombre());

        estadoVisitante = (TextView) findViewById(R.id.estado_visitante);
        estadoVisitante.setText("Estado: " + equipoVisitante.getEstado());

        escudoVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetallePartido.this, DetalleEquipo.class);
                intent.putExtra("idEquipo", equipoVisitante.getId());
                startActivity(intent);
            }
        });
    }
}
