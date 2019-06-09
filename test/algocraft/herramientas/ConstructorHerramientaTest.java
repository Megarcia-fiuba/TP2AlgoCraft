package algocraft.herramientas;

import java.util.ArrayList;
import java.util.List;

import algocraft.materiales.*;
import org.junit.Assert;
import org.junit.Test;

import algocraft.herramientas.constructor.ConstructorHerramienta;

public class ConstructorHerramientaTest {
	
	@Test
	public void test01ConstructorHerramientaCreaHachaMaderaConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Madera());
		constructor.agregarMaterial(1,new Madera());
		constructor.agregarMaterial(3,new Madera());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Hacha.class);
	}
	@Test
	public void test02ConstructorHerramientaCreaHachaPiedraConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Piedra());
		constructor.agregarMaterial(1,new Piedra());
		constructor.agregarMaterial(3,new Piedra());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Hacha.class);
	}
	@Test
	public void test03ConstructorHerramientaCreaHachaMetalConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Metal());
		constructor.agregarMaterial(1,new Metal());
		constructor.agregarMaterial(3,new Metal());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Hacha.class);
	}
	@Test
	public void test04ConstructorHerramientaCreaPicoMaderaConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Madera());
		constructor.agregarMaterial(1,new Madera());
		constructor.agregarMaterial(2,new Madera());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Pico.class);
	}
	@Test
	public void test05ConstructorHerramientaCreaHachaPiedraConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Piedra());
		constructor.agregarMaterial(1,new Piedra());
		constructor.agregarMaterial(2,new Piedra());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Pico.class);
	}
	@Test
	public void test06ConstructorHerramientaCreaPicoMetalConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Metal());
		constructor.agregarMaterial(1,new Metal());
		constructor.agregarMaterial(2,new Metal());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==Pico.class);
	}
	@Test
	public void test07ConstructorHerramientaCreaPicoFinoConMaterialesYPosicionesCorrespondientes() {

		ConstructorHerramienta constructor = new ConstructorHerramienta();
		constructor.agregarMaterial(0,new Metal());
		constructor.agregarMaterial(1,new Metal());
		constructor.agregarMaterial(2,new Metal());
		constructor.agregarMaterial(3,new Piedra());
		constructor.agregarMaterial(4,new Madera());
		constructor.agregarMaterial(7,new Madera());

		Herramienta herramienta = constructor.construir();
		//hay que cambiar la forma de validacion
		Assert.assertTrue(herramienta.getClass()==PicoFino.class);
	}

}
