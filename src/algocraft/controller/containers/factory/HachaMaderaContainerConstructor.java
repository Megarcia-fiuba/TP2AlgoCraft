package algocraft.controller.containers.factory;

import algocraft.controller.containers.HachaMaderaContainer;
import algocraft.controller.containers.HerramientaContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadMadera;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class HachaMaderaContainerConstructor implements HerramientaContainerConstructor {

    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadMadera().esUnHachaDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new HachaMaderaContainer(herramienta);
    }
}
