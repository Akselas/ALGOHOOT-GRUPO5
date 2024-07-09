package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parser {
    List<Pregunta> preguntas;

    public Parser(){
        preguntas = new ArrayList<>();
    }
    //test
    public Pregunta devolverPrimeraPregunta(){
        return preguntas.get(0);
    }
    public void leer(String archivo) throws IOException {
        try (FileReader lector = new FileReader(archivo)) {
            JsonArray preguntasArray = JsonParser.parseReader(lector).getAsJsonArray();

            // Por cada pregunta del json
            for (JsonElement preguntaElement : preguntasArray) {
                JsonObject preguntaJson = preguntaElement.getAsJsonObject();

                String tipo = preguntaJson.get("Tipo").getAsString();
                String opcionCorrecta = preguntaJson.get("Respuesta").getAsString();
                // Extraigo las opciones sin importar el tipo de pregunta
                Opciones opciones = new Opciones();
                Map<String, Opcion> opcionesMap = new HashMap<>();

                for (Map.Entry<String, JsonElement> entry : preguntaJson.entrySet()) {
                    if (entry.getKey().startsWith("Opcion")) {
                        Opcion op = new Opcion(entry.getValue().getAsString());
                        opciones.agregarOpcion(op);
                        //Me guardo el "x" de "Opcion x" en el opcionesMap
                        opcionesMap.put(String.valueOf(entry.getKey().charAt(entry.getKey().length() -1)),op);
                        //me guardo la opcion en un map asi luego la uso en correcta
                    }
                }
                Pregunta pregunta;
                String titulo;
                //Modulizar esta parte para cada pregunta, capaz en una clase
                if("Verdadero Falso".equals(tipo) || "Verdadero Falso Simple".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaVF correcta = new RespuestaVF();
                    correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
                    pregunta = new PreguntaVF(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }
                if("Verdadero Falso Penalidad".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaVF correcta = new RespuestaVF();
                    correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
                    pregunta = new PreguntaVFPenalidad(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }

                if("Ordered Choice".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaOC correcta = new RespuestaOC();
                    //Itero sobre el array de strings, ya que la respuesta tiene un orden
                    for (String opcion : opcionCorrecta.split(",")){
                        correcta.agregar(opcionesMap.get(opcion));
                    }
                    pregunta = new PreguntaOC(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }
                if("Multiple Choice Simple".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaMC correcta = new RespuestaMC();
                    //Itero sobre el array de strings, ya que la respuesta tiene un orden
                    for (String opcion : opcionCorrecta.split(",")){
                        correcta.agregarOpcionSeleccionada(opcionesMap.get(opcion));
                    }
                    pregunta = new PreguntaMC(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }

                if("Multiple Choice Puntaje Parcial".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaMC correcta = new RespuestaMC();
                    //Itero sobre el array de strings, ya que la respuesta tiene un orden
                    for (String opcion : opcionCorrecta.split(",")){
                        correcta.agregarOpcionSeleccionada(opcionesMap.get(opcion));
                    }
                    pregunta = new PreguntaMCParcial(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }
                if("Multiple Choice Penalidad".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
                    RespuestaMC correcta = new RespuestaMC();
                    //Itero sobre el array de strings, ya que la respuesta tiene un orden
                    for (String opcion : opcionCorrecta.split(",")){
                        correcta.agregarOpcionSeleccionada(opcionesMap.get(opcion));
                    }
                    pregunta = new PreguntaMCPenalidad(titulo, opciones, correcta);
                    preguntas.add(pregunta);
                }
                if("Group Choice".equals(tipo)){
                    titulo = preguntaJson.get("Pregunta").getAsString();
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
                    pregunta = new PreguntaGC(titulo, opciones,preguntaJson.get("Grupo A").getAsString() ,preguntaJson.get("Grupo B").getAsString(),correcta);
                    preguntas.add(pregunta);
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }







    public PreguntaVF devolverPreguntaVF(){
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
    }



}
