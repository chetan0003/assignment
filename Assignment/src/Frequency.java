public class Frequency {

    static void getFrequencyValue(int[] array) {
        String out = "";
        for (int i = 0; i < array.length; i++) {
            int freq = array[i];
            int value = array[i + 1];
            for (int j = 0; j < freq; j++) {
                out = out + value;
            }
            i++;
        }
        System.out.println(out);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        getFrequencyValue(array);
        int[] array1 = new int[]{1, 1, 2, 3};
        getFrequencyValue(array1);
    }
}
