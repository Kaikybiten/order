public enum OrderStatus {
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;

    @Override
    public String toString() {
        return switch (this) {
            case PENDING_PAYMENT -> "Pending payment.";
            case PROCESSING -> "Processing.";
            case SHIPPED -> "Shipped";
            case DELIVERED -> "Delivered";
        };
    }
}
