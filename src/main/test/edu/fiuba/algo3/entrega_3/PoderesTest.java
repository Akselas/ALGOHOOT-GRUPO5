package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoderesTest {
    @Test
    public void test01JugadorUsaDuplicadorYRecibeElDobleDePuntosAlContestarCorrectamente() {

        //Arrange
        int puntajeEsperado = 2;
        //Ronda r1 = new Ronda();
        Duplicador duplicador = new Duplicador();
        Jugador j1 = new Jugador("Juani");
        Puntaje puntaje = new Puntaje(1);
        Puntajes puntajes = new Puntajes();
        puntajes.agregarPuntaje(puntaje);

        //Act
        duplicador.aplicarUnico(puntaje);
        j1.sumarPuntaje(puntaje);

        //assert
        assertEquals(puntajeEsperado, j1.getPuntaje());
    }
    @Test
    public void test02JugadorUsaDuplicadorYNoDuplicaSuPuntajePorQueRespondeMal() {
        //Arrange
        int puntajeEsperado = 0;
        //Ronda r1 = new Ronda();
        Duplicador duplicador = new Duplicador();
        Jugador j1 = new Jugador("Juani");
        Puntaje puntaje = new Puntaje(0);

        //Act
        duplicador.aplicarUnico(puntaje);
        j1.sumarPuntaje(puntaje);

        //assert
        assertEquals(puntajeEsperado, j1.getPuntaje());

    }
    @Test
    public void test03JugadorUsaTriplicadorYRecibeElTripleDePuntosAlContestarCorrectamente() {

        //Arrange
        int puntajeEsperado = 3;
        Triplicador triplicador = new Triplicador();
        Jugador j1 = new Jugador("Juani");
        Puntaje puntaje = new Puntaje(1);

        //Act
        triplicador.aplicarUnico(puntaje);
        j1.sumarPuntaje(puntaje);

        //assert
        assertEquals(puntajeEsperado, j1.getPuntaje());
        }
    @Test
    public void test03JugadorUsaAnuladorYNingunoDeLosJugadoresObtienePuntos(){
        //Arrange
        int puntajeEsperado = 0;
        Jugador j1 = new Jugador("maria");
        Puntaje puntaje1 = new Puntaje(1);
        Anulador anulador = new Anulador();
        Puntajes puntajes = new Puntajes();

        //Act
        puntajes.agregarPuntaje(puntaje1);
        anulador.aplicar(puntajes);
        j1.sumarPuntaje(puntaje1);

        //assert
        assertEquals(puntajeEsperado, j1.getPuntaje());
    }

    @Test
    public void test05JugadorUsaExclusividadYRecibeElDobleDePuntosAlContestarCorrectamente() {
        //Arrange
        int puntajeEsperado = 2;
        Exclusividad exclusividad = new Exclusividad();
        Jugador j1 = new Jugador("Juani");
        Puntaje puntaje = new Puntaje(1);
        Puntajes puntajes = new Puntajes();

        puntajes.agregarPuntaje(puntaje);

        //Act
        exclusividad.aplicar(puntajes);//aca modifica el puntaje de un solo puntaje porque solo agrega uno
        j1.sumarPuntaje(puntaje);//entonces aca obviamente va a agregar el puntaje al unico juga

        //assert
        assertEquals(puntajeEsperado, j1.getPuntaje());
    }
    /*
        public class Jugador{

            this.mochila = new Mochila;
        }
        public void activarDuplicador(Ronda r1){

            if(mochila.puedeUsarMultiplicador()){
                r1.agregarPoder(self, this.obtenerMultiplicador());
                mochila.reducirDuplicador()
            }
        }

        public class Partida{
            private static Partida instancia = new Partida();

            private Partida();

            public static Partida obtenerPartida() {
                return instance;
            }
        }

        public class Ronda {
            Partida partida = Partida.obtenerPartida();
            this.puntajes = ;
            private Pregunta pregunta;


            public Ronda(Pregunta){
                this.pregunta = pregunta;
            }

            public bool siguienteTurno() {

            }

            public Puntajes calcularResultadoRonda(){
                partida.obtenerJugadoes();
            }
            public void agregarPuntaje(jugador,
                pregunta.calcularPuntaje(
        }


        public class Mochila{

            this.duplicador = new MultiplicadorDoble;
            this.triplicador = new MultiplicadorTriple;
            this.anulador = new Anulador:
            this.exclusividad = new Exclusividad;
        }

    */
}


