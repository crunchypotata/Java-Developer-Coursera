public class Main {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "orange", "kiwi", "grape"};
        quickSort(words, 0, words.length - 1);

        System.out.print("Sorted words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the partition index
    }
}