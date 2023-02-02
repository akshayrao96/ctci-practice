package stringRotation;

public class Question {

    public static boolean stringRotation(String s1, String s2) {
        if (s2.length() > s1.length()) return false;
        if (s2.length() == 0) return true;

        for (int i = 0; i < s1.length(); i++) {
            int indexFound = -1;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    indexFound = j;
                    break;
                }
            }
            if (indexFound != -1) {
                int start1 = i % s1.length(); // 1
                int start2 = indexFound % s2.length(); // 1
                do {
                    if (s1.charAt(start1) != s2.charAt(start2)) {
                        break;
                    }
                    start1 = (start1 + 1) % s1.length(); // 5
                    start2 = (start2 + 1) % s2.length(); // 1
                } while (start2 != indexFound);
                if (start2 == indexFound) return true;
            }
        }
        return false;
    }

    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        StringBuilder str1 = new StringBuilder();
        str1.append(s1);
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
            /* concatenate s1 and s1 within new buffer */
            str1.append(s1);
            return isSubstring(str1.toString(), s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}

/*
Ordering matters
Iterate through string.

s1 is longer or same as s2
Find where s1.charAt(0) = s2.charAt(i)
if not found, return false

if found, track index

false
if same, true
if true, increment s1++
always increment (s2 % s2.length)

end condition: s2 % s2.length hits index
//s1 == s1.length


"bottle"   6  index is 0, 1, 2, 3, 4, 5
"lebott"   6, index is 2, 3, 4, 5, 0, 1

"botole"  i = 1
"loto"    j = 1

Time complexity: O(n * m)
space complexity: O(1)

 */
