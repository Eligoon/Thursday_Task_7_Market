 public class BasketEntry
    {
        private InventoryItem item;
        private int quantity;

        public BasketEntry(InventoryItem item, int quantity)
        {
            this.item = item;
            this.quantity = quantity;
        }

        public InventoryItem getItem()
        {
            return item;
        }

        public int getQuantity()
        {
            return quantity;
        }

        public void increaseQuantity(int amount)
        {
            this.quantity += amount;
        }

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
