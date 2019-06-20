import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

@RunWith(JUnitParamsRunner.class)

public class CalculatorTest {

    @Test
    public void sum_a2b5_7() {
        // Arange/Given
        double expected = 7;
        // Act/When
        double actual = Calculator.sum(2, 5);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void sum_a5_b6_11() {
        int expected = 11;
        int actual = Calculator.sum(5, 6);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sum_a0_2b0_1_expected0_3() {
        double expected = 0.3;
        double actual = Calculator.sum(0.2, 0.1);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void substraction_a10_b5_5() {
        double expected = 5;
        double actual = Calculator.substraction(10, 5);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void divide_a32_b16_2() {
        double expected = 2;
        double actual = Calculator.divide(32, 16);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void multiply_a2_b6_12() {
        double expected = 12;
        double actual = Calculator.multiply(2, 6);
        Assert.assertEquals(expected, actual, 0.01);
    }

    // Testowanie wyjatkow
    // Metoda 1
    @Test
    public void divide_a10b0_IlegalArgumentsExeptionTrycatch() {
        try {
            Calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

    // Metoda 2
    @Test(expected = IllegalArgumentException.class)
    public void divide_a10_b0_IlegalArgumentExeption() {
        Calculator.divide(10, 0);
    }


    // Metoda 3
    @Rule
    public ExpectedException rule = ExpectedException.none();

    @Test
    public void divide_a10_b0_IlegalArgumentExeptionRule() {
        rule.expect(IllegalArgumentException.class);
        Calculator.divide(10, 0);
    }


    // testowanie metoty log
    @Test
    public void log_a2_b4_2() {
        double expected = 2;
        double actual = Calculator.log(2, 4);
        Assert.assertEquals(expected, actual, 0.01);
    }


    // Testowanie metody log z podstawa mniejzza od zera -
    // metoda wyrzuca wyjatek
    @Test(expected = IllegalArgumentException.class)
    public void log_a_1_b10_IlegalArgumentExeption() {
        Calculator.log(-1, 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void log1_a10_b1_IlegalArgumentExeption() {
        Calculator.log(10, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void log_a1_b10_IlegalArgumentExeption() {
        Calculator.log(1, 10);
    }


    // Testowanie metody log za pomoca **assetrJ**
    // ** wyjatek 1 **
    @Test
    public void log_a_3b10_IllegalArgumentExeptionMessageBaseOfLogarytmShouldBeGreaterThan0() {
        // wywolanie funkcji lambda
        assertThatThrownBy(() -> {
            Calculator.log(-3, 10);
        }).hasMessage("Podstawa logarytmu musi byc wiekssza od zera");
    }

    // Testowanie metody log za pomoca **assetrJ**
    // **wyjatek 2 **
    @Test
    public void log_a_10b1_IllegalArgumentExeptionMessageLogCantBeLessThen0() {
        // wywolanie funkcji lambda
        assertThatThrownBy(() -> {
            Calculator.log(10, -1);
        }).hasMessage("Liczba logarytmowana nie moze byc mniejsza od 0 ");
    }

    // Testowanie metody log za pomoca **assetrJ**
    // **wyjatek 3 **
    @Test
    public void log_a1b10_IllegalArgumentExeptionMessageBaseOfLogMustBeDifferentThen1() {
        // wywolanie funkcji lambda
        assertThatThrownBy(() -> {
            Calculator.log(1, 10);
        }).hasMessage("Podstawa logarytmu musi byc rozna od 1");
    }

    // porownywanie wartosci z metody log
    @Test
    public void log_a2b4_2() {
        double expected = 2;
        double actulal = Calculator.log(2, 4);
        assertThat(expected).isEqualTo(actulal);
    }

    // Ustawianie offsetu(granicy bledu) na spredzeniu metondy log
    public void log_2b4_2() {
        double expected = 2;
        double actual = Calculator.log(2, 4);
        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    // Ustawianie offsetu(granicy bledu) na spredzeniu metondy sum
    @Test
    public void sum_a2b2_2() {
        double expected = 4;
        double actual = Calculator.sum(2, 2);
        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    public void pow_a2b3_8(){
        double expectet = 8;
        double actual = Calculator.pow(2, 3);
        assertThat(expectet).isEqualTo(actual, Offset.strictOffset(0.01));
    }
    // Testowanie pow parametrycznie
    @Test
    @Parameters({"2, 2, 4", "3, 3, 27", "4, 2, 16"})
    public void pow_parametrized(double a, double b, double expected){
        double actual = Calculator.pow(a, b);
    }


    // testowanie za pomoca metody
    @Test
    @Parameters(method = "getPowData")
    public void powParametrizedMethod(double a, double b, double expected){
        double actual = Calculator.pow(a, b);
        assertThat(expected).isEqualTo(actual);
    }

    private Object[] getPowData(){
        return new Object[]{
                new Object[]{2, 2, 4},
                new Object[]{3, 3, 27},
                new Object[]{4, 4, 256}
        };
    }

    @Test
    @Parameters(source = PowDataProwider.class)
    public void powParametrizedByClass(double a, double b, double expected){
        double actual = Calculator.pow(a, b);
        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }


    // testowammie kalkulatora.sum parametrycznie
    @Test
    @Parameters({"1, 2 , 3", "23, 17, 40"})
    public void sum_parametrized(double a, double b, double expected) {
        double actual = Calculator.sum(a, b);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    // testowammie kalkulatora.multipy parametrycznie
    @Test
    @Parameters({"1, 2 , 2", "5, 5, 25", "4, 4, 16"})
    public void multiply_parametrized(double a, double b, double expected) {
        double actual = Calculator.multiply(a, b);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }


    // testowammie kalkulatora.divide parametrycznie
    @Test
    @Parameters({"5, 2.5 , 2", "6, 2, 3"})
    public void divide_parametrized(double a, double b, double expected) {
        double actual = Calculator.divide(a, b);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    // Testowanie numerow Fibonacciego parametrycznie
    @Test
    @Parameters({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21", "9, 34", "10, 55"})
    public void FibonacciNumber_parametrized(int n, int expected) {
        int actual = Calculator.getFibonaciNumber(n);
        assertThat(expected).isEqualTo(actual);
    }


    // testowanie getFibonaciNumber za pomoca metody
    @Test
    @Parameters(method = "getFibonaciData")
    public void getFibonaciNumber_parametrizedByMethod(int n, int expected) {
        int actual = Calculator.getFibonaciNumber(n);
        assertThat(expected).isEqualTo(actual);
    }

    private Object[] getFibonaciData() {
        return new Object[]{
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 1},
                new Object[]{3, 2},
                new Object[]{4, 3},
                new Object[]{5, 5},
                new Object[]{6, 8},
                new Object[]{7, 13},
                new Object[]{8, 21},
                new Object[]{9, 34},
                new Object[]{10, 55},
        };
    }

    // testowanie Calculator.sum za pomoca metody
    @Test
    @Parameters(method = "sumData")
    public void sum_parametrizedByMethod(double a, double b, double expected) {
        double actual = Calculator.sum(a, b);
        assertThat(expected).isEqualTo(actual);
    }

    private Object[] sumData() {
        return new Object[]{
                new Object[]{0, 0, 0},
                new Object[]{1, 1, 2},
                new Object[]{2, 1, 3},
                new Object[]{3, 2, 5},
                new Object[]{4, 3, 7},
                new Object[]{5, 5, 10},
                new Object[]{6, 8, 14},
                new Object[]{7, 13, 20},
                new Object[]{8, 21, 29},
                new Object[]{9, 34, 43},
                new Object[]{10, 55, 65},
        };
    }

    @Test
    @Parameters(source = SubstractionDataProvider.class)
    public void substraction_parametrizedByClass(double a, double b, double expected){
        double actual = Calculator.substraction(a,b);

        assertThat(expected).isEqualTo(actual);
    }


    @Test
    @Parameters(source = MultiplyDataProvider.class)
    public void multiply_parametrizedByClass(double a, double b, double expected){
        double actual = Calculator.multiply(a,b);

        assertThat(expected).isEqualTo(actual);
    }
}
