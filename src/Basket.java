import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Basket
{
    private Map<String, BasketEntry> entries = new TreeMap<>();

    public void addItem(InventoryItem item)
    {
        String name = item.getName();

        if (entries.containsKey(name))
        {
            entries.get(name).increaseQuantity(1);
        }
        else
        {
            entries.put(name, new BasketEntry(item, 1));
        }
    }

    public Collection<BasketEntry> getEntries()
    {
        return entries.values(); // Always sorted by item name because of Treemapping
    }
}


