public class InsertionSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(SortMethods.less(a[j], a[j-1])) {
                    SortMethods.exch(a, j, j-1);
                }else {
                    break;
                }
            }
        }
        return a;
    }
}
