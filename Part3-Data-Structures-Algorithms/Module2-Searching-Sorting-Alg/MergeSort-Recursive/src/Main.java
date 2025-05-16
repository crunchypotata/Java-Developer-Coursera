
public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "kiwi", "grapefruit", "pear", "orange"};
        mergeSort(words, 0, words.length - 1);

        System.out.print("Sorted words: \n");
        for (String word : words) {
            System.out.print(word + " \n");
        }
    }

    public static void mergeSort(String[] unsortedWords, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively divide the array
            mergeSort(unsortedWords, left, middle);
            mergeSort(unsortedWords, middle + 1, right);

            // Merge the sorted halves
            merge(unsortedWords, left, middle, right);
        }
    }

    public static void merge(String[] arr, int left, int middle, int right) {
        // Calculate the sizes of the two sub-arrays
        int leftSub = middle - left + 1;
        int rightSub = right - middle;

        // Create temporary arrays for the left and right halves
        String[] leftArray = new String[leftSub];
        String[] rightArray = new String[rightSub];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSub; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightSub; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Initialize indices for merging
        int i = 0, j = 0;
        int indexOfOrigArray = left;

        // Merge the two sorted arrays based on string length
        while (i < leftSub && j < rightSub) {
            if (leftArray[i].length() <= rightArray[j].length()) {
                arr[indexOfOrigArray] = leftArray[i];
                i++;
            } else {
                arr[indexOfOrigArray] = rightArray[j];
                j++;
            }
            indexOfOrigArray++;
        }

        // Copy any remaining elements from the left array
        while (i < leftSub) {
            arr[indexOfOrigArray] = leftArray[i];
            i++;
            indexOfOrigArray++;
        }

        // Copy any remaining elements from the right array
        while (j < rightSub) {
            arr[indexOfOrigArray] = rightArray[j];
            j++;
            indexOfOrigArray++;
        }
    }
}