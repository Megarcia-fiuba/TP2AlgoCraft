package algocraft.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        Parent root = FXMLLoader.load(getClass().getResource("interfaces/VistaPrincipal.fxml"));
        return new Scene(root);
    }

}
