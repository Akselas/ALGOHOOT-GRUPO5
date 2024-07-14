package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
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
                Pregunta pregunta = crearPregunta(preguntaJson, opciones, opcionesMap);
                if (pregunta != null) {
                    preguntas.add(pregunta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Pregunta crearPreguntaVF(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
        return new PreguntaVF(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }


    private Pregunta crearPreguntaVFPenalidad(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
        return new PreguntaVFPenalidad(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private Pregunta crearPreguntaOC(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaOC correcta = new RespuestaOC();
        //Itero sobre el array de strings, ya que la respuesta tiene un orden
        for (String opcion : opcionCorrecta.split(",")){
            correcta.agregar(opcionesMap.get(opcion));
        }
        //public PreguntaOC(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta)
        return new PreguntaOC(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private Pregunta crearPreguntaMC(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaMC correcta = new RespuestaMC();
        Opciones opcionesCorrecta = new Opciones();
        //Itero sobre el array de strings, ya que la respuesta tiene un orden
        for (String opcion : opcionCorrecta.split(",")){
            opcionesCorrecta.agregarOpcion(opcionesMap.get(opcion));
        }
        //aca las guardo
        for(Opcion opcion: opciones){
            if(opcionesCorrecta.hayOpcion(opcion)){
                correcta.agregarOpcionSeleccionada(opcion);
            }
            else{
                correcta.agregarOpcionNoSeleccionada(opcion);
            }
        }
        return new PreguntaMC(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private Pregunta crearPreguntaMCParcial(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
        RespuestaMC correcta = new RespuestaMC();
        Opciones opcionesCorrecta = new Opciones();
        //Itero sobre el array de strings, ya que la respuesta tiene un orden
        for (String opcion : opcionCorrecta.split(",")){
            opcionesCorrecta.agregarOpcion(opcionesMap.get(opcion));
        }
        //aca las guardo
        for(Opcion opcion: opciones){
            if(opcionesCorrecta.hayOpcion(opcion)){
                correcta.agregarOpcionSeleccionada(opcion);
            }
            else{
                correcta.agregarOpcionNoSeleccionada(opcion);
            }
        }
        return new PreguntaMCParcial(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private Pregunta crearPreguntaMCPenalidad(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
        RespuestaMC correcta = new RespuestaMC();
        Opciones opcionesCorrecta = new Opciones();
        //Itero sobre el array de strings, ya que la respuesta tiene un orden
        for (String opcion : opcionCorrecta.split(",")){
            opcionesCorrecta.agregarOpcion(opcionesMap.get(opcion));
        }
        //aca las guardo
        for(Opcion opcion: opciones){
            if(opcionesCorrecta.hayOpcion(opcion)){
                correcta.agregarOpcionSeleccionada(opcion);
            }
            else{
                correcta.agregarOpcionNoSeleccionada(opcion);
            }
        }
        return new PreguntaMCPenalidad(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private Pregunta crearPreguntaGC(JsonObject preguntaJson, String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
            Grupo g1 = new Grupo();
            Grupo g2 = new Grupo();

            //Parseo el string del tipo "A: 1,2,3; B:4,5,6"
            //Primero separo en dos pequeños grupos cortando con ";"
            for (String grupito : opcionCorrecta.split(";")) {

                // Separar por ':' para obtener el identificador del grupo y las opciones
                String[] partes = grupito.split(":");

                //Utilizo el identificador para asignarlo al grupo correcto
                String identificador = partes[0].trim();

                //Recorre la parte de los numeros y asigna a cada grupo la opcion,
                // se me ocurre que el objeto Grupo deba tener nombre asi lo identificamos
                for(String a : (partes[1].trim().split(","))){
                    if (identificador.equals("A")){
                        g1.agregar(opcionesMap.get(a));
                    }
                    if (identificador.equals("B")){
                        g2.agregar(opcionesMap.get(a));
                    }
                }
            }
            RespuestaGC correcta = new RespuestaGC(g1,g2);
            //Itero sobre el array de strings, ya que la respuesta tiene un orden

            return new PreguntaGC(pregunta, tema, tipo,opciones,preguntaJson.get("Grupo A").getAsString(),preguntaJson.get("Grupo B").getAsString(),correcta, textoRespuesta);

    }

    private Pregunta crearPregunta(JsonObject preguntaJson, Opciones opciones, Map<String, Opcion> opcionesMap) {
        String texto = preguntaJson.get("Pregunta").getAsString();
        String tema = preguntaJson.get("Tema").getAsString();
        String tipo = preguntaJson.get("Tipo").getAsString();
        String opcionCorrecta = preguntaJson.get("Respuesta").getAsString();
        String textoRespuesta = preguntaJson.get("Texto respuesta").getAsString(); // O puedes extraerlo como corresponda

        switch (tipo) {
            case "Verdadero Falso":
            case "Verdadero Falso Simple":
                return crearPreguntaVF(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Verdadero Falso Penalidad":
                return crearPreguntaVFPenalidad(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Ordered Choice":
                return crearPreguntaOC(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Multiple Choice Simple":
                return crearPreguntaMC(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Multiple Choice Puntaje Parcial":
                return crearPreguntaMCParcial(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Multiple Choice Penalidad":
                return crearPreguntaMCPenalidad(texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            case "Group Choice":
                return crearPreguntaGC(preguntaJson ,texto, tema, tipo, opcionCorrecta, opciones, opcionesMap, textoRespuesta);
            default:
                return null;
        }
    }
}

/* public PreguntaVF devolverPreguntaVF(){
        RespuestaVF correcta = new RespuestaVF();
        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("Falso"));
        opciones.agregarOpcion(new Opcion("Verdadero"));
        correcta.agregarOpcion(new Opcion("Verdadero"));
        return new PreguntaVF("El tomate es una fruta?", opciones, correcta);
    }

    public PreguntaOC devolverPreguntaOC(){
        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("Messi ganó un mundial"));
        opciones.agregarOpcion(new Opcion("El hombre llegó la luna"));
        opciones.agregarOpcion(new Opcion("Abrió la UBA"));

        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));
        return new PreguntaOC("Ordenar cronologicamente:", opciones, respuestaCorrecta);
    }

    public PreguntaGC devolverPreguntaGC(){
        Grupo frutas = new Grupo();
        frutas.agregar(new Opcion("tomate"));
        frutas.agregar(new Opcion("mandarina"));
        frutas.agregar(new Opcion("manzana"));

        Grupo verduras = new Grupo();
        verduras.agregar(new Opcion("cebolla"));
        verduras.agregar(new Opcion("lechuga"));
        verduras.agregar(new Opcion("zanahoria"));

        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("tomate"));
        opciones.agregarOpcion(new Opcion("mandarina"));
        opciones.agregarOpcion(new Opcion("manzana"));
        opciones.agregarOpcion(new Opcion("cebolla"));
        opciones.agregarOpcion(new Opcion("lechuga"));
        opciones.agregarOpcion(new Opcion("zanahoria"));

        RespuestaGC correcta = new RespuestaGC(frutas, verduras);
        return new PreguntaGC("ordenar Frutas y Verduras", opciones, "Frutas", "Verduras", correcta);
    }

    public PreguntaMC devolverPreguntaMC(){
        RespuestaMC correcta = new RespuestaMC();

        Opcion opcion1 = new Opcion("4");
        Opcion opcion2 = new Opcion("Un numero par");
        Opcion opcion3 = new Opcion("2");
        Opcion opcion4 = new Opcion("Un numero impar");

        correcta.agregarOpcionSeleccionada(opcion1);
        correcta.agregarOpcionSeleccionada(opcion2);
        correcta.agregarOpcionNoSeleccionada(opcion3);
        correcta.agregarOpcionNoSeleccionada(opcion4);

        Opciones opciones = new Opciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);
        opciones.agregarOpcion(opcion4);

        return new PreguntaMC("Cuanto es 2+2?", opciones, correcta);
    }*/
