import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Inventory
{
    private Collection<InventoryItem> allItems;

    public Inventory()
    {
        allItems = new ArrayList<>();
    }

    public Collection<InventoryItem> getAllItems()
    {
        return allItems;
    }

    public void loadInventory(String csvFilePath)
    {
        Path path = Paths.get(csvFilePath);

        try
        {
            List<String> lines = Files.readAllLines(path);

            for (int i = 1; i < lines.size(); i++)
            {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");

                String name = parts[1].trim();
                double price = Double.parseDouble(parts[3].trim());

                InventoryItem item = new InventoryItem(name, price, price, false);
                allItems.add(item);
            }

            System.out.println("Loaded " + allItems.size() + " items from CSV.");
        }
        catch (IOException e)
        {
            System.out.println("CSV file not found: " + csvFilePath);
        }
    }

    public void loadSaleItems(String saleCsvPath)
    {
        Path path = Paths.get(saleCsvPath);

        try
        {
            List<String> lines = Files.readAllLines(path);

            for (int i = 1; i < lines.size(); i++)
            {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");

                String name = parts[1].trim();
                double salePrice = Double.parseDouble(parts[3].trim());

                // Find the item in allItems
                for (InventoryItem item : allItems)
                {
                    if (item.getName().equalsIgnoreCase(name))
                    {
                        item.setOnSale(true);
                        item.setSalePrice(salePrice);
                    }
                }
            }

            System.out.println("Applied sale prices from " + saleCsvPath);
        }
        catch (IOException e)
        {
            System.out.println("Sale CSV file not found: " + saleCsvPath);
        }
    }
}
