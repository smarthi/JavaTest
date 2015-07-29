import java.util.Random;

/**
 * Created by smarthi on 4/17/15.
 */
public class RandomTest {

  public static void main(String[] args) throws Exception {
    long[] bits = new long[10];
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      bits[i] = random.nextInt(2);
      System.out.println(bits[i]);
    }
    System.out.println((1024 + 63)/64);
  }
}
