class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; // left pointer of the sliding window
        int right = 0; // right pointer of the sliding window

        int[] freq = new int[26]; // frequency of characters inside the sliding window
        int maxFreq = 0; // max frequency of an element inside the sliding window

        int res = 0; // final response, length of the longest substring

        // standard sliding window template
        while (right < s.length()) {
            // update the count of element at the end of sliding window
            // standard sliding window template
            freq[s.charAt(right) - 'A'] += 1; 

            // get the max frequency of the element in the sliding window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // get the number to replace, 
            // i.e. size of sliding window - max frequency element inside the sliding window
            int lettersToReplace = (right - left + 1) - maxFreq;

            // check for invalid window
            // a window is invalid, if letters to replace is greater than k
            // move the sliding window from left side 
            // update the frequency
            // standard sliding window template
            if (lettersToReplace > k) {
                freq[s.charAt(left) - 'A'] -= 1;
                left += 1;
            } else {
                // if the window is valid, then get the maximum size of the sliding window
                res = Math.max(res, right - left + 1); 
            }

            // always move the right pointer at the end
            // standard sliding window template
            right += 1;
        }

        // return the response
        return res;
    }
}