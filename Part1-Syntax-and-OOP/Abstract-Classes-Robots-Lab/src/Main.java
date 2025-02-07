public class Main {
    public static void main(String[] args) {


        /** TODO 13: Comment out the code on SideKick below  **/
//
//        SideKick sideKickObject = new SideKick();
//
//        sideKickObject.setChoice();
//
//        sideKickObject.takeAction();

        /** TODO 14: Create an object of the
         *           "WatADriver" class
         *           named "driverBot"
         **/
        WatADriver watADriverObject = new WatADriver();
        watADriverObject.rechargeBattery();
        watADriverObject.displayBatteryLevel();

        /** TODO 15:  Call the method rechargeBattery()
         *            and then
         *            displayBatteryLevel()
         *            with the object "driverBot"
         **/

        /** TODO 19: Call the methods "setChoice"
         *           and "takeAction"
         *           with the object "driverBot"
         *           which you created in
         *           "TODO 16".
         **/

        watADriverObject.setChoice();
        watADriverObject.takeAction();

         }
}

