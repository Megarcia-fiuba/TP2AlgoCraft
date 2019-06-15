package algocraft.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TP2 AlgoCraft");
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
