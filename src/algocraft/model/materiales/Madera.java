package algocraft.model.materiales;

import algocraft.model.herramientas.Hacha;

public class Madera extends Materializable{

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {
        durabilidad -= hacha.getFuerza();
    }


    @Override
    public boolean mismoMaterial(Materializable otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Madera madera) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return this.mismoMaterial((Materializable) obj);
    }
}
