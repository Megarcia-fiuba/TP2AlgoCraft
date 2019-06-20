package algocraft.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class VistaPrincipalController {
    @FXML
    private Button botonComenzar;

    @FXML
    public void handleAccionBotonComenzar(ActionEvent evento) throws IOException {
        Stage stage = (Stage) botonComenzar.getScene().getWindow();
//        Parent root = FXMLLoader.load(new File("src/algocraft/view/interfaces/VistaJuego.fxml").toURL());

        stage.setScene(ProveedorEscena.getEscenaJuego());
        stage.show();
    }

}
