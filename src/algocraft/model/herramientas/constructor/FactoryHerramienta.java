package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.Pico;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class FactoryHerramienta {


    public static Herramienta construirHerramienta(MatrizDefinida<Materializable> forma){
        if(forma.equalShape(Hacha.FORMA)){
            return new Hacha(FactoryDurabilidad.construirDurabilidadHacha(forma));
        }else if(forma.equalShape(Pico.FORMA)){
            return new Pico(FactoryDurabilidad.construirDurabilidadPico(forma));
        }else if(forma.equal(PicoFino.FORMACOMPLETA)){
            return new PicoFino();
        }
        throw new FormaInvalidaException();
    }
}
