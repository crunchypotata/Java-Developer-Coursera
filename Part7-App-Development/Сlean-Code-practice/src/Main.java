public class Main {
    public static void main(String[] args) {
        ShoppingCartManager cart = new ShoppingCartManager();

        cart.addItem("Laptop", 1200);
        cart.addItem("Headphones", 200);
        cart.addItem("Keyboard", 150);

        System.out.println("After adding items:");
        cart.displayCart();

        cart.removeItem("Keyboard");

        System.out.println("\nAfter removing an item:");
        cart.displayCart();
    }
}
