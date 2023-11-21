public class ReverseWord_ASMT_07 {

    private static StringBuilder getReverseWord(String s) {

        String[] words = s.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            if (i != 0) {
                stringBuilder.append(".");
            }
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        String s = "i.like.this.program.very.much";
        System.out.println("Output 1 >> " + getReverseWord(s));

        String s2 = "pqr.mno";
        System.out.println("Output 2 >> " + getReverseWord(s2));
    }
}
