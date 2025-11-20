import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Inventory
{
    // Collection of all items in the inventory
    private Collection<InventoryItem> allItems;

    // Constructor initializes an empty inventory
    public Inventory()
    {
        allItems = new ArrayList<>();
    }

    // Return all items in the inventory
    public Collection<InventoryItem> getAllItems()
    {
        return allItems;
    }

    // Load inventory items from a CSV file
    public void loadInventory(String csvFilePath)
    {
        Path path = Paths.get(csvFilePath);

        try
        {
            List<String> lines = Files.readAllLines(path);

            // Skip the header line and process remaining lines
            for (int i = 1; i < lines.size(); i++)
            {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");

                String name = parts[1].trim();
                double price = Double.parseDouble(parts[3].trim());

                // Create an inventory item with regular price
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

    // Load sale prices from a CSV and apply them to matching inventory items
    public void loadSaleItems(String saleCsvPath)
    {
        Path path = Paths.get(saleCsvPath);

        try
        {
            List<String> lines = Files.readAllLines(path);

            // Skip header and process each line
            for (int i = 1; i < lines.size(); i++)
            {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");

                String name = parts[1].trim();
                double salePrice = Double.parseDouble(parts[3].trim());

                // Apply sale price to the matching inventory item
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
