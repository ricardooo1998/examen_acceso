package com.tema3.ricardo.tema3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBAdapter {
    private static final String DATABASE_NAME = "dbad3b.db";
    private static final String DATABASE_TABLE_ALUMNOS = "alumnos";
    private static final String DATABASE_TABLE_PROFESORES = "profesores";
    private static final int DATABASE_VERSION = 1;


    private static final String a_nombre = "a_nombre";
    private static final String a_edad = "a_edad";
    private static final String a_ciclo = "a_ciclo";
    private static final String a_curso = "a_curso";

    private static final String p_nombre = "p_nombre";
    private static final String p_edad = "p_edad";
    private static final String p_ciclo = "p_ciclo";
    private static final String p_curso = "p_curso";
    private static final String p_despacho = "p_despacho";


    private static final String DATABASE_CREATE_ALUMNOS = "CREATE TABLE "+DATABASE_TABLE_ALUMNOS+" (_id integer primary key autoincrement, a_nombre text, a_edad text, a_ciclo text, a_curso text);";
    private static final String DATABASE_CREATE_PROFESORES = "CREATE TABLE "+DATABASE_TABLE_PROFESORES+" (_id integer primary key autoincrement, p_nombre text, p_edad text, p_ciclo text, p_curso text, p_despacho text);";
    private static final String DATABASE_DROP_ALUMNOS = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ALUMNOS+";";
    private static final String DATABASE_DROP_PROFESORES = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ALUMNOS+";";

    private final Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarAlumno(String nombre, String edad, String ciclo, String curso){
        ContentValues newValues = new ContentValues();
        newValues.put(a_nombre, nombre);
        newValues.put(a_edad, edad);
        newValues.put(a_ciclo, ciclo);
        newValues.put(a_curso, curso);
        db.insert(DATABASE_TABLE_ALUMNOS,null,newValues);
    }

    public void insertarProfesor(String nombre, String edad, String ciclo, String curso, String despacho){
        ContentValues newValues = new ContentValues();
        newValues.put(p_nombre, nombre);
        newValues.put(p_edad, edad);
        newValues.put(p_ciclo, ciclo);
        newValues.put(p_curso, curso);
        newValues.put(p_despacho, despacho);
        db.insert(DATABASE_TABLE_PROFESORES,null,newValues);
    }


    public ArrayList<String> recuperarAlumnos(){
        ArrayList<String> alumnos = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }


    public ArrayList<String> recuperarAlumnosPorCiclo(String ciclo){
        ArrayList<String> alumnos = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS,null,"a_ciclo='"+ciclo+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }
    public ArrayList<String> recuperarAlumnosPorCurso(String curso){
        ArrayList<String> alumnos = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS,null,"a_curso='"+curso+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }
    public ArrayList<String> recuperarProfesores(){
        ArrayList<String> profesores = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE_PROFESORES,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                profesores.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" ");
            }while (cursor.moveToNext());
        }
        return profesores;
    }


    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_ALUMNOS);
            db.execSQL(DATABASE_CREATE_PROFESORES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP_ALUMNOS);
            db.execSQL(DATABASE_DROP_PROFESORES);
            onCreate(db);
        }

    }
}
