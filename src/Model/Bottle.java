package Model;

public class Bottle {

    public int size;
    public String name;
    public char pant;
    public int type;

    public Bottle(int size, String name, char pant, int type) {

       this.size = size;
       this.name = name;
       this.pant = pant;
       this.type = type;

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
