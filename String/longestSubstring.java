package String;

import java.util.*;

//abccabcc=>3
//abcbbd=>3
//ccccc=>1
// =>0
//abcbda=>4

public class longestSubstring {
    // space:O(n)
    // Time:O(n^2)
    public static int brute(String s) {
        // set for seeing if next letter is already in substring
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        // stores length of longest substring
        int longest = 0;

        // Lets iterate over String:
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            longest = Math.max(longest, set.size());
        }

        return longest;
    }

    public static int op(String s) {
        // space:O(n)
        // time:O(n)
        int longest = 0;
        // hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            } else {
                int dupIndex = map.get(s.charAt(j));
                if (dupIndex >= i) {
                    i = dupIndex + 1;
                }
                map.put(s.charAt(j), j);
            }
            longest = Math.max(longest, (j - i) + 1);
            System.out.println("Longest:" + longest);
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(op(s));
    }
}
