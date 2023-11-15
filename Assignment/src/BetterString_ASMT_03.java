public class BetterString_ASMT_03 {


    static int getSubSequenceCount(String str) {
        int count = 1;
        int [] alphas = new int[26];

        for(int i = 0; i < str.length(); i++) {
          if(alphas[str.charAt(i) - 'a']  == 0) {
              alphas[str.charAt(i) - 'a'] = count;
              count = count * 2;
          } else {
              int oldCount = alphas[str.charAt(i) - 'a'];
              alphas[str.charAt(i) - 'a']  = count;
              count = count * 2;
              count = count - oldCount;
          }
        }
        return count;
    }


    public static void main(String[] args) {
        //Example 1
        String str1 = "gfg" , str2 = "ggg";
        String betterString1 = getSubSequenceCount(str1) >= getSubSequenceCount(str2) ? str1 : str2;
        System.out.println("Output 1 >> " + betterString1);

        //Example 2
        String str3 = "a" , str4 = "b";
        String betterString2 = getSubSequenceCount(str3) >= getSubSequenceCount(str4) ? str3 : str4;
        System.out.println("Output 2 >> " + betterString2);

    }
}
