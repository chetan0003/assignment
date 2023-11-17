import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindMinimumIndex_ASMT_05 {

    static int findMinimumIndex(String str, String pad, int[] array) {

        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i);
        }
        for (int i = 0; i < pad.length(); i++) {
            if (array[i] == pad.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String pad = "set";
        int[] array = new int[str.length()];
        System.out.print("Output 1 >> ");
        System.out.println(findMinimumIndex(str, pad, array));

        String str1 = "adcffaet";
        String pad1 = "onkl";
        int[] array1 = new int[str1.length()];
        System.out.print("Output 2 >> ");
        System.out.println(findMinimumIndex(str1, pad1, array1));
    }
}
