
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class SistemaVideos {
    private Map<String, Youtube2> vidSis;

    public Map<String, Youtube2> getVidSis() {
        return this.vidSis;
    }

    public void setVidSis(Map<String, Youtube2> vidSis) {
        this.vidSis = vidSis;
    }

    public SistemaVideos(){
        this.vidSis= new TreeMap<String,Youtube2>();
    }

    public SistemaVideos(String content, Youtube2 video){
        this();
        this.vidSis.put(content,video.clone());
    }

    //falta fazer sistema vides
    public SistemaVideos(SistemaVideos sis){

    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;
        
        if (obj==null || obj.getClass()!=this.getClass())
            return false;

        SistemaVideos newVidSis = (SistemaVideos) obj;
        return (this.vidSis.equals(newVidSis.getVidSis()));
    }

    public SistemaVideos clone(){
        return new SistemaVideos(this);
    }

    public String toString(){
        return this.vidSis.toString();
    }


    //tenho de definir o compare to na class youtube???
    // public int compareTo(SistemaVideos vidSis){

    // }

    //funcoes das fichas

        public void addVideo(Youtube2 v){
            this.vidSis.put(v.getContent(), v.clone());
        }

        public Youtube2 getVideo(String codVid){
            return this.vidSis.get(codVid).clone();
        }

        public void removeVideo(String codVideo){
            this.vidSis.remove(codVideo);
        }

        public void addLike(String codVideo){
            Youtube2 video = this.vidSis.get(codVideo);
            video.thumbsUp();
            this.vidSis.put(codVideo,video);
        }

        public String topLikes(){
            double maxLikes=0;
            String codVid = "";
            for (String vid: this.vidSis.keySet()){
                Youtube2 n = this.vidSis.get(vid);
                if (n.getLikes()>maxLikes){
                    maxLikes = n.getLikes();
                    codVid = n.getContent();
                }
            }
            return codVid;
        }

        public String topLikes(LocalDate dinicial, LocalDate dFinal){
            double maxLikes=0;
            String codVid = "";
            for (Youtube2 n: this.vidSis.values()){
                if (n.getLikes()>maxLikes && n.getDateUpload().isBefore(dFinal) && n.getDateUpload().isAfter(dinicial) ){
                    maxLikes = n.getLikes();
                    codVid = n.getContent();
                }
            }
            return codVid;
        }

        public Youtube2 videoMaisLongo(){
            LocalTime longest=null;
            Youtube2 vidToRet=null;
            for (Youtube2 n : this.vidSis.values()){
                if (n.getLenOfVid().isAfter(longest) || vidToRet==null){
                    longest=n.getLenOfVid();
                    vidToRet=n;
                }
            }
            return vidToRet;
        }



}
