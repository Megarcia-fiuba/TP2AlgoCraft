package algocraft.model.herramientas.durabilidad;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;
import algocraft.model.utils.MatrizDefinida;

public class DurabilidadPiedra extends Durabilidad {

    public static final MatrizDefinida<Materializable> FORMAHACHA;

    public static final MatrizDefinida<Materializable> FORMAPICO;

    static{
        //init FORMAHACHA
        FORMAHACHA= new MatrizDefinida<>(3,3);
        FORMAHACHA.putValor(0,2,new Piedra());
        FORMAHACHA.putValor(1,2,new Piedra());
        FORMAHACHA.putValor(0,1,new Piedra());
        FORMAHACHA.putValor(1,1,new Madera());
        FORMAHACHA.putValor(1,0,new Madera());

        //init FORMAPICO
        FORMAPICO= new MatrizDefinida<>(3,3);
        FORMAPICO.putValor(0,2,new Piedra());
        FORMAPICO.putValor(1,2,new Piedra());
        FORMAPICO.putValor(2,2,new Piedra());
        FORMAPICO.putValor(1,1,new Madera());
        FORMAPICO.putValor(1,0,new Madera());
    }

    public DurabilidadPiedra() {
        valor = 200.0;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 5;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 4;
    }

    @Override
    public void desgastar(Hacha hacha) {
        if( valor - 5 < 0) {
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 5;
    }

    @Override
    public void desgastar(Pico pico) {
        if( valor - 4/1.5 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 4/1.5;
    }

    @Override
    public boolean romperMaterial(Metal metal) {
        return true;
    }

    @Override
    public String getIconoPath(Hacha hacha) {
        return "../view/imagenes/hachaPiedra.jpg";
    }

    @Override
    public String getIconoPath(Pico pico) {
        return "../view/imagenes/picoPiedra.png";
    }
}
