// Problem statement
// You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.

// Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.

// Note :
// 1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.

// 2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".

// 3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 50000
// 0 <= AT[i] <= DT[i] <= 2359

// Where 'AT[i]' and 'DT[i]' are the elements of the arrival and the departure arrays respectively.
// Optimal Approach

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int cnt=0;
        int result=0;
        int i=0, j=0;

        while(i< n && j < n){
            if(at[i]<= dt[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            result = Math.max(result,cnt);
        }
        return result;
    }
}