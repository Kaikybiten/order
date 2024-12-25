public class OrderItem {
    private int quantity;
    private Product product;

    public OrderItem(int quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }

    public double subTotal(){
        return this.product.getPrice() * this.quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product.toString() +
                "Quantity: " + this.quantity +
                ", Subtotal: $" + String.format("%.2f", this.subTotal());
    }
}