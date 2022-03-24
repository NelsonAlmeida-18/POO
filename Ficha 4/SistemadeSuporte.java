import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.time.temporal.*;

public class SistemadeSuporte {
    private ArrayList<PedidoSuporte> listaDePedidos;

    public ArrayList<PedidoSuporte> getListaDePedidos() {
        return this.listaDePedidos;
    }

    public void setListaDePedidos(ArrayList<PedidoSuporte> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public SistemadeSuporte(){
        this.listaDePedidos=new ArrayList<PedidoSuporte>();
    }

    public SistemadeSuporte(ArrayList<PedidoSuporte> sup){
        this.listaDePedidos=sup;
    }

    public SistemadeSuporte(SistemadeSuporte antigoSis){
        this.listaDePedidos=antigoSis.clone().getListaDePedidos();
    }

    public void inserePedido(PedidoSuporte pedido){
        this.listaDePedidos.add(pedido.clone());
    }

    public PedidoSuporte procuraPedido(String user, LocalDateTime data){
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if (ped.getMatter().equals(user)  &&  ped.getCall().equals(data))
                return ped;
        }
        return null;
    }

    public void resolvePedido(PedidoSuporte pedido, String tecnico, String infoToClient){
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if (pedido.equals(ped)){
                ped.setTechName(tecnico);
                ped.setInfoToClient(infoToClient);
                ped.setTechVisist(LocalDateTime.now());
                ped.Setresolvido(true);
            }
        }
    }

    public List<PedidoSuporte> resolvidos(){
        List<PedidoSuporte> lista = new ArrayList<PedidoSuporte>();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if (ped.getResolvido())
                lista.add(ped);
        }
        return lista;
    }

    private int count(ArrayList<PedidoSuporte> lista, String tech){
        int inter=0;
        ListIterator<PedidoSuporte> iter = lista.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if (ped.getTechName()==tech)
                inter+=1;
        }
        return inter;
    }

    public String colaboradorTopExt(){
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        int maxNumRes=0;
        String tech="";
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            int res=count(this.listaDePedidos,ped.getTechName());
            if (res>maxNumRes){
                maxNumRes=res;
                tech=ped.getTechName();
            }
        }
        return tech;
    }

    public List<PedidoSuporte> resolvidosExt(LocalDateTime inicio, LocalDateTime fim){
        List<PedidoSuporte> lista = new ArrayList<PedidoSuporte>();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if(ped.getResolvido())
                lista.add(ped);
        }
        return lista;
    }

    public double tempoMedioResolucaoExt(){
        double tempos=0;
        double inter=0;
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            tempos+=ChronoUnit.SECONDS.between(ped.getCall(), ped.getTechVisist())+1;
            inter+=1;
        }
        return tempos/inter;
    }

    public double tempoMedioResolucaoExt(LocalDateTime inicio, LocalDateTime fim){
        double tempos=0;
        double inter=0;
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            if(ped.getTechVisist().isBefore(fim)  &&  inicio.isAfter(ped.getTechVisist())){
                tempos+=ChronoUnit.SECONDS.between(ped.getCall(), ped.getTechVisist())+1;
                inter+=1;
            }
        }
        return tempos/inter;
    }

    public PedidoSuporte pedidoMaisLongo(){
        PedidoSuporte pedToReturn=new PedidoSuporte();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        long maxTimeToSolve=0;
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            long timeToSolve=ChronoUnit.SECONDS.between(ped.getCall(),ped.getTechVisist());
            if (timeToSolve>maxTimeToSolve || maxTimeToSolve==0){
                maxTimeToSolve=timeToSolve;
                pedToReturn=ped;
            }
        }
        return pedToReturn;
    }

    public PedidoSuporte pedidoMaisLongo(LocalDateTime init, LocalDateTime fim){
        PedidoSuporte pedToReturn=new PedidoSuporte();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        long maxTimeToSolve=0;
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            long timeToSolve=ChronoUnit.SECONDS.between(ped.getCall(),ped.getTechVisist());
            if (timeToSolve>maxTimeToSolve  &&  ped.getTechVisist().isBefore(fim)  &&  ped.getTechVisist().isAfter(init)  && ped.getCall().isBefore(fim)  &&  ped.getCall().isAfter(init)  || maxTimeToSolve==0){
                maxTimeToSolve=timeToSolve;
                pedToReturn=ped;
            }
        }
        return pedToReturn;
    }

    public PedidoSuporte pedidoMaisCurto(){
        PedidoSuporte pedToReturn=new PedidoSuporte();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        long maxTimeToSolve=0;
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            long timeToSolve=ChronoUnit.SECONDS.between(ped.getCall(),ped.getTechVisist());
            if (timeToSolve<maxTimeToSolve || maxTimeToSolve==0){
                maxTimeToSolve=timeToSolve;
                pedToReturn=ped;
            }
        }
        return pedToReturn;
    }

    public PedidoSuporte pedidoMaisCurto(LocalDateTime init, LocalDateTime fim){
        PedidoSuporte pedToReturn=new PedidoSuporte();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        long maxTimeToSolve=0;
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            long timeToSolve=ChronoUnit.SECONDS.between(ped.getCall(),ped.getTechVisist());
            if (timeToSolve<maxTimeToSolve &&  ped.getTechVisist().isBefore(fim)  &&  ped.getTechVisist().isAfter(init)  && ped.getCall().isBefore(fim)  &&  ped.getCall().isAfter(init)  || maxTimeToSolve==0 ){
                maxTimeToSolve=timeToSolve;
                pedToReturn=ped;
            }
        }
        return pedToReturn;
    }
    

    public SistemadeSuporte clone(){
        return new SistemadeSuporte(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListIterator<PedidoSuporte> iter = this.listaDePedidos.listIterator();
        int numPedido=1;
        while(iter.hasNext()){
            PedidoSuporte ped = iter.next();
            sb.append("Pedido de Suporte número: ");
            sb.append(numPedido);
            sb.append("\n");
            sb.append(ped.toString());
            numPedido+=1;
        }
        return sb.toString();
    }

}
