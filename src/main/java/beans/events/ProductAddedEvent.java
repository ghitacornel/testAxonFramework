package beans.events;

import lombok.Value;

@Value
public class ProductAddedEvent {

    String orderId;
    String productId;

}
