package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.controller.containers.PicoMaderaContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadMadera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class PicoMaderaContainerConstructor implements HerramientaContainerConstructor {

    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadMadera().esUnPicoDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new PicoMaderaContainer(herramienta);
    }
}
