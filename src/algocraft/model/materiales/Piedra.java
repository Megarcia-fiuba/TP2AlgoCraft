package algocraft.model.materiales;

import algocraft.model.herramientas.Pico;

public class Piedra extends Materializable{

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.getFuerza();
    }

    @Override
    public boolean mismoMaterial(Materializable otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Piedra piedra) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return this.mismoMaterial((Materializable) obj);
    }
}
