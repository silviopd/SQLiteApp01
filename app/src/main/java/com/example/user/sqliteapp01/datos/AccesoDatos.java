package com.example.user.sqliteapp01.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 15/09/2016.
 */

public class AccesoDatos extends SQLiteOpenHelper {

    private static String nombreBD="bdEmpresa";
    private static int versionBD=1;

    /*Referenciar la aplicación donde se instalará la BD*/
    public static Context aplicacion;

    private static String tablaDepartamento="create table departamento(codigo_departamento INTEGER PRIMARY KEY,nombre varchar(100))";
    private static String tablaDepartamentoDatos[]={
     "insert into departamento values (1,'FINANZA')","insert into departamento values (2,'COMERCIAL')"
    };


    private static String tablaArea="create table area(codigo_area  INTEGER PRIMARY KEY,codigo_departamento INTEGER ,nombre varchar(100),FOREIGN KEY(codigo_departamento) references departamento(codigo_departamento))";
    private static String tablaAreaDatos[]={
            "insert into area values (1,1,'CONTABILIDAD')",
            "insert into area values (2,1,'TESORERIA')",
            "insert into area values (3,1,'AUDITORIA CONTABLE')",
            "insert into area values (4,1,'TRIBUTACION')",

            "insert into area values (5,2,'VENTAS')",
            "insert into area values (6,2,'MARKETING')",
            "insert into area values (7,2,'CANALES DE DISTRIBUCION')",
            "insert into area values (8,2,'CAJA')",
    };

    public AccesoDatos(){
        super(aplicacion,nombreBD,null,versionBD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    /*Se ejecuta cuando la aplicación es intalada y cargada por primera vez (1 sola vez)*/
        db.execSQL(tablaDepartamento);
        db.execSQL(tablaArea);

        for (int i = 0; i < tablaDepartamentoDatos.length; i++) {
            db.execSQL(tablaDepartamentoDatos[i]);
        }

        for (int i = 0; i < tablaAreaDatos.length; i++) {
            db.execSQL(tablaAreaDatos[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
