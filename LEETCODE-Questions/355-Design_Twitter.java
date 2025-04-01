class Pair implements Comparable<Pair> {
    int id;
    int timestamp;

    public Pair(int _id, int _timestamp) {
        this.id = _id;
        this.timestamp = _timestamp;
    }

    @Override
    public int compareTo(Pair o) {
        return o.timestamp - this.timestamp; 
    }
}

class Twitter {
    HashMap<Integer, List<Pair>> map;  
    HashMap<Integer, List<Integer>> users;  
    int timestamp;

    public Twitter() {
        map = new HashMap<>();
        users = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        List<Pair> temp = map.getOrDefault(userId, new ArrayList<>());
        temp.add(new Pair(tweetId, timestamp++));
        map.put(userId, temp);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Pair tweet : map.getOrDefault(userId, new ArrayList<>())) {
            pq.add(tweet);
        }

        for (int follower : users.getOrDefault(userId, new ArrayList<>())) {
            for (Pair tweet : map.getOrDefault(follower, new ArrayList<>())) {
                pq.add(tweet);
            }
        }

        int k = 10;
        while (k-- > 0 && !pq.isEmpty()) {
            ans.add(pq.poll().id);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> temp = users.getOrDefault(followerId, new ArrayList<>());
        if (!temp.contains(followeeId)) { 
            temp.add(followeeId);
            users.put(followerId, temp);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> temp = users.getOrDefault(followerId, new ArrayList<>());
        if(temp.size() == 0) 
            return;
        temp.remove(Integer.valueOf(followeeId));
    }
}
