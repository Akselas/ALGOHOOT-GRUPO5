package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.PreguntaOCVista;

public class Parser {
    public PreguntaVF devolverPreguntaVF(){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        return new PreguntaVF("El tomate es una fruta?", new Opciones(), correcta);
    }

    public PreguntaOC devolverPreguntaOC(){
        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("Messi ganó un mundial"));
        opciones.agregarOpcion(new Opcion("El hombre llegó la luna"));
        opciones.agregarOpcion(new Opcion("Abrió la UBA"));

        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));
        return new PreguntaOC("Ordenar cronologicamente:", opciones, respuestaCorrecta);
    }
}
