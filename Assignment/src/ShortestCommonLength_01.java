import java.util.Arrays;
import java.util.HashSet;

public class ShortestCommonLength_01 {

    public static int shortestCommonSuperSequenceLength(String x, String y,int m, int n) {
        String z = x + y;
        int length = m + n;

        char[] charArray = z.toCharArray();
        Arrays.sort(charArray);
        HashSet<Character> count = new HashSet<>();
        for(int i = 0; i < length; i++) {
            count.add(charArray[i]);
        }
        System.out.println(count);
        return count.size();
    }
    public static void main(String[] args) {
        // Example 1
        String x1 = "abcd";
        String y1 = "xycd";
        int result1 = shortestCommonSuperSequenceLength(x1, y1,4,4);
        System.out.println("Output for Example 1: " + result1);

        // Example 2
        String x2 = "efgh";
        String y2 = "jghi";
        int result2 = shortestCommonSuperSequenceLength(x2, y2,4,4);
        System.out.println("Output for Example 2: " + result2);
    }
}
