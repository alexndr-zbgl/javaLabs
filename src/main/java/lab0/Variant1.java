package lab0;

import java.util.List;
import java.util.Objects;

public class Variant1 {


    /**
     *
     * @param a is integer
     * @param b is integer (less)
     * @return a%b
     */

    public int integerNumbersTask(int a, int b) {
        assert a>0&&b>0&&a>=b: " 'a', 'b' should be more than 0 and a > b";

        return a%b;
    }

    /**
     *
     * @param a is more than 0
     * @param b is less than -2
     * @return true, if number is positive
     */
    public boolean booleanTask(int a, int b) {
        return (a > 0 && b < -2);
    }


    public static class SignedNumber{
        private int positive;
        private int negative;

        public void setPositive(int positive){
            this.positive = positive;
        }

        public int getPositive(){
            return positive;
        }

        public void setNegative(int negative){
            this.negative = negative;
        }

        public int getNegative() {
            return negative;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SignedNumber that = (SignedNumber) o;
            return positive == that.positive &&
                    negative == that.negative;
        }

        @Override
        public int hashCode() {
            return Objects.hash(positive, negative);
        }
    }

    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @param c is integer number
     * @return transformed number
     */
    public SignedNumber ifTask(int a, int b, int c) {

        assert a!=0&&b!=0&&c!=0: "Numbers cannot be 0";

        SignedNumber number = new SignedNumber();

        if(a > 0) number.setPositive(number.getPositive()+1);
        else number.setNegative(number.getNegative()+1);

        if(b > 0) number.setPositive(number.getPositive()+1);
        else number.setNegative(number.getNegative()+1);

        if(c > 0) number.setPositive(number.getPositive()+1);
        else number.setNegative(number.getNegative()+1);

        return number;
    }


    enum OPERATION
    {

        ADDITION(1),
        SUBTRACTION(2),
        MULTIPLICATION(3),
        DIVISION(4);

        public int number;

        OPERATION(int number){
            this.number = number;
        }

    }


    /**
     *
     * @param a is integer
     * @param b is integer
     * @param operation is Operation
     * @return day of week day represented number1
     */
    public double caseTask(double a, double b, int operation) {
        assert b!=0 && operation>0 && operation<=4 : "'b' cannot be 0. Range of operations [1, 4]";

        switch (operation){
            case 1: return a+b;
            case 2: return a-b;
            case 3: return a*b;
            case 4: return a/b;
            default:
                System.out.println("There is no such an operation");
                return 0;
        }

    }


    /**
     *
     * @param price is integer number
     * @return approximated value of exp(1)
     */
    public float[] forTask(float price) {

        assert price>0: "Price cannot be less and equal to 0";

        float[] prices = new float[10];

        for(int i = 0; i<10; i++){
            prices[i] = (float)(i+1)/10.0f*price;
        }

        return prices;
    }


    /**
     *
     * @param n is integer number
     * @return k;
     */
    public int whileTask(int n) {

        assert n>0: "'n' cannot be more or equal to 0";

        int k = 0;
        while(n!=1){
            n/=2;
            k++;
        }
        return k;
    }

    public static class Detail{
        public double mass;
        public double volume;
        public int number;

        Detail(double mass, double volume, int number){
            this.mass = mass;
            this.volume = volume;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Detail detail = (Detail) o;
            return Double.compare(detail.mass, mass) == 0 &&
                    Double.compare(detail.volume, volume) == 0 &&
                    number == detail.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mass, volume, number);
        }
    }


    /**
     *
     * @param n is integer number
     * @param details is Details
     * @return k;
     */
    public Detail minMaxTask(int n, Detail[] details){
        
        assert n>0: "N cannot be less than 1";

        for (Detail d:details) {
            assert d.mass >= 0 && d.volume>=0 : "Mass and Volume have to be more or equal to 0";
        }
        
        Detail max = details[0];


        for(int i = 1; i<n; i++){
            if(details[i].mass/details[i].volume > max.mass/max.volume){
                max = details[i];
            }
        }

        return max;
    }


    /**
     *
     * @param n is integer number
     * @return n'th position of fibonacci number;
     */
    public int[] arrayTask(int n){

        assert n>2: "N has to be more than 2";

        int[] fibonacci = new int[n];

        for (int i = 0; i<n; i++){

            if((i+1==1) || (i+1==2))
                fibonacci[i] = 1;
            else
                fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        }

        return fibonacci;
    }

    /**
     *
     * @param m is number of rows
     * @param n is number of columns
     * @param d is integer number
     * @param row is the first row
     * @return matrix;
     */
    public int[][] matrixTask(int m, int n, int d, int[] row){

        assert m>0 && n>0 : "M and N have to be more than 0";

        int[][] matrix = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0){
                    matrix[i][j] = row[j];
                }
                else{
                    matrix[i][j] = matrix[i-1][j] + d;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        /*Variant1 v = new Variant1();

        int[][] matrix = v.matrixTask(4, 5, 1, new int[]{1, 2, 3, 4});

        for(int i = 0; i<5; i++){
            for(int j = 0; j<4; j++){
                System.out.println(matrix[i][j]);
            }
        }*/

    }

}