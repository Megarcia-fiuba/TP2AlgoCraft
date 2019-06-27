package algocraft.model.juego;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;


public class JugadorTests {

    private static final Herramienta herramienta = new Hacha(new DurabilidadMadera());

    @Test
    public void test01JugadorSeInicializaConSoloUnaHerramienta() {
        Jugador jugador = new Jugador(herramienta);

        Assert.assertEquals(1, jugador.getHerramientas().size());
    }

    @Test
    public void test02JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {
        Jugador jugador = new Jugador(herramienta);

        Assert.assertEquals(2, jugador.getHerramientaEnUso().getFuerza());
        Assert.assertEquals(100, jugador.getHerramientaEnUso().getDurabilidad(), 0);
    }

    @Test
    public void test03JugadorSeInicializaEnPosicionDeCoordenadaNulas() {
        Jugador jugador = new Jugador(herramienta);

        Assert.assertEquals(new Posicion(0,0), jugador.getPosicion());
    }

    @Test
    public void test04JugadorNoTieneMaterialesAlInicializarse() {
        Jugador jugador = new Jugador(herramienta);

        Assert.assertEquals(0, jugador.getMaterialesRecolectados().size());
    }

    @Test
    public void test05JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {

        // Para comprobar que el jugador se inicialice con un Hacha de Madera en el inventario se utiliza la herramienta conta
        // el material Madera. Suponemos que no es posible que existan herramientas distintas a las que se describen en el
        // enunciado, por lo tanto, solo el Hacha de Madera puede utilizarse contra el material Madera. Si el jugador obtiene
        // el material Madera luego de golpearla con su herramienta, entonces efectivamente la herramienta es un Hacha de Madera.

        Jugador jugador = new Jugador(herramienta);
        Materializable madera = new Madera();
        Materializable piedra = new Piedra();

        //pruebo usar el Hacha contra la Piedra, no deberia obtener Piedra, y la durabilidad de piedra deberia mantenerse cte
        //porque no es posuble usar un hacha contra una piedra

        jugador.usarHacha(piedra);

        Assert.assertEquals(30, piedra.getDurabilidad(),0);

        for(int i=0;i<6;i++) {
            jugador.usarHacha(madera);
        }

        Assert.assertEquals(1, jugador.getMaterialesRecolectados().size());
    }
    @Test
    public void test06SeInicializaElJugadorEnElMapaEnLaCorrespondientePosicion(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(herramienta);

        Assert.assertFalse(mapa.posicionOcupada(jugador.getPosicion()));
        jugador.iniciarEnMapa(mapa);

        Assert.assertTrue(mapa.posicionOcupada(jugador.getPosicion()));
    }
    @Test
    public void test07ElJugadorPuedeMoverseHaciaArribaEnPosicionVacia(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(herramienta);
        jugador.iniciarEnMapa(mapa);
        Posicion posicionSuperior = new Posicion(0,0);

        jugador.moverAbajo(mapa);
        jugador.moverArriba(mapa);
        Assert.assertEquals(posicionSuperior,jugador.getPosicion());
    }

    @Test
    public void test08ElJugadorPuedeMoverseHaciaAbajoEnPosicionVacia(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(herramienta);
        jugador.iniciarEnMapa(mapa);
        Posicion posicionInferior = new Posicion(0,0);

        jugador.moverAbajo(mapa);
        jugador.moverArriba(mapa);


        Assert.assertEquals(posicionInferior,jugador.getPosicion());
    }

    @Test
    public void test09ElJugadorPuedeMoverseHaciaLaDerechaEnPosicionVacia(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(herramienta);
        jugador.iniciarEnMapa(mapa);
        Posicion posicionDerecha = new Posicion(1,0);

        jugador.moverDerecha(mapa);
        Assert.assertEquals(posicionDerecha,jugador.getPosicion());
    }

    @Test
    public void test10ElJugadorPuedeMoverseHaciaLaIzquierdaEnPosicionVacia(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(herramienta);
        jugador.iniciarEnMapa(mapa);
        Posicion posicionIzquierda = new Posicion(0,0);

        jugador.moverDerecha(mapa);
        jugador.moverIzquierda(mapa);
        Assert.assertEquals(posicionIzquierda,jugador.getPosicion());
    }

}
