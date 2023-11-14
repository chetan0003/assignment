import java.util.Stack;

public class ShortestCommonLength02 {

    public static int shortestCommonSuperSequenceLength(String literal1, String literal2, int m, int n) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            char c = literal1.charAt(i);
            if (!stack.contains(c)) {
                stack.push(c);
            }
        }

        for (int i = 0; i < n; i++) {
            char c = literal2.charAt(i);
            if (!stack.contains(c)) {
                stack.push(c);
            }
        }
        Stack<Character> sortedChar = charInSequence(stack);
        System.out.println("Sorted >> " + sortedChar);
        return sortedChar.size();
    }
    public static Stack<Character> charInSequence(Stack<Character> stack) {
        Stack<Character> temp = new Stack<>();

        while (!stack.isEmpty()) {
            char current = stack.pop();

            while (!temp.isEmpty() && current < temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(current);
        }
       return temp;
    }

    public static void main(String[] args) {
        // Example 1
        String x1 = "abcd";
        String y1 = "xycd";
        int result1 = shortestCommonSuperSequenceLength(x1, y1, 4, 4);
        System.out.println("Output for Example 1: " + result1);

        // Example 2
        String x2 = "efgh";
        String y2 = "jghi";
        int result2 = shortestCommonSuperSequenceLength(x2, y2, 4, 4);
        System.out.println("Output for Example 2: " + result2);
    }
}
