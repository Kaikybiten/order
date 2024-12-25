import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final LocalDateTime moment = LocalDateTime.now();
    private OrderStatus status;
    private final Client client;
    private final List<OrderItem> items = new ArrayList<>();

    public Order (OrderStatus status, Client client){
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }
    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double total(){
        double totalPrice = 0;
        for (OrderItem i : items){
            totalPrice += i.subTotal();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("ORDER SUMMARY:");

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        text.append("\n").append("Order moment: ").append(moment.format(dateFormat));
        text.append("\n").append("Order status: ").append(status);
        text.append("\n").append(client.toString());

        for (OrderItem orderItems : items){
            text.append("\n").append(orderItems.toString());
        }

        text.append("\n").append(String.format("$%.2f", total()));

        return text.toString();
    }
}
