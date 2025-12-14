package com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.net;

import com.example.dam2_pmm_ut2_actividad3_aitorcoscollano.data.Frases;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpUtils {

    public static Frases descargarFrase(){
        Frases frases = null;

        try{
            URL url = new URL("https://zenquotes.io/api/random");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            StringBuilder resultado =  new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null){
                resultado.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(resultado.toString());
            JSONObject obj = jsonArray.getJSONObject(0);

            String frase = obj.getString("q");
            String autor = obj.getString("a");

            frases = new Frases(frase, autor);
        } catch (Exception e){
            e.printStackTrace();
        }
        return frases;
    }
}
