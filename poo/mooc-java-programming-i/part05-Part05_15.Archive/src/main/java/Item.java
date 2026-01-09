public class Item {
    private String identifier;
    private String name;

    public Item(String identifier, String name){
        this.identifier = identifier;
        this.name = name;
    }

    public boolean equals(Object compared){
        if(this == compared){
            return true;
        }

        if(!(compared instanceof Item)){
            return false;
        }

        Item aux = (Item) compared;

        if(this.identifier.equals(aux.identifier)){
            return true;
        }
        
        return false;
    }

    public String toString(){
        return this.identifier + ": " + this.name;
    }
}
