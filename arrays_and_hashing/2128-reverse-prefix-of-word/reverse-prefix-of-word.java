class Solution {
    public String reversePrefix(String word, char ch) {
        char[] res = new char[word.length()];
        int firstIndex = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == ch) {
                firstIndex = i;
                break;
            }
        }

        int j = 0;
        for (int i = firstIndex; i > -1; --i) {
            res[j] = word.charAt(i);
            j++;
        }

        for (int i = firstIndex+1; i < word.length(); ++i) {
            res[j] = word.charAt(i);
            j++;
        }
        
        return new String(res);
    }
}