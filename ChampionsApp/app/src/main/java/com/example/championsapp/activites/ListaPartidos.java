package com.example.championsapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.championsapp.R;
import com.example.championsapp.adapters.AdaptadorPartidos;
import com.example.championsapp.beans.Partido;
import com.example.championsapp.repositories.Repositorio;

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
