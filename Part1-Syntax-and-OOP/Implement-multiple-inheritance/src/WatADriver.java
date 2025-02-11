import java.util.Scanner;

public class WatADriver extends Robot{

    Scanner keyboard;

    /** default constructor **/
    public WatADriver() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public void setChoice() {

        System.out.println("***** WatADriver Menu *****");
        System.out.println("1. Drive a car");
        System.out.println("2. Fly a plane");
        System.out.println("3. Re-charge");
        System.out.println("4. Check battery level");

        System.out.println("Enter choice(1-4):");
        int choice = keyboard.nextInt();

        setModeOfOperation(choice);

    }

    @Override
    public void takeAction() {

        switch (getModeOfOperation()) {
            case 1:
                driveACar();
                System.out.println("WatADriver has completed the drive.");
                break;
            case 2:
                flyAPlane();
                System.out.println("WatADriver has completed the flight.");
                break;
            case 3:
                rechargeBattery();
                System.out.println("WatADriver has recharged battery.");
                break;
            case 4:
                System.out.println("WatADriver Battery:");
                displayBatteryLevel();
                break;
            default:
                System.out.println("WatADriver does not support the operation.");
        }
    }


    private void driveACar() {
        System.out.println("Feeding GPS location .........");
        System.out.println("Start car .........");
        System.out.println("Drive to destination.........");
        System.out.println("Park car .........");
        System.out.println("Stop car .........");
    }

    private void flyAPlane() {
        System.out.println("Feeding GPS location .........");
        System.out.println("Start plane .........");
        System.out.println("Fly to nearest airport.........");
        System.out.println("Land plane .........");
        System.out.println("Stop plane .........");
    }

}

