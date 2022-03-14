package beans.events;

import lombok.Value;

@Value
public class OrderShippedEvent {

    String orderId;

}
