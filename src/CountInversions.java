import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

public class CountInversions {

  private static BigDecimal inversionCounter = new BigDecimal(0);

  public static void main(String[] args) throws IOException {
    String fName = args[0];
    if (fName == null || fName.isEmpty()){
      throw new IllegalArgumentException("File name should be specified as the only one argument!");
    }
    int[] input = initializeInputArray(fName);
    countInversions(input);
    System.out.println("Inversions count: " + CountInversions.inversionCounter.longValueExact());
  }

  private static int[] countInversions(int[] input){
    if (input.length <= 1){
      return input;
    }

    int[] firstSorted = countInversions(Arrays.copyOfRange(input, 0, input.length / 2));
    int[] secondSorted = countInversions(Arrays.copyOfRange(input, input.length / 2, input.length));

    int[] result = new int[input.length];
    int i = 0;
    int j = 0;
    for (int k = 0; k < input.length; k++){
      if (i < firstSorted.length && (j >= secondSorted.length || firstSorted[i] <= secondSorted[j])){
        result[k] = firstSorted[i];
        i++;
      }else if (j < secondSorted.length && (i >= firstSorted.length || firstSorted[i] > secondSorted[j])){
        result[k] = secondSorted[j];
        j++;

// counting inversions
        CountInversions.inversionCounter = CountInversions.inversionCounter.add(
            new BigDecimal(firstSorted.length - i));
      }
    }

    return result;                                                                             /////// bvvline.substring(0, line.indexOf('{'));vv
  }

  private static int[] initializeInputArray(String fileName) throws NumberFormatException, IOException{
    FileInputStream fis = new FileInputStream(fileName);
    DataInputStream in = new DataInputStream(fis);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    int[] input = new int[100000];
    String strLine;
    int i = 0;
    while ((strLine = reader.readLine()) != null) {
      input[i] = Integer.parseInt(strLine);
      i++;
    }
    in.close();

    return input;
  }
}