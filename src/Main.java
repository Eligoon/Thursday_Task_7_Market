import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        inventory.loadInventory("src/Data/groceries");
        inventory.loadSaleItems("src/Data/sale");

        Robot robot = new Robot();
        Collection<InventoryItem> robotItems = robot.fyldIKurv(inventory.getAllItems());

        Basket basket = new Basket();
        for (InventoryItem item : robotItems)
        {
            basket.addItem(item);
        }

        Registrer register = new Registrer();
        register.scanBasket(basket);
        register.printReceipt();
    }
}
