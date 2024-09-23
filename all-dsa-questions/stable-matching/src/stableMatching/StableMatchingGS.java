package stableMatching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/*
This is the stable matching, Gale Shipley algorithm.

For 2 distinct sets, each set has an order of preference from all the other set.
A match is considered stable if:

- Both individuals have reciprocal preference
- One individual prefers someone else that does not prefer them preferentially back

Inputs:

We are given a list of preferences from each person that we will store in a 2d array
We will use a list of names in this case as String.

Outputs:

Match people optimally such that we have 100% stability with all matches

 */

public class StableMatchingGS {

  private static final String GUY_PATH = "/Users/akshayrao/Desktop/zooby/cs/cs-interview-prep/ctci-practice/ctci-practice-solutions/stable-matching/src/stableMatching/guys.txt";
  private static final String GIRL_PATH = "/Users/akshayrao/Desktop/zooby/cs/cs-interview-prep/ctci-practice/ctci-practice-solutions/stable-matching/src/stableMatching/girls.txt";

  public static int[][] stableMatching(List<List<Integer>> optimal, List<List<Integer>> other) {
    Queue<Integer> free = new LinkedList<>();
    int num = optimal.size();
    int[] matched = new int[num];
    Arrays.fill(matched, -1);
    int[] nextPreference = new int[num];
    Arrays.fill(nextPreference, -1);

    List<List<Integer>> inverseList = createInverse(other);

    for (int i = 0; i < optimal.size(); i++) {
      free.offer(i);
    }

    while (!free.isEmpty()) {
      int chooser = free.poll();
      for (int i = ++nextPreference[chooser]; i < num; i++) {
        int choice = optimal.get(chooser).get(i);
        if (matched[choice] == -1) {
          matched[choice] = chooser;
          break;
        } else {
          int currentOtherChoice = matched[choice];
          List<Integer> pref = inverseList.get(choice);
          if (pref.get(chooser) < pref.get(currentOtherChoice)) {
            free.offer(matched[choice]);
            matched[choice] = chooser;
            break;
          }
        }
        nextPreference[chooser]++;
      }
    }

    int[][] matching = new int[num][2];
    for (int i = 0; i < num; i++) {
      matching[i][0] = matched[i];
      matching[i][1] = i;
    }

    return matching;
  }

  // Creates inverse list for the individual being chosen
  // Allows for faster retrieval of getting a ranking
  private static List<List<Integer>> createInverse(List<List<Integer>> list) {
    List<List<Integer>> inverse = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      inverse.add(new ArrayList<>(list.get(i)));
      List<Integer> subList = inverse.get(i);
      for (int j = 0; j < subList.size(); j++) {
        int person = list.get(i).get(j);
        subList.set(person, j);
      }
    }
    return inverse;
  }

  public static void main(String[] args) throws FileNotFoundException {

    // Initializes 2D preference lists for all guys and girls
    List<List<Integer>> guyList = new ArrayList<>();
    List<List<Integer>> girlList = new ArrayList<>();

    Map<Integer, String> guyNames = new HashMap<>();
    Map<Integer, String> girlNames = new HashMap<>();

    fillGrid(guyList, guyNames, GUY_PATH);
    fillGrid(girlList, girlNames, GIRL_PATH);

    sanityCheck(guyNames, girlNames, guyList, girlList);

    int[][] guyOptimal = stableMatching(guyList, girlList);
    int[][] girlOptimal = stableMatching(girlList, guyList);

    System.out.println("Stable matching for guy optimal matches: ");
    System.out.println(Arrays.deepToString(guyOptimal));

    System.out.println("\n");

    System.out.println("Stable matching for girl optimal matches: ");
    System.out.println(Arrays.deepToString(girlOptimal));

  }

  private static void sanityCheck(Map<Integer, String> guyNames, Map<Integer, String> girlNames,
      List<List<Integer>> guyList, List<List<Integer>> girlList) {

    System.out.println("Guy names: ");
    System.out.println(guyNames.toString());
    System.out.println("\n");

    System.out.println("Girl names: ");
    System.out.println(girlNames.toString());
    System.out.println("\n");

    System.out.println("Guy preferences: ");
    System.out.println(guyList.toString());
    System.out.println("\n");

    System.out.println("Girl Preferences: ");
    System.out.println(girlList.toString());
    System.out.println("\n");

  }

  public static void fillGrid(List<List<Integer>> pref, Map<Integer, String> names, String path) {

    int idx = 0;

    try (BufferedReader in = new BufferedReader(new FileReader(path))) {
      String str;
      while ((str = in.readLine()) != null) {
        String[] preferences = str.split(",");
        names.put(idx, preferences[0]);
        pref.add(new ArrayList<>());
        fillList(pref, preferences);
        idx++;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Helper method to fill each preference list from given text file
  private static void fillList(List<List<Integer>> list, String[] pref) {
    List<Integer> subList = list.get(list.size() - 1);
    for (int i = 1; i < pref.length; i++) {
      subList.add(Integer.parseInt(pref[i]));
    }
  }
}