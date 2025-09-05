import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ShoppingCartManager class provides functionality to manage a shopping cart,
 * including adding, removing, and displaying items
 */
public class ShoppingCartManager {

    private final List<Map<String, Object>> cartItem;
    private int totalAmount;

    public ShoppingCartManager() {
        this.cartItem = new ArrayList<>();
        this.totalAmount = 0;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * Adds an item to the shopping cart.
     * @param itemName the name of the item to be added
     * @param price the price of the item to be added
     */
    public void addItem(String itemName, int price) {
        createItem(itemName, price);
        cartItem.add(createItem(itemName, price));
        totalAmount += price;
    }

    /**
     * Removes an item from the shopping cart by name.
     * @param item the name of the item to be removed
     */
    public void removeItem(String item) {
        Map<String, Object> itemToRemove = findItemByName(item);
        if (itemToRemove != null) {
            totalAmount -= (int) itemToRemove.get("price");
            this.cartItem.remove(itemToRemove);
        }
    }

    /**
     * Displays the items in the shopping cart along with the total amount.
     */
    public void displayCart() {
        System.out.println("Items in cart:");
        for (Map<String, Object> cartItem : cartItem) {
            System.out.println(cartItem.get("itemName") + " - $" + cartItem.get("price"));
        }
        System.out.println("Total: $" + totalAmount);
    }

    /**
     * Creates a new item with the given name and price.
     * @param name the name of the item
     * @param price the price of the item
     * @return a Map representing the item
     */
    private Map<String, Object> createItem(String name, int price) {
        Map<String, Object> newItem = new HashMap<>();
        newItem.put("itemName", name);
        newItem.put("price", price);
        return newItem;
    }

    /**
     * Finds an item in the cartItems list by name.
     * @param name the name of the item to find
     * @return the item map if found, null otherwise
     */
    private Map<String, Object> findItemByName(String name) {
        for (Map<String, Object> cartItem : cartItem) {
            if (cartItem.get("itemName").equals(name)) {
                return cartItem;
            }
        }
        return null;
    }
}