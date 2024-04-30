class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                stack.push(operator2 - operator1);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                stack.push(operator2 / operator1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        
        return stack.pop();
    }
}