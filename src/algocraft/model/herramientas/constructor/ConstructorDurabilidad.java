package algocraft.model.herramientas.constructor;

import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public interface ConstructorDurabilidad {

    Boolean esUnHachaDeEsteMaterial(MatrizDefinida<Materializable> forma);

    Boolean esUnPicoDeEsteMaterial(MatrizDefinida<Materializable> forma);

    Durabilidad construir();
}
