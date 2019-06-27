package algocraft.view;

import algocraft.controller.containers.*;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaView extends GridPane {

    private static final int CENTRO_MAPA = 5;
    private static final int TAMANIO_MAPA = 10;

    private Mapa mapa;
    private Map<Posicion, MaterialContainer> materiales;
    private JugadorContainer jugador;

    public MapaView(){
        super();
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void inicializar(Mapa mapa) {
        this.mapa = mapa;
        inicializarElementos();
    }

    public void refresh() {
        this.getChildren().retainAll(this.getChildren().get(0));
        refreshPosicionesMateriales();
        refreshPosicionJugador();
    }

    private void refreshPosicionesMateriales(){
        List<Posicion> posicionesDesocupadas = new ArrayList<>();
        this.materiales.forEach((posicion, material) -> {
            if(this.mapa.getPosicionesOcupadas().containsKey(posicion)){
                this.add(material.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
            } else {
                posicionesDesocupadas.add(posicion);
            }
        });
        posicionesDesocupadas.forEach(p -> this.materiales.remove(p));
    }

    private void refreshPosicionJugador(){
        this.add(this.jugador.getImageView(), this.jugador.getPosicion().getCoordenadaX(), this.jugador.getPosicion().getCoordenadaY());
    }

    public void posicionarJugador(JugadorContainer jugador) {
        this.jugador = jugador;
        this.jugador.ocuparPosicionEnMapa(this.mapa);
        this.add(this.jugador.getImageView(), jugador.getPosicion().getCoordenadaX(), jugador.getPosicion().getCoordenadaY());
    }

    private void inicializarElementos() {
        this.materiales = new HashMap<>();

        for (int posicion = 0; posicion < CENTRO_MAPA; posicion++ ) {
            posicionarNuevaMadera(new Posicion(posicion, CENTRO_MAPA));
            posicionarNuevaPiedra(new Posicion(CENTRO_MAPA, posicion));
        }

        for (int posicion = TAMANIO_MAPA; posicion > CENTRO_MAPA; posicion--) {
            posicionarNuevaMadera(new Posicion(posicion, CENTRO_MAPA));
            posicionarNuevoMetal(new Posicion(CENTRO_MAPA, posicion));
        }

        posicionarNuevoDiamante(new Posicion(CENTRO_MAPA, CENTRO_MAPA));
    }


    private void posicionarNuevaMadera(Posicion posicion) {
        MaderaContainer madera = new MaderaContainer();
        madera.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.put(posicion, madera);
        this.add(madera.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevaPiedra(Posicion posicion) {
        PiedraContainer piedra = new algocraft.controller.containers.PiedraContainer(new Piedra());
        piedra.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.put(posicion, piedra);
        this.add(piedra.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevoMetal(Posicion posicion) {
        MetalContainer metal = new MetalContainer(new Metal());
        metal.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.put(posicion, metal);
        this.add(metal.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevoDiamante(Posicion posicion) {
        DiamanteContainer diamante = new DiamanteContainer(new Diamante());
        diamante.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.put(posicion, diamante);
        this.add(diamante.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }
}
