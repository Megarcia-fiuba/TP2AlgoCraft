package algocraft.controller.containers;

import algocraft.model.materiales.Madera;

public class MaderaContainer extends MaterialContainer {

    public MaderaContainer() {
        this.material = new Madera();
        this.init();
    }

    public MaderaContainer(Madera madera) {
        this.material = madera;
        this.init();
    }

    private void init(){
        this.initImages("algocraft/view/imagenes/madera.png","algocraft/view/imagenes/maderaRota.png");
    }
}
