class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], i);
        }

        int size = 0;
        int partitionEnd = 0;
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < arr.length; ++i) {
            size++;
            partitionEnd = Math.max(partitionEnd, map.get(arr[i]));
            if (partitionEnd == i) {
                output.add(size);
                size = 0;
            }
        }

        return output;
    }
}