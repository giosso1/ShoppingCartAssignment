import javax.swing.*;

public class ShoppingTest {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        int storeOpt;
        int doneShopping=1;
        //set up items user can choose from
        Item potatoes = new Item("Potatoes", 3.49);
        Item pesto = new Item("Pesto", 2.49);
        Item beans = new Item("Beans", 1.09);
        Item olives = new Item("Olives", 3.99);
        Item crackers = new Item("Crackers", 2.99);

        //while loop, continues running until user is "done shopping"
        while(doneShopping!=0) {
            Item[] store = {potatoes, pesto, beans, olives, crackers};

            //gives user choice to add or remove item
            String[] arOptions = {"Add item", "Remove item"};
            int ar = JOptionPane.showOptionDialog(null, "Would you like to add or remove items from your cart\nYour cart: "+cart, "Done", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, arOptions, arOptions[1]);

            //if user is adding item
            if(ar==0) {
                //display options
                storeOpt = JOptionPane.showOptionDialog(null, "What would you like to buy\nYour current cart: " + cart, "Items", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, store, store[0]);
                //get how many user wants to purchase
                String amount = JOptionPane.showInputDialog("How many " + store[storeOpt].getName() + " would you like to buy for $" + store[storeOpt].getPrice());
                boolean done = false;
                int iAmount = 0;
                while (!done) {
                    try {
                        iAmount = Integer.parseInt(amount);
                        done = true;
                    } catch (Exception e) {
                        amount = JOptionPane.showInputDialog("How many " + store[storeOpt] + " would you like to buy, please enter an integer");
                    }
                }//end while

                //add itemOrder to cart
                cart.addItem(new ItemOrder(store[storeOpt], iAmount));
            }//end add item

            //if user removes an item
            else{
                //choose item to remove
                int removeOpt = JOptionPane.showOptionDialog(null, "What item would you like to remove from your cart\nYour current cart: " + cart, "Items", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, store, store[0]);
                cart.removeItem(cart.searchItem(store[removeOpt].getName()));
            }//end remove item

            //ask user to continue shopping
            String[] options = {"Yes", "No"};
            doneShopping = JOptionPane.showOptionDialog(null, "Are you done shopping\nYour cart: "+cart, "Done", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

        }

        //display final cart
        String temp="";
        for(ItemOrder i : cart.getList()){
            temp+= i.getItem() +" x " +i.getNum()+ ": "+String.format("%1$, .2f",i.getCost())+"\n";
        }
        temp+= "Total Cost: "+cart.getTotalCost();
        JOptionPane.showMessageDialog(null, temp);
    }//end main
}//end ShoppingTest
