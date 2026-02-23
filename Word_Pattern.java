// 290. Word Pattern
// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.
 

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"

// Output: true

// Explanation:

// The bijection can be established as:

// 'a' maps to "dog".
// 'b' maps to "cat".
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"

// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"

// Output: false

// SOLUTION TO THE ANSWER
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        String[] str = s.split(" ");
        if(pat.length!=str.length){
            return false;
        }
        Map<Character, String> m = new HashMap<>();
        for (int i = 0; i < pat.length; i++) {
            char c = pat[i];
            String word = str[i];

            if (!m.containsKey(c)) {
                if (m.containsValue(word)) {
                    return false;
                }
                m.put(c, word);
            } else {
                if (!m.get(c).equals(word)) {
                    return false;
                }
            }
        }

        return true;
    }
}
