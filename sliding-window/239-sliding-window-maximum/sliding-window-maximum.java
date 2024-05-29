class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // length of the output array is (nums.length - k + 1)
        // intuition is nums.length = k, answer is 1
        // nums.length = 3, k = 2, answer is 2
        int[] ans = new int[nums.length - k + 1];

        // pointer for ans array
        int j = 0;
        // Monotonic decreasing queue
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            // if queue is not empty and index at the start of queue is less than the start of the sliding window
            // poll from the start of the queue
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            // if queue is not empty and incoming number is greater than the end of queue
            // poll the end of the queue, because we are using monotonic decreasing queue
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }

            // insert element in queue
            q.offer(i);

            // populate maximum value to ans array, as it will be present at the start of the 
            // monotonic decreasing queue
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }

        // return the final result
        return ans;
    }
}