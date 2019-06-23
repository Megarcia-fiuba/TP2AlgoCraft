package algocraft.controller.SubVistas;

import algocraft.controller.VistaConstructorController;
import algocraft.controller.VistaJuegoController;
import algocraft.model.materiales.Madera;
import javafx.scene.image.ImageView;

public class MaderaView extends MaterialView{

    public MaderaView() {
        this.material=new Madera();
        this.init();
    }

    public MaderaView(Madera madera) {
        this.material = madera;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/madera.png","../view/imagenes/maderaRota.png");
    }
}
