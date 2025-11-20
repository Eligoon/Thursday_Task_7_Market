import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Inventory
{
    List<InventoryItem> allItems;
    List<InventoryItem> saleItems;


    public Inventory(List<InventoryItem> allItems, List<InventoryItem> saleItems)
    {
        this.allItems = allItems;
        this.saleItems = saleItems;
    }



    Inventory inventory = new Inventory(loadInventory(),);

    Path path = Paths.get("groceries.csv");

    public void loadInventory()
    {
    try
    {
        List<String> lines = Files.readAllLines(path);

        // Skip the header
        for (int i = 1; i < lines.size(); i++)
        {
            String line = lines.get(i);
            String[] parts = line.split(";");

            String name = parts[1].trim();
            double price = Double.parseDouble(parts[3].trim());

            InventoryItem item = new InventoryItem(name, price, price, false);
            inventory.getAllItems().add(item);
        }
    }
    catch (IOException e)
    {
        System.out.println("File could not be found");
    }
}

}
