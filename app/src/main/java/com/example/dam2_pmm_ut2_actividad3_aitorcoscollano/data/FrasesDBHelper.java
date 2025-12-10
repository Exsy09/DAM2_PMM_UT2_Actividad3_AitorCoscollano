package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jspecify.annotations.Nullable;

public class FrasesDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBRE = "frases.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLA = "t_frases";

    public FrasesDBHelper(@Nullable Context context){
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String creatorQuery = "CREATE TABLE " + DATABASE_TABLA + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "autor TEXT NOT NULL," +
                "frase TEXT NOT NULL)";
        db.execSQL(creatorQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE " + DATABASE_TABLA);
        onCreate(db);
    }
}
