package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.R;
import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data.Frases;

import java.util.ArrayList;

public class FrasesAdapter extends RecyclerView.Adapter<FrasesAdapter.FrasesViewHolder> {

    ArrayList<Frases>listaFrases;

    public FrasesAdapter (ArrayList<Frases> listaFrases){
        this.listaFrases = listaFrases;
    }

    @NonNull
    @Override
    public FrasesAdapter.FrasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_frases, parent, false);
        return new FrasesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrasesViewHolder holder, int position) {
        Frases frase = listaFrases.get(position);
        holder.viewFrase.setText(listaFrases.get(position).getFrase());
        holder.viewAutor.setText(listaFrases.get(position).getAutor());
    }

    @Override
    public int getItemCount(){ return listaFrases.size();}

    public class FrasesViewHolder extends RecyclerView.ViewHolder{

        TextView viewFrase, viewAutor;
        public FrasesViewHolder(@NonNull View itemView){
            super(itemView);
            viewFrase = itemView.findViewById(R.id.viewFrase);
            viewAutor = itemView.findViewById(R.id.viewAutor);
        }

    }

}
