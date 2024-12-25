import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        DateTimeFormatter birthDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Birth date (DD/MM/YYYY): ");
        String dateInput = input.nextLine();
        LocalDate birthDate = LocalDate.parse(dateInput, birthDateFormat);


        System.out.println("\nEnter order data: ");

        OrderStatus status = null;
        while (status == null) {
            System.out.print("Status: ");
            String statusInput = input.nextLine().toUpperCase();

            status = switch (statusInput) {
                case "PENDING_PAYMENT" -> OrderStatus.PENDING_PAYMENT;
                case "PROCESSING" -> OrderStatus.PROCESSING;
                case "SHIPPED" -> OrderStatus.SHIPPED;
                case "DELIVERED" -> OrderStatus.DELIVERED;
                default -> {
                    System.out.println("Invalid status. Please try again.");
                    yield null;
                }
            };
        }

        Order order = new Order(status, new Client(name, email, birthDate));

        System.out.print("How many items to this order? ");
        int itemsQtd = input.nextInt();
        input.nextLine();

        for (int i = 0; i < itemsQtd; i++){
            System.out.println("\nEnter #" + (i + 1) + " item data");

            System.out.print("Product name: ");
            String productName = input.nextLine();

            System.out.print("Product price: ");
            double productPrice = input.nextDouble();
            input.nextLine();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int productQuantity = input.nextInt();
            input.nextLine();

            OrderItem orderItem = new OrderItem(productQuantity, product);

            order.addItem(orderItem);
        }

        System.out.println("\n" + order);

        input.close();
    }
}