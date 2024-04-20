class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] response = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                response[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return response;
    }
}