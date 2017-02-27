package com.example.registrousuarios;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilNombre, tilPassw, tilPassw2;
    private boolean errorNombre, errorEmail, errorPassw, errorVerificacion;
    private EditText editTextNombre, editTextEmail, editTextPassw, editTextVePassw;
    private RadioGroup grbSexo;
    private CheckBox aficion1, aficion2, aficion3, aficion4;
    private Spinner spinner;
    private Button btnAceptar, btnCancelar;
    private String opcionSexo = "", aficiones ="", nacionalidad = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilEmail = (TextInputLayout) findViewById(R.id.TiLEmail);
        tilEmail.setErrorEnabled(true);
        tilNombre = (TextInputLayout) findViewById(R.id.TiLNombre);
        tilNombre.setErrorEnabled(true);
        tilPassw = (TextInputLayout) findViewById(R.id.TiLPassw);
        tilPassw.setErrorEnabled(true);
        tilPassw2 = (TextInputLayout) findViewById(R.id.TiLPassw2);
        tilPassw2.setErrorEnabled(true);

        editTextNombre = (EditText) findViewById(R.id.nombre);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassw = (EditText) findViewById(R.id.passw);
        editTextVePassw = (EditText) findViewById(R.id.passw2);

        grbSexo = (RadioGroup) findViewById(R.id.GrbSexo);
        grbSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        opcionSexo = "Hombre";
                        break;
                    case R.id.radioButton2:
                        opcionSexo = "Mujer";
                        break;
                }
            }
        });

        aficion1 = (CheckBox) findViewById(R.id.aficion1);
        aficion2 = (CheckBox) findViewById(R.id.aficion2);
        aficion3 = (CheckBox) findViewById(R.id.aficion3);
        aficion4 = (CheckBox) findViewById(R.id.aficion4);
        aficion1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aficiones += "Cine ";
                }
            }
        });
        aficion2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aficiones += "Musica ";
                }
            }
        });
        aficion3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aficiones += "Deportes ";
                }
            }
        });
        aficion4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aficiones += "Manualidades ";
                }
            }
        });
        /*
        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("española",R.mipmap.ic_espania));
        list.add(new ItemData("alemana",R.mipmap.ic_espania));
        list.add(new ItemData("inglesa",R.mipmap.ic_espania));
        list.add(new ItemData("francesa",R.mipmap.ic_espania));
        spinner=(Spinner)findViewById(R.id.spinner);
        SpinnerAdapter adapter=new SpinnerAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        spinner.setAdapter(adapter);
        */
        String[] listaNacionalidad = {"española","alemana","inglesa","francesa"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaNacionalidad);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nacionalidad = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                nacionalidad = "No se ha seleccionado nada";
            }
        });

        btnCancelar = (Button) findViewById(R.id.BtnCancelar);
        btnAceptar = (Button) findViewById(R.id.BtnAceptar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextEmail.setText("");
                editTextPassw.setText("");
                editTextVePassw.setText("");
                tilNombre.setError(null);
                tilEmail.setError(null);
                tilPassw.setError(null);
                tilPassw2.setError(null);
                grbSexo.check(R.id.radioButton);
                aficion1.setChecked(false);
                aficion2.setChecked(false);
                aficion3.setChecked(false);
                aficion4.setChecked(false);
                aficiones = "";
                int spinnerPosition = adapter.getPosition("española");
                spinner.setSelection(spinnerPosition);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = editTextNombre.getText().toString();
                if (nombreUsuario.length() < 4) {
                    tilNombre.setError("Error: Debe contener mas de 4 caracteres!");
                    errorNombre = true;
                } else {
                    tilNombre.setError(null);
                    errorNombre = false;
                }

                String email = editTextEmail.getText().toString();
                Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher vEmail = patronEmail.matcher(email);
                if (!vEmail.matches()) {
                    tilEmail.setError("Error: Email no tiene un formato valido!");
                    errorEmail = true;
                } else {
                    tilEmail.setError(null);
                    errorEmail = false;
                }

                String passw = editTextPassw.getText().toString();
                if (passw.length() < 6) {
                    tilPassw.setError("Error: Debe contener mas de 6 caracteres!");
                    errorPassw = true;
                } else {
                    tilPassw.setError(null);
                    errorPassw = false;
                }

                String passwVe = editTextVePassw.getText().toString();
                if (!passwVe.equals(passw)) {
                    tilPassw2.setError("Error: Las contraseñas no coinciden");
                    errorVerificacion = true;
                } else {
                    tilPassw2.setError(null);
                    errorVerificacion = false;
                }

                if(!errorNombre && !errorEmail && !errorPassw && !errorVerificacion) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("nombre", nombreUsuario);
                    intent.putExtra("email", email);
                    intent.putExtra("passw", passw);
                    intent.putExtra("sexo", opcionSexo);
                    intent.putExtra("aficiones", aficiones);
                    intent.putExtra("nacionalidad", nacionalidad);
                    startActivity(intent);
                }
            }
        });

    }
}
