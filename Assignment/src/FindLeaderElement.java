public class FindLeaderElement {

    static void findLeaderElement(int[] array) {

        int leaderElement = array[array.length - 1];
        System.out.println(leaderElement);
        for (int i = array.length-1; i > 0 ; i--) {

            if (leaderElement < array[i-1]) {
                leaderElement = array[i-1];
                System.out.println(leaderElement);
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{16, 17, 4, 3, 5, 2};
        findLeaderElement(array1);
        int[] array2 = new int[]{1, 2, 3, 4, 0};
        findLeaderElement(array2);
    }

}
