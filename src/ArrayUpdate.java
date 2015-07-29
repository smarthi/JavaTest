public class ArrayUpdate {

  public static void main(String[] args) throws Exception {

    ArrayObject[] inputArray = {
        new ArrayObject(1, "yest"),
        new ArrayObject(2, "test"),
        new ArrayObject(2, "fest"),
        new ArrayObject(3, "lest"),
        new ArrayObject(4, "best"),
        new ArrayObject(100, "pest")
    };

    ArrayObject[] inputArray1 = {
        new ArrayObject(1, "yest"),
        new ArrayObject(2, "test"),
        new ArrayObject(3, "fest"),
        new ArrayObject(4, "lest"),
        new ArrayObject(5, "best"),
        new ArrayObject(100, "pest")
    };

    ArrayObject[] inputArray2 = {
        new ArrayObject(1, "yest"),
        new ArrayObject(2, "test"),
        new ArrayObject(3, "fest"),
        new ArrayObject(3, "lest"),
        new ArrayObject(4, "best"),
        new ArrayObject(4, "pest")
    };

    ArrayObject[] inputArray3 = {
        new ArrayObject(1, "yest"),
        new ArrayObject(1, "yest"),
        new ArrayObject(1, "yest"),
        new ArrayObject(2, "test"),
        new ArrayObject(2, "test"),
        new ArrayObject(2, "test"),
        new ArrayObject(3, "lest"),
        new ArrayObject(3, "lest")
    };

    ArrayObject[] inputArray4 = {
        new ArrayObject(1, "yest"),
        new ArrayObject(1, "yest"),
        new ArrayObject(1, "yest"),
        new ArrayObject(2, "test"),
        new ArrayObject(2, "test"),
        new ArrayObject(2, "test"),
        new ArrayObject(100, "lest"),
        new ArrayObject(101, "lest"),
        new ArrayObject(101, "best")
    };

    ArrayUpdate arrayUpdate = new ArrayUpdate();

    printArray(arrayUpdate.returnUpdatedArray(inputArray));
    printArray(arrayUpdate.returnUpdatedArray(inputArray1));
    printArray(arrayUpdate.returnUpdatedArray(inputArray2));
    printArray(arrayUpdate.returnUpdatedArray(inputArray3));
    printArray(arrayUpdate.returnUpdatedArray(inputArray4));
    System.out.println(0x1000 & 0xFFFF >>> 1);
  }

  /**
   * Print the array elements
   *
   * @param inputArray - input sorted array
   */
  public static void printArray(final ArrayObject[] inputArray) {
    for (ArrayObject anInputArray : inputArray) {
      System.out.print(anInputArray + " ");
    }
    System.out.println();
  }

  /**
   * Updates the input sorted array and returns with unique Ids in same sorted order
   *
   * @param inputArray - - input sorted array
   * @return sorted array with updated ids
   */
  private ArrayObject[] returnUpdatedArray(final ArrayObject[] inputArray) {
    ArrayObject max = null;
    for (ArrayObject anInputArrayObject : inputArray) {
      if (max != null && anInputArrayObject.compareTo(max) <= 0) {
        anInputArrayObject.id = max.id + 1;
      }
      max = anInputArrayObject;
    }
    return inputArray;
  }

  /**
   * Dummy Class to instantiate the array with
   */
  static class ArrayObject implements Comparable<ArrayObject> {
    private int id;
    private String value;

    public ArrayObject(int id, String value) {
      this.id = id;
      this.value = value;
    }

    @Override
    public String toString() {
      return "{" +
          "id=" + id +
          ", value='" + value + '\'' +
          '}';
    }

    @Override
    public int compareTo(ArrayObject arrayObject) {
      if (this.id > arrayObject.id)
        return 1;
      else if (this.id < arrayObject.id)
        return -1;
      else
        return 0;
    }
  }
}
