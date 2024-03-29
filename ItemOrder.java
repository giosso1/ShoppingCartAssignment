public class ItemOrder {
    private Item item;
    private int num;
    private double cost;

    //default constructor, no parameters
    public ItemOrder(){}

    //constructor, 2 parameters - Item and number
    //calculates price from number of items and item price
    public ItemOrder(Item item, int num){
        this.item=item;
        this.num=num;
        this.cost=item.getPrice()*num;
    }

    //setters and getters
    public Item getItem(){return this.item;}
    public int getNum(){return this.num;}
    public double getCost(){return this.cost;}
    public void setItem(Item item){this.item=item;}
    public void setNum(int num){this.num=num;}
    public void setCost(){this.cost=this.item.getPrice()*this.num;}

    //toString formats information
    public String toString(){
        String temp = String.format("%1$, .2f", this.cost);
        return this.item.getName()+": $"+temp;
    }
}
