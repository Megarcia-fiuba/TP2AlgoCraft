package algocraft.controller.containers.factory;

import algocraft.controller.containers.HachaMaderaContainer;
import algocraft.controller.containers.HachaMetalContainer;
import algocraft.controller.containers.HerramientaContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadMetal;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class HachaMetalContainerConstructor implements HerramientaContainerConstructor {
    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadMetal().esUnHachaDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new HachaMetalContainer(herramienta);
    }
}
