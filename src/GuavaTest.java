import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * Created with IntelliJ IDEA.
 * User: smarthi
 * Date: 11/16/13
 * Time: 1:21 PM
 */
public class GuavaTest {

  public static void main(String[] args) throws Exception {

    System.out.println(Strings.isNullOrEmpty(" ".trim()));
    System.out.println(Strings.isNullOrEmpty(" "));
    System.out.println(Strings.isNullOrEmpty(null));

    List<String> list = Lists.newArrayList();
    list.add("Suneel");
    list.add("Marthi");
    list.add("Aruna");
    list.add("Abhinav");
    list.add("Nidhi");

    List<String> list1 = Lists.newArrayListWithExpectedSize(3);
    list1.addAll(list);
    Collections.reverse(list1);

    List<String> list2  = Lists.newArrayListWithCapacity(4);
    for (String str : list) {
      list2.add(str);
    }

    System.out.println(list1);
    System.out.println(list2);

    String[] strArray = new String[]{};
    Iterator<String> iter = Iterators.forArray(strArray);
    System.out.println(Iterators.size(iter));
    System.out.println((int)35.6);
    System.out.println(Runtime.getRuntime().availableProcessors());
  }
}
