package algocraft.controller.Containers;

import algocraft.model.materiales.Metal;

public class MetalContainer extends MaterialContainer {

    public MetalContainer() {
        this.material=new Metal();
        this.init();
    }

    public MetalContainer(Metal metal) {
        this.material = metal;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/metal.png","../view/imagenes/metalRoto.png");
    }
}
