class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);

        // we need to keep the size (nums.length + 1) and not nums.length
        // because in the worst case all the elements are same
        // let's say that the size of array is 5 and all elements are same
        // so the count is 5, I need to put that on 5th index. 
        // if size of array is 5, the last index is 4th index
        // that's why we are doing (nums.length + 1) below. to accomodate that case.
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        for (int key: map.keySet()) {
            int i = map.get(key);
            if (buckets[i] == null) buckets[i] = new ArrayList<>();
            buckets[i].add(key);
        }

        int counter = 0;
        int[] res = new int[k];
        for (int i = buckets.length - 1; i > -1; --i) {
            if (buckets[i] != null) {
                for (int n: buckets[i]) {
                    res[counter++] = n;
                    if (counter == k) break;
                }
            }

            if (counter == k) break;
        }

        return res;
    }
}