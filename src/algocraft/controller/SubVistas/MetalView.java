package algocraft.controller.SubVistas;

import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;

public class MetalView extends MaterialView{

    public MetalView() {
        this.material=new Metal();
        this.init();
    }

    public MetalView(Metal metal) {
        this.material = metal;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/metal.png","../view/imagenes/metalRoto.png");
    }
}
