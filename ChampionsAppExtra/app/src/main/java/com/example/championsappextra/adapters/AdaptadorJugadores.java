package com.example.championsappextra.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsappextra.R;
import com.example.championsappextra.beans.Jugador;

public class AdaptadorJugadores extends ArrayAdapter<Jugador> {

    public AdaptadorJugadores(Context context, Jugador[] datos) {
        super(context, R.layout.formato_jugadores, datos);
    }

    public View getView(int position, View convertView, final ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView  = inflater.inflate(R.layout.formato_jugadores, null);

        ImageView imagenJugador = (ImageView) itemView.findViewById(R.id.imagen_jugador);
        TextView nombreDorsal = (TextView) itemView.findViewById(R.id.nombre_dorsal);

        final Jugador jugador = getItem(position);

        imagenJugador.setImageResource(jugador.getImagen());
        nombreDorsal.setText(jugador.getNombre() + " #"+jugador.getDorsal());

        return (itemView);
    }
}
