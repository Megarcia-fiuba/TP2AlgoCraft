package algocraft.herramientas;

import algocraft.materiales.*;
import algocraft.herramientas.durabilidad.DurabilidadMadera;
import algocraft.herramientas.durabilidad.DurabilidadMetal;
import algocraft.herramientas.durabilidad.DurabilidadPiedra;
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
    public void test06UsarHachaConDurabilidadMaderaContraMaderaYReduceDurabilidadRestandoLaFuerza() {
        Materializable madera = new Madera();
        Herramienta hachaMadera = new Hacha(new DurabilidadMadera());
        int durabilidadInicial = hachaMadera.getDurabilidad();

        hachaMadera.usar(madera);
        Assert.assertEquals(durabilidadInicial - hachaMadera.getFuerza(), hachaMadera.getDurabilidad());
    }

    @Test
    public void test07UsarHachaConDurabilidadMaderaContraPiedraYReduceDurabilidadoRestandoLaFuerza() {
        Materializable piedra = new Piedra();
        Herramienta hachaMadera = new Hacha(new DurabilidadMadera());
        int durabilidadInicial = hachaMadera.getDurabilidad();

        hachaMadera.usar(piedra);
        Assert.assertEquals(durabilidadInicial - hachaMadera.getFuerza(), hachaMadera.getDurabilidad());
    }

    @Test public void test08UsarHachaConDurabilidadMaderaContraMetalYReduceDurabilidadRestandoLaFuerza(){
        Materializable metal = new Metal();
        Herramienta hachaMadera = new Hacha(new DurabilidadMadera());
        int durabilidadInicial = hachaMadera.getDurabilidad();

        hachaMadera.usar(metal);
        Assert.assertEquals(durabilidadInicial - hachaMadera.getFuerza(), hachaMadera.getDurabilidad());
    }

    @Test public void test09UsarHachaConDurabilidadMaderaContraDiamanteYReduceDurabilidadRestandoLaFuerza(){
        Materializable diamante = new Diamante();
        Herramienta hachaMadera = new Hacha(new DurabilidadMadera());
        int durabilidadInicial = hachaMadera.getDurabilidad();

        hachaMadera.usar(diamante);
        Assert.assertEquals(durabilidadInicial - hachaMadera.getFuerza(), hachaMadera.getDurabilidad());
    }

    @Test
    public void test10UsarHachaConDurabilidadPiedraContraMaderaYReduceDurabilidadRestandoLaFuerza() {
        Materializable madera = new Madera();
        Herramienta hachaPiedra = new Hacha(new DurabilidadPiedra());
        int durabilidadInicial = hachaPiedra.getDurabilidad();

        hachaPiedra.usar(madera);
        Assert.assertEquals(durabilidadInicial - hachaPiedra.getFuerza(), hachaPiedra.getDurabilidad());
    }

    @Test
    public void test11UsarHachaConDurabilidadPiedraContraPiedraYReduceDurabilidadRestandoLaFuerza() {
        Materializable piedra = new Piedra();
        Herramienta hachaPiedra = new Hacha(new DurabilidadPiedra());
        int durabilidadInicial = hachaPiedra.getDurabilidad();

        hachaPiedra.usar(piedra);
        Assert.assertEquals(durabilidadInicial - hachaPiedra.getFuerza(), hachaPiedra.getDurabilidad());
    }

    @Test
    public void test12UsarHachaConDurabilidadPiedraContraMetalYReduceDurabilidadRestandoLaFuerza() {
        Materializable metal = new Metal();
        Herramienta hachaPiedra = new Hacha(new DurabilidadPiedra());
        int durabilidadInicial = hachaPiedra.getDurabilidad();

        hachaPiedra.usar(metal);
        Assert.assertEquals(durabilidadInicial - hachaPiedra.getFuerza(), hachaPiedra.getDurabilidad());
    }

    @Test
    public void test13UsarHachaConDurabilidadPiedraContraDiamanteYReduceDurabilidadRestandoLaFuerza() {
        Materializable diamante = new Diamante();
        Herramienta hachaPiedra = new Hacha(new DurabilidadPiedra());
        int durabilidadInicial = hachaPiedra.getDurabilidad();

        hachaPiedra.usar(diamante);
        Assert.assertEquals(durabilidadInicial - hachaPiedra.getFuerza(), hachaPiedra.getDurabilidad());
    }

    @Test
    public void test14UsarHachaConDurabilidadMetalContraMaderaYReduceDurabilidadRestandoLaMitadDeLaFuerza() {
        Materializable madera = new Madera();
        Herramienta hachaMetal = new Hacha(new DurabilidadMetal());
        int durabilidadInicial = hachaMetal.getDurabilidad();

        hachaMetal.usar(madera);
        Assert.assertEquals(durabilidadInicial - hachaMetal.getFuerza() / 2, hachaMetal.getDurabilidad());
    }

    @Test
    public void test15UsarHachaConDurabilidadMetalContraPiedraYReduceDurabilidadRestandoLaMitadDeLaFuerza() {
        Materializable piedra = new Piedra();
        Herramienta hachaMetal = new Hacha(new DurabilidadMetal());
        int durabilidadInicial = hachaMetal.getDurabilidad();

        hachaMetal.usar(piedra);
        Assert.assertEquals(durabilidadInicial - hachaMetal.getFuerza() / 2, hachaMetal.getDurabilidad());
    }

    @Test
    public void test16UsarHachaConDurabilidadMetalContraMetalYReduceDurabilidadRestandoLaMitadDeLaFuerza() {
        Materializable metal = new Metal();
        Herramienta hachaMetal = new Hacha(new DurabilidadMetal());
        int durabilidadInicial = hachaMetal.getDurabilidad();

        hachaMetal.usar(metal);
        Assert.assertEquals(durabilidadInicial - hachaMetal.getFuerza() / 2, hachaMetal.getDurabilidad());
    }

    @Test
    public void test17UsarHachaConDurabilidadMetalContraDiamanteYReduceDurabilidadRestandoLaMitadDeLaFuerza() {
        Materializable diamante = new Diamante();
        Herramienta hachaMetal = new Hacha(new DurabilidadMetal());
        int durabilidadInicial = hachaMetal.getDurabilidad();

        hachaMetal.usar(diamante);
        Assert.assertEquals(durabilidadInicial - hachaMetal.getFuerza() / 2, hachaMetal.getDurabilidad());
    }

    @Test
    public void test18UsarPicoConDurabilidadMaderaContraMaderaYReduceDurabilidadRestandoLaFuerza() {
        Materializable madera = new Madera();
        Herramienta picoMadera = new Pico(new DurabilidadMadera());
        int durabilidadInicial = picoMadera.getDurabilidad();

        picoMadera.usar(madera);
        Assert.assertEquals(durabilidadInicial - picoMadera.getFuerza(), picoMadera.getDurabilidad());
    }

    @Test
    public void test19UsarPicoConDurabilidadMaderaContraPiedraYReduceDurabilidadoRestandoLaFuerza() {
        Materializable piedra = new Piedra();
        Herramienta picoMadera = new Pico(new DurabilidadMadera());
        int durabilidadInicial = picoMadera.getDurabilidad();

        picoMadera.usar(piedra);
        Assert.assertEquals(durabilidadInicial - picoMadera.getFuerza(), picoMadera.getDurabilidad());
    }

    @Test public void test20UsarHachaConDurabilidadMaderaContraMetalYReduceDurabilidadRestandoLaFuerza(){
        Materializable metal = new Metal();
        Herramienta picoMadera = new Pico(new DurabilidadMadera());
        int durabilidadInicial = picoMadera.getDurabilidad();

        picoMadera.usar(metal);
        Assert.assertEquals(durabilidadInicial - picoMadera.getFuerza(), picoMadera.getDurabilidad());
    }

    @Test public void test21UsarPicoConDurabilidadMaderaContraDiamanteYReduceDurabilidadRestandoLaFuerza(){
        Materializable diamante = new Diamante();
        Herramienta picoMadera = new Pico(new DurabilidadMadera());
        int durabilidadInicial = picoMadera.getDurabilidad();

        picoMadera.usar(diamante);
        Assert.assertEquals(durabilidadInicial - picoMadera.getFuerza(), picoMadera.getDurabilidad());
    }

    @Test
    public void test22UsarPicoConDurabilidadPiedraContraMaderaYReduceDurabilidadRestandoLaFuerzaEntre1_5() {
        Materializable madera = new Madera();
        Herramienta picoPiedra = new Pico(new DurabilidadPiedra());
        int durabilidadInicial = picoPiedra.getDurabilidad();

        picoPiedra.usar(madera);
        Assert.assertEquals(durabilidadInicial - (int) (picoPiedra.getFuerza() / 1.5), picoPiedra.getDurabilidad());
    }

    @Test
    public void test23UsarPicoConDurabilidadPiedraContraPiedraYReduceDurabilidadRestandoLaFuerzaEntre1_5() {
        Materializable piedra = new Piedra();
        Herramienta picoPiedra = new Pico(new DurabilidadPiedra());
        int durabilidadInicial = picoPiedra.getDurabilidad();

        picoPiedra.usar(piedra);
        Assert.assertEquals(durabilidadInicial - (int) (picoPiedra.getFuerza() / 1.5), picoPiedra.getDurabilidad());
    }

    @Test
    public void test24UsarPicoConDurabilidadPiedraContraMetalYReduceDurabilidadRestandoLaFuerza() {
        Materializable metal = new Metal();
        Herramienta picoPiedra = new Pico(new DurabilidadPiedra());
        int durabilidadInicial = picoPiedra.getDurabilidad();

        picoPiedra.usar(metal);
        Assert.assertEquals(durabilidadInicial - (int) (picoPiedra.getFuerza() / 1.5), picoPiedra.getDurabilidad());
    }

    @Test
    public void test25UsarPicoConDurabilidadPiedraContraDiamanteYReduceDurabilidadRestandoLaFuerza() {
        Materializable diamante = new Diamante();
        Herramienta picoPiedra = new Pico(new DurabilidadPiedra());
        int durabilidadInicial = picoPiedra.getDurabilidad();

        picoPiedra.usar(diamante);
        Assert.assertEquals(durabilidadInicial - (int) (picoPiedra.getFuerza() / 1.5), picoPiedra.getDurabilidad());
    }

    @Test
    public void test26UsarPicoConDurabilidadMetalContraMaderaYNoReduceDurabilidad() {
        Materializable madera = new Madera();
        Herramienta picoMetal = new Pico(new DurabilidadMetal());
        int durabilidadInicial = picoMetal.getDurabilidad();

        picoMetal.usar(madera);
        Assert.assertEquals(durabilidadInicial, picoMetal.getDurabilidad());
    }

    @Test
    public void test27UsarPicoConDurabilidadMetalContraPiedraYNoReduceDurabilidad() {
        Materializable piedra = new Piedra();
        Herramienta picoMetal = new Pico(new DurabilidadMetal());
        int durabilidadInicial = picoMetal.getDurabilidad();

        picoMetal.usar(piedra);
        Assert.assertEquals(durabilidadInicial, picoMetal.getDurabilidad());
    }

    @Test
    public void test28UsarPicoConDurabilidadMetalContraMetalYNoReduceDurabilidad() {
        Materializable metal = new Metal();
        Herramienta picoMetal = new Pico(new DurabilidadMetal());
        int durabilidadInicial = picoMetal.getDurabilidad();

        picoMetal.usar(metal);
        Assert.assertEquals(durabilidadInicial, picoMetal.getDurabilidad());
    }

    @Test
    public void test29UsarPicoConDurabilidadMetalContraDiamanteYNoReduceDurabilidad() {
        Materializable diamante = new Diamante();
        Herramienta picoMetal = new Pico(new DurabilidadMetal());
        int durabilidadInicial = picoMetal.getDurabilidad();

        picoMetal.usar(diamante);
        Assert.assertEquals(durabilidadInicial, picoMetal.getDurabilidad());
    }

    @Test
    public void test30UsarPicoFinoContraDiamanteReduceDurabilidadRestandoLaFuerzaEntre10() {

        Materializable diamante = new Diamante();
        Herramienta picoFino = new PicoFino();
        int valorInicial = picoFino.getDurabilidad();

        picoFino.usar(diamante);
        Assert.assertEquals(valorInicial - (int) ( valorInicial * 0.1 ), picoFino.getDurabilidad());
    }

    @Test
    public void test31UsarPicoFinoContraMaderaNoReduceDurabilidad() {
        Materializable madera = new Madera();
        Herramienta picoFino = new PicoFino();

        picoFino.usar(madera);
        Assert.assertEquals(1000, picoFino.getDurabilidad());
    }

    @Test
    public void test32UsarPicoFinoContraPiedraNoReduceDurabilidad() {
        Materializable piedra = new Piedra();
        Herramienta picoFino = new PicoFino();

        picoFino.usar(piedra);
        Assert.assertEquals(1000, picoFino.getDurabilidad());
    }

    @Test
    public void test33UsarPicoFinoContraMetalNoReduceDurabilidad() {
        Materializable metal = new Metal();
        Herramienta picoFino = new PicoFino();

        picoFino.usar(metal);
        Assert.assertEquals(1000, picoFino.getDurabilidad());
    }

    @Test
    public void test34PicoDurabilidadMetalSeRompeAlDecimoGolpe(){
        Materializable madera = new Madera();
        Herramienta pico = new Pico(new DurabilidadMetal());

        for(int i=0; i<9; i++){ pico.usar(madera); }
        Assert.assertEquals(400, pico.getDurabilidad());

        pico.usar(madera);
        Assert.assertEquals(0, pico.getDurabilidad());
    }
}