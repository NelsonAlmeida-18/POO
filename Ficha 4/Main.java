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
    
        CasaInteligente casa = new CasaInteligente();
        Lampada newLamp = new Lampada();
        casa.addLampada(newLamp);
        casa.addLampada(newLamp.clone());
        casa.ligaLampadaNormal(0);
        casa.ligaLampadaECO(0);
        System.out.println(casa.toString());
        System.out.println(casa.qtEmEco());

    }

}
