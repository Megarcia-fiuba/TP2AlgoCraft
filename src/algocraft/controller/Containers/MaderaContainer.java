package algocraft.controller.Containers;

import algocraft.model.materiales.Madera;

public class MaderaContainer extends MaterialContainer {

    public MaderaContainer() {
        this.material=new Madera();
        this.init();
    }

    public MaderaContainer(Madera madera) {
        this.material = madera;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/madera.png","../view/imagenes/maderaRota.png");
    }
}
