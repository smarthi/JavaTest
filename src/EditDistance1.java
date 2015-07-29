import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by smarthi on 10/14/14.
 */
public class EditDistance1 {

  public static void main(String[] args) throws Exception {
    Map<String, List<Integer>> map = new LinkedHashMap<>();
    long startTime = System.currentTimeMillis();
    readInputZipFile(args[0], map);
    long endTime = System.currentTimeMillis();


    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " -- " + entry.getValue().size());
    }
    System.out.println("Time taken = " + (endTime - startTime));
    System.out.println(map.size());
  }

  private static void readInputZipFile(String fileName, Map<String, List<Integer>> map) throws IOException {
    ZipFile zipFile = new ZipFile(fileName);
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    String line;
    while (entries.hasMoreElements()) {
      ZipEntry entry = entries.nextElement();
      BufferedReader reader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
      while ((line = reader.readLine()) != null) {
        String sub = line.substring(line.indexOf(" ", 0) + 1);
        if (map.containsKey(sub)) {
          List<Integer> list = map.get(sub);
          list.add(Integer.valueOf(line.substring(0, line.indexOf(" ", 0))));
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(Integer.valueOf(line.substring(0, line.indexOf(" ", 0))));
          map.put(sub, list);
        }
      }
    }
  }
}
