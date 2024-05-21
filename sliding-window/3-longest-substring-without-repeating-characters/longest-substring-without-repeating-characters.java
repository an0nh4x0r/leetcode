class Solution {
    public int lengthOfLongestSubstring(String s) {
        // here set is our sliding window
        Set<Character> set = new HashSet<>();

        // left and right pointers are the left and right boundaries of our sliding window
        int left = 0;
        int right = 0;

        // result is the final out, that is the largest sliding window
        int result = 0;

        // standard sliding window template
        while (right < s.length()) {
            // check is set doesnt contain the right index element
            if (!set.contains(s.charAt(right))) {
                // if it is not present, add the element to the set, i.e. the sliding window
                set.add(s.charAt(right));
                // increment the length of our sliding window
                right += 1;
                // calculate the set size, which is the current size of sliding window
                result = Math.max(result, set.size());
            } else {
                // if element is already present, remove elements from the left side
                set.remove(s.charAt(left));
                // decrease the size of sliding window from the left size
                left += 1;
                // we perform this else block unless and until all elements are unique and right pointer
                // can be inserted
            }
        }

        return result;        
    }
}