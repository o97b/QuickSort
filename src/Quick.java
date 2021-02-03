import java.util.ArrayList;

public class Quick {

    public static NewComparator comparator = new NewComparator();

    public static void quickSort(ArrayList<Integer> array, int low, int high) {
        int cutoff = 10; // Параметр отсечки на сортировку вставками, обычно от 5 до 15.
        if (high <= low + cutoff) { insertionSort(array, low, high); return; }

        int medianIndex = medianIndex(array, low, high, (low+high)/2);
        Integer pivot = array.get(medianIndex);
        int i = low, j = low + 1, k = high;

        swap(array, low, medianIndex);
        while (j <= k) {
            int cmp = comparator.compare(array.get(j), pivot);
            if (cmp < 0) swap(array, i++, j++);
            else if (cmp > 0) swap(array, j, k--);
            else j++;
        }

        quickSort(array, low, i - 1);
        quickSort(array, k + 1, high);
    }


    static public void insertionSort(ArrayList<Integer> array, int low, int high) {
        for (int i = low; i <= high; i ++) {
            for (int j = i; j > low && comparator.compare(array.get(j), array.get(j-1)) < 0; j--) {
                swap(array, j, j-1);
            }
        }
    }

    public static void swap(ArrayList<Integer> array, int i, int j) {
        int swapTemp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, swapTemp);
    }

    public static int medianIndex(ArrayList<Integer> array, int low, int high, int middle) {
        int a = array.get(low), b = array.get(high), c = array.get(middle);
        return (a > b) ? ((a > c) ? ((b > c) ? high : middle) : low)
                : ((a > c) ? low : ((b > c) ? middle : high));
    }
}
