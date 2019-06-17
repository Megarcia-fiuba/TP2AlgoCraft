package algocraft.controller;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.juego.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaHerramientasController implements Initializable {
    @FXML
    private Button botonRegresar;
    @FXML
    private GridPane grillaHerramienta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarHerramientas();
    }

    private void cargarHerramientas() {
        List<Herramienta> herramientas = VistaJuegoController.getJuego().getJugador().getHerramientas();
        herramientas.forEach(herramienta -> {
            ImageView icono = new ImageView(getClass().getResource(herramienta.getIconoPath()).toString());
            icono.setFitHeight(75);
            icono.setFitWidth(75);
            grillaHerramienta.add(icono,herramientas.indexOf(herramienta),0);
        });
    }

    @FXML
    public void handleAccionBotonRegresar(ActionEvent evento) throws IOException {
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getEscenaJuego());
        stage.show();
    }
}
