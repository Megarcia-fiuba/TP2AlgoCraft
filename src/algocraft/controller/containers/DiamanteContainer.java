package algocraft.controller.containers;

import algocraft.model.materiales.Diamante;

public class DiamanteContainer extends MaterialContainer {

    public DiamanteContainer() {
        this.material = new Diamante();
        this.init();
    }

    public DiamanteContainer(Diamante diamante) {
        this.material = diamante;
        this.init();
    }

    private void init(){
        this.initImages("algocraft/view/imagenes/diamante.jpg","algocraft/view/imagenes/diamanteRoto.png");
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
    public boolean equals(DiamanteContainer diamante) {
        return true;
    }
}
