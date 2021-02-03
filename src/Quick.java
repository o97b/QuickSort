import java.util.ArrayList;

public class Quick {

    public static NewComparator comparator = NewComparator.getComparator();
    public static int cutoff = 10; // Параметр отсечки на сортировку вставками, обычно от 5 до 15.


    public static void quickSort(ArrayList<Integer> array, int low, int high) {
        if (high <= low + cutoff) { insertionSort(array, low, high); return; }
        int partitionIndex = quickSortPartition(array, low, high);

        quickSort(array, low, partitionIndex-1);
        quickSort(array, partitionIndex+1, high);
    }

    private static int quickSortPartition(ArrayList<Integer> array, int low, int high) {
        Integer pivot = median(array.get(low), array.get(high), array.get((low+high)/2));
        int i = low, j = high + 1;

        while (true) {
            while (comparator.compare(array.get(++i), pivot) < 0) { if (i == high) break; }
            while (comparator.compare(pivot, array.get(--j)) < 0) { if (j == low) break; }
            if (i >= j) break;

            swap(array, i, j);
        }

        swap(array, low, j);
        return j;
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

    public static int median(int a, int b, int c) {
        return (a > b) ? ((a > c) ? (Math.max(b, c)) : a)
                : ((a > c) ? a :(Math.min(b, c)));
    }
}
