package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.controller.containers.PicoPiedraContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadPiedra;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class PicoPiedraContainerConstructor implements HerramientaContainerConstructor {
    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadPiedra().esUnPicoDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new PicoPiedraContainer(herramienta);
    }
}
