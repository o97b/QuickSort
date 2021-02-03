import java.util.Comparator;

public class NewComparator implements Comparator<Integer> {

    public int compareCounter = 0;
    @Override
    public int compare(Integer o1, Integer o2) {
        compareCounter++;
        return o1.compareTo(o2);
    }

    private static NewComparator comparator;
    private NewComparator() {
    }

    public static NewComparator getComparator() {
        if(comparator == null) {
            comparator = new NewComparator();
        }
        return comparator;
    }
}
