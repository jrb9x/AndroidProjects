package com.example.registrousuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewNombre, textViewEmail, textViewPassw, textViewSexo,
            textViewAficiones, textViewNacionalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombreUsuario = getIntent().getStringExtra("nombre");
        String email = getIntent().getStringExtra("email");
        String passw = getIntent().getStringExtra("passw");
        String sexo = getIntent().getStringExtra("sexo");
        String aficiones = getIntent().getStringExtra("aficiones");
        String nacionalidad = getIntent().getStringExtra("nacionalidad");

        textViewNombre = (TextView) findViewById(R.id.textNombre);
        textViewEmail = (TextView) findViewById(R.id.textEmail);
        textViewPassw = (TextView) findViewById(R.id.textPassw);
        textViewSexo = (TextView) findViewById(R.id.textSexo);
        textViewAficiones = (TextView) findViewById(R.id.textAficiones);
        textViewNacionalidad = (TextView) findViewById(R.id.textNacionalidad);

        textViewNombre.setText(nombreUsuario);
        textViewEmail.setText(email);
        textViewPassw.setText(passw);
        textViewSexo.setText(sexo);
        textViewAficiones.setText(aficiones);
        textViewNacionalidad.setText(nacionalidad);
    }
}
