//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] names = {"Zara", "Mia", "Anna", "Sophia", "Ben"};
//        insertionSort(names);
        insertionSortDescending(names);

        System.out.print("Sorted names: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int counter1 = 1; counter1 < n; counter1++) {
            String key = arr[counter1];
            int counter2 = counter1 - 1;
            while (counter2 >= 0 && arr[counter2].compareTo(key) > 0) {
                arr[counter2 + 1] = arr[counter2];
                counter2 = counter2 - 1;
            }
            arr[counter2 + 1] = key;
        }
    }

    public static void insertionSortDescending(String[] arr) {
        int n = arr.length;
        for (int counter1 = 1; counter1 < n; counter1++) {
            String key = arr[counter1];
            int counter2 = counter1 - 1;
            while (counter2 >= 0 && arr[counter2].compareTo(key) < 0) {
                arr[counter2 + 1] = arr[counter2];
                counter2 = counter2 - 1;
            }
            arr[counter2 + 1] = key;
        }
    }


}