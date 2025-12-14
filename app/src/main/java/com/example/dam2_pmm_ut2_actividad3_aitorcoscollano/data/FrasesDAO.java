package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FrasesDAO{

    private SQLiteDatabase db;
    private FrasesDBHelper dbHelper;

    public FrasesDAO(Context context){
        dbHelper = new FrasesDBHelper(context);
    }

    public void abrir(){
        db = dbHelper.getWritableDatabase();
    }

    public void cerrar(){
        dbHelper.close();
    }

    public void insertarFrase(Frases frases){
        ContentValues values = new ContentValues();
        values.put(FrasesDBHelper.COL_FRASE, frases.getFrase());
        values.put(FrasesDBHelper.COL_AUTOR, frases.getAutor());
        db.insert(FrasesDBHelper.DATABASE_TABLA, null, values);
    }

    public ArrayList<Frases> obtenerFrases(){
        ArrayList<Frases> listaFrases = new ArrayList<>();

        Cursor cursor = db.query(
                FrasesDBHelper.DATABASE_TABLA,
                null,
                null,
                null,
                null,
                null,
                FrasesDBHelper.COL_ID + " DESC"
        );

        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(FrasesDBHelper.COL_ID));
                String frase = cursor.getString(cursor.getColumnIndexOrThrow(FrasesDBHelper.COL_FRASE));
                String autor = cursor.getString(cursor.getColumnIndexOrThrow(FrasesDBHelper.COL_AUTOR));

                listaFrases.add(new Frases(id, frase, autor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaFrases;
    }

    public void eliminarFrases(){
        db.delete(FrasesDBHelper.DATABASE_TABLA, null, null);
    }
}
