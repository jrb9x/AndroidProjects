package com.example.championsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.championsapp.R;
import com.example.championsapp.beans.Equipo;
import com.example.championsapp.beans.Partido;

public class AdaptadorPartidos extends ArrayAdapter<Partido> {

    public AdaptadorPartidos(Context context, Partido[] datos) {
        super(context, R.layout.formato_lista_partidos, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.formato_lista_partidos, null);

        ImageView imagenLocal = (ImageView) itemView.findViewById(R.id.imagen_local);
        TextView nombreLocal = (TextView) itemView.findViewById(R.id.equipo_local);

        TextView fecha = (TextView) itemView.findViewById(R.id.fecha);
        TextView hora = (TextView) itemView.findViewById(R.id.hora);

        TextView nombreVisitante = (TextView) itemView.findViewById(R.id.equipo_visitante);
        ImageView imagenVisitante = (ImageView) itemView.findViewById(R.id.imagen_visitante);

        Partido partido = getItem(position);


        Equipo equipoLocal = partido.getEquipoLocal();
        imagenLocal.setImageResource(equipoLocal.getEscudo());

        fecha.setText(partido.getFechaPartido());
        hora.setText(partido.getHoraPartido());

        Equipo equipoVisitante = partido.getEquipoVisitante();
        imagenVisitante.setImageResource(equipoVisitante.getEscudo());

        nombreLocal.setText(equipoLocal.getNombreEquipo());
        nombreVisitante.setText(equipoVisitante.getNombreEquipo());

        return (itemView);
    }
}
