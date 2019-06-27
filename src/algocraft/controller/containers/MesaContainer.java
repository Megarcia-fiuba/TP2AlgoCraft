package algocraft.controller.containers;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.constructor.MesaDeConstruccion;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

import javax.swing.text.html.ImageView;
import java.util.List;

public class MesaContainer {
    private MatrizDefinida<MaterialContainer> casilleros;
    private MesaDeConstruccion mesa;

    public MesaContainer(MesaDeConstruccion mesa) {
        this.mesa = mesa;
        this.casilleros= new MatrizDefinida<>(3,3);
    }

    public MaterialContainer getMaterialContainer(Posicion posicion){
        return casilleros.getValor(posicion.getCoordenadaX(),posicion.getCoordenadaY());
    }

    public MaterialContainer popMaterialContainer(Posicion posicion){
        mesa.removerMaterial(posicion);
        return casilleros.popValor(posicion.getCoordenadaX(),posicion.getCoordenadaY());
    }

    public void addMaterialContainer(MaterialContainer materialContainer,Posicion posicion){
        mesa.putMaterial(posicion.getCoordenadaX(),2-posicion.getCoordenadaY(),materialContainer.getMaterial());
        this.casilleros.putValor(posicion.getCoordenadaX(),posicion.getCoordenadaY(),materialContainer);
    }

    public List<MaterialContainer> recuperarMateriales(){
        mesa.recuperarTodos();
        return this.casilleros.obtenerTodos();
    }

    public void construir(){

        Herramienta a = mesa.construir();

    }

    public void add(Materializable material,Posicion posicion){
        mesa.putMaterial(posicion.getCoordenadaX(),2-posicion.getCoordenadaY(),material);
    }
}
