package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.*;
import algocraft.utils.MatrizDefinida;

public class DurabilidadMetal extends Durabilidad {

    public static final MatrizDefinida<Materializable> FORMAHACHA;

    public static final MatrizDefinida<Materializable> FORMAPICO;

    static{
        //init FORMAHACHA
        FORMAHACHA= new MatrizDefinida<>(3,3);
        FORMAHACHA.putValor(0,2,new Metal());
        FORMAHACHA.putValor(1,2,new Metal());
        FORMAHACHA.putValor(0,1,new Metal());
        FORMAHACHA.putValor(1,1,new Madera());
        FORMAHACHA.putValor(1,0,new Madera());
        //init FORMAPICO
        FORMAPICO= new MatrizDefinida<>(3,3);
        FORMAPICO.putValor(0,2,new Metal());
        FORMAPICO.putValor(1,2,new Metal());
        FORMAPICO.putValor(2,2,new Metal());
        FORMAPICO.putValor(1,1,new Madera());
        FORMAPICO.putValor(1,0,new Madera());
    }

    private int usos;

    public DurabilidadMetal() {
        valor = 400.0;
        usos = 10;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 10;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 12;
    }

    @Override
    public void desgastar(Hacha hacha) {
        if(valor - 5 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -=  5.0;
    }

    @Override
    public void desgastar(Pico pico) {
        if(valor == 0){
            throw new DurabilidadTerminadaException();
        }

        usos--;
        if(usos <= 0){
            valor = 0.0;
        }
    }
}
