public class RenameBook {

    public static void main(String[] args) {
        String bookTitle = "The Adventures of Captain Fantastic and the Magical Unicorn";
        int titleLength = bookTitle.length();
        System.out.println("Length of the book title: " + titleLength);

        //Declare and initialise the length of shortened book title
        int maxLength = 20;


        // Shortened the book title
        String shortBookTitle = bookTitle.substring(0,maxLength);
        System.out.println("Original title: " + bookTitle);
        System.out.println("Shortened title: " + shortBookTitle);

        // Declare and initialize the searchWord
        String searchWord = "Captain";

        // Check if the searchWord is present in book title
        boolean containsWord = bookTitle.contains(searchWord);
        System.out.println("Does the title contain the word \"" + searchWord + "\"? " + containsWord);

        String javaEx = "Java programming is fun and educational";
        String searchFun = "fun";
        boolean containsFun = javaEx.contains("fun");
        System.out.println("Does the title contain the word \"" + searchFun + "\"? " + containsFun);

        String newJavaEx = javaEx.replace("educational", "awesome");
        System.out.println(newJavaEx);
        int length = newJavaEx.length();
        System.out.println(length);

        String shortJavaEx = newJavaEx.substring(0,16);
        System.out.println(shortJavaEx);


    }
}
