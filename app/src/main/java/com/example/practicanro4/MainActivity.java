package com.example.practicanro4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.*;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nombres;
    private EditText CUI;
    private ListView lv1;
    private Button registro;
    private Button modificar;
    int Seleccionado=0;
    private ArrayList <String> alumnos2 =  new ArrayList<String>();
    private ArrayList <String> CUIS2 =  new ArrayList<String>();

    public static final int REQUEST_CODE = 2;
    public static final int REQUEST_CODE_EDIT = 3;
    public static final String ESTUDIANTE_NOMBRE = "nombre";
    public static final String ESTUDIANTE_CUI = "cui";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres = (EditText)findViewById(R.id.nombreEstudiante);
        CUI = (EditText)findViewById(R.id.cuiEstudiante);
        lv1 = (ListView)findViewById(R.id.ListView1);
        registro = (Button)findViewById(R.id.sendregistro);
        modificar = (Button)findViewById(R.id.modificar);

        ArrayAdapter <String> adapter = new ArrayAdapter<String >(this, R.layout.list_item_alumnos,alumnos2);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nombres.setText(alumnos2.get(position));
                CUI.setText(CUIS2.get(position));
                Seleccionado = position;
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), registro_Alumno.class), REQUEST_CODE);
            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), editar_alumno.class), REQUEST_CODE_EDIT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                alumnos2.add(data.getStringExtra(ESTUDIANTE_NOMBRE));
                CUIS2.add(data.getStringExtra(ESTUDIANTE_CUI));//cambiar al arrayList de cuis
            }else if (resultCode == RESULT_CANCELED){

            }

        }else if(requestCode == REQUEST_CODE_EDIT){
            if(resultCode == RESULT_OK){
                alumnos2.set(Seleccionado,data.getStringExtra(ESTUDIANTE_NOMBRE));
                CUIS2.set(Seleccionado,data.getStringExtra(ESTUDIANTE_CUI));//cambiar al arrayList de cuis
                renovar();
            }else if (resultCode == RESULT_CANCELED){

            }

        }
    }
    public void renovar(){
        ArrayAdapter <String> adapter = new ArrayAdapter<String >(this, R.layout.list_item_alumnos,alumnos2);
        lv1.setAdapter(adapter);
        nombres.setText(alumnos2.get(Seleccionado));
        CUI.setText(CUIS2.get(Seleccionado));
    }
}
