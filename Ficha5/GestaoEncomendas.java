import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.*;

public class GestaoEncomendas {
    private Map<String, Encomenda> gest;

    public Map<String, Encomenda> getGest() {
        return this.gest;
    }

    public void setGest(Map<String, Encomenda> gest) {
        for (String n: gest.keySet()){
            this.gest.put(n,gest.get(n).clone());
        }
    }

    public GestaoEncomendas(){
        this.gest= new TreeMap<String,Encomenda>();
    }

    public GestaoEncomendas(Map<String, Encomenda> Ge){
        this();
        this.setGest(Ge);
    }

    public GestaoEncomendas(GestaoEncomendas Ge){
        this();
        setGest(Ge.getGest());
    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;

        if (obj==null || obj.getClass().equals(this.getClass()))
            return false;
        
        GestaoEncomendas newGe = (GestaoEncomendas) obj;
        return (this.equals(newGe));
    }

    public String toString(){
        return this.gest.toString();
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    //funcoes ficha
    public Set<String> todosCodigosEnc(){
        return this.gest.keySet().stream().collect(Collectors.toCollection(TreeSet::new));
    }

    public void addEncomenda(Encomenda enc){
        this.gest.putIfAbsent(hasher(enc.getNEnc()),enc);
    }

    public Encomenda getEncomenda(String codEnc){
        return this.gest.get(codEnc);
    }

    public void removeEncomenda(String codEnc){
        this.gest.remove(codEnc);
    }

    public String encomendaComMaisProdutos(){
        String maior = "";
        int tamMax = 0;
        for (String n: this.gest.keySet()){
            Encomenda at = this.gest.get(n);
            if (at.getLinhas().size()>tamMax){
                tamMax=at.getLinhas().size();
                maior=n;
            }
        }
        return maior;
    }

    public Set<String> encomendasComProduto(String codProd){
        Set<String> ret = new TreeSet<String>();   
        for (String n: this.gest.keySet()){
            Encomenda at = this.gest.get(n);
            for (LinhaEncomenda cod: at.getLinhas()){
                if (cod.getReferencia().equals(codProd))
                    ret.add(n);
            }
        }
        return ret;
    }

    public Set<String> encomendaAposData(LocalDate d){
        Set<String> ret =  new TreeSet<String>();
        for(String n: this.gest.keySet()){
            if(this.gest.get(n).getData().isAfter(d))
                ret.add(n);
        }
        return ret;
    }

    // public Set<Encomenda> encomendasValorDecrescente(){
    //     SortedSet<Encomenda> set = new TreeSet<Encomenda>();
    //     for (String n: this.gest.keySet()){
    //         set.add(this.gest.get(n));
    //     }
    // }

    

    //falta fazer o 9


    private String hasher(int numEnco){
        StringBuilder sb = new StringBuilder();
        while(numEnco>0){
            sb.append((char) numEnco);
            numEnco=numEnco/10;
        }
        return sb.toString();
    }

}
