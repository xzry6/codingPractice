package systemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignTwitter {

	public static void main(String[] args) {
		DesignTwitter dt = new DesignTwitter();
		dt.postTweet(1, 5);
		List<Integer> list = dt.getNewsFeed(1);
		System.out.println(list.toString());
		dt.follow(1, 2);
		dt.postTweet(2, 6);
		list = dt.getNewsFeed(1);
		System.out.println(list.toString());
		dt.unfollow(1, 2);
		list = dt.getNewsFeed(1);
		System.out.println(list.toString());
	}

	class User {
        // Properties.
        int userId;
        Set<Integer> followings;

        // Constructor.
        public User(int userId) {
            this.userId = userId;
            this.followings = new HashSet<Integer>();
        }
    }

    class Tweet {
        // Properties.
        int tweetId;
        int userId;

        // Constructor.
        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    /**
     * Registered Users.
     */
    Map<Integer, User> map;

    /**
     * Tweets List.
     */
    List<Tweet> list;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        this.map = new HashMap<Integer, User>();
        this.list = new ArrayList<Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId))
            map.put(userId, new User(userId));

        Tweet tweet = new Tweet(tweetId, userId);
        list.add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!map.containsKey(userId))
            map.put(userId, new User(userId));

        User user = map.get(userId);
        List<Integer> news = new ArrayList<Integer>();

        int index = list.size() - 1;
        int count = 0;
        while(index >= 0 && count < 10) {
            Tweet tweet = list.get(index);
            if(tweet.userId == user.userId || user.followings.contains(tweet.userId)) {
                news.add(tweet.tweetId);
                count ++;
            }
            index --;
        }

        return news;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId))
            map.put(followerId, new User(followerId));

        User user = map.get(followerId);
        user.followings.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId))
            map.put(followerId, new User(followerId));

        User user = map.get(followerId);
        user.followings.remove(followeeId);
    }
}
