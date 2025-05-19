public class Main {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "orange", "kiwi", "grape"};
        quickSort(words, 0, words.length - 1);

        System.out.print("Sorted words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    // QuickSort method that divides the array and sorts each partition
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method: selects a pivot and rearranges elements around the pivot
    public static int partition(String[] arr, int low, int high) {
        // Select the last element as the pivot
        String pivot = arr[high];
        // Index of smaller element
        int i = low - 1;

        // Loop through the subarray and move smaller (alphabetically) elements to the left of the pivot
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {  // Use compareTo to compare strings alphabetically
                i++;
                // Swap arr[i] and arr[j] to ensure smaller elements are on the left
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // After looping, swap the pivot into its correct position
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        // Return the index of the pivot
        return i + 1;
    }
}