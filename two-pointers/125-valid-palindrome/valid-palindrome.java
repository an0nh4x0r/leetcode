class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String s1 = sb.toString();
        sb.reverse();
        String s2 = sb.toString();

        return s1.equals(s2);
    }
}