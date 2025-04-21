import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculatorTestObject;
    @BeforeEach
    public void setup() {
        calculatorTestObject = new Calculator();
    }

    @Test
    /** TODO 1: create a test method "testCalculatorClassExists" **/
    public void testCalculatorClassExists() {

        /** TODO 2: inside the test method
         *          "testCalculatorClassExists()"
         *          which you created in TODO 1
         *          create an object of the "Calculator" class,
         *          using "new".
         *          Name the object "calculatorTestObject".
         **/

//        Calculator calculatorTestObject = new Calculator();

        /** TODO 4: inside the method
         *          "testCalculatorClassExists()"
         *          which you created in TODO 1,
         *          test if the object of the "Calculator" class
         *          named "calculatorTestObject"
         *          was created correctly
         *          after the line where you created the object in TODO 2
         *          by using assertNotNull()
         **/

        assertNotNull(calculatorTestObject);

    }



    /** TODO 5: below TODO 6
     *          create a test method named
     *          "testAddTwoIntegersMethodExists"
     **/


    /** TODO 6: inside the method you created in TODO 5
     *          create an object of
     *          class Calculator named
     *          "calculatorTestObject" and use it to
     *          call the method
     *          "addTwoIntegers"
     *          with the values 2 and 4 passed
     *          as parameters to the method.
     */
    @Test
    public void estAddTwoIntegersMethodExists(){
//        Calculator calculatorTestObject = new Calculator();
        calculatorTestObject.addTwoIntegers(2,4);

    }
    /** TODO 8: go to the top of this class
     *          "CalculatorTest" and just after the
     *          opening curly brace of the class,
     *          declare an object of "Calculator" class named
     *          "calculatorTestObject"
     **/


    /** TODO 9: after the declaration of the object
     *          named  "calculatorTestObject",
     *          create a method named "setup"
     *          annotated with @BeforeEach.
     *          Inside the method allocate
     *          memory to the object "calculatorTestObject"
     *          declared on top using new.
     *
     **/


    /** TODO 10: remove the line creating the object named
     *           "calculatorTestObject"
     *           from both the methods named
     *           "testCalculatorClassExists()" and
     *           "testAddTwoIntegersMethodExists()"
     **/

    /** TODO 11: create a test method named
     *          "testAddTwoIntegerMethodAddsCorrectly()"
     *          after TODO 12
     **/

    @Test
    public void testAddTwoIntegerMethodAddsCorrectly() {
        int sum = calculatorTestObject.addTwoIntegers(2,4);
        assertEquals(6,sum);
    }

    /** TODO 12: inside the method
     *           "testAddTwoIntegerMethodAddsCorrectly()"
     *           which you created in TODO 11
     *           you have to assert that the method
     *           "addTwoIntegers()" of the class "Calculator"
     *           returns 6 when 2 and 4 are passed as parameters.
     *           Use the object "calculatorTestObject"
     *           to call the method and use
     *           assertEquals() to check if 6 is returned or not.
     **/

    /** TODO 14: create a test method named
     *           "testAddTwoIntegerMethodOnRangeExceedThrowsException()"
     *           below TODO 15.
     *           This will be used to test for exceptions.
     *           Remember to annotate with @Test.
     **/
    @Test
//    @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE})
    public void testAddTwoIntegerMethodOnRangeExceedThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculatorTestObject.addTwoIntegers(Integer.MAX_VALUE, 1);
        });
    }

    /** TODO 15: in the test method named
     *           "testAddTwoIntegerMethodOnRangeExceedThrowsException()"
     *           which you created in TODO 14.
     *           assert that the method "addTwoIntegers()"
     *           of the class "Calculator"
     *           throws exception when
     *           Integer.MAX_VALUE and 1 are passed as parameters
     *           or the integer range is exceeded.
     **/

}