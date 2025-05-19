import java.util.ArrayList;
import java.util.List;


public class Database {
        private ArrayList registrations = new ArrayList();

        public Database() {
            // Initialize the ArrayList of registrations

        registrations.add(new Registration("SGL-6855", "Tyler Lennon"));
        registrations.add(new Registration("SDN-2659", "Margaret Finn"));
        registrations.add(new Registration("ANA-2866", "Zane Hallworth"));
        registrations.add(new Registration("DYC-5707", "Jodi Gatfield"));
        registrations.add(new Registration("GIG-1870", "Harvey Kenny"));
        registrations.add(new Registration("NWK-2057", "Janice Hudson"));
        registrations.add(new Registration("BYJ-6279", "Larry Newman"));
        registrations.add(new Registration("ENY-2915", "Helen Pryor"));
        registrations.add(new Registration("OYW-0632", "Quincy Cromwell"));

    }

    public void printAll(){
        for (Object obj : registrations) {
            Registration reg = (Registration) obj;
            System.out.println(reg);
        }
    }
    public void quickSort() {

        /* TODO 1: Initialize a high index variable to the size of
                   the registrations array minus 1.  */
        int highIndx = registrations.size() -1;

        /* TODO 2: Initialize a low index variable to zero*/
        int lowIndx = 0;

        /* TODO 3: Create a while loop that will run as long as the low index
                 is less than the high index  */
        while (lowIndx < highIndx) {

        /* TODO 4: Within the while loop, call the partition() method
                   passing in the high and low indexes.  */

        /* TODO 5: Initialize a pivot index variable with the value
                   returned by the partition() method. */
            int pivotIndex = partition(lowIndx, highIndx);

        /* TODO 22: Implement an If-Else-If-Else statement. The If clause is
                   true when the pivot index minus 1 exceeds the low index. */
            if (pivotIndex - 1 > lowIndx) {

        /* TODO 23: When the If clause is true, set the high index equal
                 to the pivot index minus 1 */
                highIndx = pivotIndex - 1;

        /* TODO 24: Implement the Else-If clause so it's true when the
                   pivot index plus 1 is less than the high index */
            } else if (pivotIndex + 1 < highIndx) {
        /* TODO 25: When Else-If is true, set the low index equal to the
                 pivot index plus 1 */
                lowIndx = pivotIndex + 1;
        /* TODO 26: When neither the If nor the Else-IF clause is true,
                 implement the Else clause to break out of the
                 while loop and end the sort */
            } else {
                break;
            }
        }
    }
    private int partition(int lowIndx, int highIndx) {

        /* TODO 6: Create a subarray from the registrations array that
                   starts at the low_index and ends at the high_Index
                   plus 1  */
        List subArray = registrations.subList(lowIndx, highIndx + 1);

        /* TODO 7: Initialize the pivot element to the last element in the
                   subarray */
        Registration pivotElement = (Registration)subArray.get(subArray.size() - 1);

        /* TODO 8: Initialize a greater-than index with negative 1  */
        int greaterThanIndx = - 1;

        /* TODO 9: Create a for loop initializing a current index variable
                 to zero.
           TODO 10: Set the condition so the loop runs as long as the
                 current index is less than the last index of the subarray.
           TODO 11: Increment the current index at the end of each iteration.
         */

        for (int currentIndex = 0; currentIndex < subArray.size() - 1; currentIndex++) {
            /* TODO 12: Get the element at the current index */
            Registration currentElement = (Registration) subArray.get(currentIndex);
            /* TODO 14: Comment out the print statement below */
//        System.out.println("Pivot: " + pivotElement.license +
//                ", Current: " + currentElement.license);

        /* TODO 15: Implement an IF statement whose condition is true when
                    the current element’s license is less than or equal to
                    the pivot element’s license. */
            if (currentElement.license.compareTo(pivotElement.license) <= 0) {
//                /* TODO 16: If true, increment the greater-than index  */
                greaterThanIndx++;

        /* TODO 17: Implement a nested IF statement whose condition is true
                    if the greater-than index is less than the current
                    index. */
                if (greaterThanIndx < currentIndex) {
                    /* TODO 18: If true, call the swap() method passing in the subarray,
                        the greater-than index, and the current index */
                    swap(subArray, greaterThanIndx, currentIndex);
                }
            }
        }

        /* TODO 19: After the for loop, initialize a pivot index variable
                    equal to the greater-than index plus 1  */
        int pivotIndex = greaterThanIndx + 1;

        /* TODO 20: Call the swap() method passing in the subarray, the
                    pivot index, and the index of the last element in the
                    subarray  */
        swap(subArray, pivotIndex, subArray.size()-1);
        /* TODO 21: Replace the return with the pivot index plus the
                    low_Index as an offset to the registrations array. */
        return pivotIndex + lowIndx;
    }

