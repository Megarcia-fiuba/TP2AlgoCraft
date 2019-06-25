package algocraft.view;

import algocraft.controller.VistaJuegoController;
import javafx.scene.image.ImageView;

public class VistaPiedra extends ImageView {
    public VistaPiedra(VistaJuegoController vistaJuegoController) {
        super(vistaJuegoController.getClass().getResource("../view/imagenes/piedra.png").toString());
        this.setFitHeight(45);
        this.setFitWidth(45);
    }
}
