
public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "kiwi", "grapefruit", "pear", "orange"};
        mergeSort(words, 0, words.length - 1);

        System.out.print("Sorted words: \n");
        for (String word : words) {
            System.out.print(word + " \n");
        }
    }

    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively divide the array
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    public static void merge(String[] arr, int left, int middle, int right) {
        // Calculate the sizes of the two sub-arrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays for the left and right halves
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Initialize indices for merging
        int i = 0, j = 0;
        int k = left;

        // Merge the two sorted arrays based on string length
        while (i < n1 && j < n2) {
            if (leftArray[i].length() <= rightArray[j].length()) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}