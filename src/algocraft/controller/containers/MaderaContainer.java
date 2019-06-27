package algocraft.controller.containers;

import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;

public class MaderaContainer extends MaterialContainer {

    public MaderaContainer() {
        this.material = new Madera();
        this.init();
    }

    public MaderaContainer(Materializable madera) {
        this.material = madera;
        this.init();
    }

    private void init(){
        this.initImages("algocraft/view/imagenes/madera.png","algocraft/view/imagenes/maderaRota.png");
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
    public boolean equals(MaderaContainer madera) {
        return true;
    }
}
