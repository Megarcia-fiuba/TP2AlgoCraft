package algocraft.model.herramientas.constructor;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class ConstructorHacha implements ConstructorHerramienta{
    @Override
    public Boolean herramientaEsDeForma(MatrizDefinida<Materializable> forma) {

        MatrizDefinida<Materializable> formaHacha= new MatrizDefinida<>(3,3);
        formaHacha.putValor(0,2,new Madera());
        formaHacha.putValor(1,2,new Madera());
        formaHacha.putValor(0,1,new Madera());
        formaHacha.putValor(1,1,new Madera());
        formaHacha.putValor(1,0,new Madera());

        return forma.equalShape(formaHacha);
    }

    @Override
    public Herramienta construir(MatrizDefinida<Materializable> forma) {

        return new Hacha(FactoryDurabilidad.construirDurabilidadHacha(forma));

    }
}
