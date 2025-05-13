public class BinarySearchChallenge {

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 40, 50};
        int target = 20;

        boolean multiple = hasMultipleOccurrences(arr, target);
        System.out.println("Has Multiple Occurrences: " + multiple);
    }

    public static boolean hasMultipleOccurrences(int[] arr, int target) {
        // TODO: implement the method to find if target is appearing more than once in arr

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // checking neighbours
                if ((mid > 0 && arr[mid - 1] == target) ||
                        (mid < arr.length - 1 && arr[mid + 1] == target)) {
                    return true; // multiple occurrences
                } else {
                    return false; // there aren't multiple occurrences
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // hasn't found
    }
}
