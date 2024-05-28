class Solution {
    public int scoreOfString(String s) {
        int[] asciiArray = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            asciiArray[i] = s.charAt(i);
        }

        int score = 0;

        for (int i = 0; i <= asciiArray.length - 2; ++i) {
            score += (int) Math.abs(asciiArray[i] - asciiArray[i + 1]);
        }

        return score;
    }
}