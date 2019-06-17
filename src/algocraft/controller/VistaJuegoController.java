package algocraft.controller;

import algocraft.model.juego.Juego;
import algocraft.model.juego.Mapa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaJuegoController implements Initializable {
    @FXML
    private GridPane grillaMapa;

    private Juego juego;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarJuego();
        posicionarElementosEnMapa();
    }

    private void inicializarJuego() { this.juego = new Juego(new Mapa()); }

    private void posicionarElementosEnMapa() {
        Mapa mapa = this.juego.getMapa();

        mapa.getPosicionesOcupadas().forEach((posicion, posicionable) -> {
            ImageView icono = new ImageView(getClass().getResource(posicionable.getIconoPath()).toString());
            icono.setFitHeight(50);
            icono.setFitWidth(50);
            grillaMapa.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }
}
