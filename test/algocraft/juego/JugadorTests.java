package algocraft.juego;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.materiales.Madera;
import algocraft.materiales.Materializable;
import algocraft.materiales.Piedra;
import algocraft.materiales.propiedades.DurabilidadMadera; 
import algocraft.juego.*;
import java.util.ArrayList; 
import java.util.List;
import org.junit.Test; 
import org.junit.Assert;


public class JugadorTests {
	
	@Test 
	public void test01JugadorSeInicializaConSoloUnaHerramienta() { 
	
		Jugador jugador = Jugador.getJugador();
		Assert.assertEquals(1, jugador.getHerramientas().size()); 
	
	}
	
	@Test  
    public void test02JugadorNoTieneMaterialesAlInicializarse() { 
		
		Jugador jugador = Jugador.getJugador(); 
		Assert.assertEquals(0, jugador.getMaterialesRecolectados().size()); 
   
	} 
	
	 @Test 
	 public void test03JugadorSeInicializaConHerramientaHachaDeMaderaEnInventario() { 

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
		
		Assert.assertEquals(30, piedra.getDurabilidad()); 
		 
		for(int i=0;i<6;i++) {
			jugador.usarHacha(madera);
		}
	 
		Assert.assertEquals(1, jugador.getMaterialesRecolectados().size()); 

	} 
	
	
	@Test  
    public void test04JugadorSeInicializaEnPosicionDeCoordenadaNulas() { 
		
		Jugador jugador = Jugador.getJugador(); 
		Assert.assertEquals(0, jugador.getPosicion().getPosicionX()); 	
		Assert.assertEquals(0, jugador.getPosicion().getPosicionY());
   
	} 
	
	
}
