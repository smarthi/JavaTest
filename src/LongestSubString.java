/**
 * Created by smarthi on 7/12/14.
 */
public class LongestSubString {

  public static void main(String[] args) throws Exception {
    String s2 = "BlackFridayAfterThursday";
    String s1 = "FridayAft";

    String s3 = "This string is trying to get longer";
    String s4 = "This string while trying to get longer can't make it";

    String s5 = null;
    String s6 = "simple";

    String s7 = " ";
    String s8 = " still simple ";

    String s9 = " Black Friday";
    String s10 = "Black Friday";

    System.out.println(longestCommonSubstring(s1, s2));
    System.out.println(longestCommonSubstring(s3, s4));
    System.out.println(longestCommonSubstring(s5, s6));
    System.out.println(longestCommonSubstring(s7, s8));
    System.out.println(longestCommonSubstring(s9, s10));
  }

  private static String longestCommonSubstring(String a, String b) {
    if ((a == null || a.trim().length() == 0) ||
        (b == null || b.trim().length() == 0))
      return "No common substring exists for the given inputs";

    int startPosition = 0, maxPosition = 0;
    for (int i = 0; i < a.trim().length(); i++) {
      for (int j = 0; j < b.trim().length(); j++) {
        int x = 0;
        while (a.charAt(i + x) == b.charAt(j + x)) {
          x++;
          if (((i + x) >= a.length()) || ((j + x) >= b.length())) break;
        }

        if (x > maxPosition) {
          maxPosition = x;
          startPosition = i;
        }
      }
    }
    return a.substring(startPosition, (startPosition + maxPosition));
  }

}
