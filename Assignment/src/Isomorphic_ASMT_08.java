import java.util.HashMap;
import java.util.Map;

public class Isomorphic_ASMT_08 {

    static boolean isIsomorphic(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char actual = str1.charAt(i);
            char replace = str2.charAt(i);
            if (!map.containsKey(actual)) {
                if (!map.containsValue(replace)) {
                    map.put(actual, replace);
                } else {
                    return false;
                }
            } else {
                Character character = map.get(actual);
                if (character != replace) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Output 1 >> " + isIsomorphic("aab", "xxy"));
        System.out.println("Output 2 >> " + isIsomorphic("aab", "xyz"));
    }
}
