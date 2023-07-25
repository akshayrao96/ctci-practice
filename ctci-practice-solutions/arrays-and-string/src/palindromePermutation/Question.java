package palindromePermutation;

/*
  Check if a permutation of the string can become a palindrome
  Can I rearrange the word to get a palindrome
  Palindrome -> same forward and backwards
  Ignore spaces
  If odd string, then frequency must be even, and 1 odd
  If even string, then frequency must all be even

  1.) Ignore space in string
  2.) Make frequency map
  3.) iterate over frequency map, return correct result
 */

import java.util.HashMap;

public class Question {

/*
   Given a word, check if it can be rearranged into a palindrome
   constraints:
   - ignore spaces
   - case insensitive
   palindrome for even letters:
   - each letter must occur twice and twice only
   palindrome for odd letters:
   - each letter must occur twice and twice only
   - 1 character must occur once

    Use hashmap to store letter count
    Discard non letters
 */
  public static boolean palindromePermutation(String word) {
    HashMap<Character, Integer> m = new HashMap<>();
    int counter = 0;
    for (char c : word.toCharArray()) {
      if (c < 64 || c > 123 || (c > 90) && (c < 97))
        continue;
      if (c + 32 <= 122) {
        c += 32;
      }
      if (!m.containsKey(c)) {
        m.put(c, 1);
      } else {
        m.put(c, m.get(c) + 1);
      }
      counter += 1;
    }
    counter %= 2;
    for (char c : m.keySet()) {
      int num = m.get(c);
      if (num % 2 != 0) {
        counter -= 1;
      }
      if (counter < 0)
        return false;
    }
    return true;
  }














  public static boolean palindromePermutation2(String word) {
    HashMap<Character, Integer> freqMap = new HashMap<>();
    for (char character : word.toLowerCase().toCharArray()) {
      if (character == '\0' || character == ',') {
        continue;
      }
      if (freqMap.containsKey(character)) {
        freqMap.put(character, freqMap.get(character) + 1);
      } else {
        freqMap.put(character, 1);
      }
    }
    int allowed = word.length() % 2;
    for (char character : freqMap.keySet()) {
      if (freqMap.get(character) % 2 != 0) {
        allowed -= 1;
      }
      if (allowed < 0) {
        return false;
      }
    }
    return true;
  }



  public static void main(String[] args) {
    String[] strings = {
        "Rats live on no evil star",
        "A man, a plan, a canal, panama",
        "Lleve",
        "Taco tac",
        "asda"};
    for (String s : strings) {
      boolean a = palindromePermutation(s);
      System.out.println(s);
      if (a) {
        System.out.println("Agree: " + a);
      } else {
        System.out.println("Disagree: " + a);
      }
      System.out.println();
    }

  }


}


