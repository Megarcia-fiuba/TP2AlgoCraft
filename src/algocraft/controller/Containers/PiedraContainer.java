package algocraft.controller.Containers;

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
        this.initImages("../view/imagenes/piedra.png","../view/imagenes/piedraRota.png");
    }

}
