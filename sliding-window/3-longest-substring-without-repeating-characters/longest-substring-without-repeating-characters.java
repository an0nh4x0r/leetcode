class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> slidingWindow = new HashSet<>();

        int left = 0;
        int right = 0;
        
        int res = 0;

        while (right < s.length()) {
            char start = s.charAt(left);
            char end = s.charAt(right);

            if (!slidingWindow.contains(end)) {
                slidingWindow.add(end);
                right++;
                res = Math.max(res, slidingWindow.size());
            } else {
                slidingWindow.remove(start);
                left++;
            }
        }

        return res;
    }
}