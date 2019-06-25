package algocraft.view;

import algocraft.controller.VistaJuegoController;
import javafx.scene.image.ImageView;

public class VistaJugador extends ImageView {

    public VistaJugador(VistaJuegoController vistaJuegoController) {
        super(vistaJuegoController.getClass().getResource("../view/imagenes/jugadorSur.png").toString());
        this.setFitHeight(45);
        this.setFitWidth(45);    }
}
