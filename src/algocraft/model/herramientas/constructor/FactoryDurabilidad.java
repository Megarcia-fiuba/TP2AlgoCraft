package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.herramientas.durabilidad.DurabilidadMetal;
import algocraft.model.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

import java.util.Arrays;
import java.util.List;

public class FactoryDurabilidad {

    public static Durabilidad construirDurabilidadHacha(MatrizDefinida<Materializable> forma) {

        List<ConstructorDurabilidad> constructores = Arrays.asList(new ConstructorDurabilidadMadera(),
                new ConstructorDurabilidadPiedra(), new ConstructorDurabilidadMetal());

        for (ConstructorDurabilidad constructor : constructores) {
            if (constructor.esUnHachaDeEsteMaterial(forma)) {
                return constructor.construir();
            }
        }
        throw new FormaInvalidaException();
    }

    public static Durabilidad construirDurabilidadPico(MatrizDefinida<Materializable> forma) {

        List<ConstructorDurabilidad> constructores = Arrays.asList(new ConstructorDurabilidadMadera(),
                new ConstructorDurabilidadPiedra(), new ConstructorDurabilidadMetal());

        for (ConstructorDurabilidad constructor : constructores) {
            if (constructor.esUnPicoDeEsteMaterial(forma)) {
                return constructor.construir();
            }
        }
        throw new FormaInvalidaException();
    }

}
