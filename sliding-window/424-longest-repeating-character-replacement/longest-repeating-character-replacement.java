class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; // left pointer of the sliding window
        int right = 0; // right pointer of the sliding window
        int res = 0;

        int[] freq = new int[26]; // frequency of characters inside the sliding window
        int maxFreq = 0; // max frequency of an element inside the sliding window

        while (right < s.length()) {
            freq[s.charAt(right) - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int lettersToReplace = (right - left + 1) - maxFreq;

            if (lettersToReplace > k) {
                freq[s.charAt(left) - 'A'] -= 1;
                left += 1;
            } else {
                res = Math.max(res, right - left + 1); 
            }

            right += 1;
        }

        return res;
    }
}