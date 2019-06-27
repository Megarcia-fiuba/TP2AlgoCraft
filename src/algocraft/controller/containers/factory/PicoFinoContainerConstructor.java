package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.controller.containers.PicoFinoContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorPicoFino;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class PicoFinoContainerConstructor implements HerramientaContainerConstructor {
    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorPicoFino().herramientaEsDeForma(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new PicoFinoContainer(herramienta);
    }
}
