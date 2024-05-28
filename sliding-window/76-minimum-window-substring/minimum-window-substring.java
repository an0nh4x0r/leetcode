class Solution {
    public String minWindow(String s, String t) {
        int[] charFrequency = new int[128];
        for (char c: t.toCharArray()) {
            charFrequency[c]++;
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        int requiredChars = t.length();

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            if (charFrequency[rightChar] > 0) requiredChars--;
            charFrequency[rightChar]--;

            while (requiredChars == 0) {

                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                charFrequency[leftChar]++;
                if (charFrequency[leftChar] > 0) requiredChars++;
                left++;
            }

            right ++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}