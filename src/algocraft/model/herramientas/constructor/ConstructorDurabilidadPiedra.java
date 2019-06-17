package algocraft.model.herramientas.constructor;

import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Piedra;
import algocraft.model.utils.MatrizDefinida;

public class ConstructorDurabilidadPiedra implements ConstructorDurabilidad {


    @Override
    public Boolean esUnHachaDeEsteMaterial(MatrizDefinida<Materializable> forma) {

        MatrizDefinida<Materializable> formaHacha= new MatrizDefinida<>(3,3);
        formaHacha.putValor(0,2,new Piedra());
        formaHacha.putValor(1,2,new Piedra());
        formaHacha.putValor(0,1,new Piedra());
        formaHacha.putValor(1,1,new Madera());
        formaHacha.putValor(1,0,new Madera());

        return formaHacha.equal(forma);
    }

    @Override
    public Boolean esUnPicoDeEsteMaterial(MatrizDefinida<Materializable> forma) {

        MatrizDefinida<Materializable> formaPico= new MatrizDefinida<>(3,3);
        formaPico.putValor(0,2,new Piedra());
        formaPico.putValor(1,2,new Piedra());
        formaPico.putValor(2,2,new Piedra());
        formaPico.putValor(1,1,new Madera());
        formaPico.putValor(1,0,new Madera());

        return formaPico.equal(forma);
    }

    @Override
    public Durabilidad construir() {

        return new DurabilidadPiedra();
    }
}
