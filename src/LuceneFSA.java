import com.google.common.collect.Lists;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.automaton.Automaton;
import org.apache.lucene.util.automaton.BasicAutomata;
import org.apache.lucene.util.automaton.BasicOperations;
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
import org.apache.lucene.util.automaton.RegExp;

import java.util.Collection;
import java.util.List;

public class LuceneFSA  {

  public static void main(String[] args) throws Exception {
    String[] words = {"hockey", "hawk", "puck", "text", "textual", "anachronism", "anarchy"};
    Collection<BytesRef> strings = Lists.newArrayList();
    for (String word : words) {
      strings.add(new BytesRef(word));

    }
//build up a simple automaton out of several words
    Automaton automaton = BasicAutomata.makeStringUnion(strings);
    CharacterRunAutomaton run = new CharacterRunAutomaton(automaton);
    System.out.println("Match: " + run.run("hockey"));
    System.out.println("Match: " + run.run("ha"));

    automaton = createNameValidator(new String[]{"Suneel", "Abhinav","Aruna"}, new String[]{"Marthi","Mylavarapu"});
    automaton.determinize();
    System.out.println(automaton.getNumberOfStates());
    System.out.println(automaton.getNumberOfTransitions());
  }

  /**
   * @param strs
   *   All the strings that we want to allow in the returned language
   * @return
   *   An automaton that allows only the passed in strings
   */
  public static Automaton stringUnionAutomaton(String[] strs) {
    Automaton strUnion = null;
    // Simply loop through the strings and place them in the automaton
    for (String str: strs) {
      // Basic building block, make an automaton that accepts a singl
      // string
      Automaton currStrAutomaton = BasicAutomata.makeString(str);
      if (strUnion == null) {
        strUnion = currStrAutomaton;
      }
      else {
        // Combine the current string with the Automata for the
        // previous string, saying that this new string is also valid
        strUnion = BasicOperations.union(strUnion, currStrAutomaton);
      }
    }
    return strUnion;
  }

  /**
   * @param firstNames
   *   Set of allowable first names
   * @param lastNames
   *   Set of allowable last names
   * @return
   *   An automaton that allows FirstName\s+LastName
   */
  public static Automaton createFirstBeforeLastAutomaton(String[] firstNames, String[] lastNames) {
    List<Automaton> allAutomatons = Lists.newArrayList();
    // Use our builder to create an automaton that allows all the first names
    allAutomatons.add(stringUnionAutomaton(firstNames));

    // Add in an Automaton that allows any whitespace by using
    // the regular expression
    RegExp anyNumberOfSpaces = new RegExp("[ \t]+");
    Automaton anySpaces = anyNumberOfSpaces.toAutomaton();
    allAutomatons.add(anySpaces);

    // Add in an Automaton that allows all our last names
    allAutomatons.add(stringUnionAutomaton(lastNames));

    // Return the concatenation off all these automatons
    return BasicOperations.concatenate(allAutomatons);
  }

  public static Automaton createLastBeforeFirstAutomaton(String[] firstNames, String[] lastNames) {
    List<Automaton> allAutomatons = Lists.newArrayList();
    allAutomatons.add(stringUnionAutomaton(lastNames));

    RegExp commaPlusAnyNumberOfSpaces = new RegExp(",[ \t]+");
    allAutomatons.add(commaPlusAnyNumberOfSpaces.toAutomaton());
    allAutomatons.add(stringUnionAutomaton(firstNames));
    return BasicOperations.concatenate(allAutomatons);
  }

  public static Automaton createNameValidator(String[] firstNames, String[] lastNames) {
    return BasicOperations.union(createFirstBeforeLastAutomaton(firstNames, lastNames),
        createLastBeforeFirstAutomaton(firstNames, lastNames));
  }
}
