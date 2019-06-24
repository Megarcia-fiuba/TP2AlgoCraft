package algocraft.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

import algocraft.view.inicio.ContenedorInicio;

public class Aplicacion extends Application {

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TP2 AlgoCraft");
        
        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio);

        stage.setScene(escenaInicio);
		stage.setFullScreen(true);
		stage.show();
    }


}
