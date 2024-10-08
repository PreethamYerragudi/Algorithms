public class KnuthShuffle {
    public static void shuffle(Comparable[] a) {
        int N = a.length;
        int R = 0;
        for (int i = 0; i < N; i++) {
            R = (int)(Math.random()*i);
            SortMethods.exch(a, i, R);
        }
    }
}
