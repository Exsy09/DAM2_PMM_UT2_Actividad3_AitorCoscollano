package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data.Frases;
import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data.FrasesDAO;
import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.net.HttpUtils;
import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.ui.FrasesAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button btnDescargar, btnMostrar, btnEliminar;
    private RecyclerView recyclerView;
    private FrasesAdapter adapter;
    private FrasesDAO dao;
    private boolean visible = false;

    @Override
    protected void onCreate(Bundle saveInstanceStace){
        super.onCreate(saveInstanceStace);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnDescargar = findViewById(R.id.btnDescargar);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnEliminar = findViewById(R.id.btnEliminar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.GONE);

        dao = new FrasesDAO(this);
        dao.abrir();

        btnDescargar.setOnClickListener(v -> {
            new Thread(() ->{
                Frases frases = HttpUtils.descargarFrase();
                if (frases != null){
                    dao.insertarFrase(frases);
                }
            }).start();
        });

        btnMostrar.setOnClickListener(v -> {
            if (!visible){
                ArrayList<Frases> listaFrases = dao.obtenerFrases();
                adapter = new FrasesAdapter(listaFrases);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
                btnMostrar.setText("Ocultar Frases");
                visible = true;
            } else {
                recyclerView.setVisibility(View.GONE);
                btnMostrar.setText("Mostrar Frases");
                visible = false;
            }
        });

        btnEliminar.setOnClickListener(v -> {
            dao.eliminarFrases();
            recyclerView.setAdapter(null);
        });
    }

    @Override
    protected void onDestroy(){
        dao.cerrar();
        super.onDestroy();
    }
}