import java.util.HashMap;
import java.util.Map;

public class Roman {

    static void putValue(Character c, Integer i) {
        map.put(c,i);
    }
    static Map<Character, Integer> map = new HashMap<>();
    static {
        putValue('I', 1);
        putValue('V', 5);
        putValue('X', 10);
        putValue('L', 50);
        putValue('C', 100);
        putValue('D', 500);
        putValue('M', 1000);
    }

    static Integer convertRomanToInteger(String str) {
        int length = str.length();
        int number = 0;
        for (int i = 0; i < length; i++) {
            Integer romanNumber1 = map.getOrDefault(str.charAt(i), -1);
            if (romanNumber1 == -1)
                throw new IllegalArgumentException("Invalid Roman number");
            if (i == 0) {
                number = romanNumber1;
            }
            if (length == 1)
                return romanNumber1;
            else {
                if (i + 1 < length) {
                    Integer romanNumber2 = map.getOrDefault(str.charAt(i + 1), -1);
                    if (romanNumber1 == -1)
                        throw new IllegalArgumentException("Invalid Roman number");
                    if (romanNumber1 >= romanNumber2) {
                        number += romanNumber2;
                    } else {
                        number = romanNumber2 - number;
                        i++;
                    }
                }
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(convertRomanToInteger("III"));
    }
}
