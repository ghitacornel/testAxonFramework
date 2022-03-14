package beans.events;

import lombok.Value;

@Value
public class ProductCountDecrementedEvent {

    String orderId;
    String productId;

}
