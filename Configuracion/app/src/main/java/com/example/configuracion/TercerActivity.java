package com.example.configuracion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TercerActivity extends AppCompatActivity {

    private Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        String email = getIntent().getStringExtra("email");
        String privacidad = getIntent().getStringExtra("privacidad");
        String bateria = getIntent().getStringExtra("bateria");
        String tema = getIntent().getStringExtra("tema");
        String tono = getIntent().getStringExtra("tono");
        String opcionRed = getIntent().getStringExtra("red");

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        if(privacidad.equals("Activado"))
            textView10.setTextColor(0xFF00FF00);
        else
            textView10.setTextColor(0xffff0000);
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        if(bateria.equals("Activado"))
            textView11.setTextColor(0xFF00FF00);
        else
            textView11.setTextColor(0xffff0000);
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        TextView textView15 = (TextView) findViewById(R.id.textView15);
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        LinearLayout relativeLayout = (LinearLayout) findViewById(R.id.activity_tercer);
        if(tema.equals("Gold"))
            relativeLayout.setBackgroundColor(0xffE8AF13);
        else if (tema.equals("Blue"))
            relativeLayout.setBackgroundColor(0xff00CFFF);
        else if (tema.equals("Light"))
            relativeLayout.setBackgroundColor(Color.WHITE);

        textView4.setText("Bienvenid@ " + nombreUsuario);
        textView7.setText(email);
        textView10.setText(privacidad);
        textView11.setText(bateria);
        textView14.setText(opcionRed);
        textView15.setText(tono);
        textView16.setText(tema);

        inicio = (Button) findViewById(R.id.button);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TercerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
