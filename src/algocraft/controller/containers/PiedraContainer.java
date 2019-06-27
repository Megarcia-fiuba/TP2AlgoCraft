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
    public boolean equals(PiedraContainer piedra) {
        return true;
    }
}
