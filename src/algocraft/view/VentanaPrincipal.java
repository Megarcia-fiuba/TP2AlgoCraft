package algocraft.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaPrincipal extends AnchorPane {

    Stage stage;

    public VentanaPrincipal (Stage stage) {

        this.stage = stage;

        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("interfaces/VistaPrincipal.fxml"));
            this.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
