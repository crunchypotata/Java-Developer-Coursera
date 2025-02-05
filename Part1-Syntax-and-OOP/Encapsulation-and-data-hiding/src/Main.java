public class Main {
    public static void main(String[] args) {

        /** TODO 2: Create an object of the SideKick class named "sideKickObject" **/
        SideKick sideKickObject = new SideKick();

        /** TODO 3: Try accessing the property "modeOfOperation" using the dot operator
         *          like:
         *          System.out.println("Mode of operation is: " + sideKickObject.modeOfOperation);
         *
         **/
//        System.out.println("Mode of operation is: " + sideKickObject.modeOfOperation);


        /** TODO 4: Comment out the line created by TODO 3    **/

        /** TODO 6: Display the current value of the property "modeOfOperation"  of the object
         *         "sideKickObject" within a println() using the getter method of the object
         *         you created in TODO 5
         **/
        System.out.println(sideKickObject.getModeOfOperation());

        /** TODO 9: Set the value of the property "modeOfOperation" of the object
         *        "sideKickObject", using the setter you created in TODO 8, to a
         *        a value of 3
         **/
        sideKickObject.setModeOfOperation(3);

        /** TODO 10: Call the method takeAction() of the object "sideKickObject" **/
        sideKickObject.takeAction();

        /** TODO 12: Set the value of the property "modeOfOperation" of the object
         *          "sideKickObject to a value of 1
         *           using the setter method you created in TODO 7 and TODO 8.
         *           After that is done, call the method takeAction() using object
         *           "sideKickObject" and the dot operator.
         **/
        sideKickObject.setModeOfOperation(1);
        sideKickObject.takeAction();

        /** TODO 15: Set the value of the property "modeOfOperation" of the object
         *          "sideKickObject to a value of 2
         *           using the setter method you created in TODO 7 and TODO 8.
         *           After that is done, call the method takeAction() using object
         *           "sideKickObject" and the dot operator.
         **/
        sideKickObject.setModeOfOperation(2);
        sideKickObject.takeAction();
        
    }
}