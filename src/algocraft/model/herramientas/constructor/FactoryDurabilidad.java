package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.herramientas.durabilidad.DurabilidadMetal;
import algocraft.model.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class FactoryDurabilidad {

    public static Durabilidad construirDurabilidadHacha(MatrizDefinida<Materializable> forma){
        if(forma.equal(DurabilidadMadera.FORMAHACHA)){
            return new DurabilidadMadera();
        }else if(forma.equal(DurabilidadPiedra.FORMAHACHA)){
            return new DurabilidadPiedra();
        }else if(forma.equal(DurabilidadMetal.FORMAHACHA)){
            return new DurabilidadMetal();
        }
        throw new FormaInvalidaException();
    }

    public static Durabilidad construirDurabilidadPico(MatrizDefinida<Materializable> forma){
        if(forma.equal(DurabilidadMadera.FORMAPICO)){
            return new DurabilidadMadera();
        }else if(forma.equal(DurabilidadPiedra.FORMAPICO)){
            return new DurabilidadPiedra();
        }else if(forma.equal(DurabilidadMetal.FORMAPICO)){
            return new DurabilidadMetal();
        }
        throw new FormaInvalidaException();
    }

}
