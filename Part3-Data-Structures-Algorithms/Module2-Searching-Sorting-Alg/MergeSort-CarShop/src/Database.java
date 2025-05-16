import java.util.ArrayList;
import java.util.Arrays;


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
        registrations.add(new Registration("KEC-3996", "Kathy Myers"));
        registrations.add(new Registration("HOZ-1224", "Hugh Haines"));
        registrations.add(new Registration("KGJ-5010", "Tammy Mallard"));
        registrations.add(new Registration("FVA-4467", "Michael Knowles"));
        registrations.add(new Registration("NEV-9119", "Michael Knowles"));
        registrations.add(new Registration("BJT-9772", "Karl Yardley"));
        registrations.add(new Registration("YQD-3410", "Andrea Elsworth"));
        registrations.add(new Registration("DUY-0288", "Jay Zagorski"));
        registrations.add(new Registration("ATZ-9783", "Sally Oakes"));
        registrations.add(new Registration("IAG-6602", "Patrick Hewitt"));
        registrations.add(new Registration("DCP-2974", "Donna Wardman"));
        registrations.add(new Registration("FAH-2515", "Jay Newton"));
        registrations.add(new Registration("GYF-3958", "Carla Collins"));
        registrations.add(new Registration("NCL-9068", "James McBride"));
        registrations.add(new Registration("UBJ-1923", "Helen Gibbs"));
        registrations.add(new Registration("UUG-4837", "Conrad Pryor"));
        registrations.add(new Registration("GMD-6786", "Tracy Gilbert"));
        registrations.add(new Registration("QTW-6473", "Donald Gatfield"));
        registrations.add(new Registration("QQE-3264", "Charlotte Newport"));
        registrations.add(new Registration("WAO-8258", "Rodney Gilbert"));

    }

    public void printAll(){
        for (Object obj : registrations) {
            Registration reg = (Registration) obj;
            System.out.println(reg);
        }
    }

    public void mergeSort() {
        int n = registrations.size();

        /* TODO 1: Implement a for loop that sets the size of the
                   subarrays. */

        /* TODO 2: Start the subarray size at 1 element. */
        /* TODO 3: Double the subarray size with each iteration. */
        /* TODO 4: Continue to iterate as long as the subarray size
                   does not exceed the registration array size. */
        for (int subArrSize = 1; subArrSize < n; subArrSize *= 2) {

            /* TODO 5: Within the for loop Implement a nested for loop that
                   creates and processes the subarrays */
            /* TODO 6: with each iteration, shift the left start index of
                   the subarrays.*/
            /* TODO 7: Stop the for loop when all sub arrays have been
                   processed. */
            for (int leftStart = 0; leftStart < n - subArrSize; leftStart += 2 * subArrSize) {

                /* TODO 8: With each iteration, determine the start and end
                   indexes for the left and right subarrays.*/
                int rightStart = leftStart + subArrSize;
                int rightEndExcluded = Math.min(leftStart + 2 * subArrSize, n);

                /* TODO 9: Using the left, right, and right end indexes create a set
                   of left and right subarrays */

                ArrayList leftSub = new ArrayList(registrations.subList(leftStart, rightStart));
                ArrayList rightSub = new ArrayList(registrations.subList(rightStart, rightEndExcluded));

                /* TODO 11: Comment out the next two lines */
//                System.out.println("Left: " + leftStart + ", Right: " + rightStart +
//                ", Right Excluded: " + rightEndExcluded);

                /* TODO 12: With each iteration, pass the merge index, which is the
                    left start index, and the two subarrays to the merge( )
                    method. */
                merge(leftStart, leftSub, rightSub);
            }
        }
    }

    private void merge(int mergeIndex, ArrayList leftArray, ArrayList rightArray) {
        /* TODO 13: Initialize variables used in the method. */
        int leftIndex = 0;
        int rightIndex = 0;

        /* TODO 14: Implement the first while loop, which iterates over
                    the elements in the subarrays. */

        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()) {

            /* TODO 15: Set the condition of the while loop to stop when
                    either all the left or right elements have been
                    merged.*/
            /* TODO 16: Within the first while loop, store the elements from the
                    left and right sub arrays in local variables according to
                    their corresponding indexes. */

            Registration leftVal = (Registration) leftArray.get(leftIndex);
            Registration rightVal = (Registration) rightArray.get(rightIndex);

            /* TODO 17: Uncomment the next two lines below and run the
                        application. */
//            System.out.println("leftVal: " + leftVal.license +
//                    " rightVal: " + rightVal.license);
//            leftIndex++;
            /* TODO 18: Remove or comment out the two lines above */

            /* TODO 19: Implement an IF statement comparing the left Subarray
                    element to the right one. The condition is true if the
                    left element is less than or equal to the right. */

            if (leftVal.license.compareTo(rightVal.license) <= 0) {
            /* TODO 20: If true, merge the element from the left subarray into
                    the registration array and increment the left subarray
                    index.  */

                registrations.set(mergeIndex, leftVal);
                leftIndex++;

                /* TODO 21: Else, merge the element from the right subarray into
                    the registration array and increment the right subarray
                    index. */
            } else {
                registrations.set(mergeIndex, rightVal);
                rightIndex++;
            }

            /* TODO 22: Increment the merge index. */
            mergeIndex++;
        }

        /* TODO 23: Implement a second while loop to merge any elements
                    from the left subarray that have not already been
                    merged. */
        /* TODO 24: Inside the second while loop, with each iteration,
                    obtain the value at the left index from the left
                    subarray */
        /* TODO 25: Set the value at the left index to the merge index in
                    the registrations array. */
        /* TODO 26: Increment both the left and merge index by 1 */

        while (leftIndex < leftArray.size()) {
            Registration leftVal = (Registration) leftArray.get(leftIndex);
            registrations.set(mergeIndex, leftVal);
            leftIndex++;
            mergeIndex++;
        }
        /* TODO 27: Implement a third while loop to merge any elements
                    from the right subarray that have not already been
                    merged. */
        /* TODO 28: Inside the second while loop, with each iteration
                    obtain the value at the right index from the right
                    subarray */
        /* TODO 29: Set the value at the right index to the merge index in
                    the registrations array. */
        /* TODO 30: Increment both the right and merge index by 1 */

        while (rightIndex < rightArray.size()) {
            Registration rightVal = (Registration) rightArray.get(rightIndex);
            registrations.set(mergeIndex, rightVal);
            rightIndex++;
            mergeIndex++;
        }
    }
    public void insertionSort() {
        int regCount = registrations.size();
        for (int unsortedIndx = 1; unsortedIndx < regCount; unsortedIndx++) {
            Registration unsortedReg =
                    (Registration)registrations.get(unsortedIndx);
            int sortedIndx = unsortedIndx - 1;
            while (sortedIndx >= 0) {
                Registration sortedReg =
                        (Registration)registrations.get(sortedIndx);
                int compareValue = sortedReg.license.compareTo(unsortedReg.license);
                if (sortedReg.license.compareTo(unsortedReg.license) > 0) {
                    registrations.set(sortedIndx + 1, sortedReg);
                    sortedIndx--; // Move to the next element to the left
                } else {
                    break;
                }
            }
            registrations.set(sortedIndx + 1, unsortedReg);
        }
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
    public static void main(String[] args) {

        Database db = new Database();

        db.mergeSort();

        /* TODO 31: Uncomment the following lines */
        System.out.println("\n******* Sorted ArrayList ******\n");
        db.printAll();

    }
}
