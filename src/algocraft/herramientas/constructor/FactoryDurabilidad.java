package algocraft.herramientas.constructor;

import algocraft.excepciones.FormaInvalidaException;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.herramientas.durabilidad.DurabilidadMadera;
import algocraft.herramientas.durabilidad.DurabilidadMetal;
import algocraft.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.materiales.Materializable;
import algocraft.utils.MatrizDefinida;

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
