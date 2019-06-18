package algocraft.model.herramientas.durabilidad;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class DurabilidadMadera extends Durabilidad{

    /**
     * Matriz que representa la forma de un hacha, creada con madera
     */
    public static final MatrizDefinida<Materializable> FORMAHACHA;


    public static final MatrizDefinida<Materializable> FORMAPICO;

    static{
        //init FORMAHACHA
        FORMAHACHA= new MatrizDefinida<>(3,3);
        FORMAHACHA.putValor(0,2,new Madera());
        FORMAHACHA.putValor(1,2,new Madera());
        FORMAHACHA.putValor(0,1,new Madera());
        FORMAHACHA.putValor(1,1,new Madera());
        FORMAHACHA.putValor(1,0,new Madera());

        //init FORMAPICO
        FORMAPICO= new MatrizDefinida<>(3,3);
        FORMAPICO.putValor(0,2,new Madera());
        FORMAPICO.putValor(1,2,new Madera());
        FORMAPICO.putValor(2,2,new Madera());
        FORMAPICO.putValor(1,1,new Madera());
        FORMAPICO.putValor(1,0,new Madera());
    }



    public DurabilidadMadera(){
        valor = 100.0;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 2;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 2;
    }

    @Override
    public void desgastar(Hacha hacha) {
        if( valor - 2 < 0 ){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 2;
    }

    @Override
    public void desgastar(Pico pico) {
        if( valor - 2 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 2;
    }

    @Override
    public String getIconoPath(Hacha hacha) {
        return "../view/imagenes/hachaMadera.jpg";
    }

    @Override
    public String getIconoPath(Pico pico) {
        return "../view/imagenes/picoMadera.png";
    }
}
