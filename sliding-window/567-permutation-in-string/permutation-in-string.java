class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        for (char c: s1.toCharArray()) {
            freqS1[c - 'a'] += 1;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            freqS2[s2.charAt(right) - 'a'] += 1;

            if ((right - left + 1) == s1.length() && Arrays.equals(freqS1, freqS2)) return true;

            if (right - left + 1 >= s1.length()) {
                freqS2[s2.charAt(left) - 'a'] -= 1;
                left += 1;
            }

            right += 1;
        }

        return false;        
    }
}