package algocraft.model.juego;

import algocraft.model.excepciones.PosicionInvalidaException;
import algocraft.model.excepciones.PosicionOcupadaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import org.junit.Assert;
import org.junit.Test;

public class MapaTests {

    private static final Herramienta herramienta = new Hacha(new DurabilidadMadera());

    @Test
    public void test01SePuedeOcuparUnCasilleroVacioEnElMapa() {
        Mapa mapa = new Mapa();
        Posicion posicionAOcupar = new Posicion(5,5);
        Assert.assertFalse(mapa.posicionOcupada(posicionAOcupar));

        mapa.ocuparPosicion(posicionAOcupar, new Jugador(herramienta));
        Assert.assertTrue(mapa.posicionOcupada(posicionAOcupar));
    }

    @Test(expected = PosicionOcupadaException.class)
    public void test02NoSePuedeOcuparPosicionOcupada() {
        Mapa mapa = new Mapa();
        Posicionable jugador = new Jugador(herramienta);
        Posicion posicionAOcupar = new Posicion(5,5);
        Assert.assertFalse(mapa.posicionOcupada(posicionAOcupar));

        mapa.ocuparPosicion(posicionAOcupar, jugador);
        mapa.ocuparPosicion(posicionAOcupar, jugador);
    }

    @Test(expected = PosicionInvalidaException.class)
    public void test03NoSePuedeOcuparPosicionesInexistentesEnMapa() {
        Mapa mapa = new Mapa();

        mapa.ocuparPosicion(new Posicion(11,11), new Jugador(herramienta));
    }

    @Test
    public void test04SePuedeOcuparPosicionPorJugador() {
        Mapa mapa = new Mapa();
        Posicion posicionAOcupar = new Posicion(1,2);
        Jugador jugador = new Jugador(herramienta);

        Assert.assertFalse(mapa.posicionOcupada(posicionAOcupar));
        jugador.moverseEnMapa(mapa, posicionAOcupar);

        Assert.assertTrue(mapa.posicionOcupada(posicionAOcupar));
    }

    @Test
    public void test05SePuedeOcuparPosicionPorMaterial() {
        Mapa mapa = new Mapa();
        Posicion posicionAOcupar = new Posicion(2,3);
        Materializable pieza = new Madera();
        Assert.assertFalse(mapa.posicionOcupada(posicionAOcupar));

        pieza.ocuparPosicionEnMapa(mapa, posicionAOcupar);

        Assert.assertTrue(mapa.posicionOcupada(posicionAOcupar));
    }
}
