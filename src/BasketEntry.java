public class BasketEntry
{
    private InventoryItem item;
    private int quantity;

    // Constructor for BasketEntry with item and initial quantity
    public BasketEntry(InventoryItem item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }

    // Return the inventory item
    public InventoryItem getItem()
    {
        return item;
    }

    // Return the quantity of this item in the basket
    public int getQuantity()
    {
        return quantity;
    }

    // Increase the quantity of this item by a specified amount
    public void increaseQuantity(int amount)
    {
        this.quantity += amount;
    }

    // Return the price to use (sale or regular)
    public double getPriceToUse()
    {
        if (item.isOnSale())
        {
            return item.getSalePrice();
        }
        else
        {
            return item.getRegularPrice();
        }
    }

    // Calculate total savings for this basket entry
    public double getTotalSaved()
    {
        if (item.isOnSale())
        {
            return (item.getRegularPrice() - item.getSalePrice()) * quantity;
        }
        else
        {
            return 0;
        }
    }
}
