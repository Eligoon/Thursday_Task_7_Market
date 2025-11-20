import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Basket
{
    // Stores items in the basket, sorted by item name
    private Map<String, BasketEntry> entries = new TreeMap<>();

    // Add an item to the basket
    public void addItem(InventoryItem item)
    {
        String name = item.getName();

        // If item already exists, increase its quantity
        if (entries.containsKey(name))
        {
            entries.get(name).increaseQuantity(1);
        }
        // Otherwise, add the item as a new entry with quantity 1
        else
        {
            entries.put(name, new BasketEntry(item, 1));
        }
    }

    // Get all entries in the basket
    public Collection<BasketEntry> getEntries()
    {
        return entries.values(); // Always sorted by item name because of Treemapping
    }
}



