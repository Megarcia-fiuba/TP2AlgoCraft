package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;
import algocraft.model.utils.MatrizDefinida;

public class ConstructorPicoFino implements ConstructorHerramienta {
    @Override
    public Boolean herramientaEsDeForma(MatrizDefinida<Materializable> forma) {
        MatrizDefinida<Materializable> formaPicoFino = new MatrizDefinida<>(3, 3);
        formaPicoFino.putValor(0, 2, new Metal());
        formaPicoFino.putValor(1, 2, new Metal());
        formaPicoFino.putValor(2, 2, new Metal());
        formaPicoFino.putValor(0, 1, new Piedra());
        formaPicoFino.putValor(1, 1, new Madera());
        formaPicoFino.putValor(1, 0, new Madera());
        return formaPicoFino.equal(forma);
    }

    @Override
    public Herramienta construir(MatrizDefinida<Materializable> forma) {

        if (!herramientaEsDeForma(forma)){throw new FormaInvalidaException();}

        return new PicoFino();
    }
}
