package algocraft.herramientas.constructor;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;
import algocraft.materiales.Metal;
import algocraft.materiales.Piedra;
import algocraft.materiales.PiezaDeConstruccionHerramientas;

import java.util.List;

public class ConstructorDefinidor {

    public Herramienta construir(List<PiezaDeConstruccionHerramientas> listaMateriales) {
        if (listaMateriales.get(2).esVacia() && listaMateriales.get(0).mismoMaterial(listaMateriales.get(3))) {
            return new Hacha(listaMateriales.get(0).obtenerTipoDurabilidad());
        }
        if (listaMateriales.get(3).esVacia() && listaMateriales.get(0).mismoMaterial(listaMateriales.get(2))) {
            return new Pico(listaMateriales.get(0).obtenerTipoDurabilidad());
        }
        if(listaMateriales.get(3).mismoMaterial(new Piedra()) && listaMateriales.get(0).mismoMaterial(listaMateriales.get(2)) && listaMateriales.get(2).mismoMaterial(new Metal())){
            return new PicoFino();
        }
        return null;
    }
}
