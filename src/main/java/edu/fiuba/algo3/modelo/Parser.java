package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Parser {
    List<Pregunta> preguntas;

    public Parser(String ruta) throws IOException {
        preguntas = new ArrayList<>();
        this.leer(ruta);
    }
    //test
    public Pregunta devolverPrimeraPregunta(){
        return preguntas.get(0);
    }
    //Devuelve una cantidad random de preguntas
    public List<Pregunta> devolverPreguntasRandom(int cantidad){
        List<Pregunta> copiaPreguntas = new ArrayList<>(this.preguntas);
        Collections.shuffle(copiaPreguntas);
        //Haciendo min atajo la posibilidad de que se reduzca con un numero mayor a la cantidad de preguntas
        List<Pregunta> preguntasReducida = copiaPreguntas.subList(0, Math.min(cantidad, copiaPreguntas.size()));
        return preguntasReducida;
    }
    public void leer(String archivo) throws IOException {
        try (FileReader lector = new FileReader(archivo)) {
            JsonArray preguntasArray = JsonParser.parseReader(lector).getAsJsonArray();

            // Por cada pregunta del json
            for (JsonElement preguntaElement : preguntasArray) {
                JsonObject preguntaJson = preguntaElement.getAsJsonObject();

                // Extraigo las opciones sin importar el tipo de pregunta
                Opciones opciones = new Opciones();
                Map<String, Opcion> opcionesMap = new HashMap<>();

                for (Map.Entry<String, JsonElement> entry : preguntaJson.entrySet()) {
                    if (entry.getKey().startsWith("Opcion")) {
                        Opcion op = new Opcion(entry.getValue().getAsString());
                        opciones.agregarOpcion(op);
                        //Me guardo el "x" de "Opcion x" en el opcionesMap
                        opcionesMap.put(String.valueOf(entry.getKey().charAt(entry.getKey().length() - 1)), op);
                        //me guardo la opcion en un map asi luego la uso en correcta
                    }
                }
                //Pregunta pregunta = crearPregunta(preguntaJson, opciones, opcionesMap);
                 Pregunta pregunta = PreguntaFactory.crearPregunta(preguntaJson, opciones, opcionesMap);
                if (pregunta != null) {
                    preguntas.add(pregunta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
