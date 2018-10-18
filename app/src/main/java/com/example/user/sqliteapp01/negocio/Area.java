package com.example.user.sqliteapp01.negocio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.sqliteapp01.datos.AccesoDatos;

import java.util.ArrayList;

/**
 * Created by USER on 15/09/2016.
 */
public class Area extends AccesoDatos {

    private int codigoArea;
    private int codigoDepartamento;
    private String nombre;

    public static ArrayList<Area> listaAre = new ArrayList<Area>();

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void cargarDatosArea(int codigoDepartamento){
        SQLiteDatabase bd = this.getReadableDatabase();
        String sql = "select * from area where codigo_departamento="+codigoDepartamento+" order by 2";
        Cursor resultado = bd.rawQuery(sql,null);

        listaAre.clear();

        while(resultado.moveToNext()){
            Area objAre = new Area();
            objAre.setCodigoArea(resultado.getInt(0));
            objAre.setNombre(resultado.getString(2));
            listaAre.add(objAre);
        }
    }

    public String[] listaArea(int codigoDepartamento){
        cargarDatosArea(codigoDepartamento);

        String listaNombresAreas[] = new String[listaAre.size()];

        for (int i = 0; i < listaAre.size(); i++) {
            Area item = listaAre.get(i);
            listaNombresAreas[i] = item.getNombre();
        }

        return listaNombresAreas;
    }
}
