package Tests;

import Clases.*;
import org.junit.Assert;
import org.junit.Test;

public class MaterialTest {

    @Test
    public void test01MaderaSeGolpeaConHachaMaderaYReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        Hacha hachaMadera = new Hacha(new DurabilidadMadera());

        madera.recibirGolpe(hachaMadera);
        Assert.assertEquals(madera.getDurabilidad(),10 - hachaMadera.getFuerza());
    }
}
