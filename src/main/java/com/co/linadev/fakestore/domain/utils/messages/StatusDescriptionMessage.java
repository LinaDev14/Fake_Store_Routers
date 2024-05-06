package com.co.linadev.fakestore.domain.utils.messages;

public class StatusDescriptionMessage {

    public static final String PENDING = "The order has been received but has not yet been processed";
    public static final String IN_PROCESS = "The order is being processed, the products are being picked, packed and prepared for shipment.";
    public static final String SHIPPED = "The products have been shipped to the customer.";
    public static final String DELIVERED = "The products have been successfully delivered to the customer.";
    public static final String CANCELLED = "The order has been cancelled by the customer or for some internal reason.";
    public static final String REFUNDED = "A refund has been made to the customer for some reason";
}
