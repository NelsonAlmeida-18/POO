import java.util.ArrayList;
import java.util.ListIterator;

public class Stack{
    private ArrayList<String> stack;

    public Stack(){
        this.stack = new ArrayList<String>();
    }

    public Stack(String string){
        this.stack = new ArrayList<String>();
        this.stack.add(string);
    }

    public Stack(Stack stack){
        this.stack = stack.getStack();
    }

    public ArrayList<String> getStack() {
        return this.stack;
    }

    public void setStack(ArrayList<String> stackIn) {
        ListIterator<String> iter = stackIn.listIterator();
        ArrayList<String> newArr = new ArrayList<String>();
        while(iter.hasNext()){
            newArr.add(iter.next());
        }
        this.stack=newArr;
    }

    public Stack clone(){
        return new Stack(this);
    }

    public boolean equals(Object obj){
        if (this==obj)
            return true;
        
        if (obj==null || this.getClass()!=obj.getClass())
            return false;
        
        Stack newObj = (Stack) obj;
        return (this.getStack().equals(newObj.getStack()));

    }

    public String toString(){
        return this.stack.toString();
    }

    //Funcoes da Ficha

    public String top(){
        return this.stack.get(this.stack.size()-1);
    }

    public void push(String s){
        this.stack.add(s);
    }

    public void pop(){
        if (this.stack.size()!=0){
            this.stack.remove(this.stack.size()-1);
        }
    }

    public boolean empty(){
        return (this.stack.size()==0);
    }

    public int length(){
        return this.stack.size()-1;
    }

}