package algocraft.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class VistaPrincipalController implements Initializable {
    @FXML
    private Button botonComenzar;

    @FXML
    public void handleAccionBotonComenzar(ActionEvent evento) throws IOException {
        Stage stage = (Stage) botonComenzar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getInstancia().getEscenaJuego());
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MediaPlayer reproductor = new MediaPlayer(new Media(new File("assasin-3-assasin.mp3").toURI().toString()));
        reproductor.play();
    }
}
