public class MapAlphabet {

    static String mapDigitToLowerCase(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if ((i + 2) < n && s.charAt(i + 2) == '#') {
                String substring = s.substring(i, i + 2);
                int num = Integer.parseInt(substring);
                int asci = num + 96;
                char ch = (char) asci;
                stringBuilder.append(ch);
                i = i + 3;
            } else {
                char ch = s.charAt(i);
                String ss = String.valueOf(ch);
                int num = Integer.parseInt(ss);
                int asci = num + 96;
                char ch2 = (char) asci;
                stringBuilder.append(ch2);
                i++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String s1 = "10#11#12";
        String s2 = "1326#";
        System.out.println(mapDigitToLowerCase(s1));
        System.out.println(mapDigitToLowerCase(s2));

    }
}
