package algocraft.view;

import algocraft.model.juego.Juego;
import algocraft.model.juego.Mapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TP2 AlgoCraft");

        Juego juego = inicializarModelo();
        stage.setScene(crearVentanaPrincipal(stage));

        crearVentanaDeJuego(stage, juego);

        stage.show();
    }

    private Juego inicializarModelo() {
        return new Juego(new Mapa());
    }

    private Scene crearVentanaPrincipal(Stage stage) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(stage);
        return new Scene(ventanaPrincipal);
    }

    private void crearVentanaDeJuego(Stage stage, Juego juego) {

    }
}
