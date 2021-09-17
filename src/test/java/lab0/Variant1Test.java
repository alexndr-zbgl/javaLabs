package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant1;


public class Variant1Test {


    @Test(dataProvider = "integerProvider")
    public void integerNumbersTask(int a, int b, int expected){
        assertEquals(new Variant1().integerNumbersTask(a, b), expected);
    }


    @DataProvider
    public Object[][] integerProvider(){
        return new Object[][]{{10, 4, 2},{10, 2, 0}};
    }


    @Test(dataProvider = "negativeIntegerProvider", expectedExceptions = AssertionError.class)
    public void negativeIntegerNumbersTask(int a, int b){
        new Variant1().integerNumbersTask(a, b);
    }


    @DataProvider
    public Object[][] negativeIntegerProvider(){
        return new Object[][]{{10, 20},{-10, 5}, {5, -6}};
    }


    ///////////////////////////////////////////////////////////


    @Test(dataProvider = "booleanProvider")
    public void booleanTask(int a, int b, boolean expected){
        assertEquals(new Variant1().booleanTask(a, b), expected);
    }


    @DataProvider
    public Object[][] booleanProvider(){
        return new Object[][] {{1, -3, true},{10, -5, true}};
    }


    //////////////////////////////////////////////////////////


    @Test(dataProvider = "ifProvider")
    public void ifTask(int a, int b, int c, Variant1.SignedNumber expected){
        assertEquals(new Variant1().ifTask(a, b, c), expected);
    }


    @DataProvider
    public Object[][] ifProvider(){
        Variant1.SignedNumber s = new Variant1.SignedNumber();
        s.setPositive(2);
        s.setNegative(1);

        return new Object[][] {{1, -1, 2, s}};
    }


    @Test(dataProvider = "negativeIfProvider", expectedExceptions = AssertionError.class)
    public void negativeIfTask(int a, int b, int c){
        new Variant1().ifTask(a, b, c);
    }


    @DataProvider
    public Object[][] negativeIfProvider(){
        return new Object[][] {{0, -1, 2}, {0, 0, 0}};
    }


    /////////////////////////////////////////////////////////////////


    @Test(dataProvider = "caseProvider")
    public void caseTask(double a, double b, int operation, double expected){
        assertEquals(new Variant1().caseTask(a, b, operation), expected);
    }


    @DataProvider
    public Object[][] caseProvider(){
        return new Object[][] {{1, 1, Variant1.OPERATION.ADDITION.number, 2},{2, 3, Variant1.OPERATION.MULTIPLICATION.number, 6}};
    }


    @Test(dataProvider = "negativeCaseProvider", expectedExceptions = AssertionError.class)
    public void negativeCaseTask(double a, double b, int operation){
       new Variant1().caseTask(a, b, operation);
    }


    @DataProvider
    public Object[][] negativeCaseProvider(){
        return new Object[][] {{11.9, 0, Variant1.OPERATION.ADDITION.number},{2.5, 0, Variant1.OPERATION.MULTIPLICATION.number}};
    }


    ///////////////////////////////////////////////////////////////////


    @Test(dataProvider = "forProvider")
    public void forTest(float price, float[] expected){
        assertEquals(new Variant1().forTask(price), expected);
    }


    @DataProvider
    public Object[][] forProvider(){
        return new Object[][] {{10, new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}, {114, new float[]{11.4f, 22.8f, 34.2f, 45.6f, 57f, 68.4f, 79.8f, 91.2f, 102.6f, 114}}};
    }


    @Test(dataProvider = "negativeForProvider", expectedExceptions = AssertionError.class)
    public void negativeForTest(float price){
        new Variant1().forTask(price);
    }


    @DataProvider
    public Object[][] negativeForProvider(){
        return new Object[][] {{-2}, {0}};
    }


    ///////////////////////////////////////////////////////////////////


    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, int expected){
        assertEquals(new Variant1().whileTask(n), expected);
    }


    @DataProvider
    public Object[][] whileProvider(){
        return new Object[][] {{4, 2}, {64, 10}};
    }


    @Test(dataProvider = "negativeWhileProvider", expectedExceptions = AssertionError.class)
    public void negativeWhileTest(int n){
        new Variant1().whileTask(n);
    }


    @DataProvider
    public Object[][] negativeWhileProvider(){
        return new Object[][] {{0}, {-2}};
    }


    //////////////////////////////////////////////////////////////////


    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(Variant1.Detail[] details, Variant1.Detail detail){
        assertEquals(new Variant1().minMaxTask(details.length, details), detail);
    }


    @DataProvider
    public Object[][] minMaxProvider(){
        Variant1.Detail[] details = {
                new Variant1.Detail(2,3,1),
                new Variant1.Detail(3,3,2),
                new Variant1.Detail(8,4,3),
                new Variant1.Detail(20,10,4),
                new Variant1.Detail(1,5,5),
        };

        Variant1.Detail detailExpected = new Variant1.Detail(8,4,3);

        return new Object[][] {{details, detailExpected}};
    }


    @Test(dataProvider = "negativeMinMaxProvider", expectedExceptions = AssertionError.class)
    public void negativeMinMaxTest(Variant1.Detail[] details){
        new Variant1().minMaxTask(details.length, details);
    }


    @DataProvider
    public Object[][] negativeMinMaxProvider(){
        Variant1.Detail[] details = {
                new Variant1.Detail(-2,3,0),
                new Variant1.Detail(3,-3,2),
                new Variant1.Detail(8,4,3),
                new Variant1.Detail(20,-10,4),
                new Variant1.Detail(1,5,-5),
        };

        return new Object[][] {{details}};
    }

    /////////////////////////////////////////////////////////////////


    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int n, int[] expected){
        assertEquals(new Variant1().arrayTask(n), expected);
    }


    @DataProvider
    public Object[][] arrayProvider(){
        int[] array = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233};

        return new Object[][] {{array.length, array}};
    }


    @Test(dataProvider = "negativeArrayProvider", expectedExceptions = AssertionError.class)
    public void negativeArrayTest(int n){
        new Variant1().arrayTask(n);
    }

    @DataProvider
    public Object[][] negativeArrayProvider(){
        return new Object[][] {{-4}, {0}, {1}};
    }

    ////////////////////////////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int m, int n, int d, int[] row, int[][] expected){
        assertEquals(new Variant1().matrixTask(m, n, d, row), expected);
    }

    @DataProvider
    public Object[][] matrixProvider(){

        int[] row = new int[]{1, 3, 5, 7, 9};

        int[][] matrix = new int[][]{
                {1, 3, 5, 7, 9},
                {3, 5, 7, 9, 11},
                {5, 7, 9, 11, 13},
                {7, 9, 11, 13, 15},
                {9, 11, 13, 15, 17}
        };

        return new Object[][] {
                {row.length, 5, 2, row, matrix}
        };
    }


    @Test(dataProvider = "negativeMatrixProvider", expectedExceptions = AssertionError.class)
    public void negativeMatrixTest(int m, int n, int d, int[] row){
        new Variant1().matrixTask(m, n, d, row);
    }

    @DataProvider
    public Object[][] negativeMatrixProvider(){

        int[] row = new int[]{1, 3, 5, 7, 9};

        return new Object[][] {
                {row.length, -2, 2, row},
                {4, 0, 10, row}
        };
    }


}