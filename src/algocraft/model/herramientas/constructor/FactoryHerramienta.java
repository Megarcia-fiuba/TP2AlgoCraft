package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.Pico;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

import java.util.Arrays;
import java.util.List;

public class FactoryHerramienta {


    public static Herramienta construirHerramienta(MatrizDefinida<Materializable> forma){
        List<ConstructorHerramienta> constructores= Arrays.asList(new ConstructorHacha(),
                new ConstructorPico(), new ConstructorPicoFino());
        for(ConstructorHerramienta constructor: constructores){
            if(constructor.herramientaEsDeForma(forma)){
                return constructor.construir(forma);
            }
        }
        throw new FormaInvalidaException();
    }
}
