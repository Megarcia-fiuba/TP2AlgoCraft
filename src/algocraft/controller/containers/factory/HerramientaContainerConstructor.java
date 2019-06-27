package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public interface HerramientaContainerConstructor {

    boolean esEstaHerramienta(MatrizDefinida<Materializable> forma);

    HerramientaContainer construir(Herramienta herramienta);

}
