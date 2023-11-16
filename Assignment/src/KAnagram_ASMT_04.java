import java.util.HashMap;
import java.util.Map;

public class KAnagram_ASMT_04 {

    static Map<Character, Integer> map = new HashMap<>();

    static int isKAnagram(String str1, String str2, int k) {
        int success = 1;
        int fail = 0;
        if (str1.length() != str2.length())
            return fail;
        int[] ascs = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int pos = str1.charAt(i) - 'a';
            ascs[pos]++;
            if(map.containsKey(str1.charAt(i))) {
                Integer count = map.get(str1.charAt(i));
                map.put(str1.charAt(i),count+1);
            } else {
                map.put(str1.charAt(i),1);
            }

        }
        for (int j = 0; j < str2.length(); j++) {
            char c = str1.charAt(k);
            int pos = str2.charAt(j) - 'a';
            if(map.containsKey(str2.charAt(j))) {
                Integer count = map.get(str2.charAt(j));
                if(count > 0) {
                    map.put(str2.charAt(j),count - 1);
                }
            }
            if (ascs[pos] > 0) {
                ascs[pos]--;
            }
        }
        System.out.println("char with update count >> " + map);
        int sum = 0;
        for (int x = 0; x < 26; x++) {
            sum +=ascs[x];
        }
        if (sum <= k)
            return success;
        else
            return fail;
    }

    public static void main(String[] args) {
        System.out.println(isKAnagram("fodr", "gork", 2));
    }
}
