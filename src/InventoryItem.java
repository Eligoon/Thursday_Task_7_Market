public class InventoryItem
{
    private String name;
    private double regularPrice;
    private double salePrice;
    private boolean onSale;

    public InventoryItem(String name, double regularPrice, double salePrice, boolean onSale)
    {
        this.name = name;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.onSale = onSale;
    }

    public String getName()
    {
        return name;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public double getSalePrice()
    {
        return salePrice;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

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

}

