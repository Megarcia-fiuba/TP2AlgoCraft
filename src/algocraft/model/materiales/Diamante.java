package algocraft.model.materiales;

import algocraft.model.herramientas.PicoFino;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;

public class Diamante extends Materializable {

    private String iconoPath = "../view/imagenes/diamante.png";

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
    public void ocuparPosicionEnMapa(Mapa mapa, Posicion posicion) {
        mapa.ocuparPosicion(posicion, this);
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object obj) {
        return this.mismoMaterial((Materializable)obj);
    }

    @Override
    public String getIconoPath() {
        return this.iconoPath;
    }
}
