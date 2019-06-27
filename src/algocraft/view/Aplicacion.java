package algocraft.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Aplicacion extends Application {

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("TP2 AlgoCraft");

        stage.setScene(crearVentanaPrincipal(stage));

        stage.show();
    }

    private Scene crearVentanaPrincipal(Stage stage) throws IOException {
        MediaPlayer reproductor = new MediaPlayer(new Media(new File("assasin-3-assasin.mp3").toURI().toString()));
        reproductor.play();
        Parent root = FXMLLoader.load(getClass().getResource("interfaces/VistaPrincipal.fxml"));
        return new Scene(root);
    }

}
