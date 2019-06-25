package algocraft.model.materiales;

import algocraft.model.herramientas.Pico;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;

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
    public void ocuparPosicionEnMapa(Mapa mapa, Posicion posicion) {
        mapa.ocuparPosicion(posicion, this);
        this.posicion = posicion;
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
