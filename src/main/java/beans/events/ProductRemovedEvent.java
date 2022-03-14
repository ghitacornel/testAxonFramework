package beans.events;

import lombok.Value;

@Value
public class ProductRemovedEvent {

    String orderId;
    String productId;

}
