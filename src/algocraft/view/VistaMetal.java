package algocraft.view;

import algocraft.controller.VistaJuegoController;
import javafx.scene.image.ImageView;

public class VistaMetal extends ImageView {
    public VistaMetal(VistaJuegoController vistaJuegoController) {
        super(vistaJuegoController.getClass().getResource("../view/imagenes/Metal.png").toString());
        this.setFitHeight(45);
        this.setFitWidth(45);
    }
}
