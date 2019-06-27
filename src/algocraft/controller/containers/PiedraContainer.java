package algocraft.controller.containers;

import algocraft.model.materiales.Piedra;

public class PiedraContainer extends MaterialContainer {

    public PiedraContainer() {
        this.material=new Piedra();
        this.init();
    }

    public PiedraContainer(Piedra piedra) {
        this.material = piedra;
        this.init();
    }

    private void init(){
        this.initImages("algocraft/view/imagenes/piedra.png","algocraft/view/imagenes/piedraRota.png");
    }

}
