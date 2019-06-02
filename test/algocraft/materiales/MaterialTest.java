package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Madera;
import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.DurabilidadMadera;
import org.junit.Assert;
import org.junit.Test;

public class MaterialTest {

    @Test
    public void test01MaderaSeGolpeaConHachaMaderaYReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        int durabilidadInicial=madera.getDurabilidad();
        Hacha hachaMadera = new Hacha(new DurabilidadMadera());

        madera.recibirGolpe(hachaMadera);
        Assert.assertEquals(madera.getDurabilidad(),durabilidadInicial - hachaMadera.getFuerza());
    }

    @Test
    public void test02PiedraSeGolpeaConHachaNoReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        int durabilidadInicial= piedra.getDurabilidad();
        Hacha hachaMadera = new Hacha(new DurabilidadMadera());

        piedra.recibirGolpe(hachaMadera);
        Assert.assertEquals(piedra.getDurabilidad(),durabilidadInicial);

    }

    @Test
    public void test03MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        int durabilidadInicial= metal.getDurabilidad();
        Pico picoMadera= new Pico(new DurabilidadMadera());

        metal.recibirGolpe(picoMadera);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad());

    }
}
