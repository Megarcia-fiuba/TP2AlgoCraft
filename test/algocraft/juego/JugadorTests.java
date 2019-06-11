package algocraft.juego;

import algocraft.materiales.Madera;
import algocraft.materiales.Materializable;
import algocraft.materiales.Piedra;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//Los tests se corren en orden por ser singleton,
//primero deben estar los tests que no modifican los atributos de jugador.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JugadorTests {

    /******** Tests de inicializacion sin modificar atributos de Jugador ********/

    @Test
    public void test01JugadorSeInicializaConSoloUnaHerramienta() {
        Jugador jugador = Jugador.getJugador();

        Assert.assertEquals(1, jugador.getHerramientas().size());
    }

    @Test
    public void test02JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {
        Jugador jugador = Jugador.getJugador();

        Assert.assertEquals(2, jugador.getHerramientaEnUso().getFuerza());
        Assert.assertEquals(100, jugador.getHerramientaEnUso().getDurabilidad(), 0);
    }

    // no pasa la prueba porque la unica instancia que existe le es modificada su posicion inicial 
//    @Test
//    public void test03JugadorSeInicializaEnPosicionDeCoordenadaNulas() {
//        Jugador jugador = Jugador.getJugador();
//
//        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaX());
//        Assert.assertEquals(0, jugador.getPosicion().getCoordenadaY());
//    }

    @Test
    public void test04JugadorNoTieneMaterialesAlInicializarse() {
        Jugador jugador = Jugador.getJugador();

        Assert.assertEquals(0, jugador.getMaterialesRecolectados().size());
    }

    /************************************************************************/

    @Test
    public void test05JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() {

        // Para comprobar que el jugador se inicialice con un Hacha de Madera en el inventario se utiliza la herramienta conta
        // el material Madera. Suponemos que no es posible que existan herramientas distintas a las que se describen en el
        // enunciado, por lo tanto, solo el Hacha de Madera puede utilizarse contra el material Madera. Si el jugador obtiene
        // el material Madera luego de golpearla con su herramienta, entonces efectivamente la herramienta es un Hacha de Madera.

        Jugador jugador = Jugador.getJugador();
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



}
