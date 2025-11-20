import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Inventory
{
    private Collection<InventoryItem> allItems = new ArrayList<>();
    private Collection<InventoryItem> saleItems = new ArrayList<>();

    public void loadInventory()
    {
        loadRegularItems("groceries.csv");
        loadSaleItems("sale.csv");
    }

    private void loadRegularItems(String filename)
    {
        try
        {
            List<String> lines = Files.readAllLines(Path.of(filename));

            for (int i = 1; i < lines.size(); i++)
            {
                String[] parts = lines.get(i).split(";");

                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                allItems.add(new InventoryItem(name, price, price, false));
            }
        }
        catch (IOException e)
        {
            System.out.println("Could not read regular items");
        }
    }

    private void loadSaleItems(String filename)
    {
        try
        {
            List<String> lines = Files.readAllLines(Path.of(filename));

            for (int i = 1; i < lines.size(); i++)
            {
                String[] parts = lines.get(i).split(";");

                String name = parts[1].trim();
                double regularPrice = Double.parseDouble(parts[2].trim());
                double salePrice = Double.parseDouble(parts[3].trim());

                saleItems.add(new InventoryItem(name, regularPrice, salePrice, true));
            }
        }
        catch (IOException e)
        {
            System.out.println("Could not read sale items");
        }
    }

    public Collection<InventoryItem> getAllItems()
    {
        return allItems;
    }

    public Collection<InventoryItem> getSaleItems()
    {
        return saleItems;
    }
}
