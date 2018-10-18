package com.example.user.sqliteapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user.sqliteapp01.datos.AccesoDatos;
import com.example.user.sqliteapp01.negocio.Area;
import com.example.user.sqliteapp01.negocio.Departamento;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spDepartamento,spArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDepartamento = (Spinner) findViewById(R.id.spDepartamento);
        spArea = (Spinner) findViewById(R.id.spArea);

        AccesoDatos.aplicacion = this;

        cargarDatosSpinnerDepartamento();

        spDepartamento.setOnItemSelectedListener(this);
    }

    private void cargarDatosSpinnerDepartamento(){
        String listaDepartamento[] = new Departamento().listaDespartamento();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,listaDepartamento);

        spDepartamento.setAdapter(adapter);
    }

    private void cargarDatosSpinnerArea(int codigoDepartamento){
        String listaArea[] = new Area().listaArea(codigoDepartamento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,listaArea);

        spArea.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.spDepartamento:
                int dep = Departamento.listaDep.get(i).getCodigoDepartamento();
                cargarDatosSpinnerArea(dep);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
