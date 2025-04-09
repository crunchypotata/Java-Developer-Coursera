public class Calculator {

    // method to return square of a single parameter
    public int squareOfSingleIntegerNumber(int num1) {
        /* check for overflow or underflow */
        long resultTestValue = (long) num1 * num1;

        if(resultTestValue > Integer.MAX_VALUE
                ||
                resultTestValue < Integer.MIN_VALUE) {
            throw new ArithmeticException("Overflow/Underflow error.");
        }

        /* return normal value */
        return (int) resultTestValue;
    }

    // method to return sum of two parameters
    public int addTwoIntegerNumbers(int num1, int num2) {

        /* check for overflow or underflow */
        long resultTestValue = (long) num1 + num2;

        if(resultTestValue > Integer.MAX_VALUE
                ||
                resultTestValue < Integer.MIN_VALUE) {
            throw new ArithmeticException("Overflow/Underflow error.");
        }

        /* return normal value */
        return (int) resultTestValue;

    }

    // method to return quotient of two parameters
    public int divideTwoIntegerNumbers(int num1, int num2) {
        /* check for overflow or underflow */
        /* might throw DivideByZeroException */
        long resultTestValue = (long) num1 / num2;

        if(resultTestValue > Integer.MAX_VALUE
                ||
                resultTestValue < Integer.MIN_VALUE) {
            throw new ArithmeticException("Overflow/Underflow error.");
        }

        /* return normal value */
        return (int) resultTestValue;
    }
}
