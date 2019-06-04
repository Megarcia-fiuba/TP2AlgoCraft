package algocraft.materiales.propiedades;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Metal;
import org.junit.Assert;
import org.junit.Test;

public class DurabilidadTest {

    @Test
    public void test01DurabilidadMaderaSeInicializaConValorYFuerzaCorrespondiente() {
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

   
}
