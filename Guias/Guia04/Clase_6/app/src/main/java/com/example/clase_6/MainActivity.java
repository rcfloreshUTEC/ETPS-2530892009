package com.example.clase_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//elementos a utilizar
    Spinner spPais1, spPais2;
    TextView edtInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencia sobre los objetos dentro del layout
        spPais1=findViewById(R.id.spPais1);
        spPais2=findViewById(R.id.spPais2);
        edtInfo=findViewById(R.id.edtInfo);

        //arreglo
        String[]paises={"Seleccione un pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panama"};
        //Adaptador
        ArrayAdapter<String>adaptador1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,paises);
        //mostrar
        spPais1.setAdapter(adaptador1);
        spPais2.setAdapter(adaptador1);
    }
    public void guardar(View v){
        //variables
        String datos = "";
        String datos2= "";
        //obtener dato
        String seleccion1=spPais1.getSelectedItem().toString();
        String seleccion2=spPais2.getSelectedItem().toString();
        //condicional
        if (seleccion1.equals("Seleccione un pais")){
            Toast.makeText(this, "Seleccione un pais en el 1° listado por favor", Toast.LENGTH_LONG).show();
        } else if (seleccion1.equals("Guatemala")) {
            datos="Guatemala";
        } else if (seleccion1.equals("El Salvador")) {
            datos="El Salvador";
        } else if (seleccion1.equals("Honduras")) {
            datos="Honduras";
        } else if (seleccion1.equals("Nicaragua")) {
            datos="Nicaragua";
        } else if (seleccion1.equals("Costa Rica")) {
            datos="Costa Rica";
        } else if (seleccion1.equals("Panama")) {
            datos="Panama";
        }
        if (seleccion2.equals("Seleccione un pais")){
            Toast.makeText(this, "Seleccione un pais en el 2° listado por favor", Toast.LENGTH_LONG).show();
        } else if (seleccion2.equals("Guatemala")) {
            datos2="Guatemala";
        } else if (seleccion2.equals("El Salvador")) {
            datos2="El Salvador";
        } else if (seleccion2.equals("Honduras")) {
            datos2="Honduras";
        } else if (seleccion2.equals("Nicaragua")) {
            datos2="Nicaragua";
        } else if (seleccion2.equals("Costa Rica")) {
            datos2="Costa Rica";
        } else if (seleccion2.equals("Panama")) {
            datos2="Panama";
        }

        edtInfo.setText("\n"+datos+"\n"+datos2);
    }
}