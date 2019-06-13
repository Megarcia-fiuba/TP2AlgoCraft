package algocraft.herramientas.constructor;

import algocraft.excepciones.FormaInvalidaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;
import algocraft.materiales.Materializable;
import algocraft.utils.MatrizDefinida;

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
