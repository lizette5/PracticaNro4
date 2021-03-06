package com.example.practicanro4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.practicanro4.MainActivity.ESTUDIANTE_CUI;
import static com.example.practicanro4.MainActivity.ESTUDIANTE_NOMBRE;


public class registro_Alumno extends AppCompatActivity {
    EditText nombre;
    EditText CUI;
    Button hecho,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__alumno);

        nombre = findViewById(R.id.nombreEstudiante);
        CUI = findViewById(R.id.cuiEstudiante);
        hecho = findViewById(R.id.registroHecho);
        cancelar=findViewById(R.id.registroHecho2);

        hecho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String nombre2 = nombre.getText().toString();
                String cui2 = CUI.getText().toString();
                intent.putExtra(ESTUDIANTE_NOMBRE, nombre2);
                intent.putExtra(ESTUDIANTE_CUI, cui2);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
}
