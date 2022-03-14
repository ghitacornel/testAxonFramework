package beans.events;

import lombok.Value;

@Value
public class OrderCreatedEvent {

    String orderId;

}
