package algocraft.model.herramientas.constructor;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class ConstructorPico implements ConstructorHerramienta {
    @Override
    public Boolean herramientaEsDeForma(MatrizDefinida<Materializable> forma) {

        MatrizDefinida<Materializable> formaPico= new MatrizDefinida<>(3,3);
        formaPico.putValor(0,2,new Madera());
        formaPico.putValor(1,2,new Madera());
        formaPico.putValor(2,2,new Madera());
        formaPico.putValor(1,1,new Madera());
        formaPico.putValor(1,0,new Madera());

        return formaPico.equalShape(forma);

    }

    @Override
    public Herramienta construir(MatrizDefinida<Materializable> forma) {

        return new Pico(FactoryDurabilidad.construirDurabilidadPico(forma));
    }
}
