import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // Create inventory and load items
        Inventory inventory = new Inventory();
        inventory.loadInventory("src/Data/groceries");
        inventory.loadSaleItems("src/Data/sale");

        // Robot selects items to put in basket
        Robot robot = new Robot();
        Collection<InventoryItem> robotItems = robot.fyldIKurv(inventory.getAllItems());

        // Add items to basket
        Basket basket = new Basket();
        for (InventoryItem item : robotItems)
        {
            basket.addItem(item);
        }

        // Scan basket into register and print receipt
        Registrer register = new Registrer();
        register.scanBasket(basket);
        register.printReceipt();
    }
}
