package com.example.championsappextra.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.championsappextra.R;
import com.example.championsappextra.adapters.AdaptadorPartidos;
import com.example.championsappextra.beans.Partido;
import com.example.championsappextra.repositories.Repositorio;

public class ListaPartidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partidos);

        Repositorio repositorio = new Repositorio();

        final AdaptadorPartidos adaptador = new AdaptadorPartidos(this, repositorio.getPartidos());

        ListView lista = (ListView) findViewById(R.id.lista_partidos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Partido partido = (Partido)parent.getItemAtPosition(position);
                Intent intent = new Intent(ListaPartidos.this, DetallePartido.class);
                intent.putExtra("idPartido",partido.getId());
                startActivity(intent);
            }
        });
    }
}
