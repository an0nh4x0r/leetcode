class TimeMap {

    Map<String, List<Pair<String, Integer>>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair<String, Integer>(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key) == null) return "";

        List<Pair<String, Integer>> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid).getValue() <= timestamp) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index != -1 ? list.get(index).getKey() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */