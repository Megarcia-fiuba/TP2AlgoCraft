package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.controller.containers.PicoMaderaContainer;
import algocraft.controller.containers.PicoMetalContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadMetal;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class PicoMetalContainerConstructor implements HerramientaContainerConstructor {
    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadMetal().esUnPicoDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new PicoMetalContainer(herramienta);
    }
}
