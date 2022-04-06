import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class FBFeedMap {
    private Map<String,List<FBPost>> feed;

    public FBFeedMap(){
        this.feed = new HashMap<String,List<FBPost>>();
    }

    public FBFeedMap(Map<String,List<FBPost>> feed){
        this();
        setFeed(feed);
    }

    public FBFeedMap(FBFeedMap a){
        this();
        setFeed(a.getFeed());
    }

    public void addPost(String user, FBPost post){
        if (this.feed.containsKey(user)){
            List<FBPost> postsUser = this.feed.get(user);
            postsUser.add(post.clone());
            this.feed.replace(user,postsUser);
        }
        else{
            List<FBPost> posts = new ArrayList<FBPost>();
            posts.add(post.clone());
            this.feed.put(user, posts);
        }
    }

    public void removePosts(String user, LocalDateTime di, LocalDateTime df){
        if (this.feed.keySet().contains(user)){
            List<FBPost> userPosts = this.feed.get(user);
            for (FBPost post: userPosts){
                if (post.getCreation().isAfter(di) &&  post.getCreation().isBefore(df)){
                    userPosts.remove(post);
                }
            }
            this.feed.put(user,userPosts);
        }
    }

    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df){
        int posts=0;
        for (List<FBPost> post: this.feed.values()){
            for(FBPost post1: post){
                if(post1.getCreation().isAfter(di) && post1.getCreation().isBefore(df))
                    posts+=1;
            }
        }
        return posts;
    }

    public String utilizadorMaisAtivo (LocalDateTime di, LocalDateTime df){
        String user = "";
        int numPosts =0;
        for(String user1: this.feed.keySet()){
            int Nposts=0;
            List<FBPost> posts = this.feed.get(user);
            for (FBPost post1: posts){
                if(post1.getCreation().isAfter(di) && post1.getCreation().isBefore(df))
                    Nposts+=1;
            }
            if (Nposts>numPosts){
                numPosts=Nposts;
                user = user1;
            }
        }
        return user;
    }


    public void setFeed(Map<String,List<FBPost>> feed){
        Map<String,List<FBPost>> feed2 = new HashMap<String,List<FBPost>>();
        for (String n: feed.keySet()){
            List<FBPost> lista = new ArrayList<FBPost>();
            List<FBPost> posts = feed.get(n);
            for (FBPost post: posts){
                lista.add(post.clone());
            }
            feed2.put(n,lista);
        }
        this.feed=feed2;
    }

    public String toString(){
        return this.feed.toString();
    }

    public Map<String,List<FBPost>> getFeed(){
        return this.feed;
    }

}