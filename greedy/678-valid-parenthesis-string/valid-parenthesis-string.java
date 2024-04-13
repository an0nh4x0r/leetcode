class Solution {
    public boolean checkValidString(String s) {

        int cmin = 0;
        int cmax = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin--;
                cmax--;
            } else {
                cmin--;
                cmax++;
            }
            cmin = Math.max(0, cmin);

            if (cmax < 0) return false;
        }

        return cmin == 0;        
    }
}