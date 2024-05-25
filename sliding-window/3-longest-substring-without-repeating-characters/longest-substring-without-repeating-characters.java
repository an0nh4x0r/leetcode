class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> slidingWindow = new HashSet<>();
        int left = 0; // start of the sliding window
        int right = 0; // end of the sliding window
        int res = 0; // final response

        while (right < s.length()) {
            if (!slidingWindow.contains(s.charAt(right))) {
                slidingWindow.add(s.charAt(right));
                res = Math.max(res, slidingWindow.size());
                right += 1;
            } else {
                slidingWindow.remove(s.charAt(left));
                left += 1;
            }
        }
        
        return res;
    }
}