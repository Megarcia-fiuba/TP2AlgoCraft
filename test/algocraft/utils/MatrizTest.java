package algocraft.utils;

import org.junit.Assert;
import org.junit.Test;

public class MatrizTest {


    @Test
    public void test01PuedoRecuperarElementoDeMatriz(){
        MatrizDefinida<Integer> matrizA=new MatrizDefinida<>(3,3);
        matrizA.putValor(2,2,12);

        Assert.assertEquals(matrizA.getValor(2,2),Integer.valueOf(12));
    }

    @Test
    public void test01DosMatricesVaciasTienenLaMismaForma(){
        MatrizDefinida<Integer> matrizA=new MatrizDefinida<>(3,3);
        MatrizDefinida<Integer> matrizB=new MatrizDefinida<>(3,3);

        Assert.assertTrue(matrizA.equalShape(matrizB));
    }

    @Test
    public void test01DosMatricesConUnElementoEnLaMismaPosicionTienenLaMismaForma(){
        MatrizDefinida<Integer> matrizA=new MatrizDefinida<>(3,3);
        MatrizDefinida<Integer> matrizB=new MatrizDefinida<>(3,3);

        matrizA.putValor(1,1,12);
        matrizB.putValor(1,1,12);

        Assert.assertTrue(matrizA.equalShape(matrizB));
    }

}
