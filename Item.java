public class Item {
    private String name;
    private double price;

    //default constructor, no parameters
    public Item(){
        this.name="";
        this.price=0;
    }

    //constructor, 2 parameters - name and price
    public Item(String name, double price){
        this.name=name;
        this.price=price;
    }

    //getters and setters
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public void setName(String name){this.name=name;}
    public void setPrice(double price){this.price=price;}

    //toString - returns String with formatted information
    public String toString(){return this.name+": $"+this.price;}
}