package org.umssdiplo.automationv01.testdriver;

public class TestSingleton {
    private static TestSingleton TestSingleton;

    private TestSingleton(){
    }

    public static TestSingleton getInstance(){
        if(TestSingleton == null){
            TestSingleton = new TestSingleton();
        }
        return TestSingleton;
    }
}
