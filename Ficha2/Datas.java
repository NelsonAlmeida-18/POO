import java.time.LocalDate;
import java.time.temporal.*;

public class Datas {
    private LocalDate[] datas;
       
    public void insereData(LocalDate data){
        int pos=0;
        boolean existe=false;
        while(pos<this.datas.length){
            if(data.equals(this.datas[pos])){
                existe=true;
            }
            pos+=1;
        }
        if(!existe){
            this.datas[pos]=data;
        }
    }

    public LocalDate dataMaixProxima(LocalDate data){
        long minSpacing=0;
        int pos=0;
        long tempTime;
        LocalDate closestData=null;
        while(pos<this.datas.length){
            tempTime=ChronoUnit.DAYS.between(this.datas[pos], data);
            if (tempTime<minSpacing || minSpacing==0){
                minSpacing=tempTime;
                closestData = this.datas[pos];
            }
            pos+=1;
        }
        return closestData;
    }

    //nao me apetece fazer esta merdinha
}
