package algocraft.view;

import algocraft.controller.VistaJuegoController;
import javafx.scene.image.ImageView;

public class VistaMadera extends ImageView {
    public VistaMadera(VistaJuegoController vistaJuegoController){
        super(vistaJuegoController.getClass().getResource("../view/imagenes/madera.png").toString());
        this.setFitHeight(45);
        this.setFitWidth(45);
    }
}
