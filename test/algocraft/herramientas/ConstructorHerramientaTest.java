package algocraft.herramientas;

import algocraft.excepciones.FormaInvalidaException;
import algocraft.herramientas.constructor.MesaDeConstruccion;
import algocraft.materiales.Madera;
import algocraft.materiales.Metal;
import algocraft.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorHerramientaTest {
	
	@Test
	public void test01ConstructorHerramientaCreaHachaMaderaConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Madera());
		mesa.putMaterial(0,1,new Madera());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,2,new Madera());

		Herramienta hacha= mesa.construir();
		//hay que cambiar la forma de validacion

		Assert.assertNotNull(hacha);
		Assert.assertEquals(100,hacha.getDurabilidad(),0);
	}

	@Test
	public void test02ConstructorHerramientaCreaHachaPiedraConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Piedra());
		mesa.putMaterial(0,1,new Piedra());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,2,new Piedra());

		Herramienta hacha= mesa.construir();
		//hay que cambiar la forma de validacion
		Assert.assertNotNull(hacha);
		Assert.assertEquals(200,hacha.getDurabilidad(),0);

	}
	@Test
	public void test03ConstructorHerramientaCreaHachaMetalConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Metal());
		mesa.putMaterial(0,1,new Metal());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,2,new Metal());

		Herramienta hacha= mesa.construir();
		//hay que cambiar la forma de validacion
		Assert.assertNotNull(hacha);
		Assert.assertEquals(400,hacha.getDurabilidad(),0);


	}
	@Test
	public void test04ConstructorHerramientaCreaPicoMaderaConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Madera());
		mesa.putMaterial(1,2,new Madera());
		mesa.putMaterial(2,2,new Madera());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,0,new Madera());

		Herramienta pico= mesa.construir();
//hay que cambiar la forma de validacion
		Assert.assertEquals(100,pico.getDurabilidad(),0);

	}
	@Test
	public void test05ConstructorHerramientaCreaHachaPiedraConMaterialesYPosicionesCorrespondientes() {

		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Piedra());
		mesa.putMaterial(1,2,new Piedra());
		mesa.putMaterial(2,2,new Piedra());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,0,new Madera());

		Herramienta pico= mesa.construir();
//hay que cambiar la forma de validacion
		Assert.assertEquals(200,pico.getDurabilidad(),0);

	}
	@Test
	public void test06ConstructorHerramientaCreaPicoMetalConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Metal());
		mesa.putMaterial(1,2,new Metal());
		mesa.putMaterial(2,2,new Metal());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,0,new Madera());

		Herramienta pico= mesa.construir();
//hay que cambiar la forma de validacion
		Assert.assertEquals(400,pico.getDurabilidad(),0);

	}
	@Test
	public void test07ConstructorHerramientaCreaPicoFinoConMaterialesYPosicionesCorrespondientes() {
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Metal());
		mesa.putMaterial(1,2,new Metal());
		mesa.putMaterial(2,2,new Metal());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(0,1,new Piedra());

		Herramienta picoFino= mesa.construir();
//hay que cambiar la forma de validacion
		Assert.assertEquals(1000,picoFino.getDurabilidad(),0);

	}

	@Test(expected = FormaInvalidaException.class)
	public void test08NoSePuedeConstruirAlgoDeFormaIncoherente(){
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Metal());
		mesa.putMaterial(1,2,new Metal());
		mesa.putMaterial(2,2,new Metal());
		mesa.putMaterial(1,1,new Madera());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(0,1,new Piedra());
		mesa.putMaterial(0,0,new Madera());

		Herramienta algo=mesa.construir();
	}

	@Test(expected = FormaInvalidaException.class)
	public void test09NoSePuedeConstruirAlgoConMaterialesEquivocados(){
		MesaDeConstruccion mesa= new MesaDeConstruccion();

		mesa.putMaterial(0,2,new Metal());
		mesa.putMaterial(0,1,new Piedra());
		mesa.putMaterial(1,0,new Madera());
		mesa.putMaterial(1,1,new Metal());
		mesa.putMaterial(1,2,new Madera());

		Herramienta algo=mesa.construir();
	}

}
