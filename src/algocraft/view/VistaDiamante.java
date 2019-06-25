package algocraft.view;

import algocraft.controller.VistaJuegoController;
import javafx.scene.image.ImageView;

public class VistaDiamante extends ImageView {
    public VistaDiamante(VistaJuegoController vistaJuegoController) {
        super(vistaJuegoController.getClass().getResource("../view/imagenes/diamante.png").toString());
        this.setFitHeight(45);
        this.setFitWidth(45);
    }
}
