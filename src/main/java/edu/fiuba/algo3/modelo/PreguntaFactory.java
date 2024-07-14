package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.Map;

public class PreguntaFactory {

//    public static Pregunta fabricar(PreguntaBuilder builder){
//
//        if (builder.getTipo() == "Verdadero Falso" && builder.getTipo() =="Verdadero Falso Simple") {
//            return builder.buildVF();
//        } else if (builder.getTipo() == "Verdadero Falso Penalidad") {
//            return builder.buildVF();
//        } else if (builder.getTipo()=="Ordered Choice") {
//            return builder.buildOC();
//        } else if (builder.getTipo() == "Multiple Choice Simple") {
//            return builder.buildMC();
//        }
//        else if (builder.getTipo() == "Multiple Choice Puntaje Parcial") {
//            return builder.buildMC();
//        }
//        else if (builder.getTipo() == "Multiple Choice Penalidad") {
//            return builder.buildMC();
//        } else if (builder.getTipo() == "Group Choice") {
//            return builder.buildGC();
//        }
//
//    }


    public static Pregunta crearPregunta(JsonObject preguntaJson, Opciones opciones, Map<String, Opcion> opcionesMap){

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
    private static Pregunta crearPreguntaVF(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
        return new PreguntaVF(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }


    private static Pregunta crearPreguntaVFPenalidad(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(opcionesMap.get(opcionCorrecta)); //cambiarle el nombre a "agregar" nada mas
        return new PreguntaVFPenalidad(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private static Pregunta crearPreguntaOC(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
        RespuestaOC correcta = new RespuestaOC();
        //Itero sobre el array de strings, ya que la respuesta tiene un orden
        for (String opcion : opcionCorrecta.split(",")){
            correcta.agregar(opcionesMap.get(opcion));
        }
        //public PreguntaOC(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta)
        return new PreguntaOC(pregunta, tema, tipo, opciones, correcta, textoRespuesta);
    }

    private static Pregunta crearPreguntaMC(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta){
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

    private static Pregunta crearPreguntaMCParcial(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
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

    private static Pregunta crearPreguntaMCPenalidad(String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
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

    private static Pregunta crearPreguntaGC(JsonObject preguntaJson, String pregunta, String tema, String tipo, String opcionCorrecta, Opciones opciones, Map<String, Opcion> opcionesMap, String textoRespuesta) {
        //PreguntaBuilder builder;

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
}
