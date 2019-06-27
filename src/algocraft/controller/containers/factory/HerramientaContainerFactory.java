package algocraft.controller.containers.factory;

import algocraft.controller.containers.HerramientaContainer;
import algocraft.controller.containers.MaterialContainer;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

import java.util.Arrays;
import java.util.List;

public class HerramientaContainerFactory {

    public static HerramientaContainer construir(MatrizDefinida<Materializable> materiales, Herramienta herramienta){
        List<HerramientaContainerConstructor> containerConstructors= Arrays.asList();
        return null;
    }
}
