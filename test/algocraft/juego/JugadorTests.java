package algocraft.juego;


import org.junit.Assert;
import org.junit.Test;

public class JugadorTests {



    @Test
    public void obtenerJugador(){
        Jugador jugador = Jugador.getJugador();

        Assert.assertNotNull(jugador);
    }
}
