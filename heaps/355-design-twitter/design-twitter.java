class Twitter {

    int count = 0;
    Map<Integer, List<int[]>> tweetMap = new HashMap<>();
    Map<Integer, Set<Integer>> followMap = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = tweetMap.getOrDefault(userId, new ArrayList<>());
        list.add(new int[] {tweetId, count});
        tweetMap.put(userId, list);
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> newsFeed = new ArrayList<>();
        List<int[]> tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.forEach(newsFeed::add);

        Set<Integer> set = followMap.getOrDefault(userId, new HashSet<Integer>());
        set.forEach(id -> {
            List<int[]> t = tweetMap.getOrDefault(id, new ArrayList<int[]>());
            t.forEach(newsFeed::add);
        });

        Collections.sort(newsFeed, (a, b) -> b[1] - a[1]);
        List<Integer> response = new ArrayList<>();

        for (int i = 0; i < 10 && i < newsFeed.size(); ++i) {
            response.add(newsFeed.get(i)[0]);
        }

        return response;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<Integer>());
        set.add(followeeId);
        followMap.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<Integer>());
        if (set.contains(followeeId)) set.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */