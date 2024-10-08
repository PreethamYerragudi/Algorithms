public class SelectionSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if(SortMethods.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortMethods.exch(a, i, min);
        }
        return a;
    }
}
