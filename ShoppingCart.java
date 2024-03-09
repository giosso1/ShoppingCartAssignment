import java.util.ArrayList;

public class ShoppingCart{
    private ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
    private double totalCost;

    public ShoppingCart(){
        totalCost=0;
    }
    public ShoppingCart(ArrayList<ItemOrder> list){
        this.list.addAll(list);
        for(ItemOrder io : this.list){
            this.totalCost+= io.getCost();
        }
    }

    public ArrayList<ItemOrder> getList(){return this.list;}
    public double getTotalCost(){
        this.totalCost=0;
        for(ItemOrder io:this.list){
            this.totalCost+=io.getCost();
        }
        return this.totalCost;
    }

    public void addItem(ItemOrder itemOrder){list.add(itemOrder);}
    public void addItem(ArrayList<ItemOrder> list){this.list.addAll(list);}

    public void removeItem(ItemOrder itemOrder){list.remove(itemOrder);}
    public ItemOrder searchItem(String name){
        for(ItemOrder io:this.list){
            if(name.equals(io.getItem().getName())) return io;
        }
        return new ItemOrder();
    }

    public String toString(){
        this.totalCost=this.getTotalCost();
        String temp = String.format("%1$, .2f", this.getTotalCost());
        return this.list+": $"+temp;}
}