    private void swap(List subArray, int i, int j) {
        Registration iElement = (Registration)subArray.get(i);
        Registration jElement = (Registration)subArray.get(j);
        subArray.set(i, jElement);
        subArray.set(j, iElement);
    }

    public void bubbleSort() {
        int n = registrations.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                Registration currentReg = (Registration) registrations.get(j);
                Registration nextReg = (Registration) registrations.get(j + 1);
                if (currentReg.license.compareTo(nextReg.license) > 0) {
                    registrations.set(j, nextReg);
                    registrations.set(j + 1, currentReg);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void insertionSort() {
        int regCount = registrations.size();
        for (int unsorted_Indx = 1; unsorted_Indx < regCount; unsorted_Indx++) {
            Registration unsortedReg =
                    (Registration)registrations.get(unsorted_Indx);
            int sorted_Indx = unsorted_Indx - 1;

            while (sorted_Indx >= 0) {
                Registration sortedReg =
                        (Registration)registrations.get(sorted_Indx);
                int compareValue = sortedReg.license.compareTo(unsortedReg.license);
                if (sortedReg.license.compareTo(unsortedReg.license) > 0) {
                    registrations.set(sorted_Indx + 1, sortedReg);
                    sorted_Indx--; // Move to the next element to the left
                } else {
                    break;
                }
            }
            registrations.set(sorted_Indx + 1, unsortedReg);
        }
    }

    public void mergeSort() {
        int n = registrations.size();
        for (int subArrSize = 1; subArrSize < n; subArrSize *= 2) {
            for (int leftStart = 0; leftStart < n - subArrSize; leftStart += 2 * subArrSize) {
                int rightStart = leftStart + subArrSize;
                int rightEndExcluded = Math.min(leftStart + 2 * subArrSize, n);
                ArrayList leftArray = new ArrayList(registrations.subList(leftStart, rightStart));
                ArrayList rightArray = new ArrayList(registrations.subList(rightStart, rightEndExcluded));
                merge(leftStart, leftArray, rightArray);
            }
        }
    }

    private void merge(int mergeIndex, ArrayList leftArray, ArrayList rightArray) {
        int left_Indx = 0, right_Indx = 0;
        Registration leftVal;
        Registration rightVal;
        while (left_Indx < leftArray.size() && right_Indx < rightArray.size()) {
            leftVal = (Registration) leftArray.get(left_Indx);
            rightVal = (Registration) rightArray.get(right_Indx);
            if (leftVal.license.compareTo(rightVal.license) <= 0) {
                this.registrations.set(mergeIndex, leftVal);
                left_Indx++;
            } else {
                this.registrations.set(mergeIndex, rightVal);
                right_Indx++;
            }
            mergeIndex++;
        }
        while (left_Indx < leftArray.size()) {
            leftVal = (Registration) leftArray.get(left_Indx);
            this.registrations.set(mergeIndex, leftVal);
            left_Indx++;
            mergeIndex++;
        }
        while (right_Indx < rightArray.size()) {
            rightVal = (Registration) rightArray.get(right_Indx);
            this.registrations.set(mergeIndex, rightVal);
            right_Indx++;
            mergeIndex++;
        }
    }


    public static void main(String[] args) {

        Database db = new Database();

        db.quickSort();

        /* TODO 27: Uncomment the last two lines */
        System.out.println("\n******* Sorted ArrayList ******\n");
        db.printAll();

    }

}
