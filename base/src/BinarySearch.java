public class BinarySort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySortRecursion(array, 5, 0, array.length - 1));
        System.out.println(binarySort(array, 5));
    }

    /**
     * 循环实现二分查找
     *
     * @param array
     * @param key
     * @return
     */
    public static int binarySort(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分查找
     *
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int binarySortRecursion(int[] array, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                return binarySortRecursion(array, key, low, mid - 1);
            } else if (key > array[mid]) {
                return binarySortRecursion(array, key, mid + 1, high);
            } else {
                return mid;
            }
        }
        return -1;
    }

}
