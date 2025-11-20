import java.util.Map;
import java.util.TreeMap;

public class Registrer
{
    // Stores scanned basket entries sorted by item name
    private Map<String, BasketEntry> entries = new TreeMap<>();

    // Scan all items from a basket into the register
    public void scanBasket(Basket basket)
    {
        for (BasketEntry be : basket.getEntries())
        {
            String name = be.getItem().getName();

            // Increment quantity if item already exists
            if (entries.containsKey(name))
            {
                entries.get(name).increaseQuantity(be.getQuantity());
            }
            // Add new basket entry if item is new
            else
            {
                entries.put(name, be);
            }
        }
    }

    // Calculate total cost and total savings
    public double calculateTotal()
    {
        double total = 0;
        double totalSaved = 0;

        for (BasketEntry be : entries.values())  // entries = your TreeMap
        {
            total += be.getPriceToUse() * be.getQuantity();
            totalSaved += be.getTotalSaved();
        }

        System.out.println("Total saved: " + totalSaved + " kr.");

        return total;
    }

    // Print a detailed receipt for all scanned items
    public void printReceipt()
    {
        double subTotal;
        double total = 0;
        double totalSaved = 0;

        for(BasketEntry be : entries.values())
        {
            System.out.println(be.getItem().getName());

            // Calculate subtotal for this item
            subTotal = be.getPriceToUse() * be.getQuantity();

            System.out.println(be.getQuantity() + " x " + be.getPriceToUse() + " = " + subTotal + " kr.");

            // Print discount if applicable
            if(be.getTotalSaved() > 0)
            {
                System.out.println("Discount: -" + be.getTotalSaved() + " kr.");
            }

            total += subTotal;
            totalSaved += be.getTotalSaved();
        }

        System.out.println("Total saved: " + totalSaved + " kr.");
        System.out.println("Grand total: " + total + " kr.");
    }
}



