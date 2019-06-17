package algocraft.model.materiales;

import algocraft.model.herramientas.Pico;

public class Metal extends Materializable{

    private String iconoPath = "../view/imagenes/metal.png";
	
    public Metal(){
        durabilidad = 50;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.romperMaterial(this);
    }

    @Override
    public boolean mismoMaterial(Materializable otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Metal metal) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return this.mismoMaterial((Materializable) obj);
    }

    @Override
    public String getIconoPath() {
        return this.iconoPath;
    }
}
