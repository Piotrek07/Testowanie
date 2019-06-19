public class MultiplyDataProvider {

    // wazna jest nazwa metody - musi byc poprzedzona slowem *****provide*****

    public static Object[] provideFirstArrayOfData(){
        return new Object[]{
                new Object[]{4, 2, 8},
                new Object[]{10, 5, 50}
        };
    }

    public static Object[] provideSecondArrayOfData(){
        return new Object[]{
                new Object[]{5, 2, 10},
                new Object[]{10, 3, 30}
        };
    }
}