
public class HarshadNums {

  public static void main (String[] args) throws Exception {
    int current = 0;
    for (int i = 11; i < 1202; i++) {
      if (i % sumOfIntegers(i) == 0 && ((i+1) % sumOfIntegers(i+1)) == 0) {
        if (current != 0 && i == current + 1) {
          System.out.println(current);
          System.out.println(i);
          System.out.println(i+1);
        }
        current = i;
      }
    }
  }

  private static int sumOfIntegers(int n) {
    int sum = 0;
    while (n != 0) {
      sum += n % 10;
      n /= 10;
     }
    return sum;
  }
}
