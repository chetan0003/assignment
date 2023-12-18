import java.util.HashMap;
import java.util.Map;

public class PrintDuplicate {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 5, 6, 7, 3, 3, 2};
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], count + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(map);
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println("Duplicates => " + key);
            }
        }

    }
}
