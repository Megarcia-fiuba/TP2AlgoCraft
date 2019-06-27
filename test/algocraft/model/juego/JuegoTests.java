package algocraft.model.juego;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTests {
    /*
    @Test
    public void  test01ElJuegoInicializaConElJugadorUbicadoEnlaPosicionCorrespondiente(){
        Jugador jugador = new Jugador();
        Mapa mapa = new Mapa();

        Assert.assertFalse(mapa.posicionOcupada(jugador.getPosicion()));

        Juego juego = new Juego(mapa);
        Assert.assertTrue(mapa.posicionOcupada(jugador.getPosicion()));
    }
    @Test
    //posicion central es aquella que al menos una de sus coordenadas es 5.
    public void  test01ElJuegoInicializaConLasPosicionesCentralesOcupadas(){
        Mapa mapa = new Mapa();
        for(int i = 0; i <= 10; i++){
            Assert.assertFalse(mapa.posicionOcupada(new Posicion(5,i)));
            Assert.assertFalse(mapa.posicionOcupada(new Posicion(i,5)));
        }
        Juego juego = new Juego(mapa);

        for(int i = 0; i <= 9; i++){
            Assert.assertTrue(mapa.posicionOcupada(new Posicion(5,i)));
            Assert.assertTrue(mapa.posicionOcupada(new Posicion(i,5)));
        }
    }
    @Test
    public void  test01ElJuegoInicializaConLasPosicionesNoCentralesNoOcupadas(){
        Mapa mapa = new Mapa();
        Juego juego = new Juego(mapa);

        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if(i == 5 || j ==5 ||(i == 0 && j==0)){
                    continue;
                }
                Assert.assertFalse(mapa.posicionOcupada(new Posicion(i,j)));
            }
        }
    }*/
}
