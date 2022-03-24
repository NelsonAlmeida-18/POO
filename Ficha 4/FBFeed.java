import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.time.LocalDateTime;

public class FBFeed{
    private ArrayList<FBPost> timeline;

    public ArrayList<FBPost> getTimeline() {
        return this.timeline;
    }

    public void setTimeline(ArrayList<FBPost> timeline) {
        this.timeline = timeline;
    }
    
    public FBFeed(){
        this.timeline = new ArrayList<FBPost>();
    }

    public FBFeed(ArrayList<FBPost> timeline){
        ListIterator<FBPost> iter =  timeline.listIterator();
        while(iter.hasNext()){
            FBPost pos = iter.next();
            this.timeline.add(pos.clone());
        }
    }

    //NÃO ESTÁ A CLONAR E VAI DAR MERDA 100%
    public FBFeed(FBFeed feedToPaste){
        this.timeline = feedToPaste.getTimeline();
    }

    //Funcoes da ficha
    public int nrPosts(String user){
        ListIterator<FBPost> iter = this.timeline.listIterator();
        int numOfPosts=0;
        while(iter.hasNext()){
            FBPost post=iter.next();
            if (post.getNameOfUser().equals(user))
                numOfPosts+=1;
        }
        return numOfPosts;
    }

    public List<FBPost> postsOf(String user){
        List<FBPost> lista = new ArrayList<FBPost>();
        ListIterator<FBPost> iter = this.timeline.listIterator();
        while(iter.hasNext()){
            FBPost post = iter.next();
            if (post.getNameOfUser().equals(user))
                lista.add(post);
        }
        return lista;
    }

    public List<FBPost> postsOf(String user,LocalDateTime inicio, LocalDateTime fim){
        List<FBPost> lista = new ArrayList<FBPost>();
        ListIterator<FBPost> iter = this.timeline.listIterator();
        while(iter.hasNext()){
            FBPost post = iter.next();
            if (post.getNameOfUser().equals(user)  && inicio.isBefore(post.getCreation()) &&  fim.isAfter(post.getCreation()))
                lista.add(post);
        }
        return lista;
    }

    public FBPost getPost(int id){
        ListIterator<FBPost> iter = this.timeline.listIterator();
        while(iter.hasNext()){
            FBPost post = iter.next();
            if (post.getIdentifier()==id)
                return post;
        }
        return null;
    }

    public void comment(FBPost post, String comentario){
        ArrayList<String> comments = post.getComments();
        comments.add(comentario);
        post.setComments(comments);
    }

    public void comment(int postId, String comentario){
        ArrayList<String> comments = new ArrayList<String>();
        ListIterator<FBPost> iter = this.timeline.listIterator();
        while(iter.hasNext()){
            FBPost post = iter.next();
            if (post.getIdentifier()==postId){
                comments=post.getComments();
                comments.add(comentario);
                post.setComments(comments);
            }
        }
    }

    public void like(FBPost post){
        post.setLikes(post.getLikes()+1);
    }

    public void like(int postid){
        ListIterator<FBPost> iter = this.timeline.listIterator();
        while(iter.hasNext()){
            FBPost post = iter.next();
            if (post.getIdentifier()==postid){
                post.setLikes(post.getLikes()+1);
            }
        } 
    }
    
//repensar esta

    // public List<Integer> top5Comments(){
    //     ListIterator<FBPost> iter = this.timeline.listIterator();
    //     List <Integer> lista = new ArrayList<Integer>();
    //     while(iter.hasNext()){
    //         FBPost post = iter.next();
    //         if(post.getComments())

    //     }
    // }
    



}