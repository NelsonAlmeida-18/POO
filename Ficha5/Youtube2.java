


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.lang.StringBuilder;

public class Youtube2 {
    private String nomeVideo;
    private String content;
    private LocalDate dateUpload;
    private double res;
    private LocalTime lenOfVid;
    private ArrayList<String> comments;
    private double likes;
    private double dislikes;

    public Youtube2(){
        this.nomeVideo="";
        this.content="";
        this.dateUpload=LocalDate.now();
        this.res=0;
        this.lenOfVid=LocalTime.of(0,0,0);
        this.comments=new ArrayList<String>();
        this.likes=0;
        this.dislikes=0;
    }

    public Youtube2(Youtube2 vid){
        this.nomeVideo=vid.getNomeVideo();
        this.content=vid.getContent();
        this.dateUpload=vid.getDateUpload();
        this.res=vid.getRes();
        this.lenOfVid=vid.getLenOfVid();
        this.comments=vid.getComments();
        this.likes=vid.getLikes();
        this.dislikes=vid.getDislikes();
    }


    //Setters e getters

    public String getNomeVideo() {
		return this.nomeVideo;
	}

	public void setNomeVideo(String nomeVideo) {
		this.nomeVideo = nomeVideo;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDateUpload() {
		return this.dateUpload;
	}

	public void setDateUpload(LocalDate dateUpload) {
		this.dateUpload = dateUpload;
	}

	public double getRes() {
		return this.res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	public LocalTime getLenOfVid() {
		return this.lenOfVid;
	}

	public void setLenOfVid(LocalTime lenOfVid) {
		this.lenOfVid = lenOfVid;
	}

	public ArrayList<String> getComments() {
		return this.comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public double getLikes() {
		return this.likes;
	}

	public void setLikes(double likes) {
		this.likes = likes;
	}

	public double getDislikes() {
		return this.dislikes;
	}

	public void setDislikes(double dislikes) {
		this.dislikes = dislikes;
	}

    //Equals, clone e toString

    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null || this.getClass()!=obj.getClass())
            return false;

        Youtube2 newVideo = (Youtube2) obj;
        return (this.nomeVideo.equals(newVideo.getNomeVideo()) &&  this.content.equals(newVideo.getContent())  && this.dateUpload.equals(newVideo.getDateUpload())  &&  this.res==newVideo.getRes()  &&  this.lenOfVid.equals(newVideo.getLenOfVid())  && this.comments.equals(newVideo.getComments())  &&  this.likes==newVideo.getLikes()  && this.dislikes==newVideo.getDislikes());
    }

    public Youtube2 clone(){
        return new Youtube2(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do vídeo: ");
        sb.append(this.nomeVideo);
        sb.append("\nConteúdo no vídeo: ");
        sb.append(this.content);
        sb.append("\nData do upload");
        sb.append(this.getDateUpload().toString());
        sb.append("\nResolução em que foi gravado: ");
        sb.append(this.getRes());
        sb.append("\nDuração do vídeo: ");
        sb.append(this.getLenOfVid());
        sb.append("\nComentários no vídeo: ");
        sb.append(this.getComments().toString());
        sb.append("\nNúmero de likes no vídeo: ");
        sb.append(this.getLikes());
        sb.append("\nNúmero de Dislikes: ");
        sb.append(this.getDislikes());
        return sb.toString();
    }

    //Funcoes da ficha
    public void insereCometario(String comment){
        this.comments.add(comment);
    }

    public long qtsDiasDepois(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.DAYS.between(agora,this.dateUpload);
    }

    public void thumbsUp(){
        this.likes+=1;
    }
    public String processa(){
        return this.content;
    }

}
