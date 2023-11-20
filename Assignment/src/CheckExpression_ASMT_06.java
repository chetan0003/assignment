import java.util.Stack;

public class CheckExpression_ASMT_06 {


    static boolean isValidExpression(String exp) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if ('{' == exp.charAt(i) || '(' == exp.charAt(i) || '[' == exp.charAt(i)) {
                stack.push(exp.charAt(i));
            } else if ('}' == exp.charAt(i)) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (']' == exp.charAt(i)) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (')' == exp.charAt(i)) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Output 1 >> " +isValidExpression("{([])}"));
        System.out.println("Output 2 >> " +isValidExpression("([]"));
    }
}
