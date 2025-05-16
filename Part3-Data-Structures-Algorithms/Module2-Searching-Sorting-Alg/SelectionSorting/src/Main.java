public class Main {
    public static void main(String[] args) {
        int[] heightOfBooks = {29, 10, 14, 37, 13};

        selectionSortDescending(heightOfBooks);
        System.out.print("Sorted heightOfBooks (Descending): ");
        printArray(heightOfBooks);

        selectionSort(heightOfBooks);
        System.out.print("Sorted heightOfBooks (Ascending): ");
        printArray(heightOfBooks);

    }

    public static void printArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int counter1 = 0; counter1 < n - 1; counter1++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = counter1;
            for (int counter2 = counter1 + 1; counter2 < n; counter2++) {
                if (arr[counter2] < arr[minIndex]) {
                    minIndex = counter2;
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[counter1];
            arr[counter1] = temp;
        }
    }

    public static void selectionSortDescending(int[] arr) {
        // TODO: Write the logic to sort the scores in descending order using selection sort
        int n = arr.length;
        for (int counter1 = 0; counter1 < n - 1; counter1++) {
            // Find the max element in the unsorted part of the array
            int maxIndex = counter1;
            for (int counter2 = counter1 + 1; counter2 < n; counter2++) {
                if (arr[counter2] > arr[maxIndex]) {
                    maxIndex = counter2;
                }
            }
            // Swap the found max element with the first element of the unsorted part
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[counter1];
            arr[counter1] = temp;
        }
    }
}
