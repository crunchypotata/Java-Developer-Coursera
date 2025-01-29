public class Main {
    public static void main(String[] args) {
        // Variables to store the weight and height values
        double weight = 0, height = 0;
        // Variable to hold the BMI value
        double bmi = 0;
        // Variable to hold the BMI system value obtained from user input
        String bmiSystem;
        // Variable to hold the BMI category determined by this BMI Calculator
        String bmiCategory = "";

        // Please initialize this reference variable to create an object of the UserInput class
        UserInput userInput = new UserInput();
        // Please initialize this reference variable to create an object of the BMICalculator class
        BMICalculator bmiCalculator = new BMICalculator();

        // Invoke the obtainBMISystem() of the UserInput class
        bmiSystem = userInput.obtainBMISystem();

        // A Switch statement that determines how user input for weight and height should be obtained based on the BMI system
        switch (bmiSystem.toUpperCase()) {
            // The case of IMPERIAL BMI system
            case "IMPERIAL":
                // Please invoke the obtainWeight() method of the UserInput class and assign it to the variable weight
                weight = userInput.obtainWeight(bmiSystem);
                // Please invoke the obtainHeight() method of the UserInput class and assign it to the variable height
                height = userInput.obtainHeight(bmiSystem);
                // Please invoke the calculateBmiImperial() method of the BMICalculator class
                bmi = bmiCalculator.calculateBmiImperial(weight, height);
                // Break out of the switch statement
                break;
            // The case of METRIC BMI system
            case "METRIC":
                // Please invoke the obtainWeight() method of the UserInput class and assign it to the variable weight
                weight = userInput.obtainWeight(bmiSystem);
                // Please invoke the obtainHeight() method of the UserInput class and assign it to the variable height
                height = userInput.obtainHeight(bmiSystem);
                // Please invoke the calculateBmiMetric() method of the BMICalculator class
                bmi = bmiCalculator.calculateBmiMetric(weight, height);
                // Break out of the switch statement
                break;
            // The case of empty BMI system due to invalid user input
            case "":
                // Please display a message asking the user to enter a valid BMI system in case of invalid input
                System.out.println("Please Enter a valid BMI System as input");
                // Break out of the switch statement
                break;
        }

        // Display the calculated BMI value to the user
        System.out.println("Your BMI is: " + bmi);

        // Please invoke the getBMICategory() method of the BMICalculator class and assign the result to the bmiCategory variable
        bmiCategory = bmiCalculator.getBMICategory(bmi);
        // Display the BMI category to the user
        System.out.println("Your BMI category is: " + bmiCategory);
    }
}
