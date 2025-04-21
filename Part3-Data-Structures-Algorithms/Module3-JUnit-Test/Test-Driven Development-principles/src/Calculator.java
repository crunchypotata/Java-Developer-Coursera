/** TODO 3: create an empty public class named "Calculator"**/
public class Calculator {
    public int addTwoIntegers(int number1, int number2) {
        long result = (long) number1 + number2;

        if(result > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow during addition of two numbers.");
        }
        if(result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Underflow during addition of two numbers.");
        }
        return (int) result;
    }
}

/** TODO 7: in the class Calculator
 *          create a method named "addTwoIntegers" which
 *           i.	Accepts two integer values as parameters.
 *              Name the parameter variables number1 and number2.
 *           ii.	Returns an integer value.
 *         return 0 from the method
 **/

/** TODO 13: modify the return of the method  named
 *          "addTwoIntegers"
 *          which you created in TODO 7
 *          to return the value of
 *          the sum of the parameters passed
 *          by returning
 *           the sum of "number1" plus "number2".
 **/

/** TODO 16: in the method named
 *           "addTwoIntegers"
 *           which you created in TODO 7
 *           and modified in TODO 13,
 *           first assign the result of the sum
 *           of the parameters number1 and number 2
 *           to a variable of type "long"
 *           named "result".
 *           After the assignment check
 *           if the value of "result"
 *           exceeds the range of an integer.
 *           If it does throw an ArithmeticException.
 **/

