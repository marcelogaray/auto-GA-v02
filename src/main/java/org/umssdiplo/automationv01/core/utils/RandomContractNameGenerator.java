package org.umssdiplo.automationv01.core.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomContractNameGenerator {
    
    public static String getRandomContractName() {
        String contract = "Contrato-";
        contract += ThreadLocalRandom.current().nextInt(1223, 10000);
        return contract;
    }
}
