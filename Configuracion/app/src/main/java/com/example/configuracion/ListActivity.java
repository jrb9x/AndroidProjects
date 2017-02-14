package com.example.configuracion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_titulares);

        Titular[] titulares = new Titular[25];
        for (int i = 0; i < titulares.length; i++) {
            titulares[i] = new Titular("Titulo " + i, "Subtitulo " + i);
        }

        AdaptadorTitulares adapter = new AdaptadorTitulares(this, titulares);
        ListView lista = (ListView) findViewById(R.id.listitem_titular);
        lista.setAdapter(adapter);
    }
}
