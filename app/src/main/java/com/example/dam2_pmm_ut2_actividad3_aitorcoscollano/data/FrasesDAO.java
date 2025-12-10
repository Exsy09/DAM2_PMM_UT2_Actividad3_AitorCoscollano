package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data;

import android.content.Context;

import org.jspecify.annotations.Nullable;

public class FrasesDAO extends FrasesDBHelper {

    private Context contexto;

    public FrasesDAO(@Nullable Context contexto){
        super(contexto);
        this.contexto = contexto;
    }
}
