class Solution {

    List<String> res = new ArrayList<>();
    Stack<Character> stack = new Stack<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closeN, int n) {
        if (openN == closeN && closeN == n) {
            StringBuilder sb = new StringBuilder();
            for (Character s: stack) {
                sb.append(s);
            }
            res.add(sb.toString());
        }

        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closeN, n);
            stack.pop();
        }

        if (closeN < openN) {
            stack.push(')');
            backtrack(openN, closeN + 1, n);
            stack.pop();
        }
    }
}