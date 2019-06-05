package algocraft.materiales.propiedades;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Metal;
import org.junit.Assert;
import org.junit.Test;

public class DurabilidadTest {

    @Test
    public void test01DurabilidadMaderaSeInicializaConValorCorrespondiente() {
        Durabilidad durabilidadMadera = new DurabilidadMadera();

        Assert.assertEquals(100, durabilidadMadera.getValor());
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
       int valorInicial = durabilidadMadera.getValor();

       durabilidadMadera.desgastar(hacha);
       Assert.assertEquals(valorInicial - 2, durabilidadMadera.getValor());
   }

   @Test
    public void test05DurabilidadMaderaSeDesgastaConPico() {
       Durabilidad durabilidadMadera = new DurabilidadMadera();
       Pico pico = new Pico(new DurabilidadMadera());
       int valorInicial = durabilidadMadera.getValor();

       durabilidadMadera.desgastar(pico);
       Assert.assertEquals(valorInicial - 2, durabilidadMadera.getValor());
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

        Assert.assertEquals(200, durabilidadPiedra.getValor());
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
       int valorInicial = durabilidadPiedra.getValor();

       durabilidadPiedra.desgastar(hacha);

       Assert.assertEquals(valorInicial - 5, durabilidadPiedra.getValor());
   }

   @Test
    public void test11DurabilidadPiedraSeDesgastaConPico() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Pico pico = new Pico(new DurabilidadPiedra());
       int valorInicial = durabilidadPiedra.getValor();

       durabilidadPiedra.desgastar(pico);

       Assert.assertEquals(valorInicial - (int)(4/1.5), durabilidadPiedra.getValor());
   }

   @Test
    public void test12DurabilidadPiedraRompeMaterialMetal() {
       Durabilidad durabilidadPiedra = new DurabilidadPiedra();
       Metal metal = new Metal();

       Assert.assertTrue(durabilidadPiedra.romperMaterial(metal));
   }

}
