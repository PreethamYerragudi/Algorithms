import java.util.Arrays;

public class AlgorithmTester {
    public static void main(String args[]){
        Integer[] arr = {8,2,27,4,9,0,12,1,56,43,12,9,56,32,3,0,12,-12,6,7,132,18};
        KnuthShuffle.shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}
