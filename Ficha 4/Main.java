import java.util.ArrayList;
import java.time.LocalDateTime;
public class Main {
    
    public static void main(String[] args){

        // Stack newStack = new Stack();
        // newStack.push("teste");
        // System.out.println(newStack.top());
        // System.out.println(newStack.empty());
        // System.out.println(newStack.toString());
        // newStack.pop();
        // System.out.println(newStack.toString());
        // System.out.println(newStack.empty());
    
        // CasaInteligente casa = new CasaInteligente();
        // Lampada newLamp = new Lampada();
        // casa.addLampada(newLamp);
        // casa.addLampada(newLamp.clone());
        // casa.ligaLampadaNormal(0);
        // casa.ligaLampadaECO(0);
        // System.out.println(casa.toString());
        // System.out.println(casa.qtEmEco());

        // FBFeed feed = new FBFeed();
        // FBFeed feed2 = new FBFeed(feed);      
        // ArrayList<FBPost> timeline1 = new ArrayList<FBPost>();
        // FBPost post1 = new FBPost(0,"DiabinhaDele","0000111",LocalDateTime.now(),0,new ArrayList<String>());
        // timeline1.add(post1);
        // feed.setTimeline(timeline1);
 
        // System.out.println(feed.toString());
        // System.out.println(feed2.toString());
        // System.out.println(feed.equals(feed2));


        PedidoSuporte pedido1 = new PedidoSuporte();
        PedidoSuporte pedido2  = new PedidoSuporte();
        pedido2.setDescription("Banca verte água");
        pedido2.setName("João da Silva");
        System.out.println(pedido1.toString());
        System.out.println(pedido2.toString());
        System.out.println(pedido1.equals(pedido2));

        ArrayList<PedidoSuporte> pedidos = new ArrayList<PedidoSuporte>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        SistemadeSuporte sist = new SistemadeSuporte();
        sist.setListaDePedidos(pedidos);
        System.out.println(sist.toString());

    }

}
