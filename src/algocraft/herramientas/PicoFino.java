package algocraft.herramientas;

import algocraft.herramientas.durabilidad.DurabilidadPicoFino;
import algocraft.materiales.Diamante;
import algocraft.materiales.Materializable;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.fuerza = 20;
        this.durabilidad=new DurabilidadPicoFino();
    }

    @Override
    public int getDurabilidad() {
        return durabilidad.getValor();
    }


    @Override
    public void usar(Materializable materializable) {
        materializable.desgastar(this);
        materializable.recibirGolpe(this);
    }

    public void desgastar(Materializable material){

    }

    public void desgastar(Diamante diamante){
        durabilidad.romperMaterial(diamante);
    }
}
