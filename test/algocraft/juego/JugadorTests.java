package algocraft.juego;


import org.junit.Assert;
import org.junit.Test;

public class JugadorTests {

    @Test
    public void test01JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {
        Jugador jugador = Jugador.getInstance();

        Assert.assertEquals(2, jugador.getHerramientas().get(0).getFuerza());
        Assert.assertEquals(100, jugador.getHerramientas().get(0).getDurabilidad());
    }

    @Test
    public void test02JugadorSeInicializaEnPosicionDeCoordenadaNulas() {
        Jugador jugador = Jugador.getInstance();

        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaX());
        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaY());
    }

}
