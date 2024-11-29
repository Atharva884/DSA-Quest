class Pair {
    int tweetId;
    int time;

    public Pair(int _tweetId, int _time) {
        this.tweetId = _tweetId;
        this.time = _time;
    }
}

class Twitter {
    HashMap<Integer, List<Pair>> userMap;
    HashMap<Integer, List<Integer>> followMap;
    int time;

    public Twitter() {
        userMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        List<Pair> list = userMap.getOrDefault(userId, new ArrayList<>());
        time++;
        list.add(new Pair(tweetId, time));
        userMap.put(userId, list);
    }

    public List<Integer> getNewsFeed(int userId) {
        // List<Integer> followers = followMap.getOrDefault(userId, new ArrayList<>());
        // ArrayList<Pair> arr = new ArrayList<>();

        // for (int followerId : followers) {
        // if (userMap.containsKey(followerId)) {
        // arr.addAll(userMap.get(followerId));
        // }
        // }

        // if (userMap.containsKey(userId)) {
        // arr.addAll(userMap.get(userId));
        // }

        // arr.sort((a, b) -> b.time - a.time);

        List<Integer> followers = followMap.getOrDefault(userId, new ArrayList<>());
        ArrayList<Pair> arr = new ArrayList<>();

        if (followers.size() != 0) {
            for (int i = 0; i < followers.size(); i++) {
                int uId = followers.get(i);
                if (userMap.containsKey(uId)) {
                    List<Pair> tweets = userMap.get(uId);
                    for (int j = 0; j < tweets.size(); j++) {
                        arr.add(tweets.get(j));
                    }
                }
            }
        }

        List<Pair> tweets = userMap.get(userId);
        if (tweets != null && tweets.size() != 0) {
            for (int j = 0; j < tweets.size(); j++) {
                arr.add(tweets.get(j));
            }
        }

        Comparator comp = new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                // Descending order based on time
                return b.time - a.time;
            }
        };

        Collections.sort(arr, comp);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size() && i < 10; i++) {
            ans.add(arr.get(i).tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> list = followMap.getOrDefault(followerId, new ArrayList<>());
        if (!list.contains(followeeId)) {
            list.add(followeeId);
        }
        followMap.put(followerId, list);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = followMap.get(followerId);

        if (list == null || list.isEmpty()) {
            followMap.remove(followerId);
            return;
        }

        if (list == null || list.size() == 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == followeeId) {
                int temp = list.get(i);
                list.set(i, list.get(list.size() - 1));
                list.set(list.size() - 1, temp);
                break;
            }
        }

        list.remove(list.size() - 1);
    }
}
