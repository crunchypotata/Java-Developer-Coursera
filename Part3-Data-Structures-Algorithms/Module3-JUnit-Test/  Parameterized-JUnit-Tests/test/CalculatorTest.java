import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    /** TODO 2: declare an object of the Calculator class named "calculatorTestObject" **/

    Calculator calculatorTestObject;

    @BeforeEach
    void setUp() {
        // setup code
        /** TODO 3: inside the test method setup()
         *          create an object of the Calculator class
         *          and assign it to "calculatorTestObject"
         *          which you declared in TODO 2
         **/
        calculatorTestObject = new Calculator();
    }

    @AfterEach
    void tearDown() {
        // code to release resources
        /** TODO 4: in the test method tearDown(), which
         *          is annotated with @AfterEach,
         *          display "Method resources released."
         **/
        System.out.println("Method resources released.");
    }



    /** TODO 5: for the test method
     *          "squareOfSingleIntegerNumber()"
     *          add a display name
     *          "Test square of a number with valid values"
     **/

    /** TODO 7: for the method
     *          "squareOfSingleIntegerNumber()"
     *          pass a parameter of type "int"
     *          having the variable name
     *          "numberPassed"
     **/

    /** TODO 8: for the method
     *          "squareOfSingleIntegerNumber()"
     *          replace  the annotation @Test
     *          with @ParameterizedTest
     **/

    /** TODO 9: for the method
     *          "squareOfSingleIntegerNumber()"
     *          pass the values you want to test
     *          with as parameters
     *          with @ValueSource. Pass the values
     *          1, 12, 10 and -1.
     **/

    /** TODO 11: rename the method
     *          "squareOfSingleIntegerNumber()"
     *          to use the
     *          prefix "test" so that
     *          the method name becomes
     *          "testSquareOfSingleIntegerNumber()"
      */
    @DisplayName("Test square of a number with valid values")
    @ParameterizedTest
    @ValueSource(ints = {1, 12, 10, -1})
    void testSquareOfSingleIntegerNumber(int numberPassed) {
        /** TODO 10: in this method
         *          "squareOfSingleIntegerNumber()"
         *          calculate the expectedResult
         *          calculate the actualResult
         *          assert if both are equal
         */
        int expectedResult = numberPassed * numberPassed;
        int actualResult = calculatorTestObject.squareOfSingleIntegerNumber(numberPassed);
        assertEquals(expectedResult, actualResult);

    }

    @DisplayName("Test addition of int within range returns success")
    @Test
    /** TODO 6: for the test method
     *          "testAddingOfTwoIntegerNumbersWithinIntegerRange()"
     *          add a display name of
     *          "Test addition of int within range returns success"
     **/
    void testAddingOfTwoIntegerNumbersWithinIntegerRange() {
        /** TODO 1: in this test method
         *          "testAddingOfTwoIntegerNumbersWithinIntegerRange()"
         *
         *          comment this line:
         *           Calculator calculatorTestObject = new Calculator();
         *
         *           used to create an object of the calculator class
         **/
        Calculator calculatorTestObject = new Calculator();

        // call method being tested with test data
        int resultReturned = calculatorTestObject.addTwoIntegerNumbers(5,10);

        // check if actual value is equal to expected value
        assertEquals( 15, resultReturned);
    }

    /** TODO 12:  copy the test method
     * "testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException()"
     *   from the code snippet
     *   for TODO 12 below
     *   and paste here below
     *   TODO 14
     *
     **/

    /** TODO 13: inside the test method you pasted in
     *           TODO 12,
     *           pass Integer.MAX_VALUE and
     *           Integer.MIN_VALUE
     *           as edge case values
     *           using @ValueSource.
     **/

    /** TODO 14: inside the test method you created
     *          named
     * "testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException()"
     *          in TODO 12 add an assertion
     **         to check if an Exception of type
     *          ArithmeticException is thrown
     **/

    @DisplayName("Test square of a number with invalid values has exception")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE})
    void testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException(int numberPassed) {
        assertThrows(ArithmeticException.class, () -> {
            calculatorTestObject.squareOfSingleIntegerNumber(numberPassed);
        });
    }

   /** TODO 15: copy the test method
    * "testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException()"
    *   from the code snippet for TODO 15
    *   below
    *   and paste here below TODO 16
    **/


   /** TODO 16: for the method
    *     "testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException()"
    *     which you pasted in TODO 15
    *     pass values 2,45,66 and 77
    *     using @ValueSource since it
    *     is a parameterized test.
    **/

   @DisplayName("Test square of a number with valid values but changed actual is not equal")
   @ParameterizedTest
   @ValueSource(ints = {2, 45, 66, 77})
   void testSquareOfSingleIntegerNumberInRangeDeviatesResult(int numberPassed) {
       int expectedResult = numberPassed * numberPassed ;
       int actualResult =  calculatorTestObject.squareOfSingleIntegerNumber(numberPassed) + 1;

       assertNotEquals(expectedResult, actualResult);
   }

   /** TODO 17: copy the code for TODO 17
    *           from the code snippets below
    *           to below TODO 18
    *           to create the test method
    *           "testDivideTwoIntegerNumbersWithinRangeReturnsSuccesss()"
    **/


   /** TODO 18:  for the test method
    * "testDivideTwoIntegerNumbersWithinRangeReturnsSuccesss()"
    *   which you created in TODO 17
    *   put parameterized values using @CsvSource() annotation
    **/

   @DisplayName("Test division of int within range returns success")
   @ParameterizedTest
   @CsvSource(
           {
                   "6, 3, 2",
                   "12, 5, 2",
                   "15, 3, 5"
           }
   )
   void testDivideTwoIntegerNumbersWithinRangeReturnsSuccesss(int number1, int number2, int expectedResult) {
       int actualResult =  calculatorTestObject.divideTwoIntegerNumbers(number1,number2);

       assertEquals(expectedResult, actualResult);

   }


}




/******************** START OF CODE SNIPPETS *************/

/** Code snippet for TODO 12

 @DisplayName("Test square of a number with invalid values has exception")
 @ParameterizedTest
 void testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException(int numberPassed) {

 }

 **/


/** Code snippet for TODO 12

 @DisplayName("Test square of a number with invalid values has exception")
 @ParameterizedTest
 void testSquareOfSingleIntegerNumberOutsideIntegerRangeHasException(int numberPassed) {

 }

 **/


/** Code snippet for TODO 15

 @DisplayName("Test square of a number with valid values but changed actual is not equal")
 @ParameterizedTest
 void testSquareOfSingleIntegerNumberInRangeDeviatesResult(int numberPassed) {
 int expectedResult = numberPassed * numberPassed ;
 int actualResult =  calculatorTestObject.squareOfSingleIntegerNumber(numberPassed) + 1;

 assertNotEquals(expectedResult, actualResult);
 }

**/

/** Code snippet for TODO 17

 @DisplayName("Test division of int within range returns success")
 @ParameterizedTest
 void testDivideTwoIntegerNumbersWithinRangeReturnsSuccesss(int number1, int number2, int expectedResult) {
 int actualResult =  calculatorTestObject.divideTwoIntegerNumbers(number1,number2);

 assertEquals(expectedResult, actualResult);

 }


 **/

/******************** END OF CODE SNIPPETS *************/