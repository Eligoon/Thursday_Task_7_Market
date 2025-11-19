public class InventoryItem
{
    private String name;
    private double price;
    private double salePrice;
    private boolean isOnSale;

    public InventoryItem(String name, double price, double salePrice, boolean isOnSale)
    {
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.isOnSale = isOnSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }
}
