package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.herramientas.Pico;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.herramientas.durabilidad.DurabilidadMadera;
import algocraft.herramientas.durabilidad.DurabilidadMetal;
import algocraft.herramientas.durabilidad.DurabilidadPiedra;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;
import org.junit.Assert;
import org.junit.Test;

public class DurabilidadTest {

    @Test
    public void test01DurabilidadMaderaSeInicializaConValorCorrespondiente() {
        Durabilidad durabilidadMadera = new DurabilidadMadera();

        Assert.assertEquals(100.0, durabilidadMadera.getValor(), 0);
    }

    @Test
    public void test02DurabilidadMaderaDevuelveFuerzaCorrespondienteAHacha() {
        Durabilidad durabilidadMadera = new DurabilidadMadera();
        Hacha hacha = new Hacha(new DurabilidadMadera());

        Assert.assertEquals(2, durabilidadMadera.getFuerza(hacha));
    }

    @Test
    public void test03DurabilidadMaderaDevuelveFuerzaCorrespondienteAPico() {
        Durabilidad durabilidadMadera = new DurabilidadMadera();
        Pico pico = new Pico(new DurabilidadMadera());

        Assert.assertEquals(2, durabilidadMadera.getFuerza(pico));
    }

   @Test
   public void test04DurabilidadMaderaSeDesgastaConHacha() {
       Durabilidad durabilidadMadera = new DurabilidadMadera();
       Hacha hacha = new Hacha(new DurabilidadMadera());
       double valorInicial = durabilidadMadera.getValor();

       durabilidadMadera.desgastar(hacha);
       Assert.assertEquals(valorInicial - 2, durabilidadMadera.getValor(), 0);
   }

   @Test
    public void test05DurabilidadMaderaSeDesgastaConPico() {
       Durabilidad durabilidadMadera = new DurabilidadMadera();
       Pico pico = new Pico(new DurabilidadMadera());
       double valorInicial = durabilidadMadera.getValor();

       durabilidadMadera.desgastar(pico);
       Assert.assertEquals(valorInicial - 2, durabilidadMadera.getValor(), 0);
   }

   @Test
    public void test06DurabilidadMaderaNoRompeMaterialMetal() {
       Durabilidad durabilidadMadera = new DurabilidadMadera();
       Metal metal = new Metal();

       Assert.assertFalse(durabilidadMadera.romperMaterial(metal));
   }

   @Test
    public void test07DurabilidadPiedraSeInicializaConValorCorrespondiente() {
        Durabilidad durabilidadPiedra = new DurabilidadPiedra();

        Assert.assertEquals(200, durabilidadPiedra.getValor(), 0);
   }

   @Test
    public void test08DurabilidadPiedraDevuelveFuerzaCorrespondienteAHacha() {
        Durabilidad durabilidadPiedra = new DurabilidadPiedra();
        Hacha hacha = new Hacha(new DurabilidadPiedra());

        Assert.assertEquals(5, durabilidadPiedra.getFuerza(hacha));
   }

   @Test
    public void test09DurabilidadPiedraDevuelveFuerzaCorrespondienteAPico() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Pico pico = new Pico(new DurabilidadPiedra());

