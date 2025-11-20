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

}
