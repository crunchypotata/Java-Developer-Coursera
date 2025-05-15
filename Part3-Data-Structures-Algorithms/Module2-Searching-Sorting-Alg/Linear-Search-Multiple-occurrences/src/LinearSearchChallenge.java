import java.util.ArrayList;
import java.util.List;

public class LinearSearchChallenge {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 20, 50};
        int target = 20; // Value to search for

        int[] indices = findAllOccurrences(arr, target);
        System.out.print("Find All Occurrences: ");
        if (indices.length > 0) {
            for (int index : indices) {
                System.out.print(index + " ");
            }
        } else {
            System.out.print("No occurrences found.");
        }
        System.out.println();
    }

    public static int[] findAllOccurrences(int[] arr, int target) {
        // TODO: Implement this method to return all indices where the target value is found
        List<Integer> indicesList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indicesList.add(i);
            }
        }

        int[] indicesArray = new int[indicesList.size()];
        for (int i = 0; i < indicesArray.length; i++) {
            indicesArray[i] = indicesList.get(i);
        }

        return indicesArray;
    }
}