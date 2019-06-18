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
        for(int i = 0; i < materiales.size(); i++){
            ImageView icono = new ImageView(getClass().getResource(materiales.get(i).getIconoPath()).toString());
            icono.setFitHeight(50);
            icono.setFitWidth(50);
            grillaMateriales.add(icono,i %2,(i-i%2)/2);
        }
    }
}
