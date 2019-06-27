package algocraft.controller.containers.factory;

import algocraft.controller.containers.HachaPiedraContainer;
import algocraft.controller.containers.HerramientaContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadMetal;
import algocraft.model.herramientas.constructor.ConstructorDurabilidadPiedra;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class HachaPiedraContainerConstructor implements HerramientaContainerConstructor {
    @Override
    public boolean esEstaHerramienta(MatrizDefinida<Materializable> forma) {
        return new ConstructorDurabilidadPiedra().esUnHachaDeEsteMaterial(forma);
    }

    @Override
    public HerramientaContainer construir(Herramienta herramienta) {
        return new HachaPiedraContainer(herramienta);
    }
}
