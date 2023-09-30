import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    public int[] mirror() {
        int n = array.length;
        int[] mirroredArray = new int[2 * n];

        for (int i = 0; i < n; i++) {
            mirroredArray[i] = array[i];
            mirroredArray[2 * n - i - 1] = array[i];
        }

        return mirroredArray;
    }

    public int[] removeDuplicates() {
        List<Integer> uniqueElements = new ArrayList<>();
        
        for (int element : array) {
            if (!uniqueElements.contains(element)) {
                uniqueElements.add(element);
            }
        }
        int[] resultArray = new int[uniqueElements.size()];
        for (int i = 0; i < uniqueElements.size(); i++) {
            resultArray[i] = uniqueElements.get(i);
        }

        return resultArray;
    }

    public int[] getMissingValues() {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        List<Integer> missingValues = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            if (!contains(array, i)) {
                missingValues.add(i);
            }
        }

        int[] resultArray = new int[missingValues.size()];
        for (int i = 0; i < missingValues.size(); i++) {
            resultArray[i] = missingValues.get(i);
        }

        return resultArray;
    }

    private boolean contains(int[] arr, int value) {
        for (int element : arr) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public int[] fillMissingValues(int k) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        List<Integer> filledValues = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (contains(array, i)) {
                filledValues.add(i);
            } else {
                for (int j = 1; j <= k; j++) {
                    if (contains(array, i - j)) {
                        filledValues.add(i - j);
                        break;
                    } else if (contains(array, i + j)) {
                        filledValues.add(i + j);
                        break;
                    }
                }
            }
        }

        // Convert List to an array
        int[] resultArray = new int[filledValues.size()];
        for (int i = 0; i < filledValues.size(); i++) {
            resultArray[i] = filledValues.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] inputArray1 = {1, 2, 3};
        MyArray myArray1 = new MyArray(inputArray1);


        int[] mirroredResult = myArray1.mirror();
        System.out.println("Mirror Result: " + Arrays.toString(mirroredResult));

        int[] inputArray2 = {1, 3, 5, 1, 3, 7, 9, 8};
        MyArray myArray2 = new MyArray(inputArray2);


        int[] uniqueResult = myArray2.removeDuplicates();
        System.out.println("Remove Duplicates Result: " + Arrays.toString(uniqueResult));

        int[] inputArray3 = {10, 11, 12, 13, 14, 16, 17, 19, 20};
        MyArray myArray3 = new MyArray(inputArray3);

  
        int[] missingValues = myArray3.getMissingValues();
        System.out.println("Missing Values: " + Arrays.toString(missingValues));

        int[] inputArray4 = {10, 11, 12, -1, 14, 10, 17, 19, 20};
        MyArray myArray4 = new MyArray(inputArray4);


        int[] filledValues = myArray4.fillMissingValues(3);
        System.out.println("Filled Values: " + Arrays.toString(filledValues));
    }
}
