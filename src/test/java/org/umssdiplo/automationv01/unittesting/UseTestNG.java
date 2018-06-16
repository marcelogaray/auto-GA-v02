package org.umssdiplo.automationv01.unittesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UseTestNG {
    @Test
    public void revisarSuma(){
        int numero1 = 10;
        int numero2 = 5;

        int resultadoEsperado =15;

        int resultadoActual = new OperacionesAritmeticas().sumar(numero1, numero2);
        System.out.println("metodo sumar");

        Assert.assertEquals(resultadoActual, resultadoEsperado);

    }

    @Test(dependsOnMethods = {"revisarSuma", "revisarMulti"})
    public void revisarResta(){
        System.out.println("metodo restar");
    }

    @Test
    public void revisarMulti(){
        System.out.println("metodo multiplicar");
    }
}
