/**
 * Created with IntelliJ IDEA.
 * User: smarthi
 * Date: 10/12/13
 */
public class Test {

  public static void main(String[] args) throws Exception {
    System.out.println(recurse(10));
    double[] d = new double[] {1.0, 2.5, 3.2, 4.5, 6.7};
    String s = d.toString();
    s = s.substring(1, s.length() - 1);
    toArrayFromString(s);
  }

  public static long recurse(int k) {
    if (k == 0 | k == 1) return 0;
    if (k == 2) return 2;
    return recurse(k - 2) + 2 * recurse(k - 3);
  }

  static final String[][] DATA1 = {
      {"test1", "This is the first text."},
      {"test2", "This is the second text."},
      {"test3", "This is the third text."}
  };

  static void toArrayFromString(String s) {
    String[] a = s.split(",");
    for (String anA : a) {
      System.out.print(Double.valueOf(anA) + " ");
    }
  }

}
