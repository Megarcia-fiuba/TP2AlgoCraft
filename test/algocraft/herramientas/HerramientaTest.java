package algocraft.herramientas;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;
import algocraft.materiales.*;
import algocraft.materiales.propiedades.DurabilidadMadera;
import algocraft.materiales.propiedades.DurabilidadMetal;
import algocraft.materiales.propiedades.DurabilidadPiedra;
import org.junit.Assert;
import org.junit.Test;

public class HerramientaTest {

    @Test
    public void test01CreaHachaMaderaConDurabilidadYFuerzaCorrespondiente() {

        Herramienta herramienta = new Hacha(new DurabilidadMadera());

        Assert.assertEquals(herramienta.getDurabilidad(), 100);
        Assert.assertEquals(herramienta.getFuerza(), 2);

    }

    @Test
    public void test02CreaPicoMaderaConDurabilidadYFuerzaCorrespondiente() {

        Herramienta herramienta = new Pico(new DurabilidadMadera());

        Assert.assertEquals(herramienta.getDurabilidad(), 100);
        Assert.assertEquals(herramienta.getFuerza(), 2);

    }

    @Test
    public void test03CreaHachaMetalConDurabilidadYFuerzaCorrespondiente() {

        Herramienta herramienta = new Hacha(new DurabilidadMetal());

        Assert.assertEquals(herramienta.getDurabilidad(), 400);
        Assert.assertEquals(herramienta.getFuerza(), 10);

    }

    @Test
    public void test04CreaPicoMetalConDurabilidadYFuerzaCorrespondiente() {

        Herramienta herramienta = new Pico(new DurabilidadMetal());

        Assert.assertEquals(herramienta.getDurabilidad(), 400);
        Assert.assertEquals(herramienta.getFuerza(), 12);

    }

    @Test
    public void test05CreaPicoFinoConDurabilidadYFuerzaCorrespondiente() {

        Herramienta herramienta = new PicoFino();

        Assert.assertEquals(herramienta.getDurabilidad(), 1000);
        Assert.assertEquals(herramienta.getFuerza(), 20);

    }

    @Test
    public void test06UsarHachaContraMaterialesYReduceDurabilidadCorrespondienteAlMaterialDelHacha() {

        Materializable madera = new Madera();
        Materializable piedra = new Piedra();
        Materializable metal = new Metal();
        Materializable diamante = new Diamante();
        Herramienta hachaMadera = new Hacha(new DurabilidadMadera());
        Herramienta hachaPiedra = new Hacha(new DurabilidadPiedra());
        Herramienta hachaMetal = new Hacha(new DurabilidadMetal());

        hachaMadera.usar(madera);
        hachaPiedra.usar(madera);
        hachaMetal.usar(madera);
        Assert.assertEquals(hachaMadera.getDurabilidad(), 100 - hachaMadera.getFuerza());
        Assert.assertEquals(hachaPiedra.getDurabilidad(), 200 - hachaPiedra.getFuerza());
        Assert.assertEquals(hachaMetal.getDurabilidad(), 400 - hachaMetal.getFuerza() / 2);

        hachaMadera.usar(piedra);
        hachaPiedra.usar(piedra);
        hachaMetal.usar(piedra);
        Assert.assertEquals(hachaMadera.getDurabilidad(), 100 - 2 * hachaMadera.getFuerza());
        Assert.assertEquals(hachaPiedra.getDurabilidad(), 200 - 2 * hachaPiedra.getFuerza());
        Assert.assertEquals(hachaMetal.getDurabilidad(), 400 - 2 * hachaMetal.getFuerza() / 2);

        hachaMadera.usar(metal);
        hachaPiedra.usar(metal);
        hachaMetal.usar(metal);
        Assert.assertEquals(hachaMadera.getDurabilidad(), 100 - 3 * hachaMadera.getFuerza());
        Assert.assertEquals(hachaPiedra.getDurabilidad(), 200 - 3 * hachaPiedra.getFuerza());
        Assert.assertEquals(hachaMetal.getDurabilidad(), 400 - 3 * hachaMetal.getFuerza() / 2);

        hachaMadera.usar(diamante);
        hachaPiedra.usar(diamante);
        hachaMetal.usar(diamante);
        Assert.assertEquals(hachaMadera.getDurabilidad(), 100 - 4 * hachaMadera.getFuerza());
        Assert.assertEquals(hachaPiedra.getDurabilidad(), 200 - 4 * hachaPiedra.getFuerza());
        Assert.assertEquals(hachaMetal.getDurabilidad(), 400 - 4 * hachaMetal.getFuerza() / 2);
    }

