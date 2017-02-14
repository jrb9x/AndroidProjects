package com.example.configuracion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AdaptadorTitulares extends ArrayAdapter<Titular> {
    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.lista_titulares, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.lista_titulares, null);

        TextView lblTitulo =
                (TextView) itemView.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblSubtitulo =
                (TextView) itemView.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(getItem(position).getSubtitulo());

        return (itemView);
    }
}
