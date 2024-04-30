class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] temp = stack.pop();
                int index = temp[0];
                int value = temp[1];
                res[index] = (i - index);
            }

            stack.push(new int[] {i, temperatures[i]});
        }

        return res;        
    }
}