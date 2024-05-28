class Solution {
    public String minWindow(String s, String t) {
        // this size will store all the a-z and A-Z
        // this map is usually much much faster than a hashmap
        int[] charFrequency = new int[128];
        // store all the elements of t in charFrequency map
        for (char c: t.toCharArray()) {
            // here the int value of character, will be used as index, 
            // which will eventually point to the same element's index
            charFrequency[c]++; 
        }

        // sliding window boundary
        int left = 0; 
        int right = 0;

        // most important variables, see anki notes for there significance in the algorithm
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;

        // required characters from target, see anki note on this for more detail
        int requiredChars = t.length();

        // standard sliding window template
        // expand the window
        while (right < s.length()) {

            char rightChar = s.charAt(right);

            // see anki for significance of below two lines of snippets
            if (charFrequency[rightChar] > 0) requiredChars--;
            charFrequency[rightChar]--;

            // if required characters are matched, shrink the window
            while (requiredChars == 0) { // this condition occurs, when all the characters of target are found in the current window

                if (minLength > right - left + 1) {
                    minLength = right - left + 1; // update the minimum length
                    minLeft = left; // update the start index of the minimum window
                }

                char leftChar = s.charAt(left);

                // see anki for significance of below two lines of snippets
                charFrequency[leftChar]++;
                if (charFrequency[leftChar] > 0) requiredChars++;

                left++; // move the left pointer to shrink the window
            }

            // standard sliding window template
            right ++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}