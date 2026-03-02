// 1004. Max Consecutive Ones III
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         Brute Force appraoch
//         int n= nums.length;
//         int maxLen =0;
//         int len=0;
//         for(int i=0; i< n; i++){
//             int zeros = 0;
//             for(int j=i; j< n;j++){
//                 if(nums[j]==0){
//                     zeros++;
//                 }
//                 if(zeros<=k){
//                     len = j-i+1;
//                     maxLen = Math.max(maxLen,len);
//                 }else{
//                     break;
//                 }
//             }
//         }
//         // return maxLen;
//     }
// }
//OPTMAL SOLUTION
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n= nums.length;
        int left=0;
        int zerocount=0;
        int maxLen=0;
        for (int right = 0; right < nums.length; right++) {

            // If current element is zero, increment zerocount
            if (nums[right] == 0) {
                zerocount++;
            }
            if (zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                // Shrink window from left
                left++; 
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}