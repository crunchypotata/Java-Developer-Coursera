public class StringMethods {
    public static void main(String[] args) {
        String text = "Adventure";

        // TODO: Check the length using length() and print the length
        int length = text.length();
        System.out.println(length);

        // TODO: Get the character at position 3 and print the character
        char letter = text.charAt(4);
        System.out.println("The character at index 3 is: " + letter);

        // TODO: Get a part of the String from position 1 to 4 and print the string
        String partWord = text.substring(0,4);
        System.out.println("The substring from index 1 to 4. 4 excluded: " + partWord);

        String anotherText= "Adventure";
        // TODO: Compare text with anotherText using equals() and print the output
        boolean result = text.equals(anotherText);
        System.out.println("Using equals() method \"" +  text + "\" is equal to \"" + anotherText + "\": " + result);

        // TODO: Change to uppercase using toUpperCase() and print the converted string
        String adUpC = text.toUpperCase();
        System.out.println("The Adventure converted to uppercase: \"" + adUpC + "\"");

        // TODO: Change to lowercase using toLowerCase() and print the converted string
        String adLowC = text.toLowerCase();
        System.out.println("The Adventure converted to lowercase: \"" + adLowC + "\"");

        // TODO: Check if it contains "vent" using contains() and print the output
        boolean hasVent = text.contains("vent");
        System.out.println("The Adventure: \"" + text + "\" contains the substring \"vent\": "+ hasVent);

        // TODO: Replace 'e' with 'a' and print the output
        String AdChange = text.replace ('e', 'a');
        System.out.println("The text \"" + text + "\" with character \"e\" replaced \"a\": " + AdChange);
    }
}