public class InventoryItem
{
    private String name;
    private double regularPrice;
    private double salePrice;
    private boolean onSale;

    // Constructor to initialize an inventory item
    public InventoryItem(String name, double regularPrice, double salePrice, boolean onSale)
    {
        this.name = name;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.onSale = onSale;
    }

    // Return the name of the item
    public String getName()
    {
        return name;
    }

    // Return regular price
    public double getRegularPrice()
    {
        return regularPrice;
    }

    // Return sale price
    public double getSalePrice()
    {
        return salePrice;
    }

    // Return whether the item is on sale
    public boolean isOnSale()
    {
        return onSale;
    }

    // Return the price to use based on sale status
    public double getPriceToUse()
    {
        if (onSale)
        {
            return salePrice;
        }
        else
        {
            return regularPrice;
        }
    }

    // Set a new sale price
    public void setSalePrice(double salePrice)
    {
        this.salePrice = salePrice;
    }

    // Set whether the item is on sale
    public void setOnSale(boolean onSale)
    {
        this.onSale = onSale;
    }
}
