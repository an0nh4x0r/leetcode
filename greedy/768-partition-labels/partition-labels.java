class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }

        int size = 0;
        int partitionEnd = 0;
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            size++;
            partitionEnd = Math.max(partitionEnd, map.get(s.charAt(i)));
            if (partitionEnd == i) {
                output.add(size);
                size = 0;
            }
        }

        return output;
    }
}