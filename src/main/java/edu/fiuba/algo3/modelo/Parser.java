package edu.fiuba.algo3.modelo;

public class Parser {
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
