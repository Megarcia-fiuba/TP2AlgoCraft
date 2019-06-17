package algocraft.model.herramientas.constructor;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public interface ConstructorHerramienta {

    Boolean herramientaEsDeForma(MatrizDefinida<Materializable> forma);

    Herramienta construir(MatrizDefinida<Materializable> forma);
}
