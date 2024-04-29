class Solution {
    List<String> res = new ArrayList<>();
    Stack<Character> stack = new Stack<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int open, int close, int n) {
        if (open == close && close == n) {
            StringBuilder sb = new StringBuilder();
            for (Character c: stack) sb.append(c);
            res.add(sb.toString());
        }

        if (open < n) {
            stack.push('(');
            backtrack(open + 1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.push(')');
            backtrack(open, close + 1, n);
            stack.pop();
        }
    }
}