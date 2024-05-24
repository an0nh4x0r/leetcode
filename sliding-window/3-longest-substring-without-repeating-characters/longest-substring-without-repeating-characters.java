class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> slidingWindow = new HashSet<>();
        int right = 0;
        int left = 0;
        int maxLength = 0;
        
        while (right < s.length()){
            if (!slidingWindow.contains(s.charAt(right))) {
                slidingWindow.add(s.charAt(right));
                maxLength = Math.max(maxLength, slidingWindow.size());
                right += 1;
            } else {
                slidingWindow.remove(s.charAt(left));
                left += 1;
            }
        }

        return maxLength;
    }
}