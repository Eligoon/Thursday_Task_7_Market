import java.util.Map;
import java.util.TreeMap;

public class Registrer
{
    private Map<String, BasketEntry> entries = new TreeMap<>();

    public void scanBasket(Basket basket)
    {
        for (BasketEntry be : basket.getEntries())
        {
            String name = be.getItem().getName();

            if (entries.containsKey(name))
            {
                entries.get(name).increaseQuantity(be.getQuantity());
            }
            else
            {
                entries.put(name, be);
            }
        }
    }

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

    public void printReceipt()
    {
        double subTotal;
        double total = 0;
        double totalSaved = 0;


        for(BasketEntry be : entries.values())
        {
            System.out.println(be.getItem().getName());

            subTotal = be.getPriceToUse() * be.getQuantity();

            System.out.println(be.getQuantity() + " x " + be.getPriceToUse() + " = " + subTotal + " kr.");

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