       Assert.assertEquals(4, durabilidadPiedra.getFuerza(pico));
   }

   @Test
    public void test10DurabilidadPiedraSeDesgastaConHacha() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Hacha hacha = new Hacha(new DurabilidadPiedra());
       double valorInicial = durabilidadPiedra.getValor();

       durabilidadPiedra.desgastar(hacha);

       Assert.assertEquals(valorInicial - 5, durabilidadPiedra.getValor(), 0);
   }

   @Test
    public void test11DurabilidadPiedraSeDesgastaConPico() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Pico pico = new Pico(new DurabilidadPiedra());
       double valorInicial = durabilidadPiedra.getValor();

       durabilidadPiedra.desgastar(pico);

       Assert.assertEquals(valorInicial - (4/1.5), durabilidadPiedra.getValor(), 0);
   }

   @Test
    public void test12DurabilidadPiedraRompeMaterialMetal() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Metal metal = new Metal();

       Assert.assertTrue(durabilidadPiedra.romperMaterial(metal));
   }

   @Test
    public void test13DurabilidadMetalSeInicializaConValorCorrespondiente() {
        Durabilidad durabilidadMetal = new DurabilidadMetal();

        Assert.assertEquals(400, durabilidadMetal.getValor(), 0);
   }

   @Test
    public void test14DurabilidadMetalDevuelveFuerzaCorrespondienteAHacha() {
       Durabilidad durabilidadMetal = new DurabilidadMetal();
       Hacha hacha = new Hacha(new DurabilidadMadera());

       Assert.assertEquals(10, durabilidadMetal.getFuerza(hacha));
   }

   @Test
    public void test15DurabilidadMetalDevuelveFuerzaCorrespondienteAPico() {
       Durabilidad durabilidadMetal = new DurabilidadMetal();
       Pico pico = new Pico(new DurabilidadPiedra());

       Assert.assertEquals(12, durabilidadMetal.getFuerza(pico));
   }

   @Test
    public void test17DurabilidadMetalSeDesgastaConHacha() {
       Durabilidad durabilidadMetal = new DurabilidadMetal();
       Hacha hacha = new Hacha(new DurabilidadMetal());
       double valorInicial = durabilidadMetal.getValor();

       durabilidadMetal.desgastar(hacha);
       Assert.assertEquals(valorInicial - 5, durabilidadMetal.getValor(), 0);
   }

   @Test
    public void test18DurabilidadMetalSeDesgastaConPico() {
       Durabilidad durabilidadMetal = new DurabilidadMetal();
       Pico pico = new Pico(new DurabilidadPiedra());
       double valorInicial = durabilidadMetal.getValor();

       for(int i=0;i<9;i++){
           durabilidadMetal.desgastar(pico);
       }
       Assert.assertEquals(400, durabilidadMetal.getValor(), 0);

       durabilidadMetal.desgastar(pico);
       Assert.assertEquals(0, durabilidadMetal.getValor(), 0);
   }

   @Test
    public void test19DurabilidadMetalNoRompeMaterialMetal() {
       Durabilidad durabilidadMetal = new DurabilidadMetal();
       Metal metal = new Metal();

       Assert.assertFalse(durabilidadMetal.romperMaterial(metal));
   }

   @Test
    public void test20DurabilidadMaderaNoRompeMaterialDiamante() {
        Durabilidad durabilidadMadera = new DurabilidadMadera();
        Diamante diamante = new Diamante();

        Assert.assertFalse(durabilidadMadera.romperMaterial(diamante));
   }

   @Test
    public void test21DurabilidadPiedraNoRompeMaterialPiedra() {
        Durabilidad durabilidadPiedra = new DurabilidadPiedra();
        Diamante diamante = new Diamante();

        Assert.assertFalse(durabilidadPiedra.romperMaterial(diamante));
   }

   @Test
    public void test22DurabilidadMetalNoRompeMaterialDiamante() {
        Durabilidad durabilidadMetal = new DurabilidadMetal();
       Diamante diamante = new Diamante();

       Assert.assertFalse(durabilidadMetal.romperMaterial(diamante));
   }

   @Test
    public void test23DurabilidadPicoFinoSeInicializaConValorCorrespondiente() {
        Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();

        Assert.assertEquals(1000, durabilidadPicoFino.getValor(), 0);
   }

   @Test
    public void test24DurabilidadPicoFinoDevuelveFuerzaCorrespondienteAHacha() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Hacha hacha = new Hacha(new DurabilidadMadera());

       Assert.assertEquals(0, durabilidadPicoFino.getFuerza(hacha));
   }

   @Test
    public void test25DurabilidadPicoFinoDevuelveFuerzaCorrespondienteAPico() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Pico pico = new Pico(new DurabilidadMadera());

       Assert.assertEquals(0, durabilidadPicoFino.getFuerza(pico));
   }

   @Test
    public void test26PicoFinoNoSeDesgastaConElHacha() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Hacha hacha = new Hacha(new DurabilidadMadera());
       double valorInicial = durabilidadPicoFino.getValor();

       durabilidadPicoFino.desgastar(hacha);
       Assert.assertEquals(valorInicial, durabilidadPicoFino.getValor(), 0);
   }

   @Test
    public void test27PicoFinoNoSeDesgastaConElPico() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Pico pico = new Pico(new DurabilidadMetal());
       double valorInicial = durabilidadPicoFino.getValor();

       durabilidadPicoFino.desgastar(pico);
       Assert.assertEquals(valorInicial, durabilidadPicoFino.getValor(), 0);
   }

   @Test
    public void test28PDurabilidadPicoFinoNoRompeMaterialMetal() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Metal metal = new Metal();

       Assert.assertFalse(durabilidadPicoFino.romperMaterial(metal));
   }

   @Test
    public void test29DurabilidadPicoFinoRompeMaterialDiamanteYDisminuyeSuValor() {
       Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
       Diamante diamante = new Diamante();
       double valorInicial = durabilidadPicoFino.getValor();

       Assert.assertTrue(durabilidadPicoFino.romperMaterial(diamante));
       Assert.assertEquals((int) (valorInicial - valorInicial * 0.1), durabilidadPicoFino.getValor(), 0);
   }

   @Test(expected = DurabilidadTerminadaException.class)
    public void test30DurabilidadMaderaLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorHacha(){
        Durabilidad durabilidadMadera = new DurabilidadMadera();
        Hacha hacha = new Hacha(new DurabilidadMadera());

        for ( int i = 0; i < 50; i++ ){
            durabilidadMadera.desgastar(hacha);
        }

       Assert.assertEquals(0, durabilidadMadera.getValor(), 0);

       durabilidadMadera.desgastar(hacha);
   }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test31DurabilidadMaderaLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorPico(){
        Durabilidad durabilidadMadera = new DurabilidadMadera();
        Pico pico = new Pico(new DurabilidadMadera());

        for ( int i = 0; i < 50; i++ ){
            durabilidadMadera.desgastar(pico);
        }

        Assert.assertEquals(0, durabilidadMadera.getValor(), 0);

        durabilidadMadera.desgastar(pico);
    }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test32DurabilidadPiedraLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorHacha(){
        Durabilidad durabilidadPiedra = new DurabilidadPiedra();
        Hacha hacha = new Hacha(new DurabilidadPiedra());

        for ( int i = 0; i < 40; i++ ){
            durabilidadPiedra.desgastar(hacha);
        }

        Assert.assertEquals(0, durabilidadPiedra.getValor(), 0);

        durabilidadPiedra.desgastar(hacha);
    }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test33DurabilidadPiedraLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorPico(){
        Durabilidad durabilidadPiedra = new DurabilidadPiedra();
        Pico pico = new Pico(new DurabilidadPiedra());

        for ( int i = 0; i < 75; i++ ){
            durabilidadPiedra.desgastar(pico);
        }

        Assert.assertEquals(0, durabilidadPiedra.getValor(), 0.1);

        durabilidadPiedra.desgastar(pico);
    }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test34DurabilidadMetalLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorHacha(){
        Durabilidad durabilidadMetal = new DurabilidadMetal();
        Hacha hacha = new Hacha(new DurabilidadPiedra());

        for ( int i = 0; i < 80; i++ ){
            durabilidadMetal.desgastar(hacha);
        }

        Assert.assertEquals(0, durabilidadMetal.getValor(), 0);

        durabilidadMetal.desgastar(hacha);
    }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test35DurabilidadMetalLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroYSeVuelveAUsarPorPico(){
        Durabilidad durabilidadMetal = new DurabilidadMetal();
        Pico pico = new Pico(new DurabilidadPiedra());

        for ( int i = 0; i < 10; i++ ){
            durabilidadMetal.desgastar(pico);
        }

        Assert.assertEquals(0, durabilidadMetal.getValor(), 0);

        durabilidadMetal.desgastar(pico);
    }

    @Test(expected = DurabilidadTerminadaException.class)
    public void test36DurabilidadPicoFinoLanzaDurabilidadTerminadaExceptionCuandoSuValorEsCeroRompiendoDiamante(){
        Durabilidad durabilidadPicoFino = new DurabilidadPicoFino();
        Diamante diamante = new Diamante();

        for(int i = 0; i < 66; i++){
            durabilidadPicoFino.romperMaterial(diamante);
        }

        Assert.assertEquals(0, durabilidadPicoFino.getValor(), 5);
    }
}
