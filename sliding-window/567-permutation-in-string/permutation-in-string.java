class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (char c1: s1.toCharArray()) s1Freq[c1 - 'a']++;

        int left = 0;
        int right = 0;
        
        while(right < s2.length()) {
            s2Freq[s2.charAt(right) - 'a']++;

            if ((right - left + 1) == s1.length()) {
                if (Arrays.equals(s1Freq, s2Freq)) return true;
            }

            if ((right - left + 1) >= s1.length()) {
                s2Freq[s2.charAt(left) - 'a']--;
                left += 1;
            }

            right += 1;
        }

        return false;
    }
}