package algocraft.herramientas.constructor;

import java.util.List;

import algocraft.herramientas.Herramienta;
import algocraft.materiales.PiezaDeConstruccionHerramientas;

public class ConstructorMango {

	private ConstructorParteSuperior constructorParteSuperior;
	
	public ConstructorMango() {
		this.constructorParteSuperior = new ConstructorParteSuperior();
	}
	
	public Herramienta construir(List<PiezaDeConstruccionHerramientas> listaMateriales) {
		if(this.sirveParaMango(listaMateriales.get(4),listaMateriales.get(7))){
			return constructorParteSuperior.construir(listaMateriales);
		}
		return null;
	}

	private boolean sirveParaMango(PiezaDeConstruccionHerramientas sobreBase, PiezaDeConstruccionHerramientas base) {
		return sobreBase.sirveParaMango() && base.sirveParaMango();
	}

}
