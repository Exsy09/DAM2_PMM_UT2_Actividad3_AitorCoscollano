package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data;

public class Frases {

    private int id;
    private String frase;
    private String autor;

    public Frases(String frase, String autor){
        this.frase = frase;
        this.autor = autor;
    }
    public Frases(int id, String frase, String autor){
        this.id = id;
        this.frase = frase;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getFrase() {
        return frase;
    }
    public void setFrase(String frase) {
        this.frase = frase;
    }
}
