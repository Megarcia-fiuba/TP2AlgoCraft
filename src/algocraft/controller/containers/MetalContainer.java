package algocraft.controller.containers;

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
        this.initImages("algocraft/view/imagenes/metal.png","algocraft/view/imagenes/metalRoto.png");
    }

    @Override
    public boolean equals(Object obj) {
        try{
            MaterialContainer o=(MaterialContainer) obj;
            return o.equals(this);
        }catch(ClassCastException c){
            return super.equals(obj);
        }
    }

    @Override
    public boolean equals(MetalContainer metal) {
        return true;
    }
}
