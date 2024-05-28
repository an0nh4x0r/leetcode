class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matchedChars = 0;
        int windowStart = 0;
        int minWindowLength = s.length() + 1;
        int minWindowStart = 0;
        int windowEnd = 0;

        while (windowEnd < s.length()) {
            char endChar = s.charAt(windowEnd);

            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    matchedChars++;
                }
            }

            // shrink the window from the start if all the characters are matched

            while (matchedChars == map.size()) {
                if (minWindowLength > windowEnd - windowStart + 1) {
                    minWindowLength = windowEnd - windowStart + 1;
                    minWindowStart = windowStart;
                }

                char startChar = s.charAt(windowStart++);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        matchedChars--;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }
            }

            windowEnd++;
        }

        return minWindowLength > s.length() ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}