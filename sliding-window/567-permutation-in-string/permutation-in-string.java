class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26]; // total frequency of s1
        int[] freqS2 = new int[26]; // sliding window frequency on s2

        // populate the total frequency of s1 in freqS1
        for (char c: s1.toCharArray()) {
            freqS1[c - 'a'] += 1;
        }

        int left = 0; // start of sliding window
        int right = 0; // end of sliding window

        // standard sliding window template
        while (right < s2.length()) {

            // update the freqS2
            freqS2[s2.charAt(right) - 'a'] += 1;

            // check if the sliding window size is equal to the length of s1
            // and validate if both the frequency arrays are equal
            // return true
            if ((right - left + 1) == s1.length() && Arrays.equals(freqS1, freqS2)) return true;

            // otherwise check if the sliding window size is greater than or equal to the 
            // s1 length size, in this case we need to move the left pointer
            // note we are checking for the equals again here because, 
            // if it is equal and matched we already would have return true in above condition
            // since it is equal and not same, it means we need to move the left pointer in
            // this case as well. 
            if ((right - left + 1) >= s1.length()) {
                freqS2[s2.charAt(left) - 'a'] -= 1;
                left += 1;
            }

            // move the right pointer of sliding window in all cases. 
            // standard sliding window template
            right += 1;
        }

        return false;
    }
}