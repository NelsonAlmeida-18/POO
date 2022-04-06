

public class Main {
    
    public static void main(String[] args){
        // Parque2 parque1 = new Parque2();
        // Parque2 parque2 = new Parque2(parque1);
        // Map <String,Lugar> lugaresParque1 = new TreeMap<String,Lugar>();
        // lugaresParque1.put("99ZZ99",new Lugar("99ZZ99","José",60,true));
        // parque1.setLugares(lugaresParque1);
        // parque1.setNomeDoParque("goncaloGey");
        // System.out.println(parque1.toString());
        // parque1.alteraTempo("99ZZ99",10);
        // System.out.println(parque1.totalMinExt());
        // System.out.println(parque1.totalMinInt());
        // System.out.println(parque1.existeRegisto("99ZZ99"));
        // System.out.println(parque1.existeRegisto("99ZZ89"));
        // System.out.println(parque1.info("99ZZ99"));
        // System.out.println(parque1.lugaresOcupados());
    
       // SistemaVideos vidSis1 = new SistemaVideos();

    //    GestaoEncomendas ge = new GestaoEncomendas();
    //     System.out.println(ge.todosCodigosEnc());

        FBFeedMap newM = new FBFeedMap();
        newM.addPost("teste", new FBPost());
        System.out.println(newM.toString());


    }
}
