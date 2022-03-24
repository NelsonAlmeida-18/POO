import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;


//public class CasaInteligente implements Comparator<CasaInteligente> se implementar uma relaçao de ordem


public class CasaInteligente {
    private ArrayList<Lampada> listaDeLampadas;


    public enum Modo {
        ON, 
        OFF,
        ECO
   }

    public CasaInteligente(){
        this.listaDeLampadas=new ArrayList<Lampada>();
    }

    public CasaInteligente(CasaInteligente casa){
        this.listaDeLampadas=casa.getListaDeLampadas();
    }

    public ArrayList<Lampada> getListaDeLampadas() {
        return this.listaDeLampadas;
    }

    public void setListaDeLampadas(ArrayList<Lampada> listaDeLampadas) {
        this.listaDeLampadas = listaDeLampadas;
    }
    
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;
        
        if (obj==null || this.getClass()!=obj.getClass())
            return false;
        
        CasaInteligente newObj = (CasaInteligente) obj;
        return (this.getListaDeLampadas().equals(newObj.getListaDeLampadas()));
    }

    public String toString(){
        return this.listaDeLampadas.toString();
    }

    //Funcoes da Ficha

    public void addLampada(Lampada l){
        this.listaDeLampadas.add(l);
    }

    public void ligaLampadaNormal(int index){
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        int pos=0;
        while(pos<=index && iter.hasNext() && index<this.listaDeLampadas.size()){
            Lampada aLamp = iter.next();
            if (pos==index)
                aLamp.setModo(Lampada.Modo.ON);
                iter.set(aLamp);
            pos+=1;
        }
    }

    public void ligaLampadaECO(int index){
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        int pos=0;
        while(pos<=index && iter.hasNext() && index<this.listaDeLampadas.size()){
            Lampada aLamp = iter.next();
            if (pos==index)
                aLamp.setModo(Lampada.Modo.ECO);
                iter.set(aLamp);
            pos+=1;
        }
    }

    public int qtEmEco(){
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        int qtsEco=0;
        while(iter.hasNext()){
            Lampada lamp = iter.next();
            if (lamp.getModo().equals(Lampada.Modo.ECO))
                qtsEco+=1;
        }
        return qtsEco;
    }

    public void removeLampada(int index){
        this.listaDeLampadas.remove(index);
    }

    public void ligaTodasEco(){
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        while(iter.hasNext()){
            Lampada lamp = iter.next();
            lamp.setModo(Lampada.Modo.ECO);
        }
    }

    public double consumoTotal(){
        double total=0;
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        while(iter.hasNext()){
            Lampada lamp = iter.next();
            total+=lamp.getConsumoTotal();
        }
        return total;
    }

    public Lampada maisGastadora(){
        Lampada lampMaisGastad = new Lampada();
        double maiorConsumo=0;
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        while(iter.hasNext()){
            Lampada lamp = iter.next();
            double consumoInst = lamp.getConsumoTotal();
            if (consumoInst>maiorConsumo){
                maiorConsumo=consumoInst;
                lampMaisGastad=lamp;
            }
        }
        return lampMaisGastad.clone();
    }

    public Set<Lampada> podiumEconomia(){
        Set<Lampada> newSet = new HashSet<Lampada>();
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        while(iter.hasNext()){
            newSet.add(iter.next());
        }
        return newSet;
    }

    public void reset(){
        ListIterator<Lampada> iter = this.listaDeLampadas.listIterator();
        while(iter.hasNext()){
            Lampada lamp = iter.next();
            lamp.setPeriodoConsumo(0);
        }
    }

}
