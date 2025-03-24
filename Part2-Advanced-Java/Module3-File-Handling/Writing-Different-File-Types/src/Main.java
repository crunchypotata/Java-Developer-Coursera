import java.io.*;
import java.util.Scanner;

public class Main {
    //TODO 3: add a static method here. Use textFileWrite() as name, it won't return any value.
    public static void textFileWrite() {
        //Inside the method, declare an object of Person class and use the toString() method to obtain
        Person person = new Person("Alice", 23, 56);
        //the string representation
        System.out.println(person.toString());

        //TODO 4: create object of FileWriter class, it points to file1.txt
        //call the write() method of FileWriter to save the data of the Person object in the file

        //TODO 5: put the file writing code in try block, and catch the IO exception
        try (FileWriter writer = new FileWriter("file1.txt")) {
            writer.write(person.toString());
            writer.write("\r\n");
            writer.close();
            System.out.println("Data written to file successfully!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File Not Found!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }

//TODO 6: Define printWrite() method, a static method that doesn’t return any data.
        public static void printWrite() {

//TODO 7: Take inputs from the user with Scanner class, for name, age and weight.
//  Instantiate Person object with the inputs
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = keyboard.nextLine();

            System.out.println("Enter your age: ");
            int age = keyboard.nextInt();

            System.out.println("Enter your weight: ");
            double weight = keyboard.nextDouble();

            keyboard.close();

//TODO 8: Declare object of PrintWriter class, which refers to file2.txt file in the current folder.
            Person person = new Person(name, age, weight);
//   Call its println() method, to write the object string returned by toString() method
            try (PrintWriter printWriter = new PrintWriter("file2.txt")) {
//TODO 9: Put the code in try catch block for IOException
                printWriter.println(person);
                System.out.println("Data written to file2.txt successfully!");
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }

        }


//TODO 10: Declare a byte array to store a list of numbers.
        public static void byteArrayWrite() {
            byte[] numbers = {10, 20, 30, 40, 50};

//TODO 11: Open a FileOutputStream object, pointing towards file3.txt file
            try (FileOutputStream outputStream = new FileOutputStream("file3.txt")) {

//TODO 12: call the write() method of FileOutputStream object to print each element in the array.
// Use for loop for the purpose
//TODO 13: Place all the file activity inside the try-catch block.
                for (byte number : numbers) {
                    outputStream.write(number);
                }
                System.out.println("Data written to file3.txt successfully!");
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

//TODO 14: Declare an object of DataOutputStream class.
// Use object of FileOutputStream class as argument to its constructor.
// The FileOutputStream object refers to file4.dat
    public static void streamWrite() {

//TODO 15: Use Scanner class to read name, age, and weight.
// Instantiate a Person object from the inputs.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Enter your weight: ");
        double weight = scanner.nextDouble();

        scanner.close();
        Person person = new Person(name, age, weight);
//TODO 16: Call writeUTF(), writeInt(), and writeDouble() methods of DataOutputStream object
// to write respectively the name, age and weight attributes of the Person object.

//TODO 17: Place the entire file writing code in try-catch block
        try (FileOutputStream file = new FileOutputStream("file4.dat");
             DataOutputStream fileObj = new DataOutputStream(file)) {

            fileObj.writeUTF(person.getName());
            fileObj.writeInt(person.getAge());
            fileObj.writeDouble(person.getWeight());

            System.out.println("Data written to file4.dat successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file4.dat: " + e.getMessage());
        }
    }
}

    public static void main(String[] args) throws Exception{
//TODO 18: call the static methods from main() method
        textFileWrite();
        printWrite();
        byteArrayWrite();
        streamWrite();

    }
}