package beans.events;

import lombok.Value;

@Value
public class ProductCountIncrementedEvent {

    String orderId;
    String productId;

}
