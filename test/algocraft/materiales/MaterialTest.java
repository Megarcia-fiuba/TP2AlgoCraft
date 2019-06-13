package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;
import algocraft.herramientas.durabilidad.DurabilidadMadera;
import algocraft.herramientas.durabilidad.DurabilidadMetal;
import algocraft.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.utils.MatrizDefinida;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaterialTest {

    private Hacha hachaMadera;
    private Hacha hachaPiedra;
    private Hacha hachaMetal;
    private Pico picoMadera;
    private Pico picoPiedra;
    private Pico picoMetal;
    private PicoFino picoFino;


    @Before
    public void testSetup(){
        hachaMadera = new Hacha(new DurabilidadMadera());
        hachaPiedra = new Hacha(new DurabilidadPiedra());
        hachaMetal = new Hacha(new DurabilidadMetal());
        picoMadera = new Pico(new DurabilidadMadera());
        picoPiedra = new Pico(new DurabilidadPiedra());
        picoMetal = new Pico(new DurabilidadMetal());
        picoFino = new PicoFino();
    }

    @Test
    public void test01MaderaSeGolpeaConHachaMaderaYReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(hachaMadera);
        Assert.assertEquals(durabilidadInicial - hachaMadera.getFuerza(),madera.getDurabilidad(),0);
    }

    @Test
    public void test02MaderaSeGolpeaConHachaPiedraYReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(hachaPiedra);
        Assert.assertEquals(durabilidadInicial - hachaPiedra.getFuerza(),madera.getDurabilidad(),0);
    }

    @Test
    public void test03MaderaSeGolpeaConHachaMetalYReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(hachaMetal);
        Assert.assertEquals(durabilidadInicial - hachaMetal.getFuerza(),madera.getDurabilidad(), 0);
    }

    @Test
    public void test04MaderaSeGolpeaConPicoMaderaYNoReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(picoMadera);
        Assert.assertEquals(durabilidadInicial ,madera.getDurabilidad(), 0);
    }

    @Test
    public void test05MaderaSeGolpeaConPicoPiedraYNoReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(picoPiedra);
        Assert.assertEquals(durabilidadInicial ,madera.getDurabilidad(), 0);
    }

    @Test
    public void test06MaderaSeGolpeaConPicoMetalYNoReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(picoMetal);
        Assert.assertEquals(durabilidadInicial ,madera.getDurabilidad(), 0);
    }

    @Test
    public void test07MaderaSeGolpeaConPicoFinoYNoReduceDurabilidadMaterial(){

        Materializable madera = new Madera();
        double durabilidadInicial=madera.getDurabilidad();

        madera.recibirGolpe(picoFino);
        Assert.assertEquals(durabilidadInicial ,madera.getDurabilidad(), 0);
    }

    @Test
    public void test08PiedraSeGolpeaConHachaMaderaNoReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(hachaMadera);
        Assert.assertEquals(durabilidadInicial,piedra.getDurabilidad(), 0);

    }

    @Test
    public void test09PiedraSeGolpeaConHachaPiedraNoReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(hachaPiedra);
        Assert.assertEquals(durabilidadInicial,piedra.getDurabilidad(), 0);

    }

    @Test
    public void test10PiedraSeGolpeaConHachaMetalNoReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(hachaMetal);
        Assert.assertEquals(durabilidadInicial,piedra.getDurabilidad(), 0);

    }

    @Test
    public void test11PiedraSeGolpeaConPicoMaderaReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(picoMadera);
        Assert.assertEquals(durabilidadInicial-picoMadera.getFuerza(),piedra.getDurabilidad(), 0);

    }

    @Test
    public void test12PiedraSeGolpeaConPicoPiedraReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(picoPiedra);
        Assert.assertEquals(durabilidadInicial-picoPiedra.getFuerza(), piedra.getDurabilidad(), 0);

    }

    @Test
    public void test13PiedraSeGolpeaConPicoMetalReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(picoMetal);
        Assert.assertEquals(durabilidadInicial-picoMetal.getFuerza(),piedra.getDurabilidad(), 0);

    }

    @Test
    public void test14PiedraSeGolpeaConPicoFinoNoReduceDurabilidadDelMaterial(){

        Materializable piedra = new Piedra();
        double durabilidadInicial= piedra.getDurabilidad();

        piedra.recibirGolpe(picoFino);
        Assert.assertEquals(durabilidadInicial,piedra.getDurabilidad(), 0);

    }

    @Test
    public void test15MetalSeGolpeaConHachaMaderaNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(hachaMadera);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test16MetalSeGolpeaConHachaPiedraNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(hachaPiedra);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test17MetalSeGolpeaConHachaMetalNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(hachaMetal);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test18MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(picoMadera);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test19MetalSeGolpeaConPicoDePiedraReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(picoPiedra);
        Assert.assertEquals(durabilidadInicial - picoPiedra.getFuerza(),metal.getDurabilidad(), 0);

    }

    @Test
    public void test20MetalSeGolpeaConPicoDeMetalNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(picoMetal);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test21MetalSeGolpeaConPicoFinoNoReduceDurabilidadDelMaterial(){

        Materializable metal = new Metal();
        double durabilidadInicial= metal.getDurabilidad();

        metal.recibirGolpe(picoFino);
        Assert.assertEquals(durabilidadInicial,metal.getDurabilidad(), 0);

    }

    @Test
    public void test22DiamanteSeGolpeaConHachaMaderaNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(hachaMadera);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test23DiamanteSeGolpeaConHachaPiedraNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(hachaPiedra);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test24DiamanteSeGolpeaConHachaMetalNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(hachaMetal);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test25DiamanteSeGolpeaConPicoMaderaNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(picoMadera);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test26DiamanteSeGolpeaConPicoPiedraNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(picoPiedra);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test27DiamanteSeGolpeaConPicoMetalNoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(picoMetal);
        Assert.assertEquals(durabilidadInicial,diamante.getDurabilidad(), 0);

    }

    @Test
    public void test28DiamanteSeGolpeaConPicoFinoReduceDurabilidadDelMaterial(){

        Materializable diamante = new Diamante();
        double durabilidadInicial= diamante.getDurabilidad();

        diamante.recibirGolpe(picoFino);
        Assert.assertEquals(durabilidadInicial - picoFino.getFuerza(),diamante.getDurabilidad(), 0);

    }

    @Test
    public void testIgualdadMateriales(){
        Materializable piedra= new Piedra();
        Materializable piedraB= new Piedra();
        Materializable madera= new Madera();
        Materializable maderaB= new Madera();
        Materializable metal= new Metal();
        Materializable metalB= new Metal();

        Assert.assertEquals(madera,maderaB);
        Assert.assertEquals(piedra,piedraB);
        Assert.assertEquals(metal,metalB);
        Assert.assertNotEquals(madera,piedra);
        Assert.assertNotEquals(madera,metal);
        Assert.assertNotEquals(metal,piedra);

    }

}
