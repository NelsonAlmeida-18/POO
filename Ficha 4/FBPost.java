import java.util.ArrayList;
import java.time.LocalDateTime;
import java.lang.StringBuilder;

public class FBPost {
    private int identifier;
    private String nameOfUser;
    private String content;
    private LocalDateTime creation;
    private int likes;
    private ArrayList<String> comments;

    public FBPost(){
        this.identifier=0;
        this.nameOfUser="";
        this.content="";
        this.creation=LocalDateTime.now();
        this.likes=0;
        this.comments=new ArrayList<String>();
    }

    public FBPost(FBPost post){
        this.identifier=post.getIdentifier();
        this.nameOfUser=post.getNameOfUser();
        this.content=post.getContent();
        this.creation=post.getCreation();
        this.likes=post.getLikes();
        this.comments=post.getComments();
    }

    public FBPost(int identifier, String nameOfUser, String content, LocalDateTime creation, int likes, ArrayList<String> comments){
        this.identifier=identifier;
        this.nameOfUser=nameOfUser;
        this.content=content;
        this.creation=creation;
        this.likes=likes;
        this.comments=comments;
    }

    public LocalDateTime getCreation() {
        return this.creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getNameOfUser() {
        return this.nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;
        
        if (obj==null || this.getClass()!=obj.getClass())
            return false;
        
        FBPost newP = (FBPost) obj;
        return (this.identifier==newP.getIdentifier()  && this.nameOfUser.equals(newP.getNameOfUser())  &&  this.content.equals(newP.getContent())  &&  this.creation.equals(newP.getCreation())  &&  this.likes==newP.getLikes());
    }

    public FBPost clone(){
        return new FBPost(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Identificador do Post: ");
        sb.append(this.identifier);
        sb.append("\nNome do Utilizador: ");
        sb.append(this.nameOfUser);
        sb.append("\nConteúdo do Post: ");
        sb.append(this.content);
        sb.append("\nData do Post: ");
        sb.append(this.creation);
        sb.append("\nNúmero de likes: ");
        sb.append(this.likes);
        sb.append("\nComentários no vídeo: ");
        sb.append(this.comments.toString());
        sb.append("\n");
        return sb.toString();
    }

}
