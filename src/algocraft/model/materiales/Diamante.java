package algocraft.model.materiales;

import algocraft.model.herramientas.PicoFino;

public class Diamante extends Materializable {

    public Diamante(){
        durabilidad = 100;
    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {
        durabilidad -= picoFino.getFuerza();
        picoFino.desgastar(this);
    }

    @Override
    public boolean mismoMaterial(Materializable otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Diamante diamante) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return this.mismoMaterial((Materializable)obj);
    }

}
