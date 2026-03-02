// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.
// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

//SOLUTION bRUTE Force
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Map<Character,Integer> map = new HashMap<>();
//         int start=0;
//         int maxLen =0;
//         for(int i =0; i< s.length(); i++){

//             char ch = s.charAt(i);
//             while(map.containsKey(ch)){
//                 char removeChar = s.charAt(start);
//                 map.remove(removeChar);
//                 start++;
//             }
//             map.put(ch, 1);
//             maxLen = Math.max(maxLen,map.size());
            
//         }
//         return maxLen;
//     }
// }
//Optimal
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len=0;
        int HashLen = 256;
        int[] hash = new int[HashLen];

        Arrays.fill(hash, -1);
        int l =0, r=0, maxLen=0;
        while(r< n){
            if(hash[s.charAt(r)]!= -1){
                if(hash[s.charAt(r)]>=l){
                    l = hash[s.charAt(r)]+1;
                }
            }
            len = r-l+1;
            maxLen= Math.max(len,maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}