    @Test
    public void test07UsarPicoContraMaterialesYReduceDurabilidadCorrespondienteAlMaterialDelPico() {

        Materializable madera = new Madera();
        Materializable piedra = new Piedra();
        Materializable metal = new Metal();
        Materializable diamante = new Diamante();
        Herramienta picoMadera = new Pico(new DurabilidadMadera());
        Herramienta picoPiedra = new Pico(new DurabilidadPiedra());
        Herramienta picoMetal = new Pico(new DurabilidadMetal());

        picoMadera.usar(madera);
        picoPiedra.usar(madera);
        picoMetal.usar(madera);
        Assert.assertEquals(picoMadera.getDurabilidad(), 100 - picoMadera.getFuerza());
        Assert.assertEquals(picoPiedra.getDurabilidad(), 200 - (int) (picoPiedra.getFuerza() / 1.5));
        Assert.assertEquals(picoMetal.getDurabilidad(), 400);

        picoMadera.usar(piedra);
        picoPiedra.usar(piedra);
        picoMetal.usar(piedra);
        Assert.assertEquals(picoMadera.getDurabilidad(), 100 - 2 * picoMadera.getFuerza());
        Assert.assertEquals(picoPiedra.getDurabilidad(), 200 - 2 * (int) (picoPiedra.getFuerza() / 1.5));
        Assert.assertEquals(picoMetal.getDurabilidad(), 400);

        picoMadera.usar(metal);
        picoPiedra.usar(metal);
        picoMetal.usar(metal);
        Assert.assertEquals(picoMadera.getDurabilidad(), 100 - 3 * picoMadera.getFuerza());
        Assert.assertEquals(picoPiedra.getDurabilidad(), 200 - 3 * (int) (picoPiedra.getFuerza() / 1.5));
        Assert.assertEquals(picoMetal.getDurabilidad(), 400);

        picoMadera.usar(diamante);
        picoPiedra.usar(diamante);
        picoMetal.usar(diamante);
        Assert.assertEquals(picoMadera.getDurabilidad(), 100 - 4 * picoMadera.getFuerza());
        Assert.assertEquals(picoPiedra.getDurabilidad(), 200 - 4 * (int) (picoPiedra.getFuerza() / 1.5));
        Assert.assertEquals(picoMetal.getDurabilidad(), 400);
    }

    @Test
    public void test08UsarPicoFinoContraDiamanteReduceDurabilidadCorrespondiente() {

        Materializable diamante = new Diamante();
        Herramienta picoFino = new PicoFino();

        picoFino.usar(diamante);
        Assert.assertEquals(picoFino.getDurabilidad(), 1000 - picoFino.getFuerza() / 10);
    }
    @Test
    public void test09UsarPicoFinoContraOtrosMaterialesNoReduceDurabilidad() {

        Materializable madera = new Madera();
        Materializable piedra = new Piedra();
        Materializable metal = new Metal();
        Herramienta picoFino = new PicoFino();

        picoFino.usar(madera);
        Assert.assertEquals(picoFino.getDurabilidad(), 1000);

        picoFino.usar(piedra);
        Assert.assertEquals(picoFino.getDurabilidad(), 1000);

        picoFino.usar(metal);
        Assert.assertEquals(picoFino.getDurabilidad(), 1000);
    }
}