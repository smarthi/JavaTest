/**
 * Created by smarthi on 9/2/14.
 */
public class RecurrenceAutomaton {

  public static void main(String[] args) throws Exception {
    System.out.println(recurse(13));

  }

  public static int recurse(final int k) {
    switch (k) {
      case 0:
      case 1:
        return 0;
      case 2:
        return 2;
    }
    return 2 * recurse(k - 3) + recurse(k - 2);
  }
}
