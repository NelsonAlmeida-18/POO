import java.time.LocalDateTime;
import java.lang.StringBuilder;

public class PedidoSuporte {
    private String name;
    private LocalDateTime call;
    private String matter;
    private String description;
    private String techName;
    private LocalDateTime techVisist;
    private String infoToClient;
    private boolean resolvido;

    public boolean getResolvido(){
        return this.resolvido;
    }

    public void Setresolvido(boolean val){
        this.resolvido=val;
    }

    public void setTechVisist(LocalDateTime techVisist) {
        this.techVisist = techVisist;
    }

    public String getInfoToClient() {
        return this.infoToClient;
    }

    public void setInfoToClient(String infoToClient) {
        this.infoToClient = infoToClient;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCall() {
        return this.call;
    }

    public void setCall(LocalDateTime call) {
        this.call = call;
    }

    public String getMatter() {
        return this.matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechName() {
        return this.techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public LocalDateTime getTechVisist() {
        return this.techVisist;
    }

    public PedidoSuporte(){
        this.name="";
        this.call=LocalDateTime.now();
        this.matter="";
        this.description="";
        this.techName="";
        this.techVisist=LocalDateTime.now();
        this.infoToClient="";
        this.resolvido=false;
    }

    public PedidoSuporte(PedidoSuporte outroPedido){
        this.name=outroPedido.getName();
        this.call=outroPedido.getCall();
        this.matter=outroPedido.getMatter();
        this.description=outroPedido.getDescription();
        this.techName=outroPedido.getTechName();
        this.techVisist=outroPedido.getTechVisist();
        this.infoToClient=outroPedido.getInfoToClient();
        this.resolvido=outroPedido.getResolvido();
    }

    public PedidoSuporte(String name, LocalDateTime call, String matter, String desc, String techName, LocalDateTime techVisit, String infoToClient, boolean resolvido){
        this.name=name;
        this.call=call;
        this.matter=matter;
        this.description=desc;
        this.techName=techName;
        this.techVisist=techVisit;
        this.infoToClient=infoToClient;
        this.resolvido=resolvido;
    }

    public PedidoSuporte clone(){
        return new PedidoSuporte(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome de quem fez o pedido: ");
        sb.append(this.name);
        sb.append("\nHora da chamada: ");
        sb.append(this.call.toString());
        sb.append("\nProblema: ");
        sb.append(this.matter);
        sb.append("\nDescrição do problema: ");
        sb.append(this.description);
        sb.append("\nNome do técnico: ");
        sb.append(this.techName);
        sb.append("\nData da visita do técnico: ");
        sb.append(this.techVisist.toString());
        sb.append("\nInfo para o cliente: ");
        sb.append(this.infoToClient);
        sb.append("\nPedido resolvido: ");
        sb.append(this.resolvido);
        sb.append("\n");
        return sb.toString();
    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;

        if (obj==null|| this.getClass()!=obj.getClass())
            return false;
        
        PedidoSuporte newPedido = (PedidoSuporte) obj;
        return(this.name.equals(newPedido.getName())  &&  this.call.equals(newPedido.getCall())  &&  this.matter.equals(newPedido.getMatter())  &&  this.description.equals(newPedido.getDescription())  &&  this.techName.equals(newPedido.getTechName())  &&  this.techVisist.equals(newPedido.getTechVisist())  &&  this.infoToClient.equals(newPedido.getInfoToClient())  &&  this.resolvido == (newPedido.getResolvido()));
    }

}
