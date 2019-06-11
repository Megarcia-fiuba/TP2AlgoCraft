package algocraft.juego;

import algocraft.excepciones.PosicionOcupadaException;
import org.junit.Assert;
import org.junit.Test;

public class MapaTest {

    @Test
    public void test01SepuedeOcuparUnaPosicionVaciaDelMapa(){
        Posicion posicion =Jugador.getJugador().getPosicion();
        Mapa mapa = new Mapa();
        Posicion posicionSuperior = mapa.obtenerPosicionSuperior(posicion);
        boolean posicionEstaVacia = posicionSuperior.estaVacio();

        if(posicionEstaVacia){
            Jugador.getJugador().moverArriba(mapa);
            Assert.assertFalse(posicionSuperior.estaVacio());
        }
        else{
            Assert.assertTrue(false);
        }
    }
//    @Test(expected = PosicionOcupadaException.class)
//    public void test01NoSepuedeOcuparUnaPosicionOcupadaDelMapaYlanzaException(){
//        Posicion posicion =Jugador.getJugador().getPosicion();
//        Mapa mapa = new Mapa();
//        Posicion posicionDerecha = mapa.obtenerPosicionDerecha(posicion);
//        boolean posicionEstaVacia = posicionDerecha.estaVacio();
//
//        if(!posicionEstaVacia){
//            Jugador.getJugador().moverDerecha(mapa);
//        }
//        else{
//            Assert.assertTrue(false);
//        }
//    }
}
