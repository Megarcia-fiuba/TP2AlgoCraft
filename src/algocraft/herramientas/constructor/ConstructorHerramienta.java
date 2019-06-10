package algocraft.herramientas.constructor;
import java.util.ArrayList;
import java.util.List;

import algocraft.herramientas.Herramienta;
import algocraft.materiales.PiezaDeConstruccionHerramientas;
import algocraft.materiales.PiezaVacia;

public class ConstructorHerramienta {

	private List<PiezaDeConstruccionHerramientas> listaMateriales;
	private ConstructorMango constructorMango;

	public ConstructorHerramienta() {
		
		this.listaMateriales = new ArrayList<PiezaDeConstruccionHerramientas>();
		for (int i = 0; i < 9 ; i++){
			listaMateriales.add(i,new PiezaVacia());
		}
		this.constructorMango = new ConstructorMango();
	}

	public Herramienta construir() {
		return constructorMango.construir(listaMateriales);
	}

	public void agregarMaterial(int posicion, PiezaDeConstruccionHerramientas pieza) {
		listaMateriales.remove(posicion);
		listaMateriales.add(posicion,pieza);
	}
}
