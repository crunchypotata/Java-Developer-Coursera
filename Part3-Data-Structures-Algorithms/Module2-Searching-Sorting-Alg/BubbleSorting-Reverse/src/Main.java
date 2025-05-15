public class Main {
    public static void main(String[] args) {
        int[] heights = {198, 185, 210, 176, 195};
        bubbleSortDescending(heights);
//        bubbleSort(heights);

        System.out.print("Sorted heights in descending order: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int counter1 = 0; counter1 < n - 1; counter1++) {
            for (int counter2 = 0; counter2 < n - 1 - counter1; counter2++) {
                if (arr[counter2] > arr[counter2 + 1]) {
                    int temp = arr[counter2];
                    arr[counter2] = arr[counter2 + 1];
                    arr[counter2 + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDescending(int[] heights) {
        //TODO: write your bubble sort logic here
        int n = heights.length;
        for (int counter1 = 0; counter1 < n - 1; counter1++) {
            for (int counter2 = 0; counter2 < n - 1 - counter1; counter2++) {
                if (heights[counter2] < heights[counter2 + 1]) {
                    int temp = heights[counter2];
                    heights[counter2] = heights[counter2 + 1];
                    heights[counter2 + 1] = temp;
                }
            }
        }
    }
}