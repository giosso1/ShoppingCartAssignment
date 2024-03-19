import java.util.ArrayList;

public class ShoppingCart{
    private ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
    private double totalCost;

    //default constructor, no parameters, sets cost to 0
    public ShoppingCart(){
        totalCost=0;
    }

    //constructor, one parameter - ArrayList
    //adds items from array list into the "cart" array list
    //calculates price
    public ShoppingCart(ArrayList<ItemOrder> list){
        this.list.addAll(list);
        for(ItemOrder io : this.list){
            this.totalCost+= io.getCost();
        }
    }

    //getters return list and calculate and return total cost of cart
    public ArrayList<ItemOrder> getList(){return this.list;}
    public double getTotalCost(){
        this.totalCost=0;
        for(ItemOrder io:this.list){
            this.totalCost+=io.getCost();
        }
        return this.totalCost;
    }


    //overloaded method
    //adds single Item when given item order
    //adds whole cart when given array list
    public void addItem(ItemOrder itemOrder){list.add(itemOrder);}
    public void addItem(ArrayList<ItemOrder> list){this.list.addAll(list);}

    //removes item order from list
    public void removeItem(ItemOrder itemOrder){list.remove(itemOrder);}

    //looks through list and finds given string name
    //if name isn't found returns and empty item order
    public ItemOrder searchItem(String name){
        for(ItemOrder io:this.list){
            if(name.equals(io.getItem().getName())) return io;
        }
        return new ItemOrder();
    }

    //to string
    public String toString(){
        this.totalCost=this.getTotalCost();
        String temp = String.format("%1$, .2f", this.getTotalCost());
        return this.list+": $"+temp;}
}
