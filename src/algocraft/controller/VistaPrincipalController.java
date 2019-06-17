package algocraft.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class VistaPrincipalController {
    @FXML
    private Button botonComenzar;

    @FXML
    public void handleAccionBotonComenzar(ActionEvent evento) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) botonComenzar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/interfaces/VistaJuego.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
