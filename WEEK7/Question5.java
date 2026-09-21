class Cart {
    private final String cartId;
    final private int[] prices;
    private int count;
    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new int[maxItems];
        count = 0;
    }
    public void addItem(int price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total = total + prices[i];
        }
        return total;
    }
    public int getItemCount() {
        return count;
    }
    public String getCartId() {
        return cartId;
    }
}

public class Question5 {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}