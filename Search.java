package scf.session5;

/**
 * A utility class for searching an integer in integer array.
 * @author Shivam Kumar Meena
 * created on 20th January, 2020
 */
public class Search {

    /**
     * Linear search for input key in numbers array and return
     * index if key is found in array, else return -1.
     * @param numbers array in which key is to be searched.
     * @param key number to be searched.
     * @return index if key is found, else -1.
     */
    public static int linearSearch(int[] numbers, int key) {
        return linearSearchHelper(numbers, 0, key);
    }
    
    /**
     * Binary search for input key in numbers array and return
     * index if key is found in array, else return -1.
     * @param numbers array in which key is to be searched.
     * @param key number to be searched.
     * @return index if key is found, else -1.
     */
    public static int binarySearch(int[] numbers, int key) {
        return binarySearchHelper(numbers, 0, numbers.length - 1, key);
    }
    
    private static int linearSearchHelper(int[] numbers, int start, int key) {
        if (start == numbers.length) {
            return -1;
        }
        
        if (key == numbers[start]) {
            return start;
        }
        
        return linearSearchHelper(numbers, start + 1, key);
    }
    
    private static int binarySearchHelper(int[] numbers, int start, int end,
                                    int key) {
        int middle;
        
        if (start > end) {
            return -1;
        }
        
        middle = (start + end) / 2;
        if (key == numbers[middle]) {
            return middle;
        }
        
        if (key < numbers[middle]) {
            return binarySearchHelper(numbers, start, middle - 1, key);
        }
        
        return binarySearchHelper(numbers, middle + 1, end, key);
    }
}
