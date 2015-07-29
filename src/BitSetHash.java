import java.util.BitSet;

public class BitSetHash {

  public static void main(String[] args) throws Exception {
    BitSet b1 = new BitSet(8);
    b1.set(1, true);
    b1.set(4, true);
    b1.set(6, true);
    BitSet b2 = new BitSet(8);
    b2.set(4, true);
    b2.set(3, true);
    b2.set(8, true);
    System.out.println(b1.toString() + " " + b2.toString());
    System.out.println(b1.hashCode() + " " + b2.hashCode());
    System.out.println(b1.cardinality());

    Long l1 = 3L;
    Long l2 = 13L;
    System.out.println(1.0 * Long.bitCount(l1 & l2) / (Long.bitCount(l1) + Long.bitCount(l2) - Long.bitCount(l1 & l2)));

    int n = 8;
    BitSet b = BitSet.valueOf(new long[]{n});
    System.out.println(b.toLongArray()[0]);

    BitSet b1024 = new BitSet(1024);
    b1024.set(1);
    b1024.set(1000);
    b1024.set(759);
    b1024.set(895);
    System.out.println(b1024.toLongArray()[0]);
  }
}
