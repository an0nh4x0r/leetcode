class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right += 1;
                result = Math.max(result, set.size());
            } else {
                set.remove(s.charAt(left));
                left += 1;
            }
        }

        return result;
    }
}