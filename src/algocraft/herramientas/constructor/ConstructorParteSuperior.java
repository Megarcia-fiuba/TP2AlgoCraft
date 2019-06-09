package algocraft.herramientas.constructor;

import java.util.List;

import algocraft.herramientas.Herramienta;
import algocraft.materiales.PiezaDeConstruccionHerramientas;

public class ConstructorParteSuperior {

	private ConstructorDefinidor definidorHerramienta;
	
	public ConstructorParteSuperior() {
		this.definidorHerramienta = new ConstructorDefinidor();
	}

	public Herramienta construir(List<PiezaDeConstruccionHerramientas> listaMateriales) {
		if(this.sirveParaParteSuperior(listaMateriales)){
			return definidorHerramienta.construir(listaMateriales);
		}
		return null;
	}

	private boolean sirveParaParteSuperior(List<PiezaDeConstruccionHerramientas> listaMateriales) {
		boolean herramientaSinDetalles = listaMateriales.get(5).esVacia();
		herramientaSinDetalles &= listaMateriales.get(6).esVacia();
		herramientaSinDetalles &= listaMateriales.get(8).esVacia();
		herramientaSinDetalles &= !listaMateriales.get(2).mismoMaterial(listaMateriales.get(3));
		herramientaSinDetalles &= listaMateriales.get(0).mismoMaterial(listaMateriales.get(1));
		return herramientaSinDetalles;
	}


}
