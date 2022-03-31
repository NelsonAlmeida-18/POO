import java.lang.StringBuilder;

public class Lugar extends Parque{
    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;

    public Lugar(){
        this.matricula="";
        this.nome="";
        this.minutos=0;
        this.permanente=false;
    }

    public Lugar(String matricula, String nome, int minutos, boolean permanente){
        this.matricula=matricula;
        this.nome=nome;
        this.minutos=minutos;
        this.permanente=permanente;
    }

    public Lugar(Lugar umLugar){
        this.matricula=umLugar.getMatricula();
        this.nome=umLugar.getNome();
        this.minutos=umLugar.getMinutos();
        this.permanente=umLugar.isPermanente();
    }


    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return this.permanente;
    }

    public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}

    public boolean equals(Object obj){
        if (this==obj)
            return true;
        
        if (obj==null || this.getClass()!=obj.getClass())
            return false;
        
        Lugar newPlace = (Lugar) obj;
        return (this.matricula.equals(newPlace.getMatricula())  &&  this.nome.equals(newPlace.getNome())  &&  this.minutos==newPlace.getMinutos()  &&  this.permanente == (newPlace.isPermanente()));
    }

    public Lugar clone(){
        return new Lugar(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula do Carro: ");
        sb.append(this.matricula);
        sb.append("\nNome do proprietário: ");
        sb.append(this.nome);
        sb.append("\nTempo atribuido ao lugar: ");
        sb.append(this.minutos);
        sb.append("\nPermanente: ");
        sb.append(this.isPermanente());
        sb.append("\n");
        return sb.toString();
    }

}
