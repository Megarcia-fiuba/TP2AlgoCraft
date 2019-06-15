package algocraft.model.herramientas.constructor;

import algocraft.model.excepciones.LugarOcupadoException;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class MesaDeConstruccion {

    private MatrizDefinida<Materializable> contenido;

    public MesaDeConstruccion() {
        this.contenido = new MatrizDefinida<>(3,3);
    }

    public Herramienta construir(){
        Herramienta herramientaCreada= FactoryHerramienta.construirHerramienta(contenido);
        contenido.vaciar();
        return herramientaCreada;
    }

    public void putMaterial(int coordX,int coordY,Materializable pieza){
        if(contenido.getValor(coordX,coordY)!=null){throw new LugarOcupadoException();}
        contenido.putValor(coordX,coordY,pieza);
    }

    public Materializable removerMaterial(int coordX,int coordY){
        return contenido.popValor(coordX,coordX);
    }
}
