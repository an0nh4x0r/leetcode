class Solution {
    public int characterReplacement(String s, int k) {
        // english alphabets has 26 letters from A-Z
        // this array will store all the upper case letters
        int[] store = new int[26];

        int result = 0; // final result
        int maxFrequency = 0; // maximum frequency of a character 
        
        int left = 0; // left pointer of the sliding window
        int right = 0; // right pointer of the sliding window

        while (right < s.length()) {
            store[s.charAt(right) - 'A']++; // increment the frequency of the incoming letter
            maxFrequency = Math.max(maxFrequency, store[s.charAt(right) - 'A']);
            // right - left + 1 is used to calculate the size of the sliding window

            if ((right - left + 1) - maxFrequency > k) {
                store[s.charAt(left) - 'A']--;
                left++;
            }

            // right - left + 1 is used to calculate the size of the sliding window
            result = Math.max(result, (right - left + 1)); 
            right++;
        }

        return result;
    }
}