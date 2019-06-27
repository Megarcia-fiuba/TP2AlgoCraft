package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.LugarOcupadoException;
import algocraft.model.excepciones.PosicionInvalidaException;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class MesaDeConstruccion {

    private MatrizDefinida<Materializable> contenido;

    public MesaDeConstruccion() {
        this.contenido = new MatrizDefinida<>(3,3);
    }

    public Herramienta construir(){
        Herramienta herramientaCreada = FactoryHerramienta.construirHerramienta(contenido);
        contenido.vaciar();
        return herramientaCreada;
    }

    public void putMaterial(int coordX,int coordY,Materializable pieza){
        if(contenido.getValor(coordX,coordY)!=null){throw new LugarOcupadoException();}
        contenido.putValor(coordX,coordY,pieza);
    }

    public Materializable removerMaterial(Posicion posicion){
        return contenido.popValor(posicion.getCoordenadaX(),posicion.getCoordenadaY());
    }

    private void moverMaterial(Posicion origen, Posicion destino){
        if (contenido.getValor(origen.getCoordenadaX(),origen.getCoordenadaY())==null|| contenido.getValor(destino.getCoordenadaX(),destino.getCoordenadaY())!=null){
            throw new PosicionInvalidaException();
        }
        Materializable aMover= contenido.popValor(origen.getCoordenadaX(),origen.getCoordenadaY());
        contenido.putValor(destino.getCoordenadaX(),destino.getCoordenadaY(),aMover);
    }
}
