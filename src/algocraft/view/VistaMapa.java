package algocraft.view;

import algocraft.controller.VistaJuegoController;
import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Madera;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class VistaMapa extends GridPane {


    public void actualizar(VistaJuegoController vistaJuegoController, Mapa mapa) {
        this.inicializarVistasMaderas(vistaJuegoController,mapa);
        this.inicializarVistasPiedras(vistaJuegoController,mapa);
        this.inicializarVistasMetales(vistaJuegoController,mapa);
        this.inicializarVistasDiamantes(vistaJuegoController,mapa);
        this.inicializarVistasJugadores(vistaJuegoController,mapa);

    }

    private void inicializarVistasJugadores(VistaJuegoController vistaJuegoController, Mapa mapa) {
        mapa.getPosicionesOcupadasJugadores().forEach((posicion, jugador) -> {
            ImageView icono = new VistaJugador(vistaJuegoController);
            this.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }

    private void inicializarVistasDiamantes(VistaJuegoController vistaJuegoController, Mapa mapa) {
        mapa.getPosicionesOcupadasDiamantes().forEach((posicion, diamante) -> {
            ImageView icono = new VistaDiamante(vistaJuegoController);
            this.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }

    private void inicializarVistasMetales(VistaJuegoController vistaJuegoController, Mapa mapa) {
        mapa.getPosicionesOcupadasMetales().forEach((posicion, metal) -> {
            ImageView icono = new VistaMetal(vistaJuegoController);
            this.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }

    private void inicializarVistasPiedras(VistaJuegoController vistaJuegoController, Mapa mapa) {
        mapa.getPosicionesOcupadasPiedras().forEach((posicion, piedra) -> {
            ImageView icono = new VistaPiedra(vistaJuegoController);
            this.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }

    private void inicializarVistasMaderas(VistaJuegoController vistaJuegoController, Mapa mapa) {
        mapa.getPosicionesOcupadasMaderas().forEach((posicion, madera) -> {
            ImageView icono = new VistaMadera(vistaJuegoController);
            this.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }


}
