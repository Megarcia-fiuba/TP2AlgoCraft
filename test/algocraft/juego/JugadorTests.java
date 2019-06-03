package algocraft.juego;


import org.junit.Assert;
import org.junit.Test;

import algocraft.materiales.propiedades.DurabilidadMadera;
import algocraft.herramientas.*;


public class JugadorTests {

    @Test
    public void test01JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {
    	HerramientaInicializable hachaMadera = new HachaInicializable(new DurabilidadMadera());
    	Jugador.eliminarJugador();
    	Jugador jugador = Jugador.getInstance(hachaMadera);

        Assert.assertEquals(hachaMadera, jugador.getHerramientas().get(0));
    }

    @Test
    public void test02JugadorSeInicializaEnPosicionDeCoordenadaNulas() {
    	HerramientaInicializable hachaMadera = new HachaInicializable(new DurabilidadMadera());
    	Jugador.eliminarJugador();
    	Jugador jugador = Jugador.getInstance(hachaMadera);

        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaX());
        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaY());
    }

}
