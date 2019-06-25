package algocraft.controller.containers;

import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class MapaContainer extends GridPane {

    private static final int CENTRO_MAPA = 5;
    private static final int TAMANIO_MAPA = 10;

    private Mapa mapa;
    private List<MaterialContainer> materiales;
    private JugadorContainer jugador;

    public MapaContainer(){
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
        this.materiales.forEach(material -> {
            this.add(material.getImageView(), material.getPosicion().getCoordenadaX(), material.getPosicion().getCoordenadaY());
        });
    }

    public void posicionarJugador(Jugador jugador) {
        this.jugador = new JugadorContainer(jugador);
        this.jugador.ocuparPosicionEnMapa(this.mapa);
        this.add(this.jugador.getImageView(), jugador.getPosicion().getCoordenadaX(), jugador.getPosicion().getCoordenadaY());
    }

    private void inicializarElementos() {
        this.materiales = new ArrayList<>();

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
        this.materiales.add(madera);
        this.add(madera.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevaPiedra(Posicion posicion) {
        PiedraContainer piedra = new algocraft.controller.containers.PiedraContainer(new Piedra());
        piedra.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.add(piedra);
        this.add(piedra.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevoMetal(Posicion posicion) {
        MetalContainer metal = new MetalContainer(new Metal());
        metal.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.add(metal);
        this.add(metal.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void posicionarNuevoDiamante(Posicion posicion) {
        DiamanteContainer diamante = new DiamanteContainer(new Diamante());
        diamante.ocuparPosicionEnMapa(mapa, posicion);
        this.materiales.add(diamante);
        this.add(diamante.getImageView(), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }
}
