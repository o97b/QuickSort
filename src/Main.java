import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int N = 40;
        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            array.add((int)(10 * (Math.random() - 0.5)));
        }

        System.out.println("Start array " + array.toString());
        Quick.quickSort(array, 0, array.size() - 1);
        System.out.println("End array " + array.toString());
        System.out.println("CompareCounter " + Quick.comparator.compareCounter);
    }

}
