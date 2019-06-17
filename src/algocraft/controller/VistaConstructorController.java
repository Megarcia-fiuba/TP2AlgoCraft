package algocraft.controller;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.materiales.Materializable;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Material;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaConstructorController implements Initializable {
   @FXML
    private Button botonRegresar;
   @FXML
    private GridPane grillaMateriales;

    public void handleAccionBotonRegresar(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getEscenaJuego());
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarMateriales();
    }

    private void cargarMateriales() {
        List<Materializable> materiales = VistaJuegoController.getJuego().getJugador().getMaterialesRecolectados();
        materiales.forEach(material -> {
            ImageView icono = new ImageView(getClass().getResource(material.getIconoPath()).toString());
            icono.setFitHeight(50);
            icono.setFitWidth(50);
            //Esto no funciona porque indexOf() devuelve la misma posicion cuando encuentra un material de la misma clase que "material"
            int posicion = materiales.indexOf(material);
            grillaMateriales.add(icono,posicion %2,(posicion-posicion%2)/2);
        });
    }
}